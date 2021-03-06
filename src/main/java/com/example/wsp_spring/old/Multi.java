package com.example.wsp_spring.old;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Multi {

    @GetMapping("/multi")
    public String doGet() {
        return "old/multi_form";
    }

    @PostMapping("/multi")
    public String doPost(int x, int y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("ans", x * y);
        return "old/multi_ans";
    }

}
