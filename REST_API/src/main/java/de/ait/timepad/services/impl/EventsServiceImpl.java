package de.ait.timepad.services.impl;

import de.ait.timepad.dto.*;
import de.ait.timepad.exceptions.ForbiddenOperationException;
import de.ait.timepad.exceptions.NotFoundException;
import de.ait.timepad.models.Event;

import de.ait.timepad.repositories.EventsRepository;

import de.ait.timepad.services.EventsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static de.ait.timepad.dto.EventDto.from;

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

        EventsRepository.save(event);

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
    @Override
    public EventDto deleteEvent(Long eventId) {
//        Optional<Event> Event = EventsRepository.findById(EventId);
//
//        if (Event.isEmpty()) {
//            throw new NotFoundException("Event with id <" + EventId + "> not found");
//        }
//
//        EventsRepository.delete(Event.get());
        Event event = getEventOrThrow(eventId);

        EventsRepository.delete(event);

        return EventDto.from(event);
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {

        Event Event = getEventOrThrow(eventId); // нашли пользователя

        if (updateEvent.getNewRole().equals("ADMIN")) {
            throw new ForbiddenOperationException("Cannot make an administrator");
        }

        // обновляем ему поля
        Event.setStatus(de.ait.timepad.models.Event.Status.valueOf(updateEvent.getNewState()));


        EventsRepository.save(Event); // вместо отдельно update можно использовать save

        return EventDto.from(Event); // возвращаем обновленного пользователя
    }

    @Override
    public EventDto getEvent(Long eventId) {
        return EventDto.from(getEventOrThrow(eventId));
    }

    private Event getEventOrThrow(Long eventId) {
        return EventsRepository.findById(eventId).orElseThrow(
                () -> new NotFoundException("Event with id <" + eventId + "> not found"));
    }
}
