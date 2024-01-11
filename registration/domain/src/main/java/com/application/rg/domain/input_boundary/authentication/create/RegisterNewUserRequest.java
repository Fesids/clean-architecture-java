package com.application.rg.domain.input_boundary.authentication.create;

public record RegisterNewUserRequest(

        String role,
        String email,

        String username,

        String password

) {
}
