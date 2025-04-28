package org.garvk.movie_service.controller;

import org.garvk.movie_service.model.Movie;
import org.garvk.movie_service.model.WatchStatus;
import org.garvk.movie_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService aInMovieService){
        this.movieService = aInMovieService;
    }

    @PostMapping("/")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie aInMovie){
        return new ResponseEntity<>(movieService.addMovie(aInMovie), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long aInId){
        return new ResponseEntity<>(movieService.getMovieById(aInId), HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Movie>> getLatestMovies(){
        return new ResponseEntity<>(movieService.getLatestMovies(), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie aInMovie){
        return new ResponseEntity<>(movieService.updateMovie(aInMovie), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable("id") Long aInId){
        movieService.deleteMovie(aInId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Movie> setMovieWatchStatus(@PathVariable("id") Long aInId, @RequestParam("setStatus") WatchStatus aInWatchStatus){
        return new ResponseEntity<>(movieService.setMovieWatchStatus(aInId, aInWatchStatus), HttpStatus.CREATED);
    }


}
