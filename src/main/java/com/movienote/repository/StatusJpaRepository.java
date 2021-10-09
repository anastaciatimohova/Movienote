package com.movienote.repository;

import com.movienote.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusJpaRepository extends JpaRepository<Status,Long> {

    Status findByName(String name);

}
