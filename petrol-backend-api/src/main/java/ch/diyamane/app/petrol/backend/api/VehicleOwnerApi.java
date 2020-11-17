/**
 * 
 */
package ch.diyamane.app.petrol.backend.api;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.diyamane.app.petrol.backend.dto.owner.VehicleOwnerDto;
import ch.diyamane.app.petrol.backend.dto.owner.VehicleStatusDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author meetd
 *
 */

@Api(value = "VehicleOwners", tags = "VehicleOwner")
@RequestMapping(value = "/petrol/vehicleowner/*")
@Controller
public interface VehicleOwnerApi {
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "", notes = "Create a new Vehicle Owner", response = VehicleOwnerDto.class, httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful response", response = VehicleOwnerDto.class) })
	ResponseEntity<VehicleOwnerDto> addVehicleOwner(
			@NotNull @ApiParam(value = "Vehicle to be created", required = true, type = "VehicleOwnerDto") @RequestBody VehicleOwnerDto dto);

	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "", notes = "Update  a new Vehicle Owner", response = VehicleOwnerDto.class, httpMethod = "PUT")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful response", response = VehicleOwnerDto.class) })
	ResponseEntity<VehicleOwnerDto> updateOwner(
			@NotNull @ApiParam(value = "Vehicle to be updated", required = true, type = "VehicleOwnerDto") @RequestBody VehicleOwnerDto dto);

	
	@RequestMapping(value = "owner/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Get  a new Vehicle Owner", response = VehicleOwnerDto.class, httpMethod = "GET")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful response", response = VehicleOwnerDto.class) })
	ResponseEntity<VehicleOwnerDto> getOwner(
			@NotNull @ApiParam(value = "VehicleOwner PK", required = true) @PathVariable Long id);

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Gets `VehicleOwnerDto` objects. Optional query param of **size** determines size of returned array ", response = VehicleOwnerDto.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful response", response = VehicleOwnerDto.class) })
	ResponseEntity<List<VehicleOwnerDto>> findAllByStatus(
			@NotNull @ApiParam(value = "Status of the VehicleOwner", required = true) @RequestParam(value = "status", required = true) VehicleStatusDto status);
	
}
