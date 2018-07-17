package com.jisheng.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodDAO<Food> extends BaseDAO<Food>{
	/**
	 * 按照价钱对信息进行指定排序
	 */
	 List<Food> lookPriceInOrder(@Param("food") Food food, @Param("isAsc") boolean isAsc);
	/**
	 * 通过food的id来查找food的图片位置
	 */
	 Food lookPath(Food food);
}
