package com.ty.SpringBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBoot_FoodApp.dto.Items;
import com.ty.SpringBoot_FoodApp.repo.ItemsRepo;

@Repository
public class ItemsDao {

	@Autowired
	private ItemsRepo repo;

	public Items saveItems(Items items) {
		return repo.save(items);
	}

	public Items updateItems(Items items, int itemid) {
		Optional<Items> items2 = repo.findById(itemid);
		if (items2.isEmpty()) {
			items.setItemid(itemid);
			repo.save(items);
			return items2.get();
		} else {
			return null;
		}
	}

	public Items deleteItems(int itemid) {
		Optional<Items> items = repo.findById(itemid);
		if (items.isPresent()) {
			repo.deleteById(itemid);
			return items.get();
		} else {
			return null;
		}
	}

	public Items getbyidItems(int itemid) {
		Optional<Items> items = repo.findById(itemid);
		if (items.isPresent()) {
			return items.get();
		} else {
			return null;
		}
	}

	public Items getItemByName(String itemname) {
		Optional<Items> item = repo.getItemsByName(itemname);
		if (item.isPresent()) {
			return item.get();
		} else {
			return null;
		}
	}

	public List<Items> getallItems() {
		List<Items> items = repo.findAll();
		return items;
	}

}
