package org.garvk.show_service.controller;

import jakarta.ws.rs.Path;
import org.garvk.show_service.model.Show;
import org.garvk.show_service.model.WatchStatus;
import org.garvk.show_service.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private ShowService showService;

    @Autowired
    public ShowController(ShowService aInShowService){
        this.showService = aInShowService;
    }

    @PostMapping("/")
    public ResponseEntity<Show> addShow(@RequestBody Show aInShow){
        return new ResponseEntity<>(showService.addShow(aInShow), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Show>> getAllShows(){
        return new ResponseEntity<>(showService.getAllShows(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable("id") Long aInId){
        return new ResponseEntity<>(showService.getShowById(aInId), HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Show>> getRecentShows(){
        return new ResponseEntity<>(showService.getRecentShows(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteShow(@PathVariable("id") Long aInId){
        showService.deleteShow(aInId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> setShowWatchStatus(@PathVariable("id") Long aInId, @RequestParam("setStatus") WatchStatus aInWatchStatus){
        return new ResponseEntity<>(showService.setShowWatchStatus(aInId, aInWatchStatus), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Show> updateShow(@RequestBody Show aInShow){
        return new ResponseEntity<>(showService.updateShow(aInShow), HttpStatus.OK);
    }

}
