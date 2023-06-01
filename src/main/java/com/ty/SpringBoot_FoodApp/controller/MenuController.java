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
import com.ty.SpringBoot_FoodApp.dto.Menu;
import com.ty.SpringBoot_FoodApp.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService service;

	@PostMapping("/savemenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}

	@PutMapping("/updatemenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu, @RequestParam int mid) {
		return service.updateMenu(menu, mid);
	}

	@DeleteMapping("/deletemenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int mid) {
		return service.deleteMenu(mid);
	}

	@GetMapping("/getmenubyid")
	public ResponseEntity<ResponseStructure<Menu>> getbyidMenu(@RequestParam int mid) {
		return service.getbyidMenu(mid);
	}

	@GetMapping("/getmenubyname")
	public ResponseEntity<ResponseStructure<Menu>> getMenuByName(@RequestParam String mname) {
		return service.getMenuByName(mname);
	}

	@GetMapping("/getallmenus")
	public ResponseEntity<ResponseStructure<Menu>> getallMenus() {
		return service.getallMenus();
	}

}
