package mum.edu.mscs.swe.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.mscs.swe.pms.model.Product;
import mum.edu.mscs.swe.pms.service.ProductService;
import mum.edu.mscs.swe.pms.service.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product findById(Long productNumber) {
		// TODO Auto-generated method stub
		return productRepository.findById(productNumber).orElse(null);
	}

	@Override
	public boolean delete(Long productId) {
		// TODO Auto-generated method stub
		return false;
	}

}
