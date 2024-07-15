package com.example.gxymavenspringboot1.controller;

import com.example.gxymavenspringboot1.pojo.Task;
import com.example.gxymavenspringboot1.pojo.UpdateUserEnter;
import com.example.gxymavenspringboot1.pojo.User;
import com.example.gxymavenspringboot1.pojo.UserLoginVerify;
import com.example.gxymavenspringboot1.service.TaskService;
import com.example.gxymavenspringboot1.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    HttpServletRequest request; //通过注解获取一个request


    @GetMapping("{id}")
    public String getPathVariable(@PathVariable String id){
        return "id="+id;
    }

    //客户进行登录验证
    @GetMapping("/loginVerify")
    public ModelAndView loginVerify(@RequestParam("cusId") String cusId,
                                    @RequestParam("password") String password){

        //到数据库里查询能否找得到账号密码
        UserLoginVerify userLoginVerify=new UserLoginVerify();
        userLoginVerify.setCusId(cusId);
        userLoginVerify.setPassword(password);
        int result=0;
        result=userService.loginVerify(userLoginVerify);

        ModelAndView modelAndView=new ModelAndView();

        //登录成功
        if(result==1)
        {
            //登录成功的话，就把账号密码保存到Session
            HttpSession session = request.getSession();
            session.setAttribute("cusId",userLoginVerify.getCusId());
            session.setAttribute("password",userLoginVerify.getPassword());

            //登录成功之后直接查数据进行组装

            modelAndView.setViewName("mainPage");
            List<Task> taskResultList=new ArrayList<>();
            taskResultList=taskService.searchTaskByCusId(cusId);
            modelAndView.addObject("taskResultList",taskResultList);
            return modelAndView;
        }
        //登录失败
        else
        {
            modelAndView.setViewName("loginFail");
            modelAndView.addObject("loginMessage","用户名或密码错误");
            return modelAndView;
        }
    }

    //跳转到用户管理界面，同时查询出用户信息
    @GetMapping("/userQuery")
    public String userQuery(Model model){
        List<User> userList=userService.userQuery();
        model.addAttribute("userList",userList);
        return "userMessage";
    }

    //用户新增页面跳转
    @GetMapping("/userAddJump")
    public String userAddJump(){
        return "userAdd";
    }

    //客户数据新增
    @PostMapping("/userAdd")
    @ResponseBody
    public String userAdd(@RequestBody  Map<String,Object> userAddMessage){

        //新增客户前查询一下该客户号是否已存在
        User userQuery= userService.selectUserByCusId(userAddMessage.get("cusId").toString());
        if(userQuery==null || userQuery.getCusId().isEmpty())
        {
            User user =new User();
            user.setCusId(userAddMessage.get("cusId").toString());
            user.setPassword(userAddMessage.get("password").toString());
            int result=userService.userAdd(user);
            if(result==1)
            {
                return "用户数据添加成功";
            }
            else
            {
                return "用户数据添加失败";
            }

        }
        else
        {
            return "该客户号已存在，请勿重复添加";
        }

    }


    @GetMapping("/userUpdateQueryById")
    public ModelAndView userUpdateQuery(@RequestParam("id") int id){

        User user= userService.userUpdateQueryById(id);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userUpdate");
        modelAndView.addObject("id",id);
        modelAndView.addObject("cusId",user.getCusId());
        modelAndView.addObject("password",user.getPassword());
        return modelAndView;
    }

    @PostMapping("/userUpdate")
    @ResponseBody
    public String userUpdate(@RequestBody UpdateUserEnter updateUserEnter){
        userService.userUpdateById(updateUserEnter);
        return "客户信息更新成功";
    }

    @GetMapping("/userDeleteById")
    public String   userDeleteById(@RequestParam("id") int id){
        userService.userDeleteById(id);
        return "userDeleteResult";
    }


}
