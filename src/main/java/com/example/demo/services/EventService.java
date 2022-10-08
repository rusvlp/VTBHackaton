package com.example.demo.services;

import com.example.demo.entites.Event;
import com.example.demo.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService{
    private final EventRepository eventRepository;

    public List<Event> getNearestEvents(){
        List<Event> result = eventRepository.getNearestEvents();
        List<Event> resultListFiltered = new ArrayList<>();

        for (int i = 0; i < result.size() && i<3; i++){
            resultListFiltered.add(result.get(i));
        }


        return resultListFiltered;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public void save(Event e){
        eventRepository.save(e);
    }
}
