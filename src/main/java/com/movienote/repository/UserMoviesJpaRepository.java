package com.movienote.repository;

import com.movienote.model.UserMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMoviesJpaRepository extends JpaRepository<UserMovies,Long> {
}
