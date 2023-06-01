package com.ty.SpringBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.FoodOrderDao;
import com.ty.SpringBoot_FoodApp.dto.FoodOrder;
import com.ty.SpringBoot_FoodApp.dto.Items;

@Service
public class FoodOrderService {
	
	@Autowired
	private FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		List<Items> list = foodOrder.getItems();
		double totalprice=0;
		for (Items items : list) {
			totalprice+=items.getCost()*items.getQuantity();
			foodOrder.setTotalprice(totalprice);
		}
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("food order saved");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int fid) {
		FoodOrder foodOrder2 = dao.getbyfidFoodOrder(fid);
		if (foodOrder2 != null) {
			List<Items> list = foodOrder.getItems();
			double totalprice = 0;
			for (Items items : list) {
				totalprice += items.getCost() * items.getQuantity();
				foodOrder.setTotalprice(totalprice);
			}
			ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("food order updated");
			responseStructure.setData(dao.updateFoodOrder(foodOrder, fid));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
		
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int fid) {
		FoodOrder foodOrder = dao.deleteFoodOrder(fid);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("food order deleted");
			responseStructure.setData(dao.deleteFoodOrder(fid));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			return null;
		}
		
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getbyidFoodOrder(int fid) {
		FoodOrder foodOrder = dao.getbyfidFoodOrder(fid);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder!=null) {
			List<Items> list = foodOrder.getItems();
			double totalprice=0;
			for (Items items : list) {
				totalprice=items.getCost()*items.getQuantity();
				foodOrder.setTotalprice(totalprice);
			}
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("get food order by id");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderByName(String fname) {
		FoodOrder foodOrder=dao.getFoodOrderByName(fname);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if(foodOrder!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("get food order by name");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> getallfooFoodOrders() {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("get food order by id");
		responseStructure.setData(dao.getallFoodOrders());
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
	}

}
