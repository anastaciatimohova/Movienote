package com.movienote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "adult")
    private boolean adult;

    @Column(name = "poster")
    private byte[] poster;

    @Column(name = "original_language")
    private String language;

    @Column(name = "original_title")
    private String title;

    @Column(name = "overview")
    private String overview;

    @Column(name = "external_id")
    private Long externalId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    @OneToMany (mappedBy="movie", fetch=FetchType.EAGER)
    private Set<UserMovies> users;
}
