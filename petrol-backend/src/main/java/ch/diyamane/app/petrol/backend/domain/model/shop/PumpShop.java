package ch.diyamane.app.petrol.backend.domain.model.shop;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ch.diyamane.app.petrol.backend.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PUMP_SHOP")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PumpShop extends BaseEntity<PumpShop> {

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "ADDRESS1", nullable = false)
	private String address1;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "ZIP_CODE")
	private double zipCode;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTRY")
	private String country;

	@OneToMany(mappedBy = "pumpShop")
	@Builder.Default
	private Set<Pumping> pumpings = new LinkedHashSet<Pumping>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPumpings(@NotNull Set<Pumping> pumpings) {
		getPumpings().addAll(pumpings);
	}

	public Set<Pumping> getPumpings() {
		return pumpings;
	}

	public PumpShop(String name, String description, String address1, String address2, double zipCode, String city,
			String country) {
		super();
		this.name = name;
		this.description = description;
		this.address1 = address1;
		this.address2 = address2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public void addPumping(Pumping pumping) {
		getPumpings().add(pumping);
	}

	@Override
	public String toString() {
		return "PumpShop [id=" + getId() + ", name=" + name + ", description=" + description + ", address1=" + address1
				+ ", address2=" + address2 + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country + "]";
	}
}
