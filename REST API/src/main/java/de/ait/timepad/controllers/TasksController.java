package de.ait.timepad.controllers;


import de.ait.timepad.controllers.api.TasksApi;
import de.ait.timepad.dto.NewTaskDto;
import de.ait.timepad.dto.TaskDto;
import de.ait.timepad.dto.TasksDto;
import de.ait.timepad.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TasksController implements TasksApi {

    private final TasksService tasksService;

    @Override
    public ResponseEntity<TaskDto> addTask(NewTaskDto newTask) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tasksService.addTask(newTask));
    }
}
