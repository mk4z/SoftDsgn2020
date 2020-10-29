package com.example.wsp_spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignService {

    private final DBRepositpry dbRepositpry;

    @Autowired
    public SignService(DBRepositpry dbRepositpry) {
        this.dbRepositpry = dbRepositpry;
    }

    public UserValue signIn(String userId, String userPassword) {

        AuthnData authnData = dbRepositpry.findAuthnData(userId, userPassword);

        return new UserValue(authnData.getUserId(), authnData.getUserName());

    }

    public int signUp(AuthnData authnData) {
        return dbRepositpry.insertAuthnData(authnData);
    }

}
