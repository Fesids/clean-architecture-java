package com.application.rg.domain.input_boundary.profile.get.detail;

import com.application.rg.domain.entity.user.User;
import lombok.Builder;

public record GetProfileByUserRequest(
        String userId
) {

    @Builder
    public GetProfileByUserRequest{

    }
}
