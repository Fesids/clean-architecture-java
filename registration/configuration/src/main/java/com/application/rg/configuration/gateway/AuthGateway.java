package com.application.rg.configuration.gateway;

import com.application.rg.configuration.dao.authentication.UserAuthenticationDao;
import com.application.rg.configuration.security.JwtService;
import com.application.rg.data.dao.user.MongoUserDao;
import com.application.rg.data.database.MongoDatabase;
import com.application.rg.data.repository.user.UserRepository;
import com.application.rg.domain.dao.user.AuthenticationDao;
import com.application.rg.domain.dao.user.UserDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthGateway implements AuthenticationGateway{

    private final AuthenticationDao authenticationDao;

    private final UserDao userDao;

    public AuthGateway(JwtService jwtService, AuthenticationManager authenticationManager,
                       UserDetailsService userDetailsService, UserRepository userRepository, MongoTemplate mongoTemplate){
        userDao = new MongoDatabase(userRepository, mongoTemplate, null).userGateway();
        authenticationDao = new UserAuthenticationDao(jwtService, authenticationManager, userDetailsService, userDao);

    }
    @Override
    public AuthenticationDao authenticationGateway() {

        return authenticationDao;
    }
}
