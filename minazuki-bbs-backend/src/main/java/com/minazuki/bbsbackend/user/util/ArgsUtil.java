package com.minazuki.bbsbackend.user.util;

import com.minazuki.bbsbackend.user.pojo.User;
import com.minazuki.bbsbackend.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ArgsUtil {
    public static User fromArgs(Map<String, String> args) {
        User user = new User();
        for(Map.Entry<String, String> entry : args.entrySet()) {
            switch (entry.getKey()) {
                case "id":
                    user.setId(Integer.parseInt(entry.getValue()));
                    break;
                case "isAdmin":
                    user.setAdmin(Boolean.parseBoolean(entry.getValue()));
                    break;
                case "username":
                    user.setUsername(entry.getValue());
                    break;
                case "password":
                    user.setPassword(entry.getValue());
                    break;
                case "nickname":
                    user.setNickname(entry.getValue());
                    break;
                case "signature":
                    user.setSignature(entry.getValue());
                    break;
                case "privacyShow":
                    user.setPrivacyShow(Boolean.parseBoolean(entry.getValue()));
                    break;
                case "avatarUrl":
                    user.setAvatarUrl(entry.getValue());
                    break;
                case "createdAt":
                    user.setCreatedAt(DateUtil.strToLocalDateTime(entry.getValue()));
                    break;
                case "lastSignIn":
                    user.setLastSignIn(DateUtil.strToLocalDateTime(entry.getValue()));
                    break;
                case "email":
                    user.setEmail(entry.getValue());
                    break;
                case "phoneNumber":
                    user.setPhoneNumber(entry.getValue());
                    break;
                case "default":
                    log.warn("IllegalArgument: " + entry.getKey() + "->" + entry.getValue());
                    break;
            }
        }
        return user;
    }
}
