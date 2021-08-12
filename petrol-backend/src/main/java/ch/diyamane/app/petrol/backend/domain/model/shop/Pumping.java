package ch.diyamane.app.petrol.backend.domain.model.shop;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.diyamane.app.petrol.backend.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "PUMPING")
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
public class Pumping extends BaseEntity<Pumping> {

	@Column(name = "START_READING", nullable = false)
	private double startReading;

	@Column(name = "END_READING", nullable = false)
	private double endReading;

	@Column(name = "PUMP_DATE", nullable = false)
	private LocalDate pumpDate;

	@Column(name = "PETROL_PUMPED_IN_LITRES", nullable = false)
	private double petrolPumpedInLitres;

	@Column(name = "BILL_PAID", nullable = false)
	private double billPaid;

	@Column(name = "DISTANCE", nullable = false)
	private double distance; // Previous Pump Date.currentMiles - this pump date.currentMile

	@Column(name = "MILAGE", nullable = false)
	private double milage; // distance/petrolPumpedInLitres per Litre of Gallons.

	@Column(name = "MILLAGE")
	private double milagePer100Unit; // litres/100 KM or Miles

	@Column(name = "PETROL_PRICE_PER_LITER", nullable = false)
	private double petrolPricePerLiter;

	@ManyToOne
	@JoinColumn(name = "PUMP_SHOP_ID", foreignKey = @ForeignKey(name = "FK_PUMPING_PUMP_SHOP_1"))
	private PumpShop pumpShop;


	/**
	 * This is Previous Pumping
	 *
	 * @param currentPumping
	 */
	public void calulateMilage(final Pumping currentPumping) {
		this.endReading = currentPumping.startReading;
		this.distance = this.endReading - this.startReading;

		this.milage = BigDecimal.valueOf(this.distance / this.petrolPumpedInLitres)
				.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();

		this.milagePer100Unit = BigDecimal.valueOf((1 / milage) * 100).setScale(2, BigDecimal.ROUND_HALF_EVEN)
				.doubleValue();
	}

	@Override
	public String toString() {
		return "Pumping [id=" + getId() + ", endReading=" + endReading + ", startReading=" + startReading
				+ ", pumpDate=" + pumpDate + ", petrolPumpedInLitres=" + petrolPumpedInLitres + ", billPaid=" + billPaid
				+ ", distance=" + distance + ", milage=" + milage + ", milagePer100Unit=" + milagePer100Unit
				+ ", petrolPrice=" + petrolPricePerLiter + ", pumpShop=" + pumpShop + "]";
	}

	

}
