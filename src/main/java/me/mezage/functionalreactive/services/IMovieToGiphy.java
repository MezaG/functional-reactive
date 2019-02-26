package me.mezage.functionalreactive.services;

import reactor.core.publisher.Flux;

import java.util.List;

public interface IMovieToGiphy {
    Flux<String> getGiphysFromMovies(List<String> movies);
}
