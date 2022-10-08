package com.example.demo.controllers;

import com.example.demo.entites.Event;
import com.example.demo.services.EventService;
import com.example.demo.services.ImageService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final EventService eventService;
    private final ImageService imageService;
    @GetMapping
    private String admin(Principal p, Model m){
        m.addAttribute("title", "Админ-панель");
        m.addAttribute("user", userService.getUserByPrincipal(p));
        return "admin";
    }

    @PostMapping("/addEvent")
    private String addEvent(Principal p, Event e, @RequestParam(name = "date")String date, @RequestParam(name = "file")MultipartFile file, Model m){
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);
        LocalDate dateOfStart = LocalDate.of(year, month, day);
        e.setDateOfStart(dateOfStart);
        e.setPreviewImage(imageService.toImage(file));
        eventService.save(e);

        m.addAttribute("user", userService.getUserByPrincipal(p));
        m.addAttribute("title", "Успешно добавлено!");
        m.addAttribute("message", "Успешно добавлено!");
        return "message";
    }
}
