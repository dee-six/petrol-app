package ch.diyamane.app.petrol.backend.mapper;

import ch.diyamane.app.petrol.backend.domain.model.shop.Pumping;
import ch.diyamane.app.petrol.backend.dto.PumpingsDto;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PumpingsMapper {

  public static List<PumpingsDto> toDto(List<Pumping> pumpings) {
    return pumpings.stream().map(PumpingsMapper::toDto).collect(Collectors.toList());
  }

  public static PumpingsDto toDto(Pumping pumping) {
    return PumpingsDto.builder().billPaid(BigDecimal.valueOf(pumping.getBillPaid())).pumpDate(pumping.getPumpDate())
        .distance(BigDecimal.valueOf(pumping.getDistance()))
        .startReading(BigDecimal.valueOf(pumping.getStartReading()))
        .endReading(pumping.getEndReading()).milage(BigDecimal.valueOf(pumping.getMilage()))
        .milagePer100Unit(BigDecimal.valueOf(pumping.getMilagePer100Unit()))
        .petrolPricePerLiter(BigDecimal.valueOf(pumping.getPetrolPricePerLiter()))
        .petrolPumpedInLitres(BigDecimal.valueOf(pumping.getPetrolPumpedInLitres()))
        .build();
  }

  public static Pumping toPumpings(PumpingsDto pumping) {
    return Pumping.builder().billPaid(pumping.getBillPaid().doubleValue()).pumpDate(pumping.getPumpDate())
        .distance(pumping.getDistance().doubleValue())
        .startReading(pumping.getStartReading().doubleValue())
        .endReading(pumping.getEndReading().doubleValue()).milage(pumping.getMilage().doubleValue())
        .milagePer100Unit(pumping.getMilagePer100Unit().doubleValue())
        .petrolPricePerLiter(pumping.getPetrolPricePerLiter().doubleValue())
        .petrolPumpedInLitres(pumping.getPetrolPumpedInLitres().doubleValue())
        .build();
  }
}
