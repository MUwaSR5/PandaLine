package com.example.gxymavenspringboot1.controller;

import com.example.gxymavenspringboot1.pojo.Task;
import com.example.gxymavenspringboot1.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {


    @Autowired
    TaskService taskService;
    @Autowired
    HttpServletRequest request; //通过注解获取一个request

    @RequestMapping("/index")
    public String index( ){
        return "index";
    }


    //第一种接参方式   @PathVariable注解
    //请求方式：localhost:7001/param/123


    @GetMapping("{orgId}")
    @ResponseBody
    public String getPathVariable(@PathVariable String orgId){
        return "orgId="+orgId;
    }
    //第二种接参方式   @RequestParam注解
    /*
    * 使用这个注解需要注意两个点，一是加了这个参数后则请求中必须传递这个参数，
    * 二是@RequestParam这个注解可以指定名字，请求参数必须和指定的这个名字相同，如果不指定，则默认为具体参数名
    */
    //localhost:7001/param/getParam?myId=18
    @GetMapping("getParam")
    @ResponseBody
    public String getRequestParam(@RequestParam("myId") String id){
        return "id="+id;
    }

    //第三种方式     无注解传参
    //这种方式和2对比，最大的区别就是这个参数不是必传的，请求路径上可以不传递。
    //
    //请求方式：localhost:7001/param/getString?id=18
    @GetMapping("getString")
    @ResponseBody
    public String getString(String id){
        return "id="+id;
    }

    //第四种方式     @RequestBody接收请求体参数
    //这种方式一般用来传递实体对象，加了这个注解后，参数也是必传的。
    //{"id":18}放在请求体中
    @PostMapping("getBody")
    @ResponseBody
    public String getBody(@RequestBody String id){
        return "id="+id;
    }


    //请求多个参数
    @GetMapping("getIdAndOrgId")
    @ResponseBody
    public String getIdAndOrgId(@RequestParam("org") String org,
                                @RequestParam("org_id") String orgId){

        return "id="+org+"||||||"+"org_id="+orgId;
    }







}
