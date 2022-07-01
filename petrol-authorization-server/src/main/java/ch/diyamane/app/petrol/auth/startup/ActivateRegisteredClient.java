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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivateRegisteredClient {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final RoleManagerService roleManagerService;
  private final JpaRegisteredClientRepository jpaRegisteredClientRepository;

  private final UserManagerService userManagerService;

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationEvent() {

    RegisteredClient registeredClientCloudGateWay = RegisteredClient.withId(UUID.randomUUID().toString())
        .clientId("petrol-cloud-gateway")
        .clientSecret(bCryptPasswordEncoder.encode("random-secret"))
        .clientIdIssuedAt(Instant.EPOCH)
        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
        .redirectUri("http://127.0.0.1:8082/login/oauth2/code/petrol-cloud-gateway-oidc")
        .redirectUri("http://127.0.0.1:8082/authorized")
        .scope(OidcScopes.OPENID)
        .scope("petrol.read")
        .scope("petrol.write")
        .scope("petrol.all")
      //  .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
        .tokenSettings(TokenSettings.builder().build())
        .build();

    jpaRegisteredClientRepository.save(registeredClientCloudGateWay);

    RegisteredClient registeredClientServer = RegisteredClient.withId(UUID.randomUUID().toString())
        .clientId("petrol-client-server")
        .clientSecret(bCryptPasswordEncoder.encode("random-secret"))
        .clientIdIssuedAt(Instant.EPOCH)
        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
        .redirectUri("http://127.0.0.1:8084/login/oauth2/code/petrol-client-server-oidc")
        .redirectUri("http://127.0.0.1:8084/authorized")
        .scope(OidcScopes.OPENID)
        .scope("petrol.read")
        .scope("petrol.write")
        .scope("petrol.all")
        //  .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
        .tokenSettings(TokenSettings.builder().build())
        .build();

    jpaRegisteredClientRepository.save(registeredClientServer);

    roleManagerService.createRoles();
    log.info("Roles master data is created successfully{}", roleManagerService.getRoles());

    userManagerService.createUserData(
        SignupRequestDto.builder().userName("deepak").password("password").email("me@yahoo.com")
            .roles(Collections.singletonList(RoleEnum.USER)).build());

  }
}
