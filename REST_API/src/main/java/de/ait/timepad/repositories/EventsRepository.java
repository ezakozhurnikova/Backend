package de.ait.timepad.repositories;

import de.ait.timepad.models.Event;


import java.util.List;
import java.util.Optional;


public interface EventsRepository {
    static void save(Event Event);

    List<Event> findAll();

    static Optional<Event> findById(Long id);

    static void delete(Event event);

    // TODO: убрать метод, как только подключим базы данных
    void clear();

}
