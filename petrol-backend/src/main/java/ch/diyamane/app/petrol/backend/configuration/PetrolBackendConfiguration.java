package ch.diyamane.app.petrol.backend.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "ch.diyamane.app.petrol.backend")
@PropertySource("classpath:application-backend.properties")
public class PetrolBackendConfiguration {

}
