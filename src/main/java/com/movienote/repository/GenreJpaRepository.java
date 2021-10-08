package com.movienote.repository;

import com.movienote.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreJpaRepository extends JpaRepository<Genre,Long> {

    Genre findByName(String name);

}
