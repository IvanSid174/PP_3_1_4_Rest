package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    boolean add(User user);
    void delete(int id);
    void edit(User user, int id);
    User getById(int id);
    public User getAuthUser();

    Object getAllRoles();
}
