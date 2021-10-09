package com.movienote.repository;

import com.movienote.model.UserMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMoviesJpaRepository extends JpaRepository<UserMovies,Long> {

    List<UserMovies> findAllByUserId(Long id);

}
