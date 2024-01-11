package com.application.rg.domain.output_boundary.user.create;

import com.application.rg.domain.enums.UserRoles;
import lombok.Builder;

public record CreateNewUserResponse(

        String id,
        String username,
        String email,

        String password,
        UserRoles role
) {

    @Builder
    public CreateNewUserResponse{

    }

}
