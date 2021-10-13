package com.movienote.repository;

import com.movienote.model.User;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;


import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserJpaRepositoryTests {

    @Autowired
    private UserJpaRepository userJpaRepository;
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
        userJpaRepository.deleteAll();
    }

    @Test
    public void testGetUserByUserName() {

        final String username = "testUserName";
        User user = new User();
        user.setUsername(username);
        user.setEmail((RandomString.make(10)));
        userJpaRepository.save(user);

        List<User> found = (List<User>) userJpaRepository.findByUsername(username);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(user, found.get(0));

    }

    private void testSaveUsers(int number) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            User user = new User();
            user.setUsername("Name" + i);
            user.setEmail((RandomString.make(10)));
            users.add(user);
        }
        userJpaRepository.saveAll(users);
    }

    private void testSaveAllUsers() {
        testSaveUsers(5);
        List<User> found = userJpaRepository.findAll();
        Assertions.assertEquals(5, found.size());

    }
}
