package de.ait.timepad.controllers.api;

import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.dto.UpdateEventDto;
import de.ait.timepad.dto.EventDto;
import de.ait.timepad.dto.EventsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
        @Tag(name = "Events")
})
@RequestMapping("/api/events")
public interface EventsApi {

    @Operation(summary = "Создание события", description = "Доступно только администратору")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EventDto addEvent(@Parameter(required = true, description = "Событие") @RequestBody NewEventDto newEvent);

    @Operation(summary = "Получение событий", description = "Доступно всем")
    @GetMapping
    EventsDto getAllEvents();

    @Operation(summary = "Удаление события", description = "Доступно администратору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Событие не найдено",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Удаленное событие",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @DeleteMapping("/{event-id}")
    EventDto deleteEvent(@Parameter(required = true, description = "Идентификатор события", example = "2")
                       @PathVariable("event-id") Long EventId);

    @Operation(summary = "Обновление события", description = "Доступно администратору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "событие не найдено",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "403", description = "Нельзя сделать администратором",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Обновленное событие",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @PutMapping("/{event-id}")
    EventDto updateEvent(@Parameter(required = true, description = "Идентификатор события", example = "2")
                       @PathVariable("event-id") Long EventId,
                       @RequestBody UpdateEventDto updateEvent);

    @Operation(summary = "Получение события", description = "Доступно всем")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "событие не найдено",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Обновленное событие",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @GetMapping("/{event-id}")
    EventDto getEvent(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
                    @PathVariable("event-id") Long EventId);

}
