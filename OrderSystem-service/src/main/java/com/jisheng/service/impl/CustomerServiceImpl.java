package com.jisheng.service.impl;

import com.zengjisheng.www.dao.CustomerDao;
import com.zengjisheng.www.dao.impl.CustomerDaoImpl;
import com.zengjisheng.www.po.Customer;
import com.zengjisheng.www.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao<Customer> customerDao = new CustomerDaoImpl<Customer>();

	@Override
	public boolean addCustomer(Customer customer) {
		return customerDao.add(customer);
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		return customerDao.remove(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public List<Customer> lookSomeOne(Customer customer) {
		return customerDao.lookSomeOne(customer);
	}

	@Override
	public List<Customer> lookAll() {
		return customerDao.lookAll();
	}

}
