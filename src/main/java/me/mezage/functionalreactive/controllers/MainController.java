package me.mezage.functionalreactive.controllers;

import me.mezage.functionalreactive.models.giphy.GiphyResponse;
import me.mezage.functionalreactive.models.omdb.OmdbResponse;
import me.mezage.functionalreactive.services.GiphyService;
import me.mezage.functionalreactive.services.IMovieToGiphy;
import me.mezage.functionalreactive.services.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    private IMovieToGiphy service;

    @Autowired
    public MainController(IMovieToGiphy service) {
        this.service = service;
    }

    @GetMapping(value = "/api/movies", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getMovies(@RequestParam("q") String movieString) {
        List<String> movies = Arrays.asList(movieString.split(","));
        return service.getGiphysFromMovies(movies);
    }

    @GetMapping(value = "/api/single/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> getSingleMovies(@RequestParam("q") String movieString) {
        List<String> movies = Arrays.asList(movieString.split(","));
        return service.getGiphysFromMovies(movies).next();
    }

}
