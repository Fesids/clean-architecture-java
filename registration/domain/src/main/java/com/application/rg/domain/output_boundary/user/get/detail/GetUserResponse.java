package com.application.rg.domain.output_boundary.user.get.detail;

import com.application.rg.domain.enums.UserRoles;
import lombok.Builder;
import org.joda.time.DateTime;

import java.time.LocalDateTime;

public record GetUserResponse(

        String token
        /*String id,
        String username,
        String email,

        String password,

        UserRoles role,

        LocalDateTime createdAt,

        LocalDateTime updatedAt*/
) {

    @Builder
    public GetUserResponse{

    }
}
