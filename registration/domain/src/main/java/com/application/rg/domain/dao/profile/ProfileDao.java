package com.application.rg.domain.dao.profile;

import com.application.rg.domain.entity.profile.Profile;
import com.application.rg.domain.exception.BusinessException;
import com.application.rg.domain.exception.NotFoundException;
import com.application.rg.domain.input_boundary.profile.create.CreateNewProfileRequest;
import com.application.rg.domain.input_boundary.profile.get.detail.GetProfileByUserRequest;

public interface ProfileDao {

    Profile createNewProfile(CreateNewProfileRequest body);

    Profile getProfile(GetProfileByUserRequest body );
    class ProfileNotFoundException extends RuntimeException implements NotFoundException {}

    class UserIdIsEmpty extends RuntimeException implements BusinessException {}


}
