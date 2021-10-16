package com.movienote.repository;


import com.movienote.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MovieJpaRepositoryTests {

    @Autowired
    private MovieJpaRepository movieJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        movieJpaRepository.deleteAll();
    }

    @Test
    public void testGetMovieByTitle() {

        final String movieTitle = "testMovieTitle";
        Movie movie = new Movie();
        movie.setTitle(movieTitle);

        movieJpaRepository.save(movie);

        List<Movie> found = (List<Movie>) movieJpaRepository.findByTitle(movieTitle);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(movie, found.get(0));

    }

}
