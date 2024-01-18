package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping({"/", "home"})
    public String home(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "home";
    }
}