package ch.diyamane.app.petrol.client.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@Slf4j
public class SecurityConfiguration {

  @Bean
  public SecurityWebFilterChain configurationSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {

    serverHttpSecurity.authorizeExchange(
        authorizeExchangeSpec ->
            authorizeExchangeSpec
                .pathMatchers(HttpMethod.GET, "/actuator/**", "/api/server/**").permitAll()
                .anyExchange().authenticated()
                .and().csrf().disable()
                .oauth2Login());

    return serverHttpSecurity.build();

  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
