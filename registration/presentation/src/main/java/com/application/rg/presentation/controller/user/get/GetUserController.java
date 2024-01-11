package com.application.rg.presentation.controller.user.get;

import com.application.rg.domain.input_boundary.user.get.detail.GetUserInputBoundary;
import com.application.rg.domain.input_boundary.user.get.detail.GetUserRequest;
import com.application.rg.domain.output_boundary.user.get.detail.GetUserOutputBoundary;
import com.application.rg.presentation.ResponseViewModel;
import com.application.rg.presentation.presenter.user.GetUserPresenter;
import com.application.rg.presentation.viewmodel.user.GetUserViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class GetUserController {

    private final GetUserInputBoundary usecase;
    private final GetUserOutputBoundary presenter;

    public GetUserController(GetUserInputBoundary usecase,
                             GetUserOutputBoundary presenter) {

        this.usecase = usecase;
        this.presenter = presenter;

    }

    @GetMapping("/testeTK")
    public String testeTk(){
        return "Teste token";
    }



    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<GetUserViewModel> execute(@RequestBody GetUserRequest body){

        usecase.execute(GetUserRequest.builder()
                .email(body.email())
                .password(body.password()).build());


        return ResponseViewModel.<GetUserViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((GetUserPresenter) presenter).getViewModel())
                .build();

    }









}
