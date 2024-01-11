package com.application.rg.domain.usecase.profile;

import com.application.rg.domain.dao.profile.ProfileDao;
import com.application.rg.domain.entity.profile.Profile;
import com.application.rg.domain.input_boundary.profile.get.detail.GetProfileByUserInputBoundary;
import com.application.rg.domain.input_boundary.profile.get.detail.GetProfileByUserRequest;
import com.application.rg.domain.output_boundary.profile.create.ProfileCreatedOutputBoundary;
import com.application.rg.domain.output_boundary.profile.get.detail.GetProfileByUserOutputBoundary;
import com.application.rg.domain.output_boundary.profile.get.detail.GetProfileByUserResponse;

public class GetProfileByUserUseCase implements GetProfileByUserInputBoundary {

    private final ProfileDao profileDao;

    private final GetProfileByUserOutputBoundary presenter;

    public GetProfileByUserUseCase(ProfileDao profileDao, GetProfileByUserOutputBoundary presenter){
        this.profileDao = profileDao;
        this.presenter = presenter;

    }

    @Override
    public void execute(GetProfileByUserRequest request) {
        Profile profile = getProfile(request);

        GetProfileByUserResponse responseModel = new GetProfileByUserResponse(profile.getId(), profile.getUserId());

        presenter.present(responseModel);
    }

    private Profile getProfile(GetProfileByUserRequest request){
        return profileDao.getProfile(request);
    }

}
