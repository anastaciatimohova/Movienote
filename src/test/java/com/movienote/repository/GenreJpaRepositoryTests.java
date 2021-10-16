package com.movienote.repository;

import com.movienote.model.Genre;
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
public class GenreJpaRepositoryTests {

    @Autowired
    private GenreJpaRepository genreJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        genreJpaRepository.deleteAll();
    }


    @Test
    public void testGetGenreByName() {

        final String genreName = "testGenre";
        Genre genre = new Genre();
        genre.setName(genreName);
        genreJpaRepository.save(genre);

        List<Genre> found = (List<Genre>) genreJpaRepository.findByName(genreName);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(genre, found.get(0));

    }
}
