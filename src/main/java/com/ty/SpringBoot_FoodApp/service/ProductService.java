package com.ty.SpringBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.ProductDao;
import com.ty.SpringBoot_FoodApp.dto.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Product product2 = dao.saveProduct(product);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("product saved successfully");
		responseStructure.setData(product2);
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int pid) {
		Product product2 = dao.updateProduct(product, pid);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("product updated successfully");
			responseStructure.setData(product2);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int pid) {
		Product product = dao.deleteProduct(pid);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("product deleted successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getbyid(int pid) {
		Product product = dao.getbyid(pid);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("get product by id");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getbyname(String pname) {
		Product product = dao.getbyname(pname);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("get product by name");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getallproducts() {
		List<Product> list = dao.getallproducts();
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("all products found");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
	}

}
