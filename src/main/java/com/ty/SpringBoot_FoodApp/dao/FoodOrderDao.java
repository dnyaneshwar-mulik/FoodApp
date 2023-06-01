package com.ty.SpringBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBoot_FoodApp.dto.FoodOrder;
import com.ty.SpringBoot_FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {
	
	@Autowired
	private FoodOrderRepo repo;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repo.save(foodOrder);
	}

	public FoodOrder updateFoodOrder(FoodOrder foodOrder, int fid) {
		Optional<FoodOrder> foodOptional = repo.findById(fid);
		if (foodOptional.isPresent()) {
			foodOrder.setFid(fid);
			foodOrder.setItems(foodOrder.getItems());
			repo.save(foodOrder);
			return foodOptional.get();
		} else {
			return null;
		}
	}

	public FoodOrder deleteFoodOrder(int fid) {
		Optional<FoodOrder> foodOptional = repo.findById(fid);
		if (foodOptional.isPresent()) {
			repo.deleteById(fid);
			return foodOptional.get();
		} else {
			return null;
		}
	}
	
	public FoodOrder getbyfidFoodOrder(int fid) {
		Optional<FoodOrder> foodOptional = repo.findById(fid);
		if (foodOptional.isPresent()) {
			return foodOptional.get();
		}else {
			return null;
		}
	}

	public FoodOrder getFoodOrderByName(String fname) {
		Optional<FoodOrder> foodOrder=repo.getFoodOrderByName(fname);
		if(foodOrder.isPresent()) {
			return foodOrder.get();
		}else {
			return null;
		}
	}
	
	public List<FoodOrder> getallFoodOrders() {
		List<FoodOrder> foodOrders = repo.findAll();
		return foodOrders;
	}

}
