package org.garvk.recent_service.controller;

import org.garvk.recent_service.model.RecentRespDTO;
import org.garvk.recent_service.service.RecentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recent")
public class RecentController {

    private RecentService recentService;

    public RecentController(RecentService aInRecentService){
        this.recentService = aInRecentService;
    }

    @GetMapping("/")
    public ResponseEntity<RecentRespDTO> getRecentMedia(){
        return new ResponseEntity<>(recentService.getRecentMedia(), HttpStatus.OK);
    }

}
