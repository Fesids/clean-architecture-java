package com.application.rg.configuration;

import com.application.rg.configuration.dao.authentication.UserAuthenticationDao;
import com.application.rg.configuration.gateway.AuthGateway;
import com.application.rg.configuration.gateway.AuthenticationGateway;
import com.application.rg.configuration.security.ContextConfiguration;
import com.application.rg.configuration.security.JwtService;
import com.application.rg.data.dao.user.MongoUserDao;
import com.application.rg.data.database.Database;
import com.application.rg.data.database.MongoDatabase;
import com.application.rg.data.repository.profile.ProfileRepository;
import com.application.rg.data.repository.user.UserRepository;
import com.application.rg.domain.dao.user.AuthenticationDao;
import com.application.rg.domain.input_boundary.profile.create.CreateNewProfileInputBoundary;
import com.application.rg.domain.input_boundary.profile.get.detail.GetProfileByUserInputBoundary;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserInputBoundary;
import com.application.rg.domain.input_boundary.user.get.detail.GetUserInputBoundary;
import com.application.rg.domain.output_boundary.profile.create.ProfileCreatedOutputBoundary;
import com.application.rg.domain.output_boundary.profile.get.detail.GetProfileByUserOutputBoundary;
import com.application.rg.domain.output_boundary.user.create.UserCreatedOutputBoundary;
import com.application.rg.domain.output_boundary.user.get.detail.GetUserOutputBoundary;
import com.application.rg.domain.usecase.profile.CreateNewProfileUseCase;
import com.application.rg.domain.usecase.profile.GetProfileByUserUseCase;
import com.application.rg.domain.usecase.user.CreateNewUserUseCase;
import com.application.rg.domain.usecase.user.GetUserUseCase;
import com.application.rg.presentation.presenter.profile.GetProfileByUserPresenter;
import com.application.rg.presentation.presenter.profile.ProfileCreatedPresenter;
import com.application.rg.presentation.presenter.user.GetUserPresenter;
import com.application.rg.presentation.presenter.user.UserCreatedPresenter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EntityScan("com.application.rg.data")
@EnableMongoRepositories(basePackages = "com.application.rg.data")
@ComponentScan({"com.application.rg.data", "com.application.rg.domain", "com.application.rg.presentation", "com.application.rg.configuration"})
public class ApplicationConfiguration {


    @Bean
    public AuthenticationGateway authenticationGateway(
            JwtService jwtService, AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            UserRepository userRepository, MongoTemplate template
    ){
        return new AuthGateway(jwtService, authenticationManager, userDetailsService, userRepository, template);
    }


    @Bean
    public Database database(
            UserRepository userRepository, MongoTemplate template,
            ProfileRepository profileRepository){
        return new MongoDatabase(userRepository, template, profileRepository/*, jwtService, authenticationManager, userDetailsService*/);
    }

    @Bean
    public CreateNewUserInputBoundary createNewUserInputBoundary(
            UserCreatedOutputBoundary presenter, Database database
    ){
        return new CreateNewUserUseCase(database.userGateway(), presenter);
    }

    @Bean
    public UserCreatedOutputBoundary userCreatedOutputBoundary(){

        return new UserCreatedPresenter();
    }

    @Bean
    public GetUserInputBoundary getUserInputBoundary(
            GetUserOutputBoundary presenter, Database database,
            AuthenticationGateway authenticationGateway
    ){
        return new GetUserUseCase(database.userGateway(),authenticationGateway.authenticationGateway() /*database.authenticationGateWay()*/, presenter);
    }


    @Bean
    public GetUserOutputBoundary getUserOutputBoundary(){
        return new GetUserPresenter();
    }


    @Bean
    public CreateNewProfileInputBoundary createNewProfileInputBoundary(
            ProfileCreatedOutputBoundary presenter, Database database
    ){
        return new CreateNewProfileUseCase(database.profileGateway(), presenter);
    }


    @Bean
    public ProfileCreatedOutputBoundary profileCreatedOutputBoundary(){

        return new ProfileCreatedPresenter();
    }



    @Bean
    public GetProfileByUserInputBoundary getProfileByUserInputBoundary(
            GetProfileByUserOutputBoundary presenter, Database database
    ){
        return new GetProfileByUserUseCase(database.profileGateway(),/*database.authenticationGateWay()*/ presenter);
    }


    @Bean
    public GetProfileByUserOutputBoundary getProfileByUserOutputBoundary(){

        return new GetProfileByUserPresenter();
    }


}












