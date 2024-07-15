package com.example.gxymavenspringboot1.service.impl;

import com.example.gxymavenspringboot1.DAO.TaskMapper;
import com.example.gxymavenspringboot1.DAO.UserMapper;
import com.example.gxymavenspringboot1.pojo.Task;
import com.example.gxymavenspringboot1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> searchTaskByCusId(String cusId) {
        List<Task>  taskResultList=new ArrayList<>();
        if(cusId.equals("pandaLine"))
        {
            taskResultList=taskMapper.searchAllTask();
        }
        else
        {
            taskResultList=taskMapper.searchTaskByCusId(cusId);

        }
        return taskResultList;

    }

    @Override
    public int taskAdd(Task task) {
        int result =0;
        result=taskMapper.taskAdd(task);
        return  result;
    }

    @Override
    public Task searchTaskByIdAndCusId(int id, String cusId) {
        return taskMapper.searchTaskByIdAndCusId(id,cusId);
    }

    @Override
    public int taskUpdate(Task task) {
        return taskMapper.taskUpdate(task);
    }

    @Override
    public void taskDeleteByIdAndCusId(int id, String cusId) {
        taskMapper.taskDeleteByIdAndCusId(id,cusId);
    }

}

