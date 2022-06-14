package ch.diyamane.app.petrol.userresource.service;

import ch.diyamane.app.petrol.userresource.domain.UserData;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsBuilderServiceImpl implements UserDetailsBuilderService {

  @Override
  public UserDetails build(UserData userData) {

    List<GrantedAuthority> authorities = userData.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return org.springframework.security.core.userdetails.User.withUsername(userData.getUserName())
        .authorities(authorities).accountExpired(false).accountLocked(false).disabled(false).password(userData.getPassword())
        .credentialsExpired(false)
        .build();
  }
}
