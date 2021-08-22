package ch.diyamane.app.petrol.configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class PetroMicroserviceSwaggerConfiguration {

  @Bean
  public OpenAPI springPetrolOpenApi() {
    return new OpenAPI()
        .info(new Info().title("Diya Mane Petrol Single Page Portal - API")
            .description("Diya Mane Petrol SinglePage Application")
            .version("v0.0.1")
            .contact(new Contact().name("Deepak Rampoore").url("www.petrol.com").email("deepak.rampoore@gmail.com"))
            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
        .externalDocs(new ExternalDocumentation()
            .description("SpringShop Wiki Documentation")
            .url("https://springshop.wiki.github.org/docs"));
  }

  @PostConstruct
  public void printSomeThing() {
    log.info("Config applied");
  }
}
