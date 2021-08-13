/**
 * 
 */
package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.service.PumpingsService;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import ch.diyamane.app.petrol.backend.api.PumpingsApi;
import ch.diyamane.app.petrol.backend.dto.PumpingsDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author meetd
 *
 */
@Controller
@AllArgsConstructor
@Slf4j
public class PumpingsController implements PumpingsApi {

	PumpingsService pumpingsService;

	@Override
	public ResponseEntity<List<PumpingsDto>> getAllPumpings() {
		return new ResponseEntity<>(pumpingsService.getAllPumpings(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<PumpingsDto>> getPumping(Long id) {
		return new ResponseEntity<>(pumpingsService.getPumping(id), HttpStatus.OK);
	}
}
