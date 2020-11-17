/**
 * 
 */
package ch.diyamane.app.petrol.backend.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import ch.diyamane.app.petrol.backend.api.PumpingsApi;
import ch.diyamane.app.petrol.backend.dto.shop.PumpingsDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author meetd
 *
 */
@Controller
@Slf4j
public class PumpingsController implements PumpingsApi {

	/* (non-Javadoc)
	 * @see ch.diyamane.app.petrol.backend.api.PumpingsApi#addPumping(ch.diyamane.app.petrol.backend.dto.shop.PumpingsDto)
	 */
	@Override
	public ResponseEntity<PumpingsDto> addPumping(PumpingsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ch.diyamane.app.petrol.backend.api.PumpingsApi#updatePumping(ch.diyamane.app.petrol.backend.dto.shop.PumpingsDto)
	 */
	@Override
	public ResponseEntity<PumpingsDto> updatePumping(PumpingsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ch.diyamane.app.petrol.backend.api.PumpingsApi#getPumping(java.lang.Long)
	 */
	@Override
	public ResponseEntity<PumpingsDto> getPumping(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ch.diyamane.app.petrol.backend.api.PumpingsApi#getPumpings()
	 */
	@Override
	public ResponseEntity<List<PumpingsDto>> getPumpings() {
		// TODO Auto-generated method stub
		return null;
	}

}
