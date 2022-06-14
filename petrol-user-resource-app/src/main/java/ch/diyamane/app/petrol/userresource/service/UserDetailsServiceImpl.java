package ch.diyamane.app.petrol.userresource.service;

import ch.diyamane.app.petrol.userresource.domain.UserData;
import ch.diyamane.app.petrol.userresource.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Qualifier(value = "myUserDetailsService")
public class UserDetailsServiceImpl implements ReactiveUserDetailsService {

  @Autowired
  UserDataRepository userDataRepository;

  @Autowired
  UserDetailsBuilderServiceImpl userDetailBuilderService;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserData userData = userDataRepository.findByUserName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return userDetailBuilderService.build(userData);
  }

  @Override
  public Mono<UserDetails> findByUsername(String username) {
    return Mono.just(loadUserByUsername(username));
  }
}
