package ru.xipho.riskhakov.intechtest.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xipho.riskhakov.intechtest.dao.User;
import ru.xipho.riskhakov.intechtest.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "admin")
@Secured(value = {"ADMIN"})
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String dashboard() {
        return "redirect:/admin/users";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userService.loadUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("/topics")
    public String topics() {
        return "admin/topics";
    }
}
