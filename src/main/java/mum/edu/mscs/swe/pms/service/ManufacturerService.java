package mum.edu.mscs.swe.pms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mum.edu.mscs.swe.pms.model.Manufacturer;
import mum.edu.mscs.swe.pms.model.Product;



public interface ManufacturerService {
	public List<Manufacturer> findAll();
	public Manufacturer save(Manufacturer manufacturer);
	public Manufacturer findById(Long manufacturerId);
	public boolean delete(Long manufacturerId);

}
