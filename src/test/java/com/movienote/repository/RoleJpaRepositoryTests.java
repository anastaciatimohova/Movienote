package com.movienote.repository;

import com.movienote.model.Role;
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
public class RoleJpaRepositoryTests {

    @Autowired
    private RoleJpaRepository roleJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

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
