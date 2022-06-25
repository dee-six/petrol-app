package ch.diyamane.app.petrol.auth.authentication.service;

import ch.diyamane.app.petrol.auth.authentication.domain.UserData;
import ch.diyamane.app.petrol.auth.authentication.repository.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserDataRepository userDataRepository;
  private final  UserDetailsBuilderService userDetailsBuilderService;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserData userData = userDataRepository.findByUserName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return userDetailsBuilderService.build(userData);
  }

}
