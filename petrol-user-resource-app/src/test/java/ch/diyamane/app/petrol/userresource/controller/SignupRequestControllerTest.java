package ch.diyamane.app.petrol.userresource.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import ch.diyamane.app.petrol.user.dto.MessageDto;
import ch.diyamane.app.petrol.user.dto.SignupRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SignupRequestControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  SignupRequestDto signupRequestDto;

  @BeforeEach
  public void setup() {
    signupRequestDto = SignupRequestDto.builder().userName("deepak").password("password").build();
  }

  @Test
  public void whenSignUpIsCalled_thenUserIsCreated() {
    EntityExchangeResult<MessageDto> result = webTestClient.post().uri("/api/petrol/auth/signup")
        .body(Mono.just(signupRequestDto), SignupRequestDto.class)
        .exchange()
        .expectStatus().isOk()
        .expectBody(MessageDto.class)
        .returnResult();

    assertThat(result.getResponseBody().getMessage().contains("successfully"));

  }
}