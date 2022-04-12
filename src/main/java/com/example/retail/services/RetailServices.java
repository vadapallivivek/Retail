package com.example.retail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retail.model.Product;
import com.example.retail.repo.RetailRepo;

@Service
public class RetailServices  {
	
	@Autowired
	RetailRepo retailRepo;
	
	public List<Product> findAllProduct(){
		return retailRepo.findAll();
	}
	
	public Product findprodbyname(String prodname){
		return  retailRepo.findProductByName(prodname);
	}
	
	public List<Product> findProdByType(String type){
		return retailRepo.findProductByType(type);
	}
	
	public List<Product> findProdByCategory(String category){
		return retailRepo.findProductByCategory(category);
	}
	public List<Product> findProdByPrice(Long min , Long max){
		return retailRepo.FindProdByPrice(min,max);
	}
}
