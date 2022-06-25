package ch.diyamane.app.petrol.auth.startup;

import ch.diyamane.app.petrol.auth.authentication.service.RoleManagerService;
import ch.diyamane.app.petrol.auth.authentication.service.UserManagerService;
import ch.diyamane.app.petrol.auth.authorization.service.JpaRegisteredClientRepository;
import ch.diyamane.app.petrol.user.dto.RoleEnum;
import ch.diyamane.app.petrol.user.dto.SignupRequestDto;
import java.time.Instant;
import java.util.Collections;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivateRegisteredClient {

  private final RoleManagerService roleManagerService;
  private final JpaRegisteredClientRepository jpaRegisteredClientRepository;

  private final UserManagerService userManagerService;

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationEvent() {

    RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
        .clientId("petrol-business-resource-app")
        .clientSecret("{noop}c788161d-dadd-4189-a1dc-09cb70d6fe74")
        .clientIdIssuedAt(Instant.EPOCH)
        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
        .redirectUri("http://127.0.0.1:8082/login/oauth2/code/petrol-business-client-oidc")
        .redirectUri("http://127.0.0.1:8082/authorized")
        .scope(OidcScopes.OPENID)
        .scope("message.read")
        .scope("message.write")
        .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
        .tokenSettings(TokenSettings.builder().build())
        .build();

    jpaRegisteredClientRepository.save(registeredClient);

    roleManagerService.createRoles();
    log.info("Roles master data is created successfully{}", roleManagerService.getRoles());

    userManagerService.createUserData(
        SignupRequestDto.builder().userName("deepak").password("password").email("me@yahoo.com")
            .roles(Collections.singletonList(RoleEnum.USER)).build());

  }
}
