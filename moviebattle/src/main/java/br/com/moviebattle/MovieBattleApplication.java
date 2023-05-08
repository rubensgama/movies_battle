package br.com.moviebattle;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackages = "br.com.moviebattle.entity")
@EnableJpaRepositories(basePackages = "br.com.moviebattle.repository")
@OpenAPIDefinition(info = @Info(title = "Movie Battle API", version = "2.0", description = "Movie Battle Api Information"))
@SecurityScheme(name = "moviebattle", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class MovieBattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBattleApplication.class, args);
	}

}
