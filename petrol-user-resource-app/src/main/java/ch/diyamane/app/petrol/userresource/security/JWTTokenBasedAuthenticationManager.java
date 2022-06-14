package ch.diyamane.app.petrol.userresource.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractUserDetailsReactiveAuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class JWTTokenBasedAuthenticationManager extends AbstractUserDetailsReactiveAuthenticationManager {

  @Autowired
  ReactiveUserDetailsService userDetailsService;

  @Override
  protected Mono<UserDetails> retrieveUser(String username) {
    return userDetailsService.findByUsername(username);
  }
}
