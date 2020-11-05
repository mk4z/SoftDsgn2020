package com.example.wsp_spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignService {

    private final DBRepository dbRepository;

    @Autowired
    public SignService(DBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public UserValue signIn(String userId, String userPassword) {

        AuthnData authnData = dbRepository.findAuthnData(userId, userPassword);

        return new UserValue(authnData.getUserId(), authnData.getUserName());

    }

    public int signUp(AuthnData authnData) {
        return dbRepository.insertAuthnData(authnData);
    }

}
