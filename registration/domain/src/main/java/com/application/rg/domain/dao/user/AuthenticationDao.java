package com.application.rg.domain.dao.user;

import com.application.rg.domain.entity.authentication.Authentication;
import com.application.rg.domain.entity.user.User;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserRequest;
import com.application.rg.domain.input_boundary.user.get.detail.GetUserRequest;

public interface AuthenticationDao {

    User register(CreateNewUserRequest body, String role);

    Authentication generateToken(GetUserRequest body);

}
