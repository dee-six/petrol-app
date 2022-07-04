package ch.diyamane.app.petrol.auth.authentication.service;

import ch.diyamane.app.petrol.user.dto.SignupRequestDto;
import ch.diyamane.app.petrol.user.dto.UserDetailsDto;
import java.util.List;

public interface UserManagerService {

  UserDetailsDto createUserData(SignupRequestDto signupRequestDto);

  UserDetailsDto getUserDataByUserNameAndEmail(String userName, String eMail);

  UserDetailsDto getUserDataByUserName(String userName);

  Boolean existsByUserNameAndEmail(String userName, String eMail);

  List<UserDetailsDto> listAll();
}
