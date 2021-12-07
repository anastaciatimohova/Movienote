package com.movienote.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movienote.model.Genre;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDto {

    private String name;
    @JsonProperty("id")
    private Long externalId;


    public Genre toGenre(GenreDto genreDto) {

        Genre genre = new Genre();
        genre.setExternalId(genreDto.getExternalId());
        genre.setName(genreDto.getName());
        return genre;

    }


    public GenreDto toDto() {

        GenreDto genreDto = new GenreDto();
        genreDto.setExternalId(getExternalId());
        genreDto.setName(getName());
        return genreDto;

    }
}
