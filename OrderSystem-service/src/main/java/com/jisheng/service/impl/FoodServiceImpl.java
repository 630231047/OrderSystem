package com.jisheng.service.impl;

import com.zengjisheng.www.dao.FoodDao;
import com.zengjisheng.www.dao.impl.FoodDaoImpl;
import com.zengjisheng.www.po.Food;
import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.service.FoodService;

import java.io.File;
import java.util.List;

public class FoodServiceImpl implements FoodService {
	private FoodDao<Food> foodDao = new FoodDaoImpl<>();

	@Override
	public boolean addFood(Food food) {
		return foodDao.add(food);
	}

	@Override
	public boolean removeFood(Food food) {
		Food f = foodDao.lookPath(food);
		String uuidname = f.getUuidname();
		String savepath = f.getSavepath();
		new File("E:/Program Files/javaee/FoodSystem/web/upload" + savepath + "/" + uuidname).delete();
		return foodDao.remove(food);
	}

	@Override
	public List<Food> lookSomeOne(Food food) {
		return foodDao.lookSomeOne(food);
	}

	@Override
	public List<Storer> lookAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFood(Food food) {
		return foodDao.update(food);
	}

	@Override
	public List<Food> lookPriceInOrder(Food food, boolean isAsc) {
		return foodDao.lookPriceInOrder(food, isAsc);
	}

	@Override
	public Food lookPath(Food food) {
		return foodDao.lookPath(food);
	}
}
