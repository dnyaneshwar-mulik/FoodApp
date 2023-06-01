package com.ty.SpringBoot_FoodApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBoot_FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer>{
	
	@Query("select m from Menu m where m.mname=?1")
	public Optional<Menu> getMenuByMenuname(String mname);

}
