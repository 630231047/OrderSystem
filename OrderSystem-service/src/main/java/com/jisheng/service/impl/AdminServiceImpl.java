package com.jisheng.service.impl;

import com.jisheng.dao.AdminDAO;
import com.jisheng.service.AdminService;
import com.jisheng.po.User;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{
	//	private AdminDAO<User> adminDAOImpl = new AdminDAOImpl<User>();
	@Autowired
	private AdminDAO<User> adminDAOImpl;
//	private void openSqlSession(){
//		sqlSession = SessionUtil.openSqlSession();
//		adminDAOImpl = sqlSession.getMapper(AdminDAO.class);
//	}
//	private void closeSqlSession(){
//		sqlSession.close();
//	}
//	public AdminServiceImpl() {
//	}

	@Override
	public boolean addCusRole(User user) {
		boolean succeed= adminDAOImpl.addCusRole(user);
		return succeed;

	}

	@Override
	public boolean removeCusRole(User user) {
		boolean succeed= adminDAOImpl.removeCusRole(user);
		return succeed;
	}

	@Override
	public boolean addStoRole(User user) {
		boolean succeed= adminDAOImpl.addStoRole(user);
		return succeed;
	}

	@Override
	public boolean removeStoRole(User user) {
		boolean succeed= adminDAOImpl.removeStoRole(user);
		return succeed;
	}

	@Override
	public List<String> lookRole(User user) {
			return adminDAOImpl.lookRole(user);
	}

	@Override
	public String getPermRole(String url) {
		String roleName= adminDAOImpl.getPermRole(url);
		return roleName;
	}

	@Override
	public List<Object[]> lookAll1() {
//		return adminDAOImpl.lookAll1();
		//暂时用不上
		return null;
	}

}
