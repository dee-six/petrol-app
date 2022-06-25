package ch.diyamane.app.petrol.auth.authentication.controller;

import ch.diyamane.app.petrol.auth.authentication.service.UserManagerService;
import ch.diyamane.app.petrol.user.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupRequestController {

  @Autowired
  UserManagerService userManagerService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @PostMapping("/api/petrol/auth/signup")
  public ResponseEntity<MessageDto> signupUser(ch.diyamane.app.petrol.user.dto.SignupRequestDto signupRequestDto) {
    if (userManagerService.existsByUserNameAndEmail(signupRequestDto.getUserName(), signupRequestDto.getEmail())) {
      return ResponseEntity.badRequest().body(MessageDto.builder().message("Error: Username is already taken!").build());
    }

    // Create new user's account
    userManagerService.createUserData(signupRequestDto);

    return ResponseEntity.ok(MessageDto.builder().message("User registered successfully!").build());
  }
}
