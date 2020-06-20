package com.minazuki.bbsbackend.user.dao.sql;

import com.minazuki.bbsbackend.user.pojo.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class UserSqlProvider {
    public String update(final User user ) {
        return new SQL() {
            {
                UPDATE("user");
                if (!StringUtils.isEmpty(user.getNickname())){
                    SET("nickname = #{nickname}");
                }
                if (!StringUtils.isEmpty(user.getSignature())){
                    SET("signature = #{signature}");
                }
                if (user.isPrivacyShow() != null){
                    SET(("privacy_show = #{privacyShow}"));
                }
                if (user.isAdmin() != null){
                    SET("is_admin = #{isAdmin}");
                }
                if (!StringUtils.isEmpty(user.getAvatarUrl())){
                    SET("avatar_url = #{avatarUrl}");
                }
                if (!StringUtils.isEmpty(user.getPhoneNumber())){
                    SET("phonenumber = #{phoneNumber}");
                }
                if (!StringUtils.isEmpty(user.getEmail())){
                    SET("email = #{email}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String select(final User user) {
        return new SQL() {
            {
                SELECT("*");
                FROM("user");
                if (user.getId() != 0) {
                    WHERE("id = #{id}");
                }
                if (user.isAdmin() != null) {
                    WHERE("is_admin = #{isAdmin}");
                }
                if (!StringUtils.isEmpty(user.getNickname())) {
                    user.setNickname("%" + user.getNickname() + "%");
                    WHERE("nickname like #{nickname}");
                }
                if (!StringUtils.isEmpty(user.getEmail())) {
                    user.setEmail("%" + user.getEmail() + "%");
                    WHERE("email like #{email}");
                }
                if (!StringUtils.isEmpty(user.getPhoneNumber())) {
                    user.setPhoneNumber("%" + user.getPhoneNumber() + "%");
                    WHERE("phonenumber like #{phoneNumber}");
                }
            }
        }.toString();
    }
}
