package br.com.moviebattle.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "GAME_RATING")
public class GameRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "MOVE_TIME")
    private LocalDateTime moveTime;
    @Column(name = "MOVE_SELECTED")
    private String movieSelected;
    @Column(name= "MOVE_NOT_SELECTED")
    private String movieNotSelected;
    @Column(name = "RESULT")
    private Boolean result;
    @Column(name = "USER_ID")
    private String user;
}
