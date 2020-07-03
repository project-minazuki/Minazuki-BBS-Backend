package com.minazuki.bbsbackend.user.service;

import java.util.List;

import com.minazuki.bbsbackend.user.dataobject.UserInfoOutDto;
import com.minazuki.bbsbackend.user.dataobject.UserRegistrationDto;
import com.minazuki.bbsbackend.user.dataobject.UserSignInDto;
import com.minazuki.bbsbackend.user.dataobject.UserUpdateDto;
import com.minazuki.bbsbackend.user.exception.DuplicateUserInfoException;
import com.minazuki.bbsbackend.user.exception.NoUserMatchException;
import com.minazuki.bbsbackend.user.exception.PermissionDeniedException;

public interface UserService {

    List<UserInfoOutDto> search(String keyword);

    UserInfoOutDto getByIndex(Integer id);

    void updateUser(UserUpdateDto userUpdateDto) throws DuplicateUserInfoException, PermissionDeniedException;

    void signUp(UserRegistrationDto userRegistrationDto) throws DuplicateUserInfoException;

    String signIn(UserSignInDto userSignInDto) throws NoUserMatchException;
}
