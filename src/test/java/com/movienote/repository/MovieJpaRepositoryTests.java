package com.movienote.repository;


import com.movienote.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-dev.properties")
public class MovieJpaRepositoryTests {

    @Autowired
    private MovieJpaRepository movieJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        movieJpaRepository.deleteAll();
    }

    @Test
    @Sql(scripts = "classpath:/data_sql/movies.sql", executionPhase = BEFORE_TEST_METHOD)
    public void testGetMovieByTitle() {

        final String movieTitle = "Matrix";
        Movie movie = new Movie();
        movie.setTitle(movieTitle);

        movieJpaRepository.save(movie);

        List<Movie> found = (List<Movie>) movieJpaRepository.findByTitle(movieTitle);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(movie, found.get(0));

    }

}
