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

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private String rating;

    @Column(name = "created_timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "modefied_timestamp")
    private Timestamp modifiedTimestamp;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private User movie;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private User status;

}
