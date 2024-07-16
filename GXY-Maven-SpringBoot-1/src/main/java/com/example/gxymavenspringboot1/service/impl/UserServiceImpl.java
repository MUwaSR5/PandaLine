package com.example.gxymavenspringboot1.service.impl;

import com.example.gxymavenspringboot1.DAO.UserMapper;
import com.example.gxymavenspringboot1.pojo.UpdateUserEnter;
import com.example.gxymavenspringboot1.pojo.User;
import com.example.gxymavenspringboot1.pojo.UserLoginVerify;
import com.example.gxymavenspringboot1.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> userQuery() {
        return userMapper.userQuery();
    }

    @Override
    public Integer loginVerify(UserLoginVerify userLoginVerify) {

        Integer result=userMapper.loginVerify(userLoginVerify);
        return result;
    }

    @Override
    public Integer userAdd(User user) {
        return userMapper.userAdd(user);
    }

    @Override
    public User selectUserByCusId(String cusId) {
        return userMapper.selectUserByCusId(cusId);
    }

    @Override
    public User userUpdateQueryById(int id) {
        return userMapper.userUpdateQueryById(id);
    }

    @Override
    public void userUpdateById(UpdateUserEnter updateUserEnter) {
        userMapper.userUpdateById(updateUserEnter);
    }

    @Override
    public void userDeleteById(int id) {
        userMapper.userDeleteById(id);
    }
}
