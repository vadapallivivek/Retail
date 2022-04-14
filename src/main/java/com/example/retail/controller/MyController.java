package com.example.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.retail.model.Product;
import com.example.retail.services.RetailServices;


@RestController
public class MyController {

	@Autowired
	RetailServices retailServices;

	@GetMapping("/product/name/{prodname}")
	public Product getproductByName(@PathVariable(value = "prodname") String prodname) {
		return retailServices.findprodbyname(prodname);

	}

	@GetMapping("/product/type/{type}")
	public List<Product> getProdByType(@PathVariable(value = "type") String type) {
		return retailServices.findProdByType(type);
	}

	@GetMapping("/product/category/{category}")
	public List<Product> getProdByCategory(@PathVariable(value = "category") String category) {
		return retailServices.findProdByCategory(category);
	}

	@GetMapping("product/price")
	public List<Product> getProdByPrice(@RequestParam(value = "min") Long min, @RequestParam(value = "max") Long max) {
		return retailServices.findProdByPrice(min, max);
	}

	@PostMapping("/addproduct")
	public List<Product> addParam(@RequestBody List<Product> param) {
		for (Product record : param) {
			retailServices.addProduct(record);
		}
		return null;
	}
	
	@GetMapping("/getproduct/user/{id}")
	public List<Product> getProductByUser(@PathVariable(value="id") Long id){
		return retailServices.getProdByuser(id);
	}

	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product param) {
		
		Long pid =param.getPid();
		Long uid = param.getUserId();
		String name =param.getName();
		String type = param.getType();
		String category=param.getCategory();
		Long price=param.getPrice();
		
		return retailServices.updateProd(pid,uid,name,type,category,price);
		
	}

	@DeleteMapping("/delete/{pid}/{uid}")
	public void deleteProd(@PathVariable(value="pid") Long pid,@PathVariable(value="uid") Long uid) {
		retailServices.deleteProd(pid, uid);
	}
}
