package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.api.PumpShopsApi;
import ch.diyamane.app.petrol.backend.domain.model.shop.PumpShop;
import ch.diyamane.app.petrol.backend.dto.PumpShopDto;
import ch.diyamane.app.petrol.backend.mapper.PumpShopMapper;
import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import ch.diyamane.app.petrol.backend.service.PumShopService;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class PumpshopController implements PumpShopsApi {

	PumShopService pumShopService;

	@Override
	public ResponseEntity<PumpShopDto> addPumpshop(PumpShopDto dto) {
		return new ResponseEntity<>(pumShopService.save(dto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PumpShopDto> updatePumpshop(PumpShopDto dto) {
		return new ResponseEntity<>(pumShopService.update(dto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PumpShopDto> getPumpshop(Long id) {
		return new ResponseEntity<>(pumShopService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<PumpShopDto>> getPumpshops() {
		return new ResponseEntity<>(pumShopService.findAll(), HttpStatus.OK);
	}

}
