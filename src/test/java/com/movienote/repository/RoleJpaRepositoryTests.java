package com.movienote.repository;

import com.movienote.model.Genre;
import com.movienote.model.Role;
import com.movienote.model.User;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class RoleJpaRepositoryTests {

    @Autowired
    private RoleJpaRepository roleJpaRepository;
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
        roleJpaRepository.deleteAll();
    }

    @Test
    public void testGetRoleByName() {

        final String roleName = "testRoleName";
        Role role = new Role();
        role.setName(roleName);

        roleJpaRepository.save(role);

        List<Role> found = (List<Role>) roleJpaRepository.getByName(roleName);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(role, found.get(0));

    }

    private void testSaveRole(int number) {
        List<Role> users = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Role role = new Role();
            role.setName("NameRole" + i);

            users.add(role);
        }
        roleJpaRepository.saveAll(users);
    }

    private void testSaveAllRoles() {
        testSaveRole(5);
        List<Role> found = roleJpaRepository.findAll();
        Assertions.assertEquals(5, found.size());

    }

}
