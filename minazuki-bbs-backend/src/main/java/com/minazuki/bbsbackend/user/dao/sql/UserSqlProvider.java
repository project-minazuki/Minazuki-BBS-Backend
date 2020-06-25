package com.minazuki.bbsbackend.user.dao.sql;

import com.minazuki.bbsbackend.user.dataobject.UserRegistrationDto;
import com.minazuki.bbsbackend.user.dataobject.UserUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

@Slf4j
public class UserSqlProvider {
    public String update(final UserUpdateDto userUpdateDto) {
        return new SQL() {
            {
                UPDATE("user");
                if (userUpdateDto.getNickname() != null)
                    SET("nickname = #{nickname}");
                if (userUpdateDto.getAvatarUrl() != null)
                    SET("avatar_url = #{avatarUrl}");
                if (userUpdateDto.getPrivacyShow() != null)
                    SET("privacy_show = #{privacyShow}");
                if (userUpdateDto.getSignature() != null)
                    SET("signature = #{signature}");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String uniqueCheck(final UserRegistrationDto userRegistrationDto) {
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
