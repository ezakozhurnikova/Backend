package de.ait.timepad.controllers.api;
import de.ait.timepad.dto.TaskDto;
import de.ait.timepad.dto.TasksDto;
import de.ait.timepad.dto.NewTaskDto;
import de.ait.timepad.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tags(value = {
        @Tag(name = "Tasks")
})
@RequestMapping("/api/tasks")
public interface TasksApi {

    @Operation(summary = "Создание задачи пользователя", description = "Доступно только всем пользователям")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Пользователь с указанным ID отсутствует в системе",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "201", description = "Добавленная задача",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<TaskDto> addTask(@RequestBody NewTaskDto newTask);
}