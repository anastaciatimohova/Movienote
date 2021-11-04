package com.movienote.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movienote.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
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


    public GenreDto toDto(Genre genre) {

        GenreDto genreDto = new GenreDto();
        genreDto.setExternalId(genre.getExternalId());
        genreDto.setName(genre.getName());
        return genreDto;

    }
}
