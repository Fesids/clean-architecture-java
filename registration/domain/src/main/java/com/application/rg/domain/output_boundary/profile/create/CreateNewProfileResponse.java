package com.application.rg.domain.output_boundary.profile.create;

import com.application.rg.domain.entity.user.User;
import lombok.Builder;

public record CreateNewProfileResponse(

        String id,

        String userId
) {

    @Builder
    public CreateNewProfileResponse{

    }
}
