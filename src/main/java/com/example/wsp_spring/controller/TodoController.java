package com.example.wsp_spring.controller;

import com.example.wsp_spring.model.SignService;
import com.example.wsp_spring.model.ToDoItem;
import com.example.wsp_spring.model.ToDoService;
import com.example.wsp_spring.model.UserValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoController {

    private final SignService signService;
    private final ToDoService toDoService;

    @Autowired
    public TodoController(SignService signService,
                          ToDoService toDoService) {
        this.signService = signService;
        this.toDoService = toDoService;
    }

    @GetMapping("/todo")
    public String getToDo(Model model) {
        UserValue userValue = signService.whoIsSigned();
        List<ToDoItem> toDoItems = toDoService.showToDoItemsByUserId(userValue.getUserId());
        model.addAttribute("userValue", userValue);
        model.addAttribute("todoItems", toDoItems);
        return "view/todo_list";
    }

    @PostMapping("/todo")
    public String postToDo(String subject, String body, Model model) {
        UserValue userValue = signService.whoIsSigned();
        toDoService.additionalToDoItems(userValue.getUserId(), subject, body);
        List<ToDoItem> toDoItems = toDoService.showToDoItemsByUserId(userValue.getUserId());
        model.addAttribute("userValue", userValue);
        model.addAttribute("todoItems", toDoItems);
        return "view/todo_list";
    }

}
