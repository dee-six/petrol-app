package ch.diyamane.app.petrol.userresource.service;

import ch.diyamane.app.petrol.user.dto.RoleEnum;
import ch.diyamane.app.petrol.user.dto.SignupRequestDto;
import ch.diyamane.app.petrol.user.dto.UserDetailsDto;
import ch.diyamane.app.petrol.userresource.domain.Role;
import ch.diyamane.app.petrol.userresource.domain.UserData;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class UserDataDetailsBuilderServiceTest {

  @Autowired
  UserDetailsBuilderService userDetailsBuilderService;

  @Autowired
  UserManagerService userManagerService;

  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Test
  public void givenUserWhenUserDetailsIscalledThenUserDetailsIsCreated() {

    Set<Role> roleSet = Sets.newHashSet();
    roleSet.add(Role.builder().name(RoleEnum.USER).build());

    UserDetails what = userDetailsBuilderService.build(
        UserData.builder().userName("deepak").password("password").email("deepak.rampoore@gmail.com").roles(roleSet).build());

    Assertions.assertThat(what).isNotNull();

    Assertions.assertThat(what.isEnabled()).isTrue();
    Assertions.assertThat(what.isAccountNonLocked()).isTrue();
    Assertions.assertThat(what.isAccountNonExpired()).isTrue();
    Assertions.assertThat(what.isCredentialsNonExpired()).isTrue();

    Assertions.assertThat(what.getUsername()).isEqualTo("deepak");
    Assertions.assertThat(what.getPassword()).isEqualTo("password");
    Assertions.assertThat(what.getAuthorities().toArray()).contains(new SimpleGrantedAuthority(RoleEnum.USER.name()));
  }

  @Test
  public void givenSignWhenUserIsSavedThenUserDataIsCreated() {

    UserDetailsDto userData = userManagerService.createUserData(
        SignupRequestDto.builder().userName("deepak").email("deepak.rampoore@gmail.com").password("password")
            .roles(Lists.newArrayList(RoleEnum.USER))
            .build());

    Assertions.assertThat(userData).isNotNull();

    Assertions.assertThat(userData.getUserName()).isEqualTo("deepak");
    Assertions.assertThat(passwordEncoder.matches("password", userData.getPassword())).isTrue();
    Assertions.assertThat(userData.getRoles().stream().map(role -> role.getValue()).toArray()).contains(RoleEnum.USER.getValue());
  }

}