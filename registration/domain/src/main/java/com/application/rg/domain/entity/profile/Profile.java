package com.application.rg.domain.entity.profile;


import com.application.rg.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Profile {

    private String id;

    private String userId;
}
