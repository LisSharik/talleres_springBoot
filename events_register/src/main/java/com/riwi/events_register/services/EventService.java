package com.riwi.events_register.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.events_register.entities.Event;
import com.riwi.events_register.repositries.EventRepository;
import com.riwi.events_register.services.sevice_abstract.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {

    
    @Autowired
    private final EventRepository eventRepository;

    @Override
    public Event save(Event objEvent) {
        LocalDate currentDate = LocalDate.now();

        if (objEvent.getDate().isAfter(currentDate) && objEvent.getCapacity() > 0) {
            return this.eventRepository.save(objEvent);
        }
        
        return null;
        
    }

    @Override
    public List<Event> getAll() {
       return this.eventRepository.findAll();
    }

    @Override
    public Event findById(String id) {
        return this.eventRepository.findById(id).orElseThrow();
    }

    public Page<Event> findPaginated(int Page, int size){
        if (Page < 0) {
            Page = 1;
        }

        Pageable objPageable = PageRequest.of(Page, size);
        return this.eventRepository.findAll(objPageable);
    }

    @Override
    public void delete(String id) {
        Event eventFind = this.eventRepository.findById(id).orElseThrow();
        this.eventRepository.delete(eventFind);
    }

    @Override
    public Event update(String id, Event objEvent) {
        LocalDate currentDate = LocalDate.now();
        this.eventRepository.findById(id).orElseThrow();

        if (objEvent.getDate().isAfter(currentDate) && objEvent.getCapacity() > 0) {
            objEvent.setId(id);
            return this.eventRepository.save(objEvent);
        }
        
        return null;
    }
    




}
