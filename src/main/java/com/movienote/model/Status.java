package com.movienote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Объект представляющий юзерские статусы фильмов
 * @autor Ilkevich Anastasiya
 * @version 1.0
 */

@Entity
@Table(name = "statuses")
@Data
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany (cascade = CascadeType.ALL, mappedBy="status")
    private Set<UserMovies> UserMovie;

}
