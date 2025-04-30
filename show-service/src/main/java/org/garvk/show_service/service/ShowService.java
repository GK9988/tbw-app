package org.garvk.show_service.service;

import org.garvk.show_service.model.Show;
import org.garvk.show_service.model.WatchStatus;
import org.garvk.show_service.repository.ShowRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private ShowRepo showRepo;

    public ShowService(ShowRepo aInShowRepo){
        this.showRepo = aInShowRepo;
    }

    public Show addShow(Show aInShow) {
        return showRepo.save(aInShow);
    }

    public List<Show> getAllShows() {
        return showRepo.findAll();
    }

    public Show getShowById(Long aInId) {
        return showRepo.findById(aInId).orElse(null);
    }

    public List<Show> getRecentShows() {
        return showRepo.findLatestShows(PageRequest.of(0, 5));
    }

    public void deleteShow(Long aInId) {
        showRepo.deleteById(aInId);
    }

    public Show setShowWatchStatus(Long aInId, WatchStatus aInWatchStatus) {
        Show lShow = showRepo.findById(aInId).orElse(null);

        if(null == lShow) throw new RuntimeException("No Show Found");

        lShow.setWatchStatus(aInWatchStatus);

        return showRepo.save(lShow);
    }

    public Show updateShow(Show aInShow) {
        Long lId = aInShow.getId();

        if(null == lId) throw new RuntimeException("No Id");

        Show lShow = showRepo.findById(lId).orElse(null);

        if(null == lShow) throw new RuntimeException("No Show Found");

        if(null != aInShow.getTitle()) lShow.setTitle(aInShow.getTitle());
        if(null != aInShow.getSeasons()) lShow.setSeasons(aInShow.getSeasons());
        if(null != aInShow.getReleaseYear()) lShow.setReleaseYear(aInShow.getReleaseYear());

        return showRepo.save(lShow);
    }
}
