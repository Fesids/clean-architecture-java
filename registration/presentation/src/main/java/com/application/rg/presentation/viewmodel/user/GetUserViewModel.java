package com.application.rg.presentation.viewmodel.user;

import com.application.rg.domain.enums.UserRoles;
import lombok.Builder;
import org.joda.time.DateTime;

import java.time.LocalDateTime;

public record GetUserViewModel(

        String token
) {

    @Builder
    public GetUserViewModel{

    }
}
