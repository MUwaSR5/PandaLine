package com.example.gxymavenspringboot1.DAO;

import com.example.gxymavenspringboot1.pojo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.swing.text.TabSet;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TaskMapper {
    List<Task> searchTaskByCusId(@Param("cus_id") String cusId);

    List<Task> searchAllTask();

    int taskAdd(Task task);

    Task searchTaskByIdAndCusId(@Param("id") int id,@Param("cus_id") String cusId);

    int taskUpdate(Task task);

    void taskDeleteByIdAndCusId(@Param("id") int id,@Param("cusId") String cusId);
}
