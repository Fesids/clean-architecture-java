package com.application.rg.domain.input_boundary.user.get.detail;

import lombok.Builder;

public record GetUserRequest(
        String email,
        String password
) {

    @Builder
    public GetUserRequest{

    }

}
