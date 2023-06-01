package com.ty.SpringBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.MenuDao;
import com.ty.SpringBoot_FoodApp.dto.Menu;

@Service
public class MenuService {

	@Autowired
	private MenuDao menudao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		Menu menu2 = menudao.saveMenu(menu);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("menu saved");
		responseStructure.setData(menu2);
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu, int mid) {
		Menu menu2 = menudao.updateMenu(menu, mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("menu updated");
			responseStructure.setData(menu2);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int mid) {
		Menu menu = menudao.deleteMenu(mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("menu updated");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}

	}

	public ResponseEntity<ResponseStructure<Menu>> getbyidMenu(int mid) {
		Menu menu = menudao.getbymidMenu(mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("menu found by id");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuByName(String mname) {
		Menu menu = menudao.getMenuByname(mname);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("menu found by name");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getallMenus() {
		List<Menu> list = menudao.getallMenus();
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("all menus found");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
	}

}
