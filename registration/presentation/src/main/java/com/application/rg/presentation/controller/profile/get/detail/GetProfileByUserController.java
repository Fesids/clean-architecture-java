package com.application.rg.presentation.controller.profile.get.detail;

import com.application.rg.domain.input_boundary.profile.get.detail.GetProfileByUserInputBoundary;
import com.application.rg.domain.input_boundary.profile.get.detail.GetProfileByUserRequest;
import com.application.rg.domain.output_boundary.profile.get.detail.GetProfileByUserOutputBoundary;
import com.application.rg.presentation.ResponseViewModel;
import com.application.rg.presentation.presenter.profile.GetProfileByUserPresenter;
import com.application.rg.presentation.viewmodel.profile.GetProfileByUserViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class GetProfileByUserController {

    private final GetProfileByUserInputBoundary usecase;

    private final GetProfileByUserOutputBoundary presenter;

    public GetProfileByUserController(
            GetProfileByUserInputBoundary usecase,
            GetProfileByUserOutputBoundary presenter
    ){
        this.usecase = usecase;
        this.presenter = presenter;

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<GetProfileByUserViewModel> execute(
            @PathVariable("id") String id
    ){
        usecase.execute(GetProfileByUserRequest.builder()
                .userId(id)
                .build()
        );

        return ResponseViewModel.<GetProfileByUserViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((GetProfileByUserPresenter) presenter).getViewModel())
                .build();

    }

}
