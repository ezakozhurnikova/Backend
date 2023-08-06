package de.ait.timepad.dto;

import de.ait.timepad.models.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Задача какого-либо пользователя")
public class TaskDto {

    @Schema(description = "Идентификатор задачи", example = "1")
    private Long id;

    @Schema(description = "Текст задачи", example = "Задача какого-либо пользователя...")
    private String description;

    @Schema(description = "Заголовок задачи", example = "Задача называется...")
    private String title;

    @Schema(description = "Пользователь, который исполняет задачу")
    private UserInTaskDto executor;

    @Schema(description = "Дата начала в формате YYYY-MM-DD", example = "2022-02-02")
    private String startDate;

    @Schema(description = "Дата окончания в формате YYYY-MM-DD", example = "2022-02-02")
    private String finishDate;

    public static TaskDto from(Task task) {
        TaskDto result = TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();

        if (task.getExecutor() != null) {
            result.setExecutor(UserInTaskDto.from(task.getExecutor()));
        }

        if (task.getStartDate() != null) {
            result.setStartDate(task.getStartDate().toString());
        }
        if (task.getFinishDate() != null) {
            result.setFinishDate(task.getStartDate().toString());
        }


        return result;
    }

    public static List<TaskDto> from(List<Task> tasks) {
        return tasks.stream()
                .map(TaskDto::from)
                .collect(Collectors.toList());
    }
}

