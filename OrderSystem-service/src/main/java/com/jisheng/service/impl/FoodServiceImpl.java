package com.jisheng.service.impl;


import com.jisheng.dao.FoodDAO;
import com.jisheng.po.Food;
import com.jisheng.po.Storer;
import com.jisheng.service.FoodService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.util.List;

public class FoodServiceImpl implements FoodService {
	private FoodDAO foodDAOImpl;
	private SqlSession sqlSession;
	private void openSqlSession(){
		sqlSession = SessionUtil.openSqlSession();
		foodDAOImpl = sqlSession.getMapper(FoodDAO.class);
	}
	private void closeSqlSession(){
		sqlSession.close();
	}
	public FoodServiceImpl() {
	}
	@Override
	public boolean addFood(Food food) {
		try {
			openSqlSession();
			return foodDAOImpl.add(food);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public boolean removeFood(Food food) {
		try {
			openSqlSession();
			Food food1 = foodDAOImpl.lookPath(food);
			String uuidname = food1.getUuidname();
			String savepath = food1.getSavepath();
			new File("E:/Program Files/javaee/FoodSystem/webContent/upload" + savepath + "/" + uuidname).delete();
			return foodDAOImpl.remove(food);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Food> lookSomeOne(Food food) {
		try {
			openSqlSession();
			return foodDAOImpl.lookSomeOne(food);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Storer> lookAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFood(Food food) {
		try {
			openSqlSession();
			return foodDAOImpl.update(food);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Food> lookPriceInOrder(Food food, boolean isAsc) {
		try {
			openSqlSession();
			return foodDAOImpl.lookPriceInOrder(food, isAsc);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public Food lookPath(Food food) {
		try {
			openSqlSession();
			return foodDAOImpl.lookPath(food);
		} finally {
			closeSqlSession();
		}
	}
}
