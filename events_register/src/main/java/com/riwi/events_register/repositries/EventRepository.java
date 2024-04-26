package com.riwi.events_register.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.events_register.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    
}
