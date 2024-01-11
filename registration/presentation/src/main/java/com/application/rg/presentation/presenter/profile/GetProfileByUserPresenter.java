package com.application.rg.presentation.presenter.profile;

import com.application.rg.domain.output_boundary.profile.get.detail.GetProfileByUserOutputBoundary;
import com.application.rg.domain.output_boundary.profile.get.detail.GetProfileByUserResponse;
import com.application.rg.presentation.viewmodel.profile.GetProfileByUserViewModel;

public class GetProfileByUserPresenter implements GetProfileByUserOutputBoundary {

    private GetProfileByUserViewModel viewModel;

    public GetProfileByUserViewModel getViewModel(){return viewModel;}

    @Override
    public void present(GetProfileByUserResponse response) {
        viewModel = GetProfileByUserViewModel
                .builder()
                .id(response.id())
                .userId(response.userId())
                .build();
    }
}
