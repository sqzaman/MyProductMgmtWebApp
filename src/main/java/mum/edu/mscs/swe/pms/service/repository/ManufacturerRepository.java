package mum.edu.mscs.swe.pms.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.mscs.swe.pms.model.Manufacturer;



public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}
