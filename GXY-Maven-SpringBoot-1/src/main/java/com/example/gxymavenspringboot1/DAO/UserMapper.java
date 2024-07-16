package com.example.gxymavenspringboot1.DAO;

import com.example.gxymavenspringboot1.pojo.UpdateUserEnter;
import com.example.gxymavenspringboot1.pojo.User;
import com.example.gxymavenspringboot1.pojo.UserLoginVerify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> userQuery();

    Integer loginVerify(UserLoginVerify userLoginVerify);

    Integer userAdd(User user);

    User selectUserByCusId(String cusId);

    User userUpdateQueryById(int id);

    void userUpdateById(UpdateUserEnter updateUserEnter);

    void userDeleteById(int id);
}
