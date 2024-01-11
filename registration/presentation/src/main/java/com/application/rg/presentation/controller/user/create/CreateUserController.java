package com.application.rg.presentation.controller.user.create;

import com.application.rg.domain.input_boundary.user.create.CreateNewUserInputBoundary;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserRequest;
import com.application.rg.domain.output_boundary.user.create.UserCreatedOutputBoundary;
import com.application.rg.presentation.ResponseViewModel;
import com.application.rg.presentation.presenter.user.UserCreatedPresenter;
import com.application.rg.presentation.viewmodel.user.UserCreatedViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class CreateUserController {
    private final CreateNewUserInputBoundary usecase;
    private final UserCreatedOutputBoundary presenter;

    public CreateUserController(CreateNewUserInputBoundary usecase,
                                UserCreatedOutputBoundary presenter){
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @GetMapping("/teste")
    public String teste(){
        return "teste";
    }

    @PostMapping("/register/{role}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseViewModel<UserCreatedViewModel> execute(@PathVariable("role") String role,
                                                           @RequestBody NewUserCommand request){

        usecase.execute(
                CreateNewUserRequest
                        .builder()
                        .username(request.getUsername())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .role(role).build());

        return ResponseViewModel.<UserCreatedViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((UserCreatedPresenter) presenter).getViewModel())
                .build();


    }
}
