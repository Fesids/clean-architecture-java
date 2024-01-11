package com.application.rg.domain.input_boundary.user.create;

import com.application.rg.domain.entity.user.User;
import com.application.rg.domain.enums.UserRoles;
import com.application.rg.domain.utils.UserUtils;
import lombok.Builder;

import java.time.LocalDateTime;

public record CreateNewUserRequest(

        String role,
        String email,

        String username,

        String password
) {

    public User createClient(CreateNewUserRequest body){
        return User.builder().username(body.username)
                .email(body.email)
                .password(UserUtils.passEncode(body.password))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .role(UserRoles.CLIENT)
                .build();

    }

    public User createAdmin(CreateNewUserRequest body){
        return User.builder().username(body.username)
                .email(body.email)
                .password(UserUtils.passEncode(body.password))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .role(UserRoles.ADMIN)

                .build();
    }

    public User createStaff(CreateNewUserRequest body){
        return User.builder().username(body.username)
                .email(body.email)
                .password(UserUtils.passEncode(body.password))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .role(UserRoles.STAFF)
                .build();
    }

    @Builder
    public CreateNewUserRequest{

    }

}
