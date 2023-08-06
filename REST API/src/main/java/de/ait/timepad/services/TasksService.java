package de.ait.timepad.services;

import de.ait.timepad.dto.TaskDto;
import de.ait.timepad.dto.TasksDto;
import de.ait.timepad.dto.NewTaskDto;

public interface TasksService {
    TaskDto addTask(NewTaskDto newTask);
}
