package com.application.rg.domain.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public interface UserUtils {

    static String passEncode(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

}
