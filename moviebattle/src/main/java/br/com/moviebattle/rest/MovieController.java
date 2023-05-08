package br.com.moviebattle.rest;

import br.com.moviebattle.dto.GameMove;
import br.com.moviebattle.dto.MovieDto;
import br.com.moviebattle.entity.GameRating;
import br.com.moviebattle.service.GameRatingService;
import br.com.moviebattle.service.OmdbService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/movie")
@Api("movieController")
public class MovieController {
    @Autowired
    private OmdbService omdbService;

    @Autowired
    private GameRatingService gameRatingService;

    @PostMapping(value = "/pontuacao")
    public ResponseEntity<Boolean> filme1PossuiMaiorPontuacaoQueFilme2(@RequestBody GameMove gameMove) {
        MovieDto movie1 = omdbService.findMovieByImdbId(gameMove.getMovie1());
        MovieDto movie2 = omdbService.findMovieByImdbId(gameMove.getMovie2());
        ResponseEntity<Boolean> result = ResponseEntity.ok(movie1.getImdbRating().compareTo(movie2.getImdbRating()) >= 0);
        //save game move
        GameRating rating = new GameRating();
        rating.setResult(result.getBody());
        rating.setMovieSelected(movie1.getImdbId());
        rating.setMovieNotSelected(movie2.getImdbId());
        rating.setMoveTime(LocalDateTime.now());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        rating.setUser(username);

        gameRatingService.save(rating);
        return ResponseEntity.ok(rating.getResult());
    }

    @GetMapping(value = "/{title}")
    public MovieDto findMovieByTitle(@PathVariable("title") String title) {
        return omdbService.findMovieByTitle(title);
    }

    @GetMapping(value = "/all")
    public List<GameRating> findAll() {
        return gameRatingService.findAll();
    }
}
