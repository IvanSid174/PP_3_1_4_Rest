package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers (Model model) {
        // model.addAttribute("users",userService.allUsers());
        // model.addAttribute("rolesList", userService.getAllRoles());
        // model.addAttribute("user", new User());
        // model.addAttribute("authorisedUser", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "allUsers";
    }

    @PostMapping
    public String create(@ModelAttribute("user")  @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/";
        } else {
            userService.add(user);
            return "redirect:/admin/";
        }
    }

//    @PutMapping(value = "/{id}")
//    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
//        if (bindingResult.hasErrors()) {
//            return "edit";
//        } else {
//            userService.edit(user);
//            return "redirect:/admin/";
//        }
//    }
//    @DeleteMapping (value = "/{id}")
//    public String delete( @PathVariable("id") int id){
//        userService.delete(id);
//        return "redirect:/admin/";
//    }
}
