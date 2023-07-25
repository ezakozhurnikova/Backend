package de.ait.timepad.repositories.impl;

import de.ait.timepad.models.Event;

import de.ait.timepad.repositories.EventsRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class EventsRepositoryListImpl implements EventsRepository {
    private static List<Event> events = new ArrayList<>();

    @Override
    public void save(Event Event) {
        if (Event.getId() == null) {
            Event.setId((long) events.size() + 1); // id пользователя - его порядковый номер в списке
            events.add(Event);
        } else {
            // TODO: если бы это была база данных или файл, то нужно было бы обновить данные в хранилище
            // обновляем, но тут этого делать не нужно, потому что это список объектов
        }
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public Optional<Event> findById(Long id) {
        for (Event Event : events) {
            if (Event.getId().equals(id)) {
                return Optional.of(Event); // вместо return Event
            }
        }

        return Optional.empty(); // вместо return null
    }

    @Override
    public void delete(Event Event) {
        events.remove(Event);
    }

    @Override
    public void clear() {
        events.clear();
    }
}

