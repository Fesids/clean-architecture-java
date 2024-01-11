package com.application.rg.data.database;

/*import com.application.rg.configuration.dao.authentication.UserAuthenticationDao;
import com.application.rg.configuration.security.JwtService;*/
import com.application.rg.data.dao.profile.MongoProfileDao;
import com.application.rg.data.dao.user.MongoUserDao;
import com.application.rg.data.repository.profile.ProfileRepository;
import com.application.rg.data.repository.user.UserRepository;
import com.application.rg.domain.dao.profile.ProfileDao;
import com.application.rg.domain.dao.user.AuthenticationDao;
import com.application.rg.domain.dao.user.UserDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

public class MongoDatabase implements Database{

    private final UserDao userDao;

    private final ProfileDao profileDao;

    //private final AuthenticationDao authenticationDao;

    public MongoDatabase(UserRepository userRepository,
                         MongoTemplate mongoTemplate,
                         ProfileRepository profileRepository) {
        userDao = new MongoUserDao(userRepository, mongoTemplate);
        profileDao = new MongoProfileDao(profileRepository, mongoTemplate);

    }


    @Override
    public UserDao userGateway() {
        return userDao;
    }

    @Override
    public ProfileDao profileGateway() {
        return profileDao;
    }


}
