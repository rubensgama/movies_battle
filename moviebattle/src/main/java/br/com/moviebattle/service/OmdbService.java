package br.com.moviebattle.service;

import br.com.moviebattle.dto.MovieDto;
import br.com.moviebattle.factory.WebClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OmdbService {
    @Value("${omdb.api.url}")
    private String baseUrl;

    @Autowired
    private WebClientFactory factory;

    public MovieDto findMovieByTitle(String title) {
        WebClient client = factory.create(baseUrl.concat("&t=").concat(title));
        Mono<MovieDto> movieDtoMono = client.post()
                .header(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_JSON_VALUE).retrieve().bodyToMono(MovieDto.class);
        return movieDtoMono.block();
    }

    public MovieDto findMovieByImdbId(String id) {
        WebClient client = factory.create(baseUrl.concat("&i=").concat(id));
        Mono<MovieDto> movieDtoMono = client.post()
                .header(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_JSON_VALUE).retrieve().bodyToMono(MovieDto.class);
        return movieDtoMono.block();
    }
}
