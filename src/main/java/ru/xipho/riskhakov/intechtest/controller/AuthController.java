package ru.xipho.riskhakov.intechtest.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.xipho.riskhakov.intechtest.dto.UserDto;
import ru.xipho.riskhakov.intechtest.service.UserService;
import ru.xipho.riskhakov.intechtest.validations.ValidPassword;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String goHome() {
        return "redirect:/topics";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

//    @PostMapping("/login")
//    public String signIn() {
//        return "auth/login";
//    }

    @PostMapping(value = "/register")
    public ModelAndView signUp(
            @Valid UserDto userDto,
            BindingResult result,
            WebRequest request,
            Errors errors) {

        if (!result.hasErrors()) {
            userService.createUser(userDto, result);
        }

        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("auth/register");
            modelAndView.addObject("user", userDto);
            modelAndView.addObject("errors", errors.getAllErrors());
        } else {
            modelAndView.setViewName("auth/login");
        }

        return modelAndView;
    }
}
