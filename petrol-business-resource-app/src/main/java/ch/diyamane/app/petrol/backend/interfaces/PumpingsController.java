/**
 * 
 */
package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.service.PumpingsService;
import ch.diyamane.app.petrol.business.api.PumpingsApi;
import ch.diyamane.app.petrol.business.dto.PumpingsDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meetd
 *
 */
@RestController
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
