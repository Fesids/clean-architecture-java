package com.application.rg.domain.dao.user;

import com.application.rg.domain.entity.user.User;
import com.application.rg.domain.exception.BusinessException;
import com.application.rg.domain.exception.NotFoundException;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserRequest;
import com.application.rg.domain.input_boundary.user.get.detail.GetUserRequest;

import java.util.Optional;

public interface UserDao {

    User createNewUser(CreateNewUserRequest body, String role);

    User getUser(GetUserRequest body);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    class UserNotFoundException extends RuntimeException implements NotFoundException{}

    class UserNameIsEmpty extends RuntimeException implements BusinessException{}

    class UserEmailIsEmpty extends RuntimeException implements BusinessException{}

    class UserPasswordIsEmpty extends RuntimeException implements BusinessException{}

}
