package mum.edu.mscs.swe.pms.service;

import java.util.List;

import mum.edu.mscs.swe.pms.model.Vehicle;



public interface VehicleService {
	public List<Vehicle> findAll();
	public Vehicle save(Vehicle vehicle);
	public Vehicle findById(Long vehicleId);
	public boolean delete(Long vehicleId);

}
