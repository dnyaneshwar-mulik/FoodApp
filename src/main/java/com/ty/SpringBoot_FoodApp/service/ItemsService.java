package com.ty.SpringBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.ItemsDao;
import com.ty.SpringBoot_FoodApp.dto.Items;

@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("item saved");
		responseStructure.setData(dao.saveItems(items));
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items, int itemid) {
		Items items2 = dao.updateItems(items, itemid);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("item updated");
			responseStructure.setData(items2);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		} else {
			return null;

		}
	}

	public ResponseEntity<ResponseStructure<Items>> deleteItems(int itemid) {
		Items items = dao.deleteItems(itemid);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("item deleted");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;

		}
	}

	public ResponseEntity<ResponseStructure<Items>> getbyidItems(int itemid) {
		Items items = dao.getbyidItems(itemid);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("get item by id ");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;

		}
	}

	public ResponseEntity<ResponseStructure<Items>> getItemByName(String itemname) {
		Items items = dao.getItemByName(itemname);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("get item by name ");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Items>> getbyallItems() {
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("all itmes fetched ");
		responseStructure.setData(dao.getallItems());
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.FOUND);
	}

}
