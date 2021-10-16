package com.movienote.repository;

import com.movienote.model.Status;
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
public class StatusJpaRepositoryTests {

    @Autowired
    private StatusJpaRepository statusJpaRepository;


    @BeforeEach
    public void beforeEachSetUp() {

        statusJpaRepository.deleteAll();
    }

    @Test
    public void testGetStatusByName() {

        final String statusName = "testStatusName";
        Status status = new Status();
        status.setName(statusName);

        statusJpaRepository.save(status);

        List<Status> found = (List<Status>) statusJpaRepository.findByName(statusName);
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(status, found.get(0));

    }
}
