package com.minazuki.bbsbackend.user.dao.mapper;

import com.minazuki.bbsbackend.user.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time")
    })
    User findUserById(@Param("id") long id);

    @Insert("INSERT INTO user" +
            "(is_admin,username,password,nickname,avatar_url,created_time,last_signin_time,email,phonenumber) " +
            "VALUES(#{isAdmin}, #{username}, #{password}, #{nickname}," +
            "#{avatarUrl}, #{createdAt}, #{lastSignIn}, #{email}, #{phoneNumber})")
    void addUser(@Param("user") User user);



}
