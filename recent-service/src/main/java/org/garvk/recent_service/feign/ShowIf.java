package org.garvk.recent_service.feign;

import org.garvk.recent_service.model.ShowDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("SHOW-SERVICE")
public interface ShowIf {
    @GetMapping("/api/shows/latest")
    ResponseEntity<List<ShowDto>> getRecentShows();
}
