package ch.diyamane.app.petrol.backend.dto.shop;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PumpShopDto {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("zipCode")
    private double zipCode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("pumpings")
    private Set<PumpingsDto> pumpings;
}
