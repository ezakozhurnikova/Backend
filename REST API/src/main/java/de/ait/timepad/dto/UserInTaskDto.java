package de.ait.timepad.dto;

import de.ait.timepad.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Информация о исполнителе задачи")
public class UserInTaskDto {
    @Schema(description = "Идентификатор исполнителя", example = "1")
    private Long id;

    @Schema(description = "Email исполнителя", example = "user@mail.com")
    private String email;

    public static UserInTaskDto from(User user) {
        return UserInTaskDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
