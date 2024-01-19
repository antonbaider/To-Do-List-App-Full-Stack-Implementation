package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Role;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.RoleService;
import com.softserve.itacademy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping({"/", "home"})
    public String home(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        List<Role> allRoles = roleService.getAll();
        model.addAttribute("roles", allRoles);
        return "home";
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam String userName, Model model) {
        List<User> foundUsers = userService.searchUsersByName(userName);
        model.addAttribute("users", foundUsers);
        return "home";
    }
}