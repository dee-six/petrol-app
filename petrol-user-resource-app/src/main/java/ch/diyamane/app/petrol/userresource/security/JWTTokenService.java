package ch.diyamane.app.petrol.userresource.security;

import ch.diyamane.app.petrol.user.dto.JWTResponseTokenDto;
import ch.diyamane.app.petrol.user.dto.RoleEnum;
import ch.diyamane.app.petrol.user.dto.UserDetailsDto;
import ch.diyamane.app.petrol.userresource.service.RoleManagerService;
import ch.diyamane.app.petrol.userresource.service.UserManagerService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class JWTTokenService {

  private JWTUtils jwtUtils;

  UserManagerService userManagerService;

  RoleManagerService roleManagerService;

  ReactiveUserDetailsService userDetailsService;

  public JWTResponseTokenDto getJwtResponseTokenDto(Mono<Authentication> authentication) {

    authentication.map(userToken -> {
      String jwt = jwtUtils.generateJwtToken(authentication);

      UserDetails userDetails = (UserDetails) userToken.getDetails();
      List<RoleEnum> roles = userDetails.getAuthorities().stream()
          .map(item -> item.getAuthority())
          .map(s -> RoleEnum.valueOf(s))
          .collect(Collectors.toList());

      UserDetailsDto user = userManagerService.getUserDataByUserName(userDetails.getUsername());

      JWTResponseTokenDto jwtResponseDto = JWTResponseTokenDto.builder().id(user.getId()).userName(user.getUserName())
          .email(user.getEmail())
          .token(jwt)
          .roles(roles).build();

      log.info(jwtResponseDto.toString());
      return jwtResponseDto;
    }).switchIfEmpty(Mono.empty());

    return null;
  }

  public boolean validateJwtToken(String jwtToken) {

    if (jwtUtils.validateJwtToken(jwtToken))  {
      String userName = jwtUtils.getUserName(jwtToken);
      Mono<UserDetails> userDetails = userDetailsService.findByUsername(userName);
      userDetails.block().getAuthorities();

      UserDetails userDetailsResult = userDetails.block();
      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
          userDetailsResult, null, userDetailsResult.getAuthorities());

      ReactiveSecurityContextHolder.withAuthentication(usernamePasswordAuthenticationToken);

      return usernamePasswordAuthenticationToken.isAuthenticated();

    } else {
      return false;
    }

  }
}
