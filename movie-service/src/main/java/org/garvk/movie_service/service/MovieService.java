package org.garvk.movie_service.service;

import io.micrometer.common.util.internal.logging.WarnThenDebugLogger;
import org.garvk.movie_service.model.Movie;
import org.garvk.movie_service.model.WatchStatus;
import org.garvk.movie_service.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo aInMovieRepo){
        this.movieRepo = aInMovieRepo;
    }

    public Movie addMovie(Movie aInMovie) {
        return movieRepo.save(aInMovie);
    }

    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }

    public Movie getMovieById(Long aInId) {
        return movieRepo.findById(aInId).orElse(null);
    }

    public List<Movie> getLatestMovies() {
        return movieRepo.findLatestMovies(PageRequest.of(0, 5));
    }

    public void deleteMovie(Long aInId) {

        movieRepo.deleteById(aInId);

    }

    public Movie setMovieWatchStatus(Long aInId, WatchStatus aInWatchStatus) {

        Movie lMovie = movieRepo.findById(aInId).orElse(null);

        if(null == lMovie){
            throw new RuntimeException("Movie Entry not found");
        }

        lMovie.setWatchStatus(aInWatchStatus);

        return movieRepo.save(lMovie);
    }

    public Movie updateMovie(Movie aInMovie) {
        Long lId = aInMovie.getId();

        if(null == lId) throw new RuntimeException("No ID");

        Movie lMovie = movieRepo.findById(lId).orElse(null);

        if(null == lMovie) throw new RuntimeException("Movie Entry not found");

        if(null != aInMovie.getTitle()) lMovie.setTitle(aInMovie.getTitle());

        if(null != aInMovie.getReleaseYear()) lMovie.setReleaseYear(aInMovie.getReleaseYear());

        return movieRepo.save(lMovie);
    }
}
