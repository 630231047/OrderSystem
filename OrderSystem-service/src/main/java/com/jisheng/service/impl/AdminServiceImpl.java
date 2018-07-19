package com.jisheng.service.impl;

import com.jisheng.bo.AdminLookRole;
import com.jisheng.dao.AdminDAO;
import com.jisheng.service.AdminService;
import com.jisheng.po.User;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
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
	public List<Object[]> lookRole(User user) {
		openSqlSession();
		List<AdminLookRole> adminLookRole = adminDAOImpl.lookRole(user);
		closeSqlSession();
		List<Object[]> objects = new ArrayList<>();
		for (AdminLookRole adminLookRole1 : adminLookRole) {
			for (int i = 0; i < 2; i++) {
				Object[] obj = new Object[2];
				obj[0]=adminLookRole1.getUser_id();
				obj[1]=adminLookRole1.getRole_name();
				objects.add(obj);
			}
		}
		return objects;
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
		return null;
	}

}
