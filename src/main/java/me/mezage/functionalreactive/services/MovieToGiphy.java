package me.mezage.functionalreactive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;

import java.util.List;

@Service
public class MovieToGiphy implements IMovieToGiphy {

    private Scheduler scheduler;
    private GiphyService giphyService;
    private OmdbService omdbService;

    @Autowired
    public MovieToGiphy(Scheduler scheduler, GiphyService giphyService, OmdbService omdbService) {
        this.scheduler = scheduler;
        this.giphyService = giphyService;
        this.omdbService = omdbService;
    }

    @Override
    public Flux<String> getGiphysFromMovies(List<String> movies) {
        return Flux.fromIterable(movies)
                .parallel()
                .runOn(scheduler)
                .map(movie -> omdbService.apply(movie))
                .checkpoint("description")
                .flatMap(movie ->
                        movie.zipWhen(
                                m -> giphyService.apply(m.getSearch().get(0).getTitle()),
                                (a, b) -> b.getData().get(0).getImages().getOriginalImage().getUrl())
                )
                .sequential();
    }
}
