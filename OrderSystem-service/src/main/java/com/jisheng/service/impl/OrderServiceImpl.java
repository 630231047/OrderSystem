package com.jisheng.service.impl;

import com.jisheng.dao.OrderDAO;
import com.jisheng.po.Order;
import com.jisheng.service.OrderService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDAOImpl;
	private SqlSession sqlSession;
	private void openSqlSession(){
		sqlSession = SessionUtil.openSqlSession();
		orderDAOImpl = sqlSession.getMapper(OrderDAO.class);
	}
	private void closeSqlSession(){
		sqlSession.close();
	}
	public OrderServiceImpl() {
	}

	@Override
	public boolean addOrder(Order order) {
		try {
			openSqlSession();
			return orderDAOImpl.add(order);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public boolean removeOrder(Order order) {
		try {
			openSqlSession();
			return orderDAOImpl.remove(order);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Order> lookSomeOne(Order order) {
		openSqlSession();
		return orderDAOImpl.lookSomeOne(order);
	}

	@Override
	public List<Order> lookAll() {
		try {
			openSqlSession();
			return orderDAOImpl.lookAll();
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public boolean updateOrder(Order order) {
		try {
			openSqlSession();
			return orderDAOImpl.update(order);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Order> lookCusOrder(Order order) {
		try {
			openSqlSession();
			return orderDAOImpl.lookCusOrder(order);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Object[]> lookCusOrder1(Order order) {
		try {
			openSqlSession();
//			return orderDAOImpl.lookCusOrder1(order);
			return null;
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public Order lookCusOrder2(Order order) {
		try {
			openSqlSession();
			return orderDAOImpl.lookCusOrder2(order);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Object[]> lookCusPaidOrder(Order order) {
		try {
			openSqlSession();
//			return orderDAOImpl.lookCusPaidOrder(order);
			return null;
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Order> lookFoodState(Order order) {
		try {
			openSqlSession();
			return orderDAOImpl.lookFoodState(order);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Order> lookCanDelOrder() {
		openSqlSession();
		return orderDAOImpl.lookCanDelOrder();
	}

	@Override
	public List<Object[]> lookCusStatusOrder(Order order, String status) {
		try {
			openSqlSession();
//			return orderDAOImpl.lookCusStatusOrder(order, status);
			return null;
		} finally {
			closeSqlSession();
		}
	}

}
