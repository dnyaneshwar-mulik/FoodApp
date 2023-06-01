package com.ty.SpringBoot_FoodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dto.User;
import com.ty.SpringBoot_FoodApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value = "save user", notes = "API is used to save user for given user id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "successfully saved"), @ApiResponse(code = 400, message = "id not found")})	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}

	@ApiOperation(value = "update user", notes = "api is used to update given user id")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "successfully updated"), @ApiResponse(code = 404, message = "id not found for given user id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @RequestParam int id, @RequestBody User user) {
		return service.updateUser(id, user);
	}
	
	@ApiOperation(value = "delete user", notes = "api is used to delete given user id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "successfully deleted"), @ApiResponse(code = 404, message = "id not found for given user id") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> Userdelete(@Valid @RequestParam int id) {
		return service.deleteUser(id);
	}

	@ApiOperation(value = "get user by id", notes = "api is used to get user by id")
	@ApiResponses(value = {@ApiResponse(code = 302, message = "successfully fetched"), @ApiResponse(code = 404, message = "id not found for given user id") })
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@Valid @PathVariable int id) {
		return service.getUserById(id);
	}
	
	@GetMapping("/getuserbyname")
	public ResponseEntity<ResponseStructure<User>> getUserByName(@Valid @RequestParam String name) {
		return service.getUserbyname(name);
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<ResponseStructure<User>> getallUsers() {
		return service.getallusers();
	}
}
