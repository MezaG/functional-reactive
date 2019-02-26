package me.mezage.functionalreactive.services;

import me.mezage.functionalreactive.models.giphy.GiphyResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

 public interface GiphyService extends Function<String, Mono<GiphyResponse>> {
}
