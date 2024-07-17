package com.example.gxymavenspringboot1.controller;

import com.alibaba.fastjson.JSON;
import com.example.gxymavenspringboot1.pojo.Task;
import com.example.gxymavenspringboot1.service.TaskService;
import com.example.gxymavenspringboot1.service.UserService;
import com.example.gxymavenspringboot1.unti.DateDealUntil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    HttpServletRequest request; //通过注解获取一个request

    //登录页面跳转
    @GetMapping("/login")
    public String loginPageJump(){
        return "login";
    }


    //登录成功后带着客户号跳转到主页，然后用客户号查询任务数据
    @GetMapping("/mainPage")
    public ModelAndView  mainPage(){

        ModelAndView modelAndView = new ModelAndView();

        String cusId= (String) request.getSession().getAttribute("cusId");
        if(cusId.length()==0 || cusId==null || cusId.equals(""))
        {
            modelAndView.setViewName("loginFail");
            return modelAndView;
        }
        modelAndView.setViewName("mainPage");
        List<Task> taskResultList=new ArrayList<>();
        taskResultList=taskService.searchTaskByCusId(cusId);
        modelAndView.addObject("taskResultList",taskResultList);

        return modelAndView;
    }


    //根据客户号查询出客户号下的所有任务信息
    @GetMapping("/searchTaskByCusId")
    public ModelAndView searchTaskByCusId() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("mainPage");

        String cusId= (String) request.getSession().getAttribute("cusId");

        List<Task> taskResultList=new ArrayList<>();
        taskResultList=taskService.searchTaskByCusId(cusId);

        modelAndView.addObject("taskResultList",taskResultList);

        return modelAndView;
    }




    //跳转到任务新增页面
    @GetMapping("/taskAddJump")
    public String taskAddJump() {
        String cusId= (String) request.getSession().getAttribute("cusId");
        if(cusId.length()==0 || cusId==null || cusId.equals(""))
        {
            return "loginFail";
        }
        else
        {
            return "taskAdd";
        }
    }

    //执行任务信息添加
    @PostMapping("/taskAdd")
    @ResponseBody
    public String taskAdd(@RequestBody Map<String,Object> taskAddMessageMap) {
        String cusId= (String) request.getSession().getAttribute("cusId");
        int result=0;
        if(cusId.length()==0 || cusId==null || cusId.equals(""))
        {
            return "任务添加失败";
        }
        else
        {
            Task task=new Task();
            task.setCusId(cusId);
            task.setLoadWay(taskAddMessageMap.get("loadWay").toString());
            task.setCollectTime(taskAddMessageMap.get("collectTime").toString());
            task.setCollectAddress(taskAddMessageMap.get("collectAddress").toString());
            task.setSendTime(taskAddMessageMap.get("sendTime").toString());
            task.setSendAddress(taskAddMessageMap.get("sendAddress").toString());
            task.setCarType(taskAddMessageMap.get("carType").toString());
            task.setRemarkMessage(taskAddMessageMap.get("remarkMessage").toString());
            task.setThingMessage(taskAddMessageMap.get("thingNo").toString());
            task.setFbaCode(taskAddMessageMap.get("thingMessage").toString());
            task.setFbaId(taskAddMessageMap.get("fbaId").toString());
            task.setThingNo(taskAddMessageMap.get("fbaCode").toString());

            taskService.taskAdd(task);
        }
        return "任务添加成功!";
    }


    //根据客户号和任务id查询出客户号下制定的一条任务数据
    @GetMapping("/searchTaskByIdAndCusId")
    @ResponseBody
    public Task searchTaskByIdAndCusId(@RequestParam("id") int id) {
        String cusId= (String) request.getSession().getAttribute("userName");
        Task taskResult=new Task();
        taskResult=taskService.searchTaskByIdAndCusId(id,cusId);
        String result = JSON.toJSONString(taskResult);
        return taskResult;
    }




    //进行数据修改时，进行单条数据查询，为修改做准备
    @GetMapping("/taskUpdateQueryById")
    public ModelAndView taskUpdateQueryById(@RequestParam("id") int id) {
        String cusId= (String) request.getSession().getAttribute("cusId");
        Task taskResult=taskService.searchTaskByIdAndCusId(id,cusId);

        ModelAndView taskSelectResult=new ModelAndView();
        taskSelectResult.setViewName("taskUpdate");
        taskSelectResult.addObject("id",taskResult.getId());
        taskSelectResult.addObject("fbaCode",taskResult.getFbaCode());
        taskSelectResult.addObject("fbaId",taskResult.getFbaId());
        taskSelectResult.addObject("thingNo",taskResult.getThingNo());
        taskSelectResult.addObject("thingMessage",taskResult.getThingMessage());
        taskSelectResult.addObject("loadWay",taskResult.getLoadWay());

        taskSelectResult.addObject("collectTime",taskResult.getCollectTime().substring(0,10));

        taskSelectResult.addObject("collectAddress",taskResult.getCollectAddress());
        taskSelectResult.addObject("sendTime",taskResult.getSendTime().substring(0,10));
        taskSelectResult.addObject("sendAddress",taskResult.getSendAddress());
        taskSelectResult.addObject("carType",taskResult.getCarType());
        taskSelectResult.addObject("remarkMessage",taskResult.getRemarkMessage());
        taskSelectResult.addObject("thingNo",taskResult.getThingNo());
        return taskSelectResult;
    }


    //执行任务信息更新
    @PostMapping("/taskUpdate")
    @ResponseBody
    public String taskUpdate(@RequestBody Map<String,Object> taskUpdateMessageMap) {
        String cusId= (String) request.getSession().getAttribute("cusId");
        int result=0;
        if(cusId.length()==0 || cusId==null || cusId.equals(""))
        {
            return "更新任务信息失败";
        }
        else
        {
            Task task=new Task();
            task.setId(Integer.parseInt(taskUpdateMessageMap.get("id").toString()));
            task.setCusId(cusId);
            task.setLoadWay(taskUpdateMessageMap.get("loadWay").toString());
            task.setCollectTime(taskUpdateMessageMap.get("collectTime").toString());
            task.setCollectAddress(taskUpdateMessageMap.get("collectAddress").toString());
            task.setSendTime(taskUpdateMessageMap.get("sendTime").toString());
            task.setSendAddress(taskUpdateMessageMap.get("sendAddress").toString());
            task.setCarType(taskUpdateMessageMap.get("carType").toString());
            task.setRemarkMessage(taskUpdateMessageMap.get("remarkMessage").toString());
            task.setThingMessage(taskUpdateMessageMap.get("thingMessage").toString());
            task.setFbaCode(taskUpdateMessageMap.get("fbaCode").toString());
            task.setFbaId(taskUpdateMessageMap.get("fbaId").toString());
            task.setThingNo(taskUpdateMessageMap.get("thingNo").toString());

//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
//            java.util.Date date = new Date();//获得当前时间
//            String updateTime = df.format(date);//将当前时间转换成特定格式的时间字符串，这样便可以插入到数据库中
//            task.setUpdateTime(updateTime);

            taskService.taskUpdate(task);
            return "更新任务信息成功";
        }

    }

    @GetMapping("/taskDeleteByIdAndCusId")
    public String   taskDeleteByIdAndCusId(@RequestParam("id") int id){
        String cusId= (String) request.getSession().getAttribute("cusId");
        taskService.taskDeleteByIdAndCusId(id,cusId);
        return "taskDeleteResult";
    }

}
