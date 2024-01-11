package com.application.rg.data.repository.profile;

import com.application.rg.data.model.profile.ProfileDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<ProfileDB, String> {
}
