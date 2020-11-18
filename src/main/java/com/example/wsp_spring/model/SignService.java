package com.example.wsp_spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class SignService {

    private final HttpSession session;
    private final DBRepository dbRepository;

    @Autowired
    public SignService(HttpSession session,
                       DBRepository dbRepository) {
        this.session = session;
        this.dbRepository = dbRepository;
    }

    public UserValue signIn(String userId, String userPassword) {
        AuthnData authnData = dbRepository.findAuthnData(userId, userPassword);
        System.out.println("sessionId:" + session.getId());
//        return new UserValue(authnData.getUserId(), authnData.getUserName());
        UserValue userValue = new UserValue(authnData.getUserId(), authnData.getUserName());
        sign(userValue);
        return userValue;
    }

    public int signUp(AuthnData authnData) {
        return dbRepository.insertAuthnData(authnData);
    }

    private void sign(UserValue userValue) {
        session.setAttribute("signedUserValue", userValue);
    }

    public UserValue whoIsSigned() {
        UserValue signedUser = (UserValue) session.getAttribute("signedUserValue");
        if (Objects.isNull(signedUser)) {
            throw new RuntimeException("このブラウザはユーザー認証されていません。");
        }
        return signedUser;
    }

    public void signOut() {
        session.invalidate();
    }

}
