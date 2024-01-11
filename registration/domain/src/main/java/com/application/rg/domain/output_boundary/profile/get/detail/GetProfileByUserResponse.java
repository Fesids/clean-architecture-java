package com.application.rg.domain.output_boundary.profile.get.detail;

import com.application.rg.domain.entity.user.User;
import lombok.Builder;

public record GetProfileByUserResponse(
        String id,

        String userId
) {

    @Builder
    public GetProfileByUserResponse{

    }
}
