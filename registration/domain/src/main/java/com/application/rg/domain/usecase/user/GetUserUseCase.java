package com.application.rg.domain.usecase.user;

import com.application.rg.domain.dao.user.AuthenticationDao;
import com.application.rg.domain.dao.user.UserDao;
import com.application.rg.domain.entity.authentication.Authentication;
import com.application.rg.domain.entity.user.User;
import com.application.rg.domain.input_boundary.user.get.detail.GetUserInputBoundary;
import com.application.rg.domain.input_boundary.user.get.detail.GetUserRequest;
import com.application.rg.domain.output_boundary.user.get.detail.GetUserOutputBoundary;
import com.application.rg.domain.output_boundary.user.get.detail.GetUserResponse;

public class GetUserUseCase implements GetUserInputBoundary {

    private final UserDao userDao;

    private final AuthenticationDao authenticationDao;

    private final GetUserOutputBoundary presenter;

    public GetUserUseCase(UserDao userDao,
                          AuthenticationDao authenticationDao,
                          GetUserOutputBoundary presenter){

        this.userDao = userDao;
        this.presenter = presenter;
        this.authenticationDao = authenticationDao;
    }


    @Override
    public void execute(GetUserRequest request) {
        User user = getUser(request);
        if(user == null){
            throw new UserDao.UserNotFoundException();
        }

        String token = getToken(request).getToken();

        GetUserResponse responseModel = GetUserResponse.builder()
                .token(token).build();

        presenter.present(responseModel);
    }

    private User getUser(GetUserRequest request){

        return userDao.getUser(request);
    }

    private Authentication getToken(GetUserRequest request){

        return authenticationDao.generateToken(request);
    }










}
