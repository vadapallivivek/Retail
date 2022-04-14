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
	
	@Query(value="FROM Product where userId = ?1 ")
	public List<Product> getProdByuser(Long id);
	
	@Query(value="UPDATE Product pr set name = ?3 type=?4 category = ?5 price= ?6  WHERE userId=?2 AND Pid= ?1")
	public Product updateProd(Long pid, Long uid, String name, String type, String category, Long price);
	
	@Query(value="DELETE FROM Product  WHERE userId=?2 AND Pid=?1")
	public void deleteRecord(Long pid , Long uid);
}
