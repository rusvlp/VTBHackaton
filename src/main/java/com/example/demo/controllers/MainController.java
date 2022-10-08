package com.example.demo.controllers;

import com.example.demo.entites.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final UserService userService;
    @GetMapping
    public String main(Principal p, Model model){
        User u = userService.getUserByPrincipal(p);
        log.info(""+p);
        model.addAttribute("user", u);
        model.addAttribute("title", "Главная");
        if (p == null){
            return "redirect:/login";
        }
        return "redirect:/account";
    }
}
