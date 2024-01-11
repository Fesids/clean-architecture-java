package com.application.rg.presentation.controller.profile.create;


import com.application.rg.domain.input_boundary.profile.create.CreateNewProfileInputBoundary;
import com.application.rg.domain.input_boundary.profile.create.CreateNewProfileRequest;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserInputBoundary;
import com.application.rg.domain.output_boundary.profile.create.ProfileCreatedOutputBoundary;
import com.application.rg.presentation.ResponseViewModel;
import com.application.rg.presentation.presenter.profile.ProfileCreatedPresenter;
import com.application.rg.presentation.viewmodel.profile.ProfileCreatedViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class CreateProfileController {

    private final CreateNewProfileInputBoundary usecase;

    private final ProfileCreatedOutputBoundary presenter;

    public CreateProfileController(
            CreateNewProfileInputBoundary usecase,
            ProfileCreatedOutputBoundary presenter
    ){
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @GetMapping("/teste")
    public String testeProfile(){
        return "Testeprof";
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseViewModel<ProfileCreatedViewModel> execute(
            @RequestBody NewProfileCommand request
    ){


        usecase.execute(
                CreateNewProfileRequest.builder()
                        .userId(request.userId)
                        .build()
        );

        return ResponseViewModel.<ProfileCreatedViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((ProfileCreatedPresenter) presenter).getViewModel())
                .build();

    }


}
