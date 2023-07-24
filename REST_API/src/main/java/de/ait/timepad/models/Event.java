package de.ait.timepad.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

       public enum Status {
        NOT_CONFIRMED,
        CONFIRMED;

    }

    private Long id;

    private String name;
    private String address;

    private Status status;

    private List<Event> events;
}

