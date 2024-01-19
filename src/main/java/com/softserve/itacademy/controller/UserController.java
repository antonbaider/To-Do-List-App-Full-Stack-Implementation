package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Role;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.RoleService;
import com.softserve.itacademy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/create")
    public String create(Model model) {
        User newUser = new User();
        model.addAttribute("user", newUser);
        List<Role> allRoles = roleService.getAll();
        model.addAttribute("roles", allRoles);
        return "create-user";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User newUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("constraintViolations", bindingResult.getFieldErrors());
            List<Role> allRoles = roleService.getAll();
            model.addAttribute("roles", allRoles);
            return "create-user";
        }
        userService.create(newUser);
        return "redirect:/todos/all/users/" + newUser.getId();
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable("id") long id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        List<Role> allRoles = roleService.getAll();
        model.addAttribute("roles", allRoles);
        return "user-info";
    }

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

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        List<Role> allRoles = roleService.getAll();
        model.addAttribute("roles", allRoles);
        return "home";
    }
}