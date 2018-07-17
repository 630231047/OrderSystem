package com.jisheng.service.impl;

import com.zengjisheng.www.dao.OrderDao;
import com.zengjisheng.www.dao.impl.OrderDaoImpl;
import com.zengjisheng.www.po.Order;
import com.zengjisheng.www.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
	private OrderDao<Order> orderDao = new OrderDaoImpl<Order>();

	@Override
	public boolean addOrder(Order order) {
		return orderDao.add(order);
	}

	@Override
	public boolean removeOrder(Order order) {
		return orderDao.remove(order);
	}

	@Override
	public List<Order> lookSomeOne(Order order) {
		return orderDao.lookSomeOne(order);
	}

	@Override
	public List<Order> lookAll() {
		return orderDao.lookAll();
	}

	@Override
	public boolean updateOrder(Order order) {
		return orderDao.update(order);
	}

	@Override
	public List<Order> lookCusOrder(Order order) {
		return orderDao.lookCusOrder(order);
	}

	@Override
	public List<Object[]> lookCusOrder1(Order order) {
		return orderDao.lookCusOrder1(order);
	}

	@Override
	public Order lookCusOrder2(Order order) {
		return orderDao.lookCusOrder2(order);
	}

	@Override
	public List<Object[]> lookCusPaidOrder(Order order) {
		return orderDao.lookCusPaidOrder(order);
	}

	@Override
	public List<Order> lookFoodState(Order order) {
		return orderDao.lookFoodState(order);
	}

	@Override
	public List<Order> lookCanDelOrder() {
		return orderDao.lookCanDelOrder();
	}

	@Override
	public List<Object[]> lookCusStatusOrder(Order order, String status) {
		return orderDao.lookCusStatusOrder(order, status);
	}

}
