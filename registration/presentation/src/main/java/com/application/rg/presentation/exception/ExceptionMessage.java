package com.application.rg.presentation.exception;

import com.application.rg.domain.dao.profile.ProfileDao;
import com.application.rg.domain.dao.user.UserDao;

import java.util.HashMap;
import java.util.Map;

public class ExceptionMessage {

    private ExceptionMessage(){}

    public static Map<Class<?>, String> errors = new HashMap<>();

    static {
        errors.put(UserDao.UserNotFoundException.class, "user not found");
        errors.put(UserDao.UserPasswordIsEmpty.class, "password must be set");
        errors.put(UserDao.UserEmailIsEmpty.class, "email must be set");
        errors.put(UserDao.UserNameIsEmpty.class, "username must be set");

        errors.put(ProfileDao.ProfileNotFoundException.class, "profile not found");
        errors.put(ProfileDao.UserIdIsEmpty.class, "user id must be set");
    }



}
