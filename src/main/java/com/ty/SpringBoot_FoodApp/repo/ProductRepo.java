package com.ty.SpringBoot_FoodApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBoot_FoodApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.pname=?1")
	public Optional<Product> getproductbyname(String pname);

}
