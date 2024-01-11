package com.application.rg.presentation.presenter.user;

import com.application.rg.domain.output_boundary.user.get.detail.GetUserOutputBoundary;
import com.application.rg.domain.output_boundary.user.get.detail.GetUserResponse;
import com.application.rg.presentation.viewmodel.user.GetUserViewModel;

public class GetUserPresenter implements GetUserOutputBoundary {

    private GetUserViewModel viewModel;

    public GetUserViewModel getViewModel() {return viewModel;}
    @Override
    public void present(GetUserResponse response) {

        viewModel = GetUserViewModel.builder()
                .token(response.token()).build();
    }
}
