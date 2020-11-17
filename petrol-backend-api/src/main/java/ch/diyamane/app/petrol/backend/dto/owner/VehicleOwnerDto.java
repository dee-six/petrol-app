package ch.diyamane.app.petrol.backend.dto.owner;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class VehicleOwnerDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("pinCode")
    private String pinCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("status")
    private VehicleOwnerStatusDto status;

    @JsonProperty("ownedVehicles")
    List<VehicleDto> ownedVehicles;
    
    public void addVehicle(VehicleDto dt) {
	ownedVehicles.add(dt);
    }
}
