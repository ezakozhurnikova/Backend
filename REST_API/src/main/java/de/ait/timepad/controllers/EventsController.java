package de.ait.timepad.controllers;

import de.ait.timepad.controllers.api.EventsApi;
import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.dto.UpdateEventDto;
import de.ait.timepad.dto.EventDto;
import de.ait.timepad.dto.EventsDto;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class EventsController implements EventsApi {

    private final EventsService eventsService;
    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        return EventsService.addEvent(newEvent);
    }

    @Override
    public EventsDto getAllEvents() {
        return EventsService.getAllEvents();
    }

    @Override
    public EventDto deleteEvent(Long EventId) {
        return EventsService.deleteEvent(EventId);
    }

    @Override
    public EventDto updateEvent(Long EventId, UpdateEventDto updateEvent) {
        return EventsService.updateEvent(EventId, updateEvent);
    }

    @Override
    public EventDto getEvent(Long EventId) {
        return EventsService.getEvent(EventId);
    }
}