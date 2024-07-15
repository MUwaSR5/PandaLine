package com.example.gxymavenspringboot1.service;

import com.example.gxymavenspringboot1.pojo.UpdateUserEnter;
import com.example.gxymavenspringboot1.pojo.User;
import com.example.gxymavenspringboot1.pojo.UserLoginVerify;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface UserService {
    List<User> userQuery();

    Integer loginVerify(UserLoginVerify userLoginVerify);

    Integer userAdd(User user);

    User selectUserByCusId(String cusId);

    User userUpdateQueryById(int id);

    void userUpdateById(UpdateUserEnter updateUserEnter);

    void userDeleteById(int id);

}
