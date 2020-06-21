package com.minazuki.bbsbackend.user.dao.sql;

import com.minazuki.bbsbackend.user.pojo.User;
import com.minazuki.bbsbackend.user.util.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.WeakHashMap;

@Slf4j
public class UserSqlProvider {
    public String update(final Map<String, Object> args ) {
        return new SQL() {
            {
                UPDATE("user");
                for (Map.Entry<String, Object> entry : args.entrySet()
                     ) {
                    switch (entry.getKey()) {
                        case "isAdmin":
                            SET("is_admin = #{isAdmin}");
                            break;
                        case "username":
                            SET("username = #{username}");
                            break;
                        case "password":
                            SET("password = #{password}");
                            break;
                        case "nickname":
                            SET("nickname = #{nickname}");
                            break;
                        case "signature":
                            SET("signature = #{signature}");
                            break;
                        case "privacyShow":
                            SET("privacy_show = #{privacyShow}");
                            break;
                        case "avatarUrl":
                            SET("avatar_url = #{avatarUrl}");
                            break;
                        case "createdAt":
                            SET("created_time = #{createdAt}");
                            break;
                        case "lastSignIn":
                            SET("last_signin_time = #{lastSignIn}");
                            break;
                        case "email":
                            SET("email = #{email}");
                            break;
                        case "phoneNumber":
                            SET("phonenumber = #{phoneNumber}");
                            break;
                        case "id": break;
                        default:
                            log.warn("illegal arg: " + entry);
                    }
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String select(final Map<String, Object> args) {
        return new SQL() {
            {
                SELECT("*");
                FROM("user");
                for (Map.Entry<String, Object> entry : args.entrySet()
                     ) {
                    switch (entry.getKey()) {
                        case "id":
                            WHERE("id = #{id}");
                            break;
                        case "isAdmin":
                            WHERE("is_admin = #{isAdmin}");
                            break;
                        case "username":
                            entry.setValue("%" + entry.getValue() + "%");
                            WHERE("username like #{username}");
                            break;
                        case "nickname":
                            entry.setValue("%" + entry.getValue() + "%");
                            WHERE("nickname like #{nickname}");
                            break;
                        case "signature":
                            entry.setValue("%" + entry.getValue() + "%");
                            WHERE("signature like #{signature}");
                            break;
                        case "privacyShow":
                            WHERE("privacy_show = #{privacyShow}");
                            break;
                        case "email":
                            entry.setValue("%" + entry.getValue() + "%");
                            WHERE("email like #{email}");
                            break;
                        case "phoneNumber":
                            entry.setValue("%" + entry.getValue() + "%");
                            WHERE("phonenumber like #{phoneNumber}");
                            break;
                        default:
                            log.warn("illegal arg: " + entry);
                    }
                }
            }
        }.toString();
    }

    public String uniqueCheck(final Map<String, Object> args) {
        return new SQL() {
            {
                SELECT("*");
                FROM("user");
                WHERE("username = #{username}");
                OR();
                WHERE("nickname = #{nickname}");
                OR();
                WHERE("email = #{email}");
                OR();
                WHERE("phonenumber = #{phoneNumber}");
            }
        }.toString();
    }
}
