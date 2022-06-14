package ch.diyamane.app.petrol.userresource.controller;

import ch.diyamane.app.petrol.user.api.SigninApi;
import ch.diyamane.app.petrol.user.dto.JWTResponseTokenDto;
import ch.diyamane.app.petrol.user.dto.SigninRequestDto;
import ch.diyamane.app.petrol.userresource.security.JWTTokenService;
import ch.diyamane.app.petrol.userresource.security.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class SigninRequestController implements SigninApi {

  @Autowired
  JWTUtils jwtUtils;

  @Autowired
  ReactiveAuthenticationManager authenticationManager;

  @Autowired
  JWTTokenService jwtTokenService;

  @Override
  public ResponseEntity<JWTResponseTokenDto> signinUser(SigninRequestDto signinRequestDto) {

    log.debug("Singin request called");

    Mono<Authentication> authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(signinRequestDto.getUserName(), signinRequestDto.getPassword()));

    Authentication authenticatedResult = authentication.block();

    authentication.filter(Authentication::isAuthenticated);
    Disposable subscribe = authentication.subscribe(
        authentication1 -> {return ResponseEntity.ok(jwtTokenService.getJwtResponseTokenDto(authentication));}
    );



  }


}
