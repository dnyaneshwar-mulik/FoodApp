package com.ty.SpringBoot_FoodApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBoot_FoodApp.dto.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer>{

	@Query("Select i from Items i where i.itemname=?1")
	public Optional<Items> getItemsByName(String itemname);

}
