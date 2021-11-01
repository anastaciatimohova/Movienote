package com.movienote.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;


/**
 * Объект представляющий связи между объктами
 *
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

    @Column(name = "rating")
    private int rating;

    @Column(name = "created_timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "updated_timestamp")
    private Timestamp modifiedTimestamp;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @Enumerated
    private Status status;

    @PreUpdate
    public void preUpdate() {
        modifiedTimestamp = new Timestamp(Instant.now().toEpochMilli());
    }

}
