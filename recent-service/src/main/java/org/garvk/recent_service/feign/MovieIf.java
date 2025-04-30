package org.garvk.recent_service.feign;

import org.garvk.recent_service.model.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("MOVIE-SERVICE")
public interface MovieIf {
    @GetMapping("/api/movies/latest")
    ResponseEntity<List<MovieDto>> getLatestMovies();
}
