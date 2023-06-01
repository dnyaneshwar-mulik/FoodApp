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
import com.ty.SpringBoot_FoodApp.dto.FoodOrder;
import com.ty.SpringBoot_FoodApp.service.FoodOrderService;

@RestController
public class FoodOrderController {
	
	@Autowired
	private FoodOrderService service;
	
	@PostMapping("/savefoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}
	
	@PutMapping("/updatefoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder, @RequestParam int fid ) {
		return service.updateFoodOrder(foodOrder, fid);
	}

	@DeleteMapping("/deletefoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int fid) {
		return service.deleteFoodOrder(fid);
	}
	
	@GetMapping("/getbyidfoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> getbyiFoodOrder0(@RequestParam int fid) {
		return service.getbyidFoodOrder(fid);
	}
	
	@GetMapping("/getfoodorderbyname")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderByName(@RequestParam String fname) {
		return service.getFoodOrderByName(fname);
	}
	
	@GetMapping("/getallfoodorders")
	public ResponseEntity<ResponseStructure<FoodOrder>> getallFoodOrders() {
		return service.getallfooFoodOrders();
	}
	
}
