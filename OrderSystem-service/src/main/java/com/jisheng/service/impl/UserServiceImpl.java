package com.jisheng.service.impl;

import com.zengjisheng.www.dao.UserDao;
import com.zengjisheng.www.dao.impl.UserDaoImpl;
import com.zengjisheng.www.po.User;
import com.zengjisheng.www.service.UserService;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
public class UserServiceImpl implements UserService {

	private UserDao<User> dao = new UserDaoImpl<User>();

	@Override
	public boolean addUser(User user) {
		return dao.add(user);
	}

	@Override
	public boolean checkLoginInfo(User user) {
		String passWord= dao.checkLoginInfo(user).getPassword();
		if(user.getPassword().equals(passWord))
			return true;
		else return false;
	}

	@Override
	public boolean updateUserPassword(User user, String password) {
		if (checkLoginInfo(user)) {
			return dao.updateUserPassword( user,password);
		} else
			return false;
	}

	@Override
	public User getUserInfo(User user) {
		return dao.getUser(user);
	}

	@Override
	public boolean usernameIsExist(User user) {
		User serUser = dao.getUser(user);
		if (serUser != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean removeUser(User user) {
		return dao.remove(user);
	}

}
