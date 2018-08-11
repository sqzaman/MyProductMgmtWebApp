package mum.edu.mscs.swe.pms.service;

import java.util.List;
import mum.edu.mscs.swe.pms.model.Product;



public interface ProductService {
	public List<Product> findAll();
	public Product save(Product product);
	public Product findById(Long productId);
	public boolean delete(Long productId);

}
