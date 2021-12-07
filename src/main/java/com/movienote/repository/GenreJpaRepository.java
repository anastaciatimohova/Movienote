package com.movienote.repository;

import com.movienote.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GenreJpaRepository extends JpaRepository<Genre,Long> {

    Genre findByName(String name);

    List<Genre> findAllByExternalId(List<Long> genreExternalIds);
}
