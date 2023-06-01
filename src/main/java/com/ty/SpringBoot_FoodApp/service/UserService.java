package com.ty.SpringBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.Exception.UserIdNotFoundException;
import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.UserDao;
import com.ty.SpringBoot_FoodApp.dto.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser( User user) {
		User user2 = dao.saveUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("user successfully saved");
		responseStructure.setData(user2);
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User user2 = dao.updateUser(id, user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if(user2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user successfully updated");
			responseStructure.setData(user2);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User user = dao.deleteUser(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("user successfully deleted");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User user = dao.getuserbyid(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if(user!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("user successfully found");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			throw new UserIdNotFoundException("user id not present");
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> getUserbyname(String name) {
		User user = dao.getuserbyname(name);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if(user!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("user by name successfully found");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> getallusers(){
		List<User> user = dao.getallusers();
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("found all users");
		responseStructure.setData(user);
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
	}
}
