package com.movienote.repository;

import com.movienote.model.Genre;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class GenreJpaRepositoryTests {

    @Autowired
    private GenreJpaRepository genreJpaRepository;
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
        genreJpaRepository.deleteAll();
    }


    @Test
    public void testGetGenreByName() {

        final String genreName = "testGenre";
        Genre genre = new Genre();
        genre.setName(genreName);
        genreJpaRepository.save(genre);

        List<Genre> found = (List<Genre>) genreJpaRepository.findByName(genreName);
        org.junit.jupiter.api.Assertions.assertEquals(1, found.size());
        org.junit.jupiter.api.Assertions.assertEquals(genre, found.get(0));

    }

    private void testSaveGenre(int number) {

        List<Genre> genres = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Genre genre = new Genre();
            genre.setName("NameGenre" + i);
            genres.add(genre);
        }
        genreJpaRepository.saveAll(genres);
    }

    private void testSaveAllGenres() {
        testSaveGenre(5);
        List<Genre> found = genreJpaRepository.findAll();
        Assertions.assertEquals(5, found.size());

    }
}
