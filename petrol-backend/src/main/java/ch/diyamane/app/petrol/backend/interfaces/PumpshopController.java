package ch.diyamane.app.petrol.backend.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import ch.diyamane.app.petrol.backend.api.PumpShopApi;
import ch.diyamane.app.petrol.backend.dto.shop.PumpShopDto;
import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PumpshopController implements PumpShopApi {

	@Autowired
	PumpShopRepository _pumpShopRepository;

	@Override
	public ResponseEntity<PumpShopDto> addPumpshop(PumpShopDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PumpShopDto> updatePumpshop(PumpShopDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PumpShopDto> getPumpshop(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<PumpShopDto>> getPumpshops() {
		// TODO Auto-generated method stub
		return null;
	}

}
