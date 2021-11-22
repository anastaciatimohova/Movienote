package com.movienote.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movienote.model.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private String username;

    private String email;

    private String password;


    public User toUser(UserDto userDto) {

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public UserDto toDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
