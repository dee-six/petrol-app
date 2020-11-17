package ch.diyamane.app.petrol.backend.dto.owner;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class VehicleDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("model")
    private String model;
}
