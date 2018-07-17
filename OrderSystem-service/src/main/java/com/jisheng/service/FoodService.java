package com.jisheng.service;

import com.zengjisheng.www.po.Food;
import com.zengjisheng.www.po.Storer;

import java.util.List;

public interface FoodService {
	/**
	 * 添加新商品
	 * 
	 * @param user
	 *            新用户
	 * @return true - 添加成功 false - 添加失败
	 */
	boolean addFood(Food food);

	/**
	 * 删除商品
	 */
	boolean removeFood(Food food);
	/**
	 * 修改商品信息
	 */
	boolean updateFood(Food food);
	/**
	 * 搜索某个商家的所有商品信息
	 */
	List<Food> lookSomeOne(Food food);
	/**
	 * 得到所有商家信息
	 */
	List<Storer> lookAll();
	/**
	 * 按照价钱对信息进行指定排序
	 */
	public List<Food> lookPriceInOrder(Food food, boolean isAsc);
	/**
	 * 通过food的id来查找food的图片位置
	 */
	public Food lookPath(Food food);
}
