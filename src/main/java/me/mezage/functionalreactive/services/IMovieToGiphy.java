package me.mezage.functionalreactive.services;

import me.mezage.functionalreactive.models.giphy.GiphyResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IMovieToGiphy {
    Flux<String> getGiphysFromMovies(List<String> movies);
}
