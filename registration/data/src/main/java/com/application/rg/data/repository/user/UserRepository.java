package com.application.rg.data.repository.user;

import com.application.rg.data.model.user.UserDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDB, String> {
}
