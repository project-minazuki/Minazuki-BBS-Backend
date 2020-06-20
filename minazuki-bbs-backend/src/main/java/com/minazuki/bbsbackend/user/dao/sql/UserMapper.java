package com.minazuki.bbsbackend.user.dao.sql;

import com.minazuki.bbsbackend.user.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user" +
            "(is_admin,username,password,nickname,signature,privacy_show,avatar_url,created_time,last_signin_time,email,phonenumber) " +
            "VALUES(#{isAdmin}, #{username}, #{password}, #{nickname}, #{signature}, #{privacyShow}," +
            "#{avatarUrl}, #{createdAt}, #{lastSignIn}, #{email}, #{phoneNumber})")
    void addUser(@Param("user") User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(@Param("id") long id);

    @UpdateProvider(type = UserSqlProvider.class, method = "update")
    void updateUser(@Param("user") User user);

    @SelectProvider(type = UserSqlProvider.class, method = "select")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    List<User> selectUser(@Param("user") User user);


}
