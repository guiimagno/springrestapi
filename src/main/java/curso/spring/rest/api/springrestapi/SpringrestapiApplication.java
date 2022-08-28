package curso.spring.rest.api.springrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
@RestController
@EnableAutoConfiguration
public class SpringrestapiApplication implements WebMvcConfigurer {

	public static void main(String[] args){
		SpringApplication.run(SpringrestapiApplication.class, args);
	}

	// mapeamento global que reflete em todo o sistema
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/usuario/**")
				.allowedMethods("*")
				.allowedOrigins("*");
//				.allowedMethods("POST", "PUT", "GET", "DELETE")
//				.allowedOrigins("localhost:8080");
	}
}
