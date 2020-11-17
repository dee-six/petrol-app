package ch.diyamane.app.petrol.backend.dto.shop;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PumpingsDto {

    @JsonProperty("startReadin")
    private double startReading;

    @JsonProperty("endReading")
    private double endReading;

    @JsonProperty("pumpDate")
    private LocalDate pumpDate;

    @JsonProperty("petrolPumpedInLitres")
    private double petrolPumpedInLitres;

    @JsonProperty("billPaid")
    private double billPaid;

    @JsonProperty("distance")
    private double distance; // Previous Pump Date.currentMiles - this pump
			     // date.currentMile

    @JsonProperty("milage")
    private double milage; // distance/petrolPumpedInLitres per Litre of
			   // Gallons.

    @JsonProperty("milagePer100Unit")
    private double milagePer100Unit; // litres/100 KM or Miles

    @JsonProperty("milapetrolPricePerLiterge")
    private double petrolPricePerLiter;

    @JsonProperty("pumpShop")
    private PumpShopDto pumpShop;
}
