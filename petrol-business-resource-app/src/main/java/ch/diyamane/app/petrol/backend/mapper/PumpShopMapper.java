package ch.diyamane.app.petrol.backend.mapper;

import ch.diyamane.app.petrol.backend.domain.model.shop.PumpShop;
import ch.diyamane.app.petrol.business.dto.PumpShopDto;
import java.util.List;
import java.util.stream.Collectors;

public class PumpShopMapper {

  private PumpShopMapper() {
  }

  public static PumpShopDto toDto(PumpShop pumpShop) {

    return PumpShopDto.builder().address1(pumpShop.getAddress1()).address2(pumpShop.getAddress2())
        .city(pumpShop.getCity()).country(pumpShop.getCountry()).name(pumpShop.getName())
        .description(pumpShop.getDescription()).zipCode(pumpShop.getZipCode()).id(pumpShop.getId().intValue())
        .pumpings(pumpShop.getPumpings().stream().map(PumpingsMapper::toDto).collect(Collectors.toList()))
        .build();

  }

  public static PumpShop toPumpShop(PumpShopDto dto) {

    if (dto == null) {
      return null;
    }

    PumpShop pumpShop = PumpShop.builder().address1(dto.getAddress1()).address2(dto.getAddress2()).city(dto.getCity())
        .country(dto.getCountry()).name(dto.getName()).zipCode(dto.getZipCode())
        .description(dto.getDescription())
        .id(dto.getId() == null ? null : dto.getId().longValue())
        .build();

    if (dto.getPumpings() != null) {
      pumpShop.addPumpings(dto.getPumpings().stream().map(PumpingsMapper::toPumpings).collect(Collectors.toSet()));
    }

    return pumpShop;
  }

  public static List<PumpShopDto> toDto(List<PumpShop> findAll) {

    if (findAll == null) {
      return null;
    }

    return findAll.stream().map(PumpShopMapper::toDto).collect(Collectors.toList());
  }
}
