package com.jisheng.service;

import com.jisheng.bo.LookCusOrder1;
import com.jisheng.bo.LookCusPaidOrder;
import com.jisheng.bo.LookCusStatusOrder;
import com.jisheng.po.Order;

import java.util.List;

public interface OrderService {
	/**
	 * 添加新订单
	 * 
	 * @param order
	 *            新用户
	 * @return true - 添加成功 false - 添加失败
	 */
	boolean addOrder(Order order);

	/**
	 * 删除订单
	 */
	boolean removeOrder(Order order);
	/**
	 * 搜索订单
	 */
	List<Order> lookSomeOne(Order order);
	/**
	 * 得到所有订单信息
	 */
	List<Order> lookAll();
	/**
	 * 修改订单信息
	 */
	boolean updateOrder(Order order);
	/**
	 * 得到某个顾客的信息
	 */
	List<Order> lookCusOrder(Order order);
	/**
	 * 查看某个顾客的订单高级版
	 */
	 List<LookCusOrder1> lookCusOrder1(Order order);
	/**
	 * 商家查看某个顾客已付款的订单
	 */
	 List<LookCusPaidOrder> lookCusPaidOrder(Order order);
	/**
	 * 通过orders.id来查看某个订单信息
	 */
	 Order lookCusOrder2(Order order);
	/**
	 * 通过food_id来查询订单信息
	 * 删除商品时只有订单为除已付款其他状态时才能删除
	 */
	 List<Order>lookFoodState(Order order);
	/**
	 * 查看状态为无和已评价的订单
	 * 以便定时删除
	 * @param
	 * @return
	 */
	 List<Order>lookCanDelOrder();
	/**
	 * 查看某个顾客某个状态的订单
	 */
	 List<LookCusStatusOrder> lookCusStatusOrder(Order order, String status);
}
	
