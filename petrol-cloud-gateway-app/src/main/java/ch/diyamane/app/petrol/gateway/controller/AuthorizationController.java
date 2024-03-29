
package ch.diyamane.app.petrol.gateway.controller;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;
import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Joe Grandja
 * @since 0.0.1
 */
@Controller
@Slf4j
public class AuthorizationController {

  private final WebClient webClient;
  private final String messagesBaseUri;

  public AuthorizationController(WebClient.Builder webClientBuilder, @Value("uri") String messagesBaseUri) {
    this.webClient = webClientBuilder.baseUrl("http://localhost:8083/petrol/pumping").build();
    this.messagesBaseUri = messagesBaseUri;
  }


  @GetMapping(value = "/authorize")
  public String authorizationCodeGrant(Model model, 
      @RegisteredOAuth2AuthorizedClient("petrol-business-client-oidc") OAuth2AuthorizedClient authorizedClient) {

    log.info(" I am here authorizationCodeGrant");
    String[] messages = this.webClient
        .get()
        .uri("http://localhost:8083/petrol/pumping")
        .attributes(oauth2AuthorizedClient(authorizedClient))
        .retrieve()
        .bodyToMono(String[].class)
        .block();
    model.addAttribute("messages", messages);

    return "index";
  }

  // '/authorized' is the registered 'redirect_uri' for authorization_code
  @GetMapping(value = "/authorized", params = OAuth2ParameterNames.ERROR)
  public String authorizationFailed(Model model, HttpServletRequest request) {

    log.info(" I am here authorizationFailed");

    String errorCode = request.getParameter(OAuth2ParameterNames.ERROR);
    if (StringUtils.hasText(errorCode)) {
      model.addAttribute("error",
          new OAuth2Error(
              errorCode,
              request.getParameter(OAuth2ParameterNames.ERROR_DESCRIPTION),
              request.getParameter(OAuth2ParameterNames.ERROR_URI))
      );
    }

    return "index";
  }

  @GetMapping(value = "/authorize", params = "grant_type=client_credentials")
  public String clientCredentialsGrant(Model model) {

    log.info(" I am here clientCredentialsGrant");

    String[] messages = this.webClient
        .get()
        .uri(this.messagesBaseUri)
        .attributes(clientRegistrationId("messaging-client-client-credentials"))
        .retrieve()
        .bodyToMono(String[].class)
        .block();
    model.addAttribute("messages", messages);

    return "index";
  }
}
