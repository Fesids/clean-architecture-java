package com.application.rg.configuration.dao.authentication;

import com.application.rg.configuration.security.JwtService;
import com.application.rg.data.dao.user.MongoUserDao;
import com.application.rg.domain.dao.user.AuthenticationDao;
import com.application.rg.domain.dao.user.UserDao;
import com.application.rg.domain.entity.authentication.Authentication;
import com.application.rg.domain.entity.user.User;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserRequest;
import com.application.rg.domain.input_boundary.user.get.detail.GetUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserAuthenticationDao implements AuthenticationDao {

    private final JwtService jwtService;


    private final AuthenticationManager authenticationManager;


    private final UserDetailsService userDetail;

    private final UserDao mongoUserDao;

    public UserAuthenticationDao(
            JwtService jwtService,
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            UserDao mongoUserDao

    ){
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDetail = userDetailsService;
        this.mongoUserDao = mongoUserDao;
    }


    @Override
    public User register(CreateNewUserRequest body, String role) {
        User user = mongoUserDao.createNewUser(body, role);

        return user;
    }

    @Override
    public Authentication generateToken(GetUserRequest body) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(body.email(),
                        body.password())
        );

        var user = this.userDetail.loadUserByUsername(body.email());

        String token = jwtService.generateToken(user);

        return Authentication.builder().token(token).build();

    }
}
