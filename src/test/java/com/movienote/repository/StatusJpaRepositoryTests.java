package com.movienote.repository;

import com.movienote.model.Status;
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
public class StatusJpaRepositoryTests {

    @Autowired
    private StatusJpaRepository statusJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        statusJpaRepository.deleteAll();
    }

    @Test
    @Sql(scripts = "classpath:/data_sql/statuses.sql", executionPhase = BEFORE_TEST_METHOD)
    public void testGetStatusByName() {

        final String statusName = "Viewed";
        Status status = new Status();
        status.setName(statusName);

        statusJpaRepository.save(status);

        List<Status> found = (List<Status>) statusJpaRepository.findByName(statusName);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(status, found.get(0));

    }
}
