package ch.diyamane.app.petrol.userresource.controller;

import static org.assertj.core.api.Assertions.assertThat;

import ch.diyamane.app.petrol.user.dto.JWTResponseTokenDto;
import ch.diyamane.app.petrol.user.dto.SigninRequestDto;
import ch.diyamane.app.petrol.user.dto.SignupRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SigninRequestControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  JWTResponseTokenDto jwtResponseTokenDto;
  SigninRequestDto signinRequestDto;

  @BeforeEach
  public void setup() {
    signinRequestDto = SigninRequestDto.builder().userName("deepak").password("password").build();

    SignupRequestDto signupRequestDto = SignupRequestDto.builder().userName("deepak").password("password").build();
    webTestClient.post().uri("/api/petrol/auth/signup")
        .body(Mono.just(signupRequestDto), SignupRequestDto.class)
        .exchange()
        .expectStatus().isOk();
  }

  @Test
  public void whenWithCorrectCredentialSignInIsCalled_thenJWTTokenIsReturned() {
    EntityExchangeResult<JWTResponseTokenDto> result = webTestClient.post().uri("/api/petrol/auth/signin")
        .body(Mono.just(signinRequestDto), SigninRequestDto.class)
        .exchange()
        .expectStatus().isOk()
        .expectBody(JWTResponseTokenDto.class)
        .returnResult();

    assertThat(result.getResponseBody().getToken()).isNotNull();

  }
}