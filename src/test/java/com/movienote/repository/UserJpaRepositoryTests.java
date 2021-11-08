package com.movienote.repository;

import com.movienote.model.User;
import net.bytebuddy.utility.RandomString;
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
public class UserJpaRepositoryTests {

    @Autowired
    private UserJpaRepository userJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        userJpaRepository.deleteAll();
    }

    @Test
    @Sql(scripts = "classpath:/data_sql/users.sql", executionPhase = BEFORE_TEST_METHOD)
    public void testGetUserByUserName() {

        final String username = "TestUsername";
        User user = new User();
        user.setUsername(username);
        user.setEmail((RandomString.make(10)));
        userJpaRepository.save(user);

        List<User> found = (List<User>) userJpaRepository.findByUsername(username);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(user, found.get(0));

    }
}
