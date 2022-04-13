package com.example.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.retail.model.Product;
import com.example.retail.services.RetailServices;

@RestController
public class MyController {
	
	@Autowired
	RetailServices retailServices;
		
	@GetMapping("/product/name/{prodname}")
	public Product getproductByName(@PathVariable(value="prodname") String prodname){
		return retailServices.findprodbyname(prodname);
		
	}
	@GetMapping("/product/type/{type}")
	public List<Product> getProdByType(@PathVariable(value="type") String type){
		return retailServices.findProdByType(type);
	}
	
	@GetMapping("/product/category/{category}")
	public List<Product> getProdByCategory(@PathVariable(value="category") String category){
		return retailServices.findProdByCategory(category);
	}
	
	@GetMapping("product/price")
	public List<Product> getProdByPrice(@RequestParam(value="min")Long min, @RequestParam(value="max") Long max){
		return retailServices.findProdByPrice(min,max);
	}
}
