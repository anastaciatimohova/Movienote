package com.movienote.repository;

import com.movienote.model.Role;
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
public class RoleJpaRepositoryTests {

    @Autowired
    private RoleJpaRepository roleJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        roleJpaRepository.deleteAll();
    }

    @Test
    @Sql(scripts = "classpath:/data_sql/roles.sql", executionPhase = BEFORE_TEST_METHOD)
    public void testGetRoleByName() {

        final String roleName = "USER";
        Role role = new Role();
        role.setName(roleName);

        roleJpaRepository.save(role);

        List<Role> found = (List<Role>) roleJpaRepository.getByName(roleName);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(role, found.get(0));

    }
}
