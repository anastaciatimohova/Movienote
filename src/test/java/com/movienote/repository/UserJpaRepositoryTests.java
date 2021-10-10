package com.movienote.repository;

import com.movienote.model.Genre;
import com.movienote.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserJpaRepositoryTests {

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testGetUserByUserName(String username) {
        User user = new User();
        userJpaRepository.findByUsername(username);
        assertNotNull(user);
    }
}
