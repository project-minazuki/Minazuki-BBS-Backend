package com.minazuki.bbsbackend.user.service;

import java.util.List;

import com.minazuki.bbsbackend.user.dataObject.UserInfoOutDto;
import com.minazuki.bbsbackend.user.dataObject.UserRegistrationDto;
import com.minazuki.bbsbackend.user.dataObject.UserSignInDto;
import com.minazuki.bbsbackend.user.dataObject.UserUpdateDto;
import com.minazuki.bbsbackend.user.exception.DuplicateInfoException;
import com.minazuki.bbsbackend.user.exception.NoUserMatchException;

public interface UserService {

    List<UserInfoOutDto> search(String keyword);

    UserInfoOutDto getByIndex(Integer id);

    void updateUser(UserUpdateDto userUpdateDto) throws DuplicateInfoException;

    boolean signUp(UserRegistrationDto userRegistrationDto) throws DuplicateInfoException;

    String signIn(UserSignInDto userSignInDto) throws NoUserMatchException;
}
