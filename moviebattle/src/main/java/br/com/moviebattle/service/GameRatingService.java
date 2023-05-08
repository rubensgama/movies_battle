package br.com.moviebattle.service;

import br.com.moviebattle.entity.GameRating;
import br.com.moviebattle.repository.GameRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameRatingService {
    @Autowired
    private GameRatingRepository gameRatingRepository;

    @Transactional
    public GameRating save(GameRating rating) {
        return gameRatingRepository.save(rating);
    }

    public List<GameRating> findAll() {
        List<GameRating> result = new ArrayList<>();
        gameRatingRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }
}
