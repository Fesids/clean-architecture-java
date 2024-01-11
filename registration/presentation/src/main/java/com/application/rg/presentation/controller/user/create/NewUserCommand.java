package com.application.rg.presentation.controller.user.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NewUserCommand {

    private String username;

    private String email;

    private String password;
}
