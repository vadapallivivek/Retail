package com.example.retail.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.retail.model.Product;

public interface RetailRepo extends JpaRepository<Product,Long> {
	
	@Query(value="FROM Product where name = ?1")
	public Product findProductByName(String prodname);

	@Query(value="FROM Product where type = ?1")
	public List<Product> findProductByType(String type);
	
	@Query(value="FROM Product where category = ?1")
	public List<Product> findProductByCategory(String category);
	
	@Query(value="FROM Product where price between ?1 AND ?2")
	public List<Product>FindProdByPrice(Long min , Long max);
}
