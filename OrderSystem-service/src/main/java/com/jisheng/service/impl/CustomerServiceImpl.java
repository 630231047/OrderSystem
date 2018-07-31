package com.jisheng.service.impl;


import com.jisheng.dao.CustomerDAO;
import com.jisheng.po.Customer;
import com.jisheng.service.CustomerService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAOImpl;

    public CustomerServiceImpl() {
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customerDAOImpl.add(customer);
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        return customerDAOImpl.remove(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDAOImpl.update(customer);
    }

    @Override
    public List<Customer> lookSomeOne(Customer customer) {
        return customerDAOImpl.lookSomeOne(customer);
    }

    @Override
    public List<Customer> lookAll() {
        return customerDAOImpl.lookAll();
    }

}
