package ch.diyamane.app.petrol.backend.domain.model.shop;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.common.collect.Sets;

import ch.diyamane.app.petrol.backend.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "PUMP_SHOP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PumpShop extends BaseEntity<PumpShop> {

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "ADDRESS1", nullable = false)
	private String address1;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "ZIP_CODE", nullable = false, length = 10)
	private String zipCode;

	@Column(name = "CITY", nullable = false, length = 35)
	private String city;

	@Column(name = "COUNTRY", nullable = false, length = 35)
	private String country;

	@OneToMany(mappedBy = "pumpShop", cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private Set<Pumping> pumpings = Sets.newConcurrentHashSet();
	
	
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

	public void addPumping(Pumping pumping) {
		getPumpings().add(pumping);
		pumping.setPumpShop(this);
	}

	@Override
	public String toString() {
		return "PumpShop [id=" + getId() + ", name=" + name + ", description=" + description + ", address1=" + address1
				+ ", address2=" + address2 + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
