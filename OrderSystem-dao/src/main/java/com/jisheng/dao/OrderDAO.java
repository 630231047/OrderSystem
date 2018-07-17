package com.jisheng.dao;

import com.jisheng.po.Order;

import java.util.List;

public interface OrderDAO extends BaseDAO<Order>{
	/**
	 * 查看某个顾客的订单
	 * @param t
	 * @return
	 */
	public List<Order> lookCusOrder(Order order);
	/**
	 * 查看某个顾客的订单高级版
	 */
	public List<Object[]> lookCusOrder1(Order order);
	/**
	 * 商家查看某个顾客已付款的订单
	 */
	public List<Object[]> lookCusPaidOrder(Order order);
	/**
	 * 通过orders.id来查看某个订单信息
	 */
	public Order lookCusOrder2(Order order);
	/**
	 * 通过food_id来查询订单信息
	 * 删除商品时只有订单为除已付款其他状态时才能删除
	 */
	public List<Order>lookFoodState(Order order);
	/**
	 * 查看状态为无和已评价的订单
	 * 以便定时删除
	 * @param t
	 * @return
	 */
	public List<Order>lookCanDelOrder();
	/**
	 * 查看某个顾客某个状态的订单
	 */
	public List<Object[]> lookCusStatusOrder(Order order, String status);
}
