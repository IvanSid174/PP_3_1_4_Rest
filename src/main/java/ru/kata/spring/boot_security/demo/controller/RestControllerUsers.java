package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.util.List;

@RestController
@RequestMapping({"admin/api/users","user/api/users"})
public class RestControllerUsers {
    private final UserService userService;
    @Autowired
    public RestControllerUsers(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
        public List<User> showAllUsers() {
        List<User> list = userService.allUsers();
        return list;

        }

        @PreAuthorize("hasRole('ROLE_ADMIN')")
        @GetMapping("/{id}")
        public User showUser(@PathVariable int id) {
           return userService.getById(id);

        }

        @GetMapping("/auth_user")
        public User getAuthUser() {
            return userService.getAuthUser();
        }

        @PostMapping
        public List<User> addUser(@RequestBody User user) {
            userService.add(user);
            return userService.allUsers();
        }

        @PutMapping("/{id}")
        public List<User> updateUser(@RequestBody User user, @PathVariable int id) {
            userService.edit(user,id);
            return userService.allUsers();
        }

        @DeleteMapping("/{id}")
        public List<User> deleteUser(@PathVariable int id) {
            userService.delete(id);
            return userService.allUsers();
        }
    }
