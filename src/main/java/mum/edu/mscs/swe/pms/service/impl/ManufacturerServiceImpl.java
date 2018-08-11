package mum.edu.mscs.swe.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.mscs.swe.pms.model.Manufacturer;
import mum.edu.mscs.swe.pms.service.ManufacturerService;
import mum.edu.mscs.swe.pms.service.repository.ManufacturerRepository;


@Service
public class ManufacturerServiceImpl implements ManufacturerService{

	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	@Override
	public List<Manufacturer> findAll() {
		// TODO Auto-generated method stub
		return manufacturerRepository.findAll();
	}

	@Override
	public Manufacturer save(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		return manufacturerRepository.save(manufacturer);
	}

	@Override
	public Manufacturer findById(Long manufacturerId) {
		// TODO Auto-generated method stub
		return manufacturerRepository.findById(manufacturerId).orElse(null);
	}

	@Override
	public boolean delete(Long manufacturerId) {
		// TODO Auto-generated method stub
		manufacturerRepository.deleteById(manufacturerId);
		return true;
	}

	
}
