package com.application.rg.presentation.presenter.profile;

import com.application.rg.domain.output_boundary.profile.create.CreateNewProfileResponse;
import com.application.rg.domain.output_boundary.profile.create.ProfileCreatedOutputBoundary;
import com.application.rg.presentation.viewmodel.profile.ProfileCreatedViewModel;

public class ProfileCreatedPresenter implements ProfileCreatedOutputBoundary {

    private ProfileCreatedViewModel viewModel;

    public ProfileCreatedViewModel getViewModel(){return viewModel;}

    @Override
    public void present(CreateNewProfileResponse response) {
        viewModel = ProfileCreatedViewModel
                .builder()
                .id(response.id())
                .userId(response.userId())
                .build();
    }
}
