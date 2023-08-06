package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Добавляемая задача")
public class NewTaskDto {

    @Schema(description = "Текст задачи", example = "Текст задачи пользователя...")
    private String description;

    @Schema(description = "Идентификатор исполнителя", example = "1")
    private Long executorUserId;

    @Schema(description = "Дата начала в формате YYYY-MM-DD", example = "2022-02-02")
    private String startDate;
    @Schema(description = "Дата окончания в формате YYYY-MM-DD", example = "2022-02-02")
    private String finishDate;
}
