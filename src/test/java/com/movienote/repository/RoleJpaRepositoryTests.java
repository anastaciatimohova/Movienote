package com.movienote.repository;

import com.movienote.model.Genre;
import com.movienote.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class RoleJpaRepositoryTests {

    @Autowired
    private RoleJpaRepository roleJpaRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testGetRoleByName(String role) {
        Role roles = new Role();
        roleJpaRepository.getByName(role);
        assertNotNull(roles);
    }
}
