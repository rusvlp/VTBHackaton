package com.example.demo.repositories;

import com.example.demo.entites.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e order by e.dateOfStart desc")
    List<Event> getNearestEvents();
}
