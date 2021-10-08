package com.movienote.repository;

import com.movienote.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieJpaRepository extends JpaRepository<Movie,Long> {

    Movie findByTitle(String title);

}
