package mum.edu.mscs.swe.pms.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.mscs.swe.pms.model.Vehicle;



public interface VehicalRepository extends JpaRepository<Vehicle, Long> {

}
