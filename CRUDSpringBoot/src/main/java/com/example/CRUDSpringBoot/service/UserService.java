package com.example.CRUDSpringBoot.service;

import com.example.CRUDSpringBoot.model.User;
import com.example.CRUDSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    @Override
    public void add(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User readUser(Long id) {
        return userRepository.getOne(id);
    }
    @Transactional
    @Override
    public void edit(User user) {
        userRepository.saveAndFlush(user);
        ;
    }
    @Transactional
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
