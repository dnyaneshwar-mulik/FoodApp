package com.ty.SpringBoot_FoodApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name should not be null")
	@NotBlank(message = "name should not be blank")
	private String name;
	@NotNull(message = "address should not be null")
	private String address;
	@Min(value = 600000001)
	@Max(value = 999999991)
	private long phone;
	@NotNull(message = "email should not be null")
	@Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "invalid email")
	private String email;
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$", message = "password should met the conditopns")
	private String password;
	@NotNull(message = "role should not be null")
	@NotBlank(message = "role should not be blank")
	private String role;

}
