package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Role;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.RoleService;
import com.softserve.itacademy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //    @GetMapping("/create")
//    public String create(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
//
//    @PostMapping("/create")
//    public String create(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
//
//    @GetMapping("/{id}/read")
//    public String read(//add needed parameters) {
//        //ToDo
//        return " ";
//    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") long id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        List<Role> allRoles = roleService.getAll();
        model.addAttribute("roles", allRoles);
        return "update-user";

    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable("id") long id, @Valid @ModelAttribute("user") User updatedUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("constraintViolations", bindingResult.getFieldErrors());
            model.addAttribute("user", updatedUser);
            List<Role> allRoles = roleService.getAll();
            model.addAttribute("roles", allRoles);
            return "update-user";
        }
        userService.update(updatedUser);
        return "redirect:/home";
    }
//
//
//    @GetMapping("/{id}/delete")
//    public String delete(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
//
//    @GetMapping("/all")
//    public String getAll(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
}