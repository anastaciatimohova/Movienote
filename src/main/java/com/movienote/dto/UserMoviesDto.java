package com.movienote.dto;

import com.movienote.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMoviesDto {

    private String description;

    private int rating;

    private Status status;

}
