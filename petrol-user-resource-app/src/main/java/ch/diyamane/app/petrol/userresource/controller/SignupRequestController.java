package ch.diyamane.app.petrol.userresource.controller;

import ch.diyamane.app.petrol.user.api.SignupApi;
import ch.diyamane.app.petrol.user.dto.MessageDto;
import ch.diyamane.app.petrol.user.dto.SignupRequestDto;
import ch.diyamane.app.petrol.user.dto.UserDetailsDto;
import ch.diyamane.app.petrol.userresource.service.UserManagerService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupRequestController implements SignupApi {

  @Autowired
  UserManagerService userManagerService;

  @Autowired
  PasswordEncoder passwordEncoder;


  @Override
  public ResponseEntity<MessageDto> signupUser(ch.diyamane.app.petrol.user.dto.SignupRequestDto signupRequestDto) {
    if (userManagerService.existsByUserNameAndEmail(signupRequestDto.getUserName(), signupRequestDto.getEmail())) {
      return ResponseEntity.badRequest().body(MessageDto.builder().message("Error: Username is already taken!").build());
    }

    // Create new user's account
    userManagerService.createUserData(signupRequestDto);

    return ResponseEntity.ok(MessageDto.builder().message("User registered successfully!").build());
  }
}
