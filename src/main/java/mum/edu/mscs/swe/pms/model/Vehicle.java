package mum.edu.mscs.swe.pms.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;

@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicleId;
	
	@Column(name = "vehicle_vin_number")
	private int vehicleVINNumber;	
	private String brandName;
	Double retailPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate dateMfd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;
	
	

	public Vehicle() {
		super();
	}

	public Vehicle(int vehicleVINNumber, String brandName, double retailPrice, LocalDate dateMfd, Manufacturer manufacturer) {
		super();
		this.vehicleVINNumber = vehicleVINNumber;
		this.brandName = brandName;
		this.retailPrice = retailPrice;
		this.dateMfd = dateMfd;
		this.manufacturer = manufacturer;
	}


	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getVehicleVINNumber() {
		return vehicleVINNumber;
	}

	public void setVehicleVINNumber(int vehicleVINNumber) {
		this.vehicleVINNumber = vehicleVINNumber;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public LocalDate getDateMfd() {
		return dateMfd;
	}

	public void setDateMfd(LocalDate dateMfd) {
		this.dateMfd = dateMfd;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	
}
