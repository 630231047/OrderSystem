package com.jisheng.service.impl;


import com.jisheng.dao.CustomerDAO;
import com.jisheng.po.Customer;
import com.jisheng.service.CustomerService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO customerDAOImpl;
	private SqlSession sqlSession;
	private void openSqlSession(){
		sqlSession = SessionUtil.openSqlSession();
		customerDAOImpl = sqlSession.getMapper(CustomerDAO.class);
	}
	private void closeSqlSession(){
		sqlSession.close();
	}
	public CustomerServiceImpl() {
	}

	@Override
	public boolean addCustomer(Customer customer) {
		try {
			openSqlSession();
			return customerDAOImpl.add(customer);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		try {
			openSqlSession();
			return customerDAOImpl.remove(customer);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			openSqlSession();
			return customerDAOImpl.update(customer);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Customer> lookSomeOne(Customer customer) {
		try {
			openSqlSession();
			return customerDAOImpl.lookSomeOne(customer);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Customer> lookAll() {
		try {
			openSqlSession();
			return customerDAOImpl.lookAll();
		} finally {
			closeSqlSession();
		}
	}

}
