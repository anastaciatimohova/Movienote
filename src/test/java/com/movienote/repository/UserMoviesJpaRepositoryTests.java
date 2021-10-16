package com.movienote.repository;

import com.movienote.model.User;
import com.movienote.model.UserMovies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;


@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserMoviesJpaRepositoryTests {

    @Autowired
    private UserMoviesJpaRepository userMoviesJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        userMoviesJpaRepository.deleteAll();
    }

    @Test
    public void testGetALLUserMoviesByUserId() {

        final String username = "testUserName";
        User user = new User();
        user.setUsername(username);

        List<UserMovies> userMovies = userMoviesJpaRepository.findAllByUserId(user.getId());
        Assertions.assertEquals(1, userMovies.size());
        Assertions.assertEquals(user, userMovies.get(0));
    }
}
