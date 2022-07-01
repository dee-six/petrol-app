package ch.diyamane.app.petrol.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


  /**
   * This used where security authorization is using Authorization Code flow
   *
   * @param reactiveClientRegistrationRepository
   * @param serverOAuth2AuthorizedClientRepository
   * @return
   */
  @Bean
  WebClient config(ReactiveClientRegistrationRepository reactiveClientRegistrationRepository,
      ServerOAuth2AuthorizedClientRepository serverOAuth2AuthorizedClientRepository) {

    ServerOAuth2AuthorizedClientExchangeFilterFunction oauth2Client =
        new ServerOAuth2AuthorizedClientExchangeFilterFunction(reactiveClientRegistrationRepository,
            serverOAuth2AuthorizedClientRepository);

    oauth2Client.setDefaultOAuth2AuthorizedClient(true);

    return WebClient.builder().filter(oauth2Client).build();
  }

  /**
   * This used where security authorization is using Client Credntials
   *
   * @param reactiveClientRegistrationRepository
   * @param serverOAuth2AuthorizedClientRepository
   * @return
   */
}
