package br.com.moviebattle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket movieBattleApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()).apis(
                RequestHandlerSelectors.basePackage("br.com.moviebattle.api")).build().apiInfo(info())
                .pathMapping("/moviebattle").useDefaultResponseMessages(false).directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }
    private ApiInfo info() {
        return new ApiInfoBuilder().title("Movie Battle REST API")
                .description("API REST para uma aplicação ao estilo "
                        + "card game, onde serão informados dois filmes e o jogador "
                        + "deve acertar aquele que possui melhor avaliação no IMDB.")
                .version("1.0.0").license("None").build();
    }
}
