package com.example.wsp_spring.controller;

import com.example.wsp_spring.model.AuthnData;
import com.example.wsp_spring.model.SignService;
import com.example.wsp_spring.model.UserValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignController {

    private final SignService signService;

    @Autowired
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @GetMapping("/signIn")
    public String getSignIn() {
        return "view/sign_in_form";
    }

    @PostMapping("/signIn")
    public String postSignIn(String userId, String userPassword, Model model) {
        System.out.println(userId + ", " + userPassword);
        UserValue userValue = signService.signIn(userId, userPassword);
        model.addAttribute("userValue", userValue);
        return "view/signed";
    }

    @GetMapping("/signUp")
    public String getSignUp() {
        return "view/sign_up_form";
    }

    @PostMapping("/signUp")
    public String postSignUp(String userId, String userPassword, String userName, Model model) {
        System.out.println(userId + ", " + userPassword + ", " + userName);
        AuthnData authnData = new AuthnData(userId, userPassword, userName);
        signService.signUp(authnData);
        model.addAttribute("authnData", authnData);
        return "view/sign_up_complete";
    }

}
