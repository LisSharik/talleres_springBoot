package com.riwi.events_register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.events_register.entities.Event;
import com.riwi.events_register.services.sevice_abstract.IEventService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/events")
@AllArgsConstructor
public class EventController {
    @Autowired
    private final IEventService eventService;

    @GetMapping({"","/"})
    public ResponseEntity<List<Event>> showViewGetAll(@RequestParam (defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.eventService.findPaginated(page-1,size).toList());
    }
    

    @GetMapping("/allevents")
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(this.eventService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable String id){
        return ResponseEntity.ok(this.eventService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Event> insert(@RequestBody Event objEvent){
        return ResponseEntity.ok(this.eventService.save(objEvent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event objEvent) {
        return ResponseEntity.ok(this.eventService.update(id,objEvent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.eventService.delete(id);
        return ResponseEntity.noContent().build();
    }






}
