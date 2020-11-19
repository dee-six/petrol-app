package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.api.PumpShopsApi;
import ch.diyamane.app.petrol.backend.dto.PumpShopDto;
import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class PumpshopController implements PumpShopsApi {

	PumpShopRepository pumpShopRepository;

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
