package org.garvk.show_service.repository;

import org.garvk.show_service.model.Show;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepo extends JpaRepository<Show, Long> {

    @Query("SELECT s FROM Show s ORDER BY s.createdAt DESC")
    List<Show> findLatestShows(Pageable pageable);

}
