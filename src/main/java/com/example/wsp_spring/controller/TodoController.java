package com.example.wsp_spring.controller;

import com.example.wsp_spring.model.SignService;
import com.example.wsp_spring.model.UserValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    private final SignService signService;

    @Autowired
    public TodoController(SignService signService) {
        this.signService = signService;
    }

    @GetMapping("/todo")
    public String getToDo(Model model) {
        UserValue userValue = signService.whoIsSigned();
        model.addAttribute("userValue", userValue);
        return "view/todo_list";
    }

}
