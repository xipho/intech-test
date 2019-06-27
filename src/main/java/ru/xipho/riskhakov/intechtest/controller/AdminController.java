package ru.xipho.riskhakov.intechtest.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin")
@Secured(value = {"ADMIN"})
public class AdminController {

    @GetMapping("")
    public String dashboard() {
        return "redirect:/admin/users";
    }

    @GetMapping("/users")
    public String users() {
        return "admin/users";
    }

    @GetMapping("/categories")
    public String categories() {
        return "admin/categories";
    }

    @GetMapping("/topics")
    public String topics() {
        return "admin/topics";
    }
}
