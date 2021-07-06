/**
 * 
 */
package ch.diyamane.app.petrol.backend.application.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import ch.diyamane.app.petrol.backend.application.service.PetrolStartUpService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author rampoore
 *
 */
@Slf4j
@Transactional
@Service
public class PetrolStartUpListener {

	@Autowired
	private PetrolStartUpService _pStartUpService;

	@EventListener
	public void contextInitialized(ContextRefreshedEvent event) {

		//_pStartUpService.initSchema();

		log.info("Petrol Schema initialized");

	}

}
