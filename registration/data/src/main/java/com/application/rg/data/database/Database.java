package com.application.rg.data.database;

import com.application.rg.domain.dao.profile.ProfileDao;
import com.application.rg.domain.dao.user.AuthenticationDao;
import com.application.rg.domain.dao.user.UserDao;

public interface Database {

    UserDao userGateway();

    ProfileDao profileGateway();

    //AuthenticationDao authenticationGateWay();
}
