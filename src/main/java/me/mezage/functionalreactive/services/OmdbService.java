package me.mezage.functionalreactive.services;

import me.mezage.functionalreactive.models.omdb.OmdbResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

 public interface OmdbService extends Function<String, Mono<OmdbResponse>> {
}
