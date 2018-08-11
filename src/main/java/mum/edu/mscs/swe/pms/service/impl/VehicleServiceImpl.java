package mum.edu.mscs.swe.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mum.edu.mscs.swe.pms.model.Vehicle;
import mum.edu.mscs.swe.pms.service.VehicleService;
import mum.edu.mscs.swe.pms.service.repository.VehicalRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicalRepository vehicleRepository;
	
	@Override
	public List<Vehicle> findAll() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle findById(Long vehicleId) {
		// TODO Auto-generated method stub
		return vehicleRepository.findById(vehicleId).orElse(null);
	}

	@Override
	public boolean delete(Long productId) {
		// TODO Auto-generated method stub
		return false;
	}

}
