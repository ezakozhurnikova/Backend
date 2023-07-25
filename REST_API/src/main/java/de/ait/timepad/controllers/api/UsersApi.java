package de.ait.timepad.controllers.api;

import de.ait.timepad.dto.NewUserDto;
import de.ait.timepad.dto.UpdateUserDto;
import de.ait.timepad.dto.UserDto;
import de.ait.timepad.dto.UsersDto;
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

/**
 * 7/25/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Tags(value = {
        @Tag(name = "Users")
})
@RequestMapping("/api/users")
public interface UsersApi {

    @Operation(summary = "Создание пользователя", description = "Доступно только администратору")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto addUser(@Parameter(required = true, description = "Пользователь") @RequestBody NewUserDto newUser);

    @Operation(summary = "Получение пользователей", description = "Доступно всем")
    @GetMapping
    UsersDto getAllUsers();

    @Operation(summary = "Удаление пользователя", description = "Доступно администратору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Удаленный пользователь",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @DeleteMapping("/{user-id}")
    UserDto deleteUser(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
                       @PathVariable("user-id") Long userId);

    @Operation(summary = "Обновление пользователя", description = "Доступно администратору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "403", description = "Нельзя сделать администратором",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Обновленный пользователь",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @PutMapping("/{user-id}")
    UserDto updateUser(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
                       @PathVariable("user-id") Long userId,
                       @RequestBody UpdateUserDto updateUser);

    @Operation(summary = "Получение пользователя", description = "Доступно всем")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Обновленный пользователь",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @GetMapping("/{user-id}")
    UserDto getUser(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
                    @PathVariable("user-id") Long userId);

}
