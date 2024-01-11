package com.application.rg.data.dao.user;

import com.application.rg.data.model.user.UserDB;
import com.application.rg.data.repository.user.UserRepository;
import com.application.rg.domain.dao.user.UserDao;
import com.application.rg.domain.entity.user.User;
import com.application.rg.domain.input_boundary.user.create.CreateNewUserRequest;
import com.application.rg.domain.input_boundary.user.get.detail.GetUserRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoUserDao implements UserDao {
    //@Autowired
    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    public MongoUserDao(UserRepository userRepository, MongoTemplate mongoTemplate){
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
    }



    /*@Autowired
    private MongoTemplate mongoTemplate;*/

    @Override
    public User createNewUser(CreateNewUserRequest body, String role) {


        User newUserBody = null;//body.createClient(body);

        switch (role){
            case "CLIENT" -> {
                newUserBody = body.createClient(body);
            }

            case "STAFF" -> {
                newUserBody = body.createStaff(body);
            }

            case "ADMIN" -> {
                newUserBody = body.createAdmin(body);
            }

        }

        assert newUserBody != null;
        var newUser = UserDB.builder().createdAt(newUserBody.getCreatedAt())
                .updatedAt(newUserBody.getUpdatedAt())
                .username(newUserBody.getUsername())
                .role(newUserBody.getRole())
                .email(newUserBody.getEmail())
                .password(newUserBody.getPassword())
                .build();



        return userRepository.save(newUser).mapToEntity();
        //return "Teste creatre user";
    }

    @Override
    public User getUser(GetUserRequest body) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(body.email()));
        var user = mongoTemplate.findOne(query, UserDB.class, "USERS");

        assert user != null;
        System.out.println(user.mapToEntity());
        return user.mapToEntity();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Query query =  new Query();
        query.addCriteria(Criteria.where("username").is(username));

        var user = mongoTemplate.findOne(query, UserDB.class, "USERS");

        assert user != null;
        //return Optional.empty();
        return Optional.of(user.mapToEntity());
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Query query =  new Query();
        query.addCriteria(Criteria.where("email").is(email));

        var user = mongoTemplate.findOne(query, UserDB.class, "USERS");

        assert user != null;
        //return Optional.empty();
        return Optional.of(user.mapToEntity());
    }
}
