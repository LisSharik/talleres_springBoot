package com.riwi.events_register.services.sevice_abstract;

import java.util.List;

import org.springframework.data.domain.Page;

import com.riwi.events_register.entities.Event;

public interface IEventService {
    public Event save(Event objEvent);
    public List<Event> getAll();
    public Event findById(String id);
    public void delete(String id);
    public Event update(String id, Event objEvent);
    public Page<Event> findPaginated(int page, int size);
}
