package ch.diyamane.app.petrol.backend.service;

import ch.diyamane.app.petrol.backend.domain.model.shop.Pumping;
import ch.diyamane.app.petrol.backend.dto.PumpingsDto;
import ch.diyamane.app.petrol.backend.mapper.PumpingsMapper;
import ch.diyamane.app.petrol.backend.repository.shop.PumpingRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PumpingsService {

  PumpingRepository pumpingRepository;

  public List<PumpingsDto> getAllPumpings() {
    return PumpingsMapper.toDto(pumpingRepository.findAll());
  }

  public List<PumpingsDto>  getPumping(Long id) {
    return PumpingsMapper.toDto(pumpingRepository.findByPumpShop(id));
  }

  public Pumping save(PumpingsDto pump) {
    return pumpingRepository.save(PumpingsMapper.toPumpings(pump));
  }
}
