package org.garvk.recent_service.service;

import org.garvk.recent_service.feign.MovieIf;
import org.garvk.recent_service.feign.ShowIf;
import org.garvk.recent_service.model.MovieDto;
import org.garvk.recent_service.model.RecentRespDTO;
import org.garvk.recent_service.model.ShowDto;
import org.springframework.stereotype.Service;

import javax.lang.model.element.RecordComponentElement;
import java.util.List;

@Service
public class RecentService {

    MovieIf movieService;
    ShowIf showService;

    public RecentService(MovieIf aInMovieService, ShowIf aInShowService){
        this.movieService = aInMovieService;
        this.showService = aInShowService;
    }

    public RecentRespDTO getRecentMedia() {
        RecentRespDTO aOutResponse = new RecentRespDTO();
        List<MovieDto> lMovieList = movieService.getLatestMovies().getBody();
        List<ShowDto> lShowList = showService.getRecentShows().getBody();
        aOutResponse.setMovies(lMovieList);
        aOutResponse.setShows(lShowList);
        return aOutResponse;
    }
}
