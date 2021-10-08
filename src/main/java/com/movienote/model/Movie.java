package com.movienote.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Объект представляющий фильмы для пользователя
 * @autor Ilkevich Anastasiya
 * @version 1.0
 *
 */

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "adult")
    private boolean adult;

    @JsonProperty("backdrop_path")
    @Column(name = "backdrop_path")
    private String poster;

    @JsonProperty("original_language")
    @Column(name = "language")
    private String language;

    @JsonProperty("original_title")
    @Column(name = "title")
    private String title;

    @Column(name = "overview")
    private String overview;

    @Column(name = "external_id")
    private Long externalId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    @OneToMany (mappedBy="movie", cascade = CascadeType.DETACH)
    private Set<UserMovies> userMovie;

    @JsonProperty("id")
    public Long getExternalId() {
        return externalId;
    }

    @JsonProperty("id")
    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

}
