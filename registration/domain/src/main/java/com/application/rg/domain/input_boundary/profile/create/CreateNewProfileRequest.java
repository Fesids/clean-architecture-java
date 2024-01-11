package com.application.rg.domain.input_boundary.profile.create;

import com.application.rg.domain.entity.profile.Profile;
import com.application.rg.domain.entity.user.User;
import lombok.Builder;

public record CreateNewProfileRequest(
        String userId
) {

    @Builder
    public CreateNewProfileRequest{

    }
}
