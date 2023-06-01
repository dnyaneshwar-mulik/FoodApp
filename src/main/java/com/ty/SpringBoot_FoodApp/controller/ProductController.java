package com.ty.SpringBoot_FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dto.Product;
import com.ty.SpringBoot_FoodApp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/saveproduct")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product, @RequestParam int pid) {
		return service.updateProduct(product, pid);
	}

	@DeleteMapping("/deleteproduct")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int pid) {
		return service.deleteProduct(pid);
	}

	@GetMapping("/getbyid")
	public ResponseEntity<ResponseStructure<Product>> getbyid(@RequestParam int pid) {
		return service.getbyid(pid);
	}
	
	@GetMapping("/getbyname")
	public ResponseEntity<ResponseStructure<Product>> getbyname(@RequestParam String pname) {
		return service.getbyname(pname);
	}

	@GetMapping("/getallproducts")
	public ResponseEntity<ResponseStructure<Product>> getallProducts() {
		return service.getallproducts();
	}

}
