package br.com.moviebattle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NotNull
public class RatingDto {
    @JsonProperty("Source")
    private String source;
    @JsonProperty("Value")
    private String value;
}
