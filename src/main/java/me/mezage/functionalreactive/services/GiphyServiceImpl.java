package me.mezage.functionalreactive.services;

import me.mezage.functionalreactive.models.giphy.GiphyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GiphyServiceImpl implements GiphyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GiphyServiceImpl.class);
    private String apiKey;
    private WebClient webClient;

    @Autowired
    public GiphyServiceImpl(@Value("${apikeys.giphy}") String apiKey, WebClient.Builder webClientBuilder) {
        this.apiKey = apiKey;
        this.webClient = webClientBuilder.baseUrl("http://api.giphy.com").build();
    }
    @Override
    public Mono<GiphyResponse> apply(String s) {
        LOGGER.info("movie with Title ----> {}", s);
        return this.webClient.get().uri("/v1/gifs/search?api_key="+apiKey+"&limit=1&q="+s)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(GiphyResponse.class);
    }
}
