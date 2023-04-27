package com.example.CRUDSpringBoot.controller;

import com.example.CRUDSpringBoot.model.User;
import com.example.CRUDSpringBoot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add new user
    @GetMapping("/add")
    public String addPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "addPage";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    // print all users
    @GetMapping
    public String printUsers(Model model) {
        List<User> usersList = userService.listUsers();
        model.addAttribute("userList", usersList);
        return "users";
    }

    // Edit user
    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") long id, ModelMap model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "editPage";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/users";
    }

    //delete users
    @DeleteMapping("/{id}")
    public String deletePage(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }


}