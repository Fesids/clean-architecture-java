package com.application.rg.data.model.profile;

import com.application.rg.domain.entity.profile.Profile;
import com.application.rg.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@Data
@Document("PROFILES")
public class ProfileDB {


    public Profile mapToEntity(){
        return new Profile(
                this.id,
                this.userId
                );
    }

    public ProfileDB(){
        this.id = new Object().toString();
    }

    @Id
    private String id;

    //@DBRef
    private String userId;

}
