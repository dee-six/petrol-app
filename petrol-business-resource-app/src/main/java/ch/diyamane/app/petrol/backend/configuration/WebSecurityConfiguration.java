package ch.diyamane.app.petrol.backend.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfiguration {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests()
        .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
        .antMatchers(HttpMethod.GET, "/petrol-api-ui**", "/swagger-ui/**", "/rest/**", "/v3/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .oauth2ResourceServer().jwt();
    return httpSecurity.build();
  }

}
