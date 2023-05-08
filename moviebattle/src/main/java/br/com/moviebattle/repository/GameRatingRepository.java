package br.com.moviebattle.repository;

import br.com.moviebattle.entity.GameRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRatingRepository extends CrudRepository<GameRating, Long> {
}
