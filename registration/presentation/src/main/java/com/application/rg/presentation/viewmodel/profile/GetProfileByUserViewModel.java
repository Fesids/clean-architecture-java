package com.application.rg.presentation.viewmodel.profile;

import com.application.rg.domain.entity.user.User;
import lombok.Builder;

public record GetProfileByUserViewModel(
        String id,

        String userId
) {

    @Builder
    public GetProfileByUserViewModel{

    }
}
