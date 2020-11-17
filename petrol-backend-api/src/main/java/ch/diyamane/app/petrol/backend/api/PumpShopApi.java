package ch.diyamane.app.petrol.backend.api;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.diyamane.app.petrol.backend.dto.shop.PumpShopDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Pumpshops", tags = "PumpShops")
@RequestMapping(value = "/petrol/pumpshop")
@Controller
public interface PumpShopApi {

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "", notes = "Add a Pumpshop", response = PumpShopDto.class, httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = PumpShopDto.class) })
	ResponseEntity<PumpShopDto> addPumpshop(
			@NotNull @ApiParam(value = "Pumpshop to be created", required = true, type = "PumpShopDto") @RequestBody PumpShopDto dto);

	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "", notes = "Update a Pumpshop", response = PumpShopDto.class, httpMethod = "PUT")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = PumpShopDto.class) })
	ResponseEntity<PumpShopDto> updatePumpshop(
			@NotNull @ApiParam(value = "Pumpshop to be updated", required = true, type = "PumpShopDto") @RequestBody PumpShopDto dto);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Get  Pumpshop Details", response = PumpShopDto.class, httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = PumpShopDto.class) })
	ResponseEntity<PumpShopDto> getPumpshop(
			@NotNull @ApiParam(value = "PumpShop PK", required = true) @PathVariable Long id);
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Get a list of Pumpshot", response = PumpShopDto.class, httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = PumpShopDto.class) })
	ResponseEntity<List<PumpShopDto>> getPumpshops();

}
