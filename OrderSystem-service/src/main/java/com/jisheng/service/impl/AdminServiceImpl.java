package com.jisheng.service.impl;

import com.jisheng.dao.AdminDAO;
import com.jisheng.service.AdminService;
import com.jisheng.po.User;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AdminServiceImpl implements AdminService {
	//	private AdminDAO<User> adminDAOImpl = new AdminDAOImpl<User>();
	private AdminDAO<User> adminDAOImpl;
	private SqlSession sqlSession;
	private void openSqlSession(){
		sqlSession = SessionUtil.openSqlSession();
		adminDAOImpl = sqlSession.getMapper(AdminDAO.class);
	}
	private void closeSqlSession(){
		sqlSession.close();
	}
	public AdminServiceImpl() {
	}

	@Override
	public boolean addCusRole(User user) {
		openSqlSession();
		boolean succeed= adminDAOImpl.addCusRole(user);
		closeSqlSession();
		return succeed;

	}

	@Override
	public boolean removeCusRole(User user) {
		openSqlSession();
		boolean succeed= adminDAOImpl.removeCusRole(user);
		closeSqlSession();
		return succeed;
	}

	@Override
	public boolean addStoRole(User user) {
		openSqlSession();
		boolean succeed= adminDAOImpl.addStoRole(user);
		closeSqlSession();
		return succeed;
	}

	@Override
	public boolean removeStoRole(User user) {
		openSqlSession();
		boolean succeed= adminDAOImpl.removeStoRole(user);
		closeSqlSession();
		return succeed;
	}

	@Override
	public List<String> lookRole(User user) {
		try {
			openSqlSession();
			return adminDAOImpl.lookRole(user);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public String getPermRole(String url) {
		openSqlSession();
		String roleName= adminDAOImpl.getPermRole(url);
		closeSqlSession();
		return roleName;
	}

	@Override
	public List<Object[]> lookAll1() {
//		return adminDAOImpl.lookAll1();
		//暂时用不上
		return null;
	}

}
