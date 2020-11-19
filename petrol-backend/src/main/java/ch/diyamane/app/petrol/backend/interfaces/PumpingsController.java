/**
 * 
 */
package ch.diyamane.app.petrol.backend.interfaces;

import java.util.List;

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
@Slf4j
public class PumpingsController implements PumpingsApi {

	@Override
	public ResponseEntity<List<PumpingsDto>> getPumping(Long id) {
		return null;
	}
}
