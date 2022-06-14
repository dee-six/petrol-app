package ch.diyamane.app.petrol.userresource.config;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@Slf4j
public class JwtCorsConfiguration {

  @Value("${ch.diyamane.tutorial.spring.enableCors:false}")
  private boolean corsEnabled;

  @PostConstruct
  public void init() {
    log.info("CorsEnabled={}", corsEnabled);
  }

  @Bean
  @ConditionalOnProperty(prefix = "ch", name = "diyamane.tutorial.spring.enableCors", havingValue = "true")
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("OPTIONS", "GET", "POST"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    log.info("CorsConfigurationSource config created");

    return source;
  }
}
