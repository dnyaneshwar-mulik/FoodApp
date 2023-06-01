package com.ty.SpringBoot_FoodApp.Exception;

public class UserIdNotFoundException extends RuntimeException {
	
	private String message="user id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public UserIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
