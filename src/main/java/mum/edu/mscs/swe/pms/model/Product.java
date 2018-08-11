package mum.edu.mscs.swe.pms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = { "product_number" }) })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long pid;
	
	@NotNull(message = "*Product number can't be empty!")
	@Column(name = "product_number")
	Long productNumber;
	@NotBlank(message = "*Product name can't be empty!")
	String name;
	String description;
	@NotNull(message = "*Product price can't be empty!")
	Double unitPrice;
	@NotNull(message = "*Manufacturing date can't be empty!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate dateMfd;
	
	public Product() {
		
	}
	
	public Product(Long productNumber, String name, String description, Double unitPrice, LocalDate dateMfd) {
		super();

		this.productNumber = productNumber;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.dateMfd = dateMfd;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public LocalDate getDateMfd() {
		return dateMfd;
	}
	public void setDateMfd(LocalDate dateMfd) {
		this.dateMfd = dateMfd;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productNumber=" + productNumber + ", name=" + name + ", unitPrice="
				+ unitPrice + ", dateMfd=" + dateMfd + "]";
	}
	
	
}
