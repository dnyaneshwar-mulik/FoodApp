package com.ty.SpringBoot_FoodApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBoot_FoodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer>{

	@Query("Select f from FoodOrder f where f.fname=?1")
	public Optional<FoodOrder> getFoodOrderByName(String fname);

}
