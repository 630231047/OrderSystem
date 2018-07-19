package com.jisheng.service.impl;


import com.jisheng.dao.UserDAO;
import com.jisheng.po.User;
import com.jisheng.service.UserService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
	private UserDAO userDAOImpl;
	private SqlSession sqlSession;

	private void openSqlSession() {
		sqlSession = SessionUtil.openSqlSession();
		userDAOImpl = sqlSession.getMapper(UserDAO.class);
	}

	private void closeSqlSession() {
		sqlSession.close();
	}

	public UserServiceImpl() {
	}

	@Override
	public boolean addUser(User user) {
		try {
			openSqlSession();
			return userDAOImpl.add(user);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public boolean checkLoginInfo(User user) {
		try {
			openSqlSession();
			String passWord= userDAOImpl.checkLoginInfo(user).getPassword();
			if(user.getPassword().equals(passWord))
				return true;
			else return false;
		} finally {
				closeSqlSession();
		}
	}

	@Override
	public boolean updateUserPassword(User user, String password) {
		try {
			openSqlSession();
			if (checkLoginInfo(user)) {
				return userDAOImpl.updateUserPassword( user,password);
			} else
				return false;
		} finally {
				closeSqlSession();
		}
	}

	@Override
	public User getUserInfo(User user) {
		try {
			openSqlSession();
			return userDAOImpl.getUser(user);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public boolean usernameIsExist(User user) {
		try {
			openSqlSession();
			User serUser = userDAOImpl.getUser(user);
			if (serUser != null)
				return true;
			else
				return false;
		} finally {
				closeSqlSession();
		}
	}

	@Override
	public boolean removeUser(User user) {
		try {
			openSqlSession();
			return userDAOImpl.remove(user);
		} finally {
			closeSqlSession();
		}
	}

}
