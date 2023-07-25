package de.ait.timepad.services;

import de.ait.timepad.dto.*;

public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);

    EventsDto getAllEvents();
    EventDto deleteEvent(Long eventId);

    EventDto updateEvent(Long eventId, UpdateEventDto updateEvent);

    EventDto getEvent(Long eventId);
}
