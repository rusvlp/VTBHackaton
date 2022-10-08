package com.example.demo.controllers;

import com.example.demo.services.EventService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    @GetMapping
    public String nearestEvents(Principal p, Model m){
        m.addAttribute("title", "Ближайшие мероприятия");
        m.addAttribute("user", userService.getUserByPrincipal(p));
        m.addAttribute("nearestEvents", eventService.getNearestEvents());
        return "nearestEvents";
    }

    @GetMapping ("/all")
    public String allEvents(Principal p, Model m){
        m.addAttribute("user", userService.getUserByPrincipal(p));
        m.addAttribute("title", "Все мероприятия");
        m.addAttribute("events", eventService.getAllEvents());
        return "allEvents";
    }

    @GetMapping("/{id}")
    public String eventInfo(@PathVariable Long id, Principal p, Model m)

}
