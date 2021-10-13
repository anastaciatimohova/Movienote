package com.movienote.repository;

import com.movienote.model.UserMovies;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;


@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserMoviesJpaRepositoryTests {

    @Autowired
    private UserMoviesJpaRepository userMoviesJpaRepository;
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
        userMoviesJpaRepository.deleteAll();
    }

    @Test
    public void testGetALLUserMoviesByUserId(Long id) {
        List<UserMovies> userMovies = userMoviesJpaRepository.findAllByUserId(id);
        Assertions.assertThat(userMovies.size()).isGreaterThan(0);
    }


}
