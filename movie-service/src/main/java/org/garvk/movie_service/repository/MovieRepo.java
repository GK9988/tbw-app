package org.garvk.movie_service.repository;

import org.garvk.movie_service.model.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m ORDER BY m.createdAt DESC")
    List<Movie> findLatestMovies(Pageable pageable);


}
