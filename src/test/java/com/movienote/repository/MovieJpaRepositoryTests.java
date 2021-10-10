package com.movienote.repository;

import com.movienote.model.Genre;
import com.movienote.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MovieJpaRepositoryTests {

    @Autowired
    private MovieJpaRepository movieJpaRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testGetMovieByTitle(String title) {
        Movie movie = new Movie();
        movieJpaRepository.findByTitle(title);
        assertNotNull(movie);
    }
}