package com.jisheng.service.impl;

import com.jisheng.bo.LookCusOrder1;
import com.jisheng.bo.LookCusPaidOrder;
import com.jisheng.bo.LookCusStatusOrder;
import com.jisheng.dao.OrderDAO;
import com.jisheng.po.Order;
import com.jisheng.service.OrderService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAOImpl;

    public OrderServiceImpl() {
    }

    @Override
    public boolean addOrder(Order order) {
        order.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return orderDAOImpl.add(order);
    }

    @Override
    public boolean removeOrder(Order order) {
        return orderDAOImpl.remove(order);
    }

    @Override
    public List<Order> lookSomeOne(Order order) {

        return orderDAOImpl.lookSomeOne(order);
    }

    @Override
    public List<Order> lookAll() {
        return orderDAOImpl.lookAll();
    }

    @Override
    public boolean updateOrder(Order order) {
        order.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return orderDAOImpl.update(order);
    }

    @Override
    public List<Order> lookCusOrder(Order order) {
        return orderDAOImpl.lookCusOrder(order);
    }

    @Override
    public List<LookCusOrder1> lookCusOrder1(Order order) {
        return orderDAOImpl.lookCusOrder1(order);
//			return null;
    }

    @Override
    public Order lookCusOrder2(Order order) {
        return orderDAOImpl.lookCusOrder2(order);
    }

    @Override
    public List<LookCusPaidOrder> lookCusPaidOrder(Order order) {
        return orderDAOImpl.lookCusPaidOrder(order);
    }

    @Override
    public List<Order> lookFoodState(Order order) {
        return orderDAOImpl.lookFoodState(order);
    }

    @Override
    public List<Order> lookCanDelOrder() {

        return orderDAOImpl.lookCanDelOrder();
    }

    @Override
    public List<LookCusStatusOrder> lookCusStatusOrder(Order order, String status) {
        return orderDAOImpl.lookCusStatusOrder(order, status);
    }

}
