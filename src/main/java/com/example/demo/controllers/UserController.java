package com.example.demo.controllers;

import com.example.demo.entites.Image;
import com.example.demo.entites.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ImageService;
import com.example.demo.services.UserService;
import com.example.demo.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final ImageService imageService;
    private final UserService userService;
    private final UserValidator validator;

    @GetMapping("/login")
    public String login(Principal p, Model m){
        m.addAttribute("user", userService.getUserByPrincipal(p));
        m.addAttribute("title", "Вход");
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Principal p, Model m){
        m.addAttribute("user", userService.getUserByPrincipal(p));
        m.addAttribute("title", "Регистрация");
        return "registration";
    }

    @PostMapping("/registration")
    public String regUser(Principal p,User user, Model m, BindingResult result){
        m.addAttribute("user", userService.getUserByPrincipal(p));
        validator.validate(user, result);
        if(result.hasErrors()){
            m.addAttribute("message", "Пользователь с таким e-mail уже есть!");
            m.addAttribute("title", "Регистрация");
            return "registration";
        }

        userService.addUser(user);
        m.addAttribute("title", "Успешная регистрация");
        m.addAttribute("message", "Успешная регистрация");
        return "message";

    }

    @ResponseBody
    @PostMapping("/account/setAvatar")
    public String setAvatar(Principal p, @RequestParam(name = "file")MultipartFile multipartFile){
        log.info("" + multipartFile);
        User user = userService.getUserByPrincipal(p);
        Image image = imageService.toImage(multipartFile);
        userService.setAvatar(image, user);
        return "success";
    }

    @GetMapping("/account")
    public String account(Principal p, Model m){
        User user = userService.getUserByPrincipal(p);
        m.addAttribute("title", "Личный кабинет");
        m.addAttribute("user", user);
        m.addAttribute("targetUser", user);
        return "userInfo";
    }

    @GetMapping("/logout/success")
    public String successLogout(Principal p, Model m){
        m.addAttribute("title", "Выход из аккаунта");
        m.addAttribute("message", "Вы успешно вышли из аккаунта");
        m.addAttribute("user", userService.getUserByPrincipal(p));
        return "message";
    }
}
