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
import com.ty.SpringBoot_FoodApp.dto.Items;
import com.ty.SpringBoot_FoodApp.service.ItemsService;

@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService service;

	@PostMapping("/saveitems")
	public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
		return service.saveItems(items);
	}
	
	@PutMapping("/updateitems")
	public ResponseEntity<ResponseStructure<Items>> updateItems(@RequestBody Items items, @RequestParam int itemid) {
		return service.updateItems(items, itemid);
	}
	
	@DeleteMapping("/deleteitems")
	public ResponseEntity<ResponseStructure<Items>> deleteItems(@RequestParam int itemid) {
		return service.deleteItems(itemid);
	}
	
	@GetMapping("/getitemsbyid")
	public ResponseEntity<ResponseStructure<Items>> getbyidItems(@RequestParam int itemid) {
		return service.getbyidItems(itemid);
	}
	
	@GetMapping("/getitembyname")
	public ResponseEntity<ResponseStructure<Items>> getItemByName(@RequestParam String itemname) {
		return service.getItemByName(itemname);
	}
	
	@GetMapping("/getallitems")
	public ResponseEntity<ResponseStructure<Items>> getallItems() {
		return service.getbyallItems();
	}
	
}
