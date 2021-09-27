package com.movienote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Объект представляющий жанры для фильмов
 * @autor Ilkevich Anastasiya
 * @version 1.0
 */

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "external_id")
    private Long externalId;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;

}
