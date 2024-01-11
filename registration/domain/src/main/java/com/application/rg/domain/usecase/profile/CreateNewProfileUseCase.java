package com.application.rg.domain.usecase.profile;

import com.application.rg.domain.dao.profile.ProfileDao;
import com.application.rg.domain.entity.profile.Profile;
import com.application.rg.domain.input_boundary.profile.create.CreateNewProfileInputBoundary;
import com.application.rg.domain.input_boundary.profile.create.CreateNewProfileRequest;
import com.application.rg.domain.output_boundary.profile.create.CreateNewProfileResponse;
import com.application.rg.domain.output_boundary.profile.create.ProfileCreatedOutputBoundary;

public class CreateNewProfileUseCase implements CreateNewProfileInputBoundary {


    private final ProfileDao profileDao;

    private final ProfileCreatedOutputBoundary presenter;

    public CreateNewProfileUseCase(ProfileDao profileDao, ProfileCreatedOutputBoundary presenter){
        this.profileDao = profileDao;
        this.presenter = presenter;
    }


    @Override
    public void execute(CreateNewProfileRequest request) {
        validateProfile(request);
        Profile savedProfile = createProfile(request);

        CreateNewProfileResponse responseModel = new CreateNewProfileResponse(savedProfile.getId(), savedProfile.getUserId());

        presenter.present(responseModel);
    }

    private void validateProfile(CreateNewProfileRequest request){
        if(request.userId().equals("")){
            throw new ProfileDao.ProfileNotFoundException();
        }

    }


    private Profile createProfile(CreateNewProfileRequest request){
        return profileDao.createNewProfile(request);
    }


}
