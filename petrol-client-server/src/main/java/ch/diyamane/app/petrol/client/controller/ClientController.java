
package ch.diyamane.app.petrol.client.controller;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Joe Grandja
 * @since 0.0.1
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class ClientController {

  private final WebClient webClient;


  @GetMapping(value = "/api/authorizationCodeGrant")
  public Mono<String> authorizationCodeGrant() {

    log.info(" I am here authorizationCodeGrant");
    Mono<String> response = this.webClient
        .get()
        .uri("http://localhost:8083/petrol/pumping")
        .retrieve()
        .bodyToMono(String.class);

    return response.map(string -> "Resource: " + string);
  }


  @GetMapping(value = "/api/authorizeClientCredentials")
  public Mono<String> clientCredentialsGrant(Model model) {

    log.info(" I am here clientCredentialsGrant");

    Mono<String> response = this.webClient
        .get()
        .uri("http://localhost:8083/petrol/pumping")
        .attributes(clientRegistrationId("petrol-business-resource-app"))
        .retrieve()
        .bodyToMono(String.class);

    return response.map(string -> "Resource: " + string);

  }
}
