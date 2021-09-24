package com.movienote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * Объект представляющий связи между объктами
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Entity
@Table(name = "user_movies")
@Data
@NoArgsConstructor
public class UserMovies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "reiting")
    private String reiting;

    @Column(name = "created_timstamp")
    private Timestamp createdTimestamp;

    @Column(name = "updated_timstamp")
    private Timestamp modifiedTimestamp;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

}
