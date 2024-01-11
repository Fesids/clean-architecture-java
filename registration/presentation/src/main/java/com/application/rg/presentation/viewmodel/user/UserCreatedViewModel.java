package com.application.rg.presentation.viewmodel.user;

import com.application.rg.domain.enums.UserRoles;
import lombok.Builder;
import org.joda.time.DateTime;

public record UserCreatedViewModel(

        String id,
        String username,
        String email,
        String password,

        UserRoles role
) {

    @Builder
    public UserCreatedViewModel{

    }

}
