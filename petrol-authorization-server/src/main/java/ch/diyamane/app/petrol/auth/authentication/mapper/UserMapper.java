package ch.diyamane.app.petrol.auth.authentication.mapper;

import ch.diyamane.app.petrol.auth.authentication.domain.Role;
import ch.diyamane.app.petrol.auth.authentication.domain.UserData;
import ch.diyamane.app.petrol.user.dto.RoleEnum;
import ch.diyamane.app.petrol.user.dto.UserDetailsDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

  public static List<UserDetailsDto> toDto(List<UserData> userDataList) {
    if (userDataList == null) {
      return null;
    }
    return userDataList.stream().map(UserMapper::toDto).collect(Collectors.toList());
  }

  public static UserDetailsDto toDto(UserData userData) {
    if (userData == null) {
      return null;
    }

    List<RoleEnum> roles = new ArrayList<RoleEnum>();

    UserDetailsDto userDetailsDto = UserDetailsDto.builder().userName(userData.getUserName()).email(userData.getEmail())
        .id(userData.getId()).roles(roles).build();

    userDetailsDto.getRoles().addAll(userData.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
    return userDetailsDto;
  }

}
