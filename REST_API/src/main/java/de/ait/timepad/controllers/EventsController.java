package de.ait.timepad.controllers;

import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.dto.EventDto;
import de.ait.timepad.dto.EventsDto;
import de.ait.timepad.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventsController {

    private final UsersService eventsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto addEvent(@RequestBody NewEventDto newEvent) {

        return eventsService.addEvent(newEvent);
    }

    @GetMapping
    public EventsDto getAllEvents() {
        return eventsService.getAllEvents();
    }
}
