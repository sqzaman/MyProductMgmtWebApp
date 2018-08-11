package mum.edu.mscs.swe.pms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.Id;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manufacturer_id")
	Long manufacturerId;
	@NotBlank
	String name;
	@NotBlank
	String plantAddress;
	
	@OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	public Manufacturer() {
		super();
	}

	public Manufacturer(String name, String plantAddress) {
		super();
		this.name = name;
		this.plantAddress = plantAddress;
	}


	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlantAddress() {
		return plantAddress;
	}

	public void setPlantAddress(String plantAddress) {
		this.plantAddress = plantAddress;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	
}
