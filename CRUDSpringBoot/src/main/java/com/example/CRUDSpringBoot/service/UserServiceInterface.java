package com.example.CRUDSpringBoot.service;

import com.example.CRUDSpringBoot.model.User;

import java.util.List;

public interface UserServiceInterface {
    void add(User user);

    List<User> listUsers();

    User readUser(Long id);

    void edit(User user);

    void delete(Long id);
}
