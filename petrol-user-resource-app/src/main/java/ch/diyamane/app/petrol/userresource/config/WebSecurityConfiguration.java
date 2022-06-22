package ch.diyamane.app.petrol.userresource.config;

import ch.diyamane.app.petrol.userresource.security.AuthEntryPointJwt;
import ch.diyamane.app.petrol.userresource.security.JWTTokenBasedAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class WebSecurityConfiguration {

  @Autowired
  AuthEntryPointJwt authEntryPointJwt;

  @Autowired
  JWTTokenBasedAuthenticationManager authenticationManager;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityWebFilterChain configurationSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {

    serverHttpSecurity.authorizeExchange(
        authorizeExchangeSpec ->
            authorizeExchangeSpec
                .pathMatchers("/api/petrol/auth/signin", "/api/petrol/auth/signup").permitAll()
                .pathMatchers("/rest/**", "/v3/**").permitAll()
                .anyExchange().authenticated()
                .and().cors()
                .and().csrf().disable()
                .oauth2ResourceServer().jwt());


    return serverHttpSecurity.build();

  }

}
