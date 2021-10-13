package com.movienote.repository;


import com.movienote.model.Movie;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MovieJpaRepositoryTests {

    @Autowired
    private MovieJpaRepository movieJpaRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeAll
    public static void beforeAllSetUp() {
        System.out.println("beforeAllSetUp(): method called");
    }

    @AfterAll
    public static void afterAllTearDown() {
        System.out.println("afterAllTearDown(): method called");
    }

    @BeforeEach
    public void beforeEachSetUp() {
        System.out.println("beforeEachSetUp(): method called");
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

    private void testSaveMovie(int number) {

        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Movie movie = new Movie();
            movie.setTitle("NameMovie" + i);

            movies.add(movie);
        }
        movieJpaRepository.saveAll(movies);
    }

    private void testSaveAllMovies() {
        testSaveMovie(5);
        List<Movie> found = movieJpaRepository.findAll();
        Assertions.assertEquals(5, found.size());

    }
}
