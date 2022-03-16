package ch.diyamane.app.petrol.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.diyamane.app.petrol.backend.domain.model.shop.PumpShop;
import ch.diyamane.app.petrol.backend.dto.PumpShopDto;
import ch.diyamane.app.petrol.backend.mapper.PumpShopMapper;
import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PumpShopService {

  PumpShopRepository pumpShopRepository;

  public PumpShopDto save(PumpShopDto dto) {
    return PumpShopMapper.toDto(pumpShopRepository.save(PumpShopMapper.toPumpShop(dto)));
  }

  public PumpShopDto update(PumpShopDto dto) {
    return PumpShopMapper.toDto(pumpShopRepository.save(PumpShopMapper.toPumpShop(dto)));
  }

  public PumpShopDto findById(Long id) {
    Optional<PumpShop> what = pumpShopRepository.findById(id);
    return what.map(PumpShopMapper::toDto).orElse(null);
  }

  public List<PumpShopDto> findAll() {
    return PumpShopMapper.toDto(pumpShopRepository.findAll());
  }

}
