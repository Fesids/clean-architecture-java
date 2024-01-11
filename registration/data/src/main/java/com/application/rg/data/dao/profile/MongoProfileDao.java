package com.application.rg.data.dao.profile;

import com.application.rg.data.model.profile.ProfileDB;
import com.application.rg.data.model.user.UserDB;
import com.application.rg.data.repository.profile.ProfileRepository;
import com.application.rg.data.repository.user.UserRepository;
import com.application.rg.domain.dao.profile.ProfileDao;
import com.application.rg.domain.entity.profile.Profile;
import com.application.rg.domain.input_boundary.profile.create.CreateNewProfileRequest;
import com.application.rg.domain.input_boundary.profile.get.detail.GetProfileByUserRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MongoProfileDao implements ProfileDao {

    private final ProfileRepository profileRepository;
    private final MongoTemplate mongoTemplate;

    public MongoProfileDao(ProfileRepository profileRepository, MongoTemplate mongoTemplate){
        this.profileRepository = profileRepository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Profile createNewProfile(CreateNewProfileRequest body) {
        var newProfile = ProfileDB.builder()
                .userId(body.userId()).build();


        return profileRepository.save(newProfile).mapToEntity();


    }

    @Override
    public Profile getProfile(GetProfileByUserRequest body) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(body.userId()));
        var profile = mongoTemplate.findOne(query, ProfileDB.class, "PROFILES");

        assert profile != null;
        System.out.println(profile.mapToEntity());
        return profile.mapToEntity();
    }
}
