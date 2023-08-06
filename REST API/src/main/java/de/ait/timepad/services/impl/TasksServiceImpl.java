package de.ait.timepad.services.impl;

import de.ait.timepad.dto.TaskDto;
import de.ait.timepad.dto.TasksDto;
import de.ait.timepad.dto.NewTaskDto;
import de.ait.timepad.exceptions.IncorrectUserIdException;
import de.ait.timepad.models.Task;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.TasksRepository;
import de.ait.timepad.repositories.UsersRepository;
import de.ait.timepad.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static de.ait.timepad.dto.TaskDto.from;


@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

    private final UsersRepository usersRepository;

    private final TasksRepository tasksRepository;

    @Override
    public TaskDto addTask(NewTaskDto newTask) {
        User user = usersRepository.findById(newTask.getExecutorUserId())
                .orElseThrow(() ->
                        new IncorrectUserIdException("Id <" + newTask.getExecutorUserId() + "> is not correct"));

        Task task = Task.builder()
                .description(newTask.getDescription())
                .executor(user)
                .startDate(LocalDate.parse(newTask.getStartDate()))
                .finishDate(LocalDate.parse(newTask.getFinishDate()))
                .build();
        tasksRepository.save(task);
        return from(task);
    }
}
