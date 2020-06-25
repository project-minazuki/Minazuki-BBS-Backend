package com.minazuki.bbsbackend.user.dao.sql;

import com.minazuki.bbsbackend.user.dataobject.UserRegistrationDto;
import com.minazuki.bbsbackend.user.dataobject.UserSignInDto;
import com.minazuki.bbsbackend.user.dataobject.UserUpdateDto;
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

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    User getUserById(@Param("id") Integer id);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(@Param("id") Integer id);

    @UpdateProvider(type = UserSqlProvider.class, method = "update")
    void updateUser(@Param("userUpdateDto")UserUpdateDto userUpdateDto);

    @Select("SELECT * FROM user WHERE nickname like #{keyword} OR username like #{keyword}")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    List<User> searchUsers(@Param("keyword") String keyword);

    @Select("SELECT * FROM user WHERE nickname like #{nickname}")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    User getUserByNickname(@Param("nickname") String nickname);

    @SelectProvider(type = UserSqlProvider.class, method = "uniqueCheck")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    List<User> getUserByUniqueKey(@Param("userRegistrationDto")UserRegistrationDto userRegistrationDto);

    @Select("SELECT * FROM user WHERE password = #{password} AND " +
            "(username = #{username} OR email = #{username} OR phonenumber = #{username})")
    @Results({
            @Result(property = "isAdmin", column = "is_admin"),
            @Result(property = "avatarUrl", column = "avatar_url"),
            @Result(property = "createdAt", column = "created_time"),
            @Result(property = "lastSignIn", column = "last_signin_time"),
            @Result(property = "privacyShow", column = "privacy_show")
    })
    User signInCheck(@Param("userSignInDto") UserSignInDto userSignInDto);
}
