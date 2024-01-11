package com.application.rg.presentation.presenter.user;
import com.application.rg.domain.output_boundary.user.create.CreateNewUserResponse;
import com.application.rg.domain.output_boundary.user.create.UserCreatedOutputBoundary;
import com.application.rg.presentation.viewmodel.user.UserCreatedViewModel;

public class UserCreatedPresenter implements UserCreatedOutputBoundary {

    private UserCreatedViewModel viewModel;

    public UserCreatedViewModel getViewModel(){return viewModel;}


    @Override
    public void present(CreateNewUserResponse response) {
        viewModel = UserCreatedViewModel
                .builder()
                .id(response.id())
                .username(response.username())
                .email(response.email())
                .password(response.password())
                .role(response.role())
                .build();
    }
}
