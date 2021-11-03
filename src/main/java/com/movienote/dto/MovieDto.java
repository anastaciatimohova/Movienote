package com.movienote.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private boolean adult;

    private String poster;

    private String language;

    private String title;

    private String overview;

    private Long externalId;

    private List<Long> genreIds;

}
