package ch.diyamane.app.petrol.gateway.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
                .anyExchange().authenticated()
                .and().csrf().disable()
                .oauth2Login(withDefaults())
                .oauth2Client(withDefaults()));

    return serverHttpSecurity.build();

  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
