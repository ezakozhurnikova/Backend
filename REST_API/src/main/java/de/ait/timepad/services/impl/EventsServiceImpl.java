package de.ait.timepad.services.impl;

import de.ait.timepad.dto.*;
import de.ait.timepad.models.Event;

import de.ait.timepad.repositories.EventsRepository;

import de.ait.timepad.services.EventsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static de.ait.timepad.dto.UserDto.from;

@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .name(newEvent.getName())
                .address(newEvent.getAddress())
                .status(Event.Status.NOT_CONFIRMED)
                .build();

        eventsRepository.save(event);

        return from(event);
    }

    @Override
    public EventsDto getAllEvents() {
//
        List<Event> events = eventsRepository.findAll();
        return EventsDto.builder()
                .events(from(events))
                .count(events.size())
                .build();
    }
}
