package com.example.gxymavenspringboot1.service;

import com.example.gxymavenspringboot1.pojo.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {
    List<Task> searchTaskByCusId(String cusId);

    int taskAdd(Task task);

    Task searchTaskByIdAndCusId(int id,String cusId);

    int taskUpdate(Task task);

    void taskDeleteByIdAndCusId(int id,String cusId);

}
