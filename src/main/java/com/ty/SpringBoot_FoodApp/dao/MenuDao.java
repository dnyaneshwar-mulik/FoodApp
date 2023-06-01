package com.ty.SpringBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBoot_FoodApp.dto.Menu;
import com.ty.SpringBoot_FoodApp.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	private MenuRepo repo;

	public Menu saveMenu(Menu menu) {
		return repo.save(menu);
	}

	public Menu updateMenu(Menu menu, int mid) {
		Optional<Menu> menu2 = repo.findById(mid);
		if (menu2.isPresent()) {
			menu.setMid(mid);
			repo.save(menu);
			return menu2.get();
		} else {
			return null;
		}
	}

	public Menu deleteMenu(int mid) {
		Optional<Menu> menu = repo.findById(mid);
		if (menu.isPresent()) {
			repo.deleteById(mid);
			return menu.get();
		} else {
			return null;
		}
	}
	
	public Menu getbymidMenu(int mid) {
		Optional<Menu> menu = repo.findById(mid);
		if (menu.isPresent()) {
			return menu.get();
		}else {
			return null;
		}
	}
	
	public Menu getMenuByname(String mname) {
		Optional<Menu> menu = repo.getMenuByMenuname(mname);
		if (menu.isPresent()) {
			return menu.get();
		} else {
			return null;
		}
	}

	public List<Menu> getallMenus() {
		List<Menu> menus = repo.findAll();
		return menus;
	}
}