package com.ty.SpringBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBoot_FoodApp.dto.Product;
import com.ty.SpringBoot_FoodApp.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo repo;

	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	public Product updateProduct(Product product, int pid) {
		Optional<Product> product2 = repo.findById(pid);
		if (product2.isPresent()) {
			product.setPid(pid);
			repo.save(product);
			return product2.get();
		} else {
			return null;
		}
	}

	public Product deleteProduct(int pid) {
		Optional<Product> product = repo.findById(pid);
		if (product.isPresent()) {
			repo.deleteById(pid);
			return product.get();
		} else {
			return null;
		}
	}

	public Product getbyid(int pid) {
		Optional<Product> product = repo.findById(pid);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}
	
	public Product getbyname(String pname) {
		Optional<Product> product = repo.getproductbyname(pname);
		if (product.isEmpty()) {
			return product.get();
		} else {
			return null;
		}
	}

	public List<Product> getallproducts() {
		List<Product> product = repo.findAll();
		return product;
	}

}
