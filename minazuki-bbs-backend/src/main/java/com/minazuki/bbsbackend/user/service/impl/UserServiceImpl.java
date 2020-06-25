package com.minazuki.bbsbackend.user.service.impl;

import com.minazuki.bbsbackend.user.dao.UserDao;
import com.minazuki.bbsbackend.user.dataObject.UserInfoOutDto;
import com.minazuki.bbsbackend.user.dataObject.UserRegistrationDto;
import com.minazuki.bbsbackend.user.dataObject.UserSignInDto;
import com.minazuki.bbsbackend.user.dataObject.UserUpdateDto;
import com.minazuki.bbsbackend.user.exception.DuplicateInfoException;
import com.minazuki.bbsbackend.user.exception.NoUserMatchException;
import com.minazuki.bbsbackend.user.pojo.User;
import com.minazuki.bbsbackend.user.service.UserService;
import com.minazuki.bbsbackend.user.util.JwtUtil;
import com.minazuki.bbsbackend.user.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserInfoOutDto> search(String keyword) {
        List<User> users = userDao.searchUser(keyword);
        List<UserInfoOutDto> userInfoOutDtoList = new ArrayList<>();
        for (User user : users
             ) {
            UserInfoOutDto userInfoOutDto = new UserInfoOutDto();
            userInfoOutDto.setInfo(user);
            userInfoOutDtoList.add(userInfoOutDto);
        }
        return userInfoOutDtoList;
    }

    public UserInfoOutDto getByIndex(Integer id) {
        User user = userDao.getUserById(id);
        UserInfoOutDto userInfoOutDto = new UserInfoOutDto();
        userInfoOutDto.setInfo(user);
        return userInfoOutDto;
    }

    public void updateUser(UserUpdateDto userUpdateDto) throws DuplicateInfoException {
        if (userUpdateDto.isAllNone())
            return;
        if (userUpdateDto.getNickname() != null) {
            User user = userDao.getUserByNickname(userUpdateDto.getNickname());
            if (user == null)
                userDao.updateUser(userUpdateDto);
            else {
                DuplicateInfoException e = new DuplicateInfoException();
                e.addDuplicateInfo("nickname");
                throw e;
            }
        }
        userDao.updateUser(userUpdateDto);
    }

    public boolean signUp(UserRegistrationDto userRegistrationDto) throws DuplicateInfoException {
        List<User> users = userDao.getUserByUniqueKey(userRegistrationDto);
        if (users.size() == 0) {
            User newUser = User.builder().isAdmin(false).username(userRegistrationDto.getUsername())
                    .password(PasswordUtil.encryptPassword(userRegistrationDto.getPassword()))
                    .nickname(userRegistrationDto.getNickname()).privacyShow(true)
                    .createdAt(LocalDateTime.now()).lastSignIn(LocalDateTime.now())
                    .email(userRegistrationDto.getEmail()).phoneNumber(userRegistrationDto.getPhoneNumber())
                    .build();
            userDao.addUser(newUser);
            return true;
        } else {
            DuplicateInfoException e = new DuplicateInfoException();
            for (User user: users
                 ) {
                if (user.getUsername().equals(userRegistrationDto.getUsername()))
                    e.addDuplicateInfo("username");
                if (user.getNickname().equals(userRegistrationDto.getNickname()))
                    e.addDuplicateInfo("nickname");
                if (user.getPhoneNumber().equals(userRegistrationDto.getPhoneNumber()))
                    e.addDuplicateInfo("phoneNumber");
                if (user.getEmail().equals(userRegistrationDto.getEmail()))
                    e.addDuplicateInfo("email");
            }
            throw e;
        }
    }

    public String signIn(UserSignInDto userSignInDto) throws NoUserMatchException {
        userSignInDto.setPassword(PasswordUtil.encryptPassword(userSignInDto.getPassword()));
        User user = userDao.signInCheck(userSignInDto);
        return JwtUtil.sign(user);
    }

}
