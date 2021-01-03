package ch.diyamane.app.petrol.configuration;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Slf4j
public class PetroMicroserviceSwaggerConfiguration {

	@Bean
	public Docket petroApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {

		return new ApiInfo("Diya Mane Petrol Single Page Portal - API", "Diya Mane Petrol Single Page Portal - API",
				"1.0", "Terms of service",
				new Contact("Deepak Rampoore", "www.petrol.com", "deepak.rampoore@gmail.com"), "License of API",
				"API license URL", Collections.emptyList());

	}
	
	@PostConstruct
	public void printSomeThing() {
		log.info("Config applied");
	}
}
