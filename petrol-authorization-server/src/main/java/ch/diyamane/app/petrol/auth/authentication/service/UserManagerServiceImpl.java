package ch.diyamane.app.petrol.auth.authentication.service;

import ch.diyamane.app.petrol.auth.authentication.domain.Role;
import ch.diyamane.app.petrol.auth.authentication.domain.UserData;
import ch.diyamane.app.petrol.auth.authentication.mapper.UserMapper;
import ch.diyamane.app.petrol.auth.authentication.repository.UserDataRepository;
import ch.diyamane.app.petrol.user.dto.RoleEnum;
import ch.diyamane.app.petrol.user.dto.SignupRequestDto;
import ch.diyamane.app.petrol.user.dto.UserDetailsDto;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class UserManagerServiceImpl implements UserManagerService {

  @Autowired
  UserDataRepository userDataRepository;

  @Autowired
  RoleManagerService roleManagerService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @PostConstruct
  public void init() {
    log.info("Instance of PasswordEncoder {}", passwordEncoder.getClass().getName());
  }

  @Override
  public UserDetailsDto createUserData(SignupRequestDto signupRequestDto) {

    return UserMapper.toDto(userDataRepository.save(
        UserData.builder().userName(signupRequestDto.getUserName())
            .password(passwordEncoder.encode(signupRequestDto.getPassword()))
            .email(signupRequestDto.getEmail())
            .roles(getRoles(signupRequestDto))
            .build()));
  }

  // if Roles is null then by default USER is assigned
  private Set<Role> getRoles(SignupRequestDto signupRequestDto) {

    if (signupRequestDto.getRoles() == null) {
      return Sets.newHashSet(roleManagerService.getRoleByName(RoleEnum.USER.name()));
    }
    return signupRequestDto.getRoles().stream().map(s -> roleManagerService.getRoleByName(s.name()))
        .collect(Collectors.toSet());
  }

  @Override
  public UserDetailsDto getUserDataByUserNameAndEmail(String userName, String eMail) {

    UserData userData = userDataRepository.findByUserNameAndEmail(userName, eMail).orElseThrow(() -> {
      return new IllegalArgumentException("User " + userName + " with eMail " + eMail + " does not exists");
    });

    return UserMapper.toDto(userData);
  }

  @Override
  public UserDetailsDto getUserDataByUserName(String userName) {
    UserData userData = userDataRepository.findByUserName(userName).orElseThrow(() -> {
      return new IllegalArgumentException("User " + userName + " does not exists");
    });

    return UserMapper.toDto(userData);
  }

  @Override
  public Boolean existsByUserNameAndEmail(String userName, String eMail) {
    return userDataRepository.existsByUserNameAndEmail(userName, eMail);
  }

  @Override
  public List<UserDetailsDto> listAll() {
    return UserMapper.toDto(userDataRepository.findAll());
  }

}
