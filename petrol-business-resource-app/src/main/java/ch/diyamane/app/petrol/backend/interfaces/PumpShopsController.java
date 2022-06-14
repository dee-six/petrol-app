package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import ch.diyamane.app.petrol.backend.service.PumpShopService;
import ch.diyamane.app.petrol.business.api.PumpShopsApi;
import ch.diyamane.app.petrol.business.dto.PumpShopDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@AllArgsConstructor
public class PumpShopsController implements PumpShopsApi {

	PumpShopRepository pumpShopRepository;
	PumpShopService pumpShopService;

	@Override
	public ResponseEntity<PumpShopDto> addPumpshop(PumpShopDto dto) {
		return new ResponseEntity<>(pumpShopService.save(dto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PumpShopDto> updatePumpshop(PumpShopDto dto) {
		return new ResponseEntity<>(pumpShopService.update(dto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PumpShopDto> getPumpshop(Long id) {
		return new ResponseEntity<>(pumpShopService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<PumpShopDto>> getPumpshops() {
		return new ResponseEntity<>(pumpShopService.findAll(), HttpStatus.OK);
	}

}
