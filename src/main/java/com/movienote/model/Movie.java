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
 *
 * НЕ УЧТЕНО ПОЛЕ backdropPath. ТАК КАК НЕ ЯСНО В КАКОМ ФОРМАТЕ ХРАНИТЬ.
 *
 * НЕ ЗНАЮ КАК В ТАБЛИЦУ users_has_movies СОЗДАТЬ ПОЛЯ "description", "rating",
 * "created_timastamp" и "modefied_timastamp"
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

    //private backdropPath;  -> тип?

    @Column(name = "original_language")
    private String language;

    @Column(name = "original_title")
    private String title;

    @Column(name = "overview")
    private String overview;

    @Column(name = "external_ids")
    private Long externalId;

    @ManyToMany(mappedBy = "movies")
    private Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movies_has_genres", joinColumns = @JoinColumn(name = "movies_id"),
            inverseJoinColumns = @JoinColumn(name = "genres_id"))
    private Set<Genre> genres;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_has_movies", joinColumns = @JoinColumn(name = "movies_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id"))
    private Set<Status> statuses;


}
