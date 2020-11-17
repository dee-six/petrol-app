package ch.diyamane.app.petrol.backend.api;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.diyamane.app.petrol.backend.dto.shop.PumpingsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Pumpings", tags = "Pumpings")
@RequestMapping(value = "/petrol/pumping")
@Controller
public interface PumpingsApi {

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "Add a Pumpshop", response = PumpingsDto.class, httpMethod = "POST")
    @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful response", response = PumpingsDto.class) })
    ResponseEntity<PumpingsDto> addPumping(
	    @NotNull @ApiParam(value = "Pumpshop to be created", required = true, type = "PumpingsDto") @RequestBody PumpingsDto dto);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "", notes = "Update a Pumpshop", response = PumpingsDto.class, httpMethod = "PUT")
    @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful response", response = PumpingsDto.class) })
    ResponseEntity<PumpingsDto> updatePumping(
	    @NotNull @ApiParam(value = "Pumpshop to be updated", required = true, type = "PumpingsDto") @RequestBody PumpingsDto dto);

    @RequestMapping(value = "/pumpshop/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Get  Pumpshop Details", response = PumpingsDto.class, httpMethod = "GET")
    @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful response", response = PumpingsDto.class) })
    ResponseEntity<PumpingsDto> getPumping(
	    @NotNull @ApiParam(value = "PumpShop PK", required = true) @PathVariable Long id);

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Get a list of Pumpshot", response = PumpingsDto.class, httpMethod = "GET")
    @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful response", response = PumpingsDto.class) })
    ResponseEntity<List<PumpingsDto>> getPumpings();
}
