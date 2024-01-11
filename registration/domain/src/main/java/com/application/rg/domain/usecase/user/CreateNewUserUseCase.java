package com.application.rg.domain.usecase.user;

import com.application.rg.domain.dao.user.UserDao;
import com.application.rg.domain.entity.user.User;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserInputBoundary;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserRequest;
import com.application.rg.domain.output_boundary.user.create.CreateNewUserResponse;
import com.application.rg.domain.output_boundary.user.create.UserCreatedOutputBoundary;

public class CreateNewUserUseCase implements CreateNewUserInputBoundary {

    private final UserDao userDao;

    private final UserCreatedOutputBoundary presenter;

    public CreateNewUserUseCase(UserDao userDao, UserCreatedOutputBoundary presenter) {

        this.userDao = userDao;

        this.presenter = presenter;
    }

    @Override
    public void execute(CreateNewUserRequest request) {
        validateUser(request);
        User savedUser = createUser(request);


        CreateNewUserResponse responseModel = CreateNewUserResponse.builder()
                .id(savedUser.getId())
                .role(savedUser.getRole())
                        .email(savedUser.getEmail())
                                .username(savedUser.getUsername())
                                        .password(savedUser.getPassword()).build();

        presenter.present(responseModel);
    }

    private void validateUser(CreateNewUserRequest request) {
        if(request.username().equals("")) {
            throw new UserDao.UserNameIsEmpty();
        }

        if(request.email().equals("")) {
            throw new UserDao.UserEmailIsEmpty();
        }

        if(request.password().equals("")) {
            throw new UserDao.UserPasswordIsEmpty();
        }
    }

    private User createUser(CreateNewUserRequest request) {
        return userDao.createNewUser(new CreateNewUserRequest(
                request.role(),
                request.email(),
                request.username(),
                request.password()

        ), request.role());
    }

}
