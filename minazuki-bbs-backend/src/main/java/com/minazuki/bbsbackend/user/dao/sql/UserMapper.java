package com.minazuki.bbsbackend.user.dao.sql;

import com.minazuki.bbsbackend.user.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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
    void updateUser(@Param("args")Map<String, Object> args);

    @SelectProvider(type = UserSqlProvider.class, method = "select")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    List<User> selectUser(@Param("args") Map<String, Object> args);

    @SelectProvider(type = UserSqlProvider.class, method = "uniqueCheck")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    List<User> getUserByUniqueKey(@Param("args") Map<String, Object> args);

    @Select("SELECT * FROM user WHERE password = #{password} AND " +
            "(username = #{username} OR email = #{username} OR phonenumber = #{username})")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    User signInCheck(@Param("signInInfo") Map<String, Object> signInInfo);
}
