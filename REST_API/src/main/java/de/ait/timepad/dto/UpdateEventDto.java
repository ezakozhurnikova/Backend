package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 7/25/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@Schema(description = "Данные для обновления")
public class UpdateEventDto {

    @Schema(description = "Роль события - Event , MANAGER - менеджер", example = "Event")
    private String newRole;

    @Schema(description = "Статус ссобытия - NOT_CONFIRMED - не подтвержден, " +
            "CONFIRMED - подтвержден, BANNED - забанен, DELETED - удален", example = "CONFIRMED")
    private String newState;
}

