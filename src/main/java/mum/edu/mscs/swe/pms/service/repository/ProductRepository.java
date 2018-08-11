package mum.edu.mscs.swe.pms.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.mscs.swe.pms.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	public Product findByProductNumber(Long productNumber);
}
