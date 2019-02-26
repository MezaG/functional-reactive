package me.mezage.functionalreactive.services;

import me.mezage.functionalreactive.models.omdb.OmdbResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OmdbServiceImpl implements OmdbService {

    private static Logger LOGGER = LoggerFactory.getLogger(OmdbServiceImpl.class);
    private WebClient webClient;
    private final String apiKey;

    @Autowired
    public OmdbServiceImpl(@Value("${apikeys.omdb}") String apiKey, WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://www.omdbapi.com").build();
        this.apiKey = apiKey;
    }
    @Override
    public Mono<OmdbResponse> apply(String s) {
        LOGGER.info("Movie keyword -----> {}", s);
        return this.webClient.get().uri("/?apikey="+apiKey+"&s="+s)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(OmdbResponse.class);
    }
}
