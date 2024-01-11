package com.application.rg.presentation.viewmodel.profile;

import com.application.rg.domain.entity.user.User;
import lombok.Builder;

public record ProfileCreatedViewModel(

        String id,

        String userId
) {

    @Builder
    public ProfileCreatedViewModel{

    }
}
