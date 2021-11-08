package com.movienote.repository;

import com.movienote.model.UserMovies;
import org.assertj.core.api.Assertions;
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
public class UserMoviesJpaRepositoryTests {

    @Autowired
    private UserMoviesJpaRepository userMoviesJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        userMoviesJpaRepository.deleteAll();
    }

    @Test
    @Sql(scripts = "classpath:/data_sql/user_movies.sql", executionPhase = BEFORE_TEST_METHOD)
    public void testGetALLUserMoviesByUserId() {

        long Id = 1;
        List<UserMovies> userMoviesList = userMoviesJpaRepository.findAllByUserId(Id);
        Assertions.assertThat(userMoviesList.size()).isGreaterThan(0);


    }
}
