package com.movienote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Объект представляющий статусы просмотра для фильмов
 * @autor Ilkevich Anastasiya
 * @version 1.0
 *
 * НЕ ЗНАЮ КАК В ТАБЛИЦУ users_has_movies СОЗДАТЬ ПОЛЯ "description", "rating",
 * "created_timastamp" и "modefied_timastamp"
 *
 */

@Entity
@Table(name = "status")
@Data
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToMany(mappedBy = "statuses")
    private Set<Movie> movies;

}


