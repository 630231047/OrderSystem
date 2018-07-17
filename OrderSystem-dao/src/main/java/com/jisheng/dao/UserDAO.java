package com.jisheng.dao;


import org.apache.ibatis.annotations.Param;

public interface UserDAO<User> extends BaseDAO<User>{
	/**
	 * 判断密码是否正确
	 * 
	 * @param user
	 * @return
	 */
	User checkLoginInfo(User user);

	/**
	 * 更改密码
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	boolean updateUserPassword(@Param("user") User user, @Param("password") String password);

	/**
	 * 获得用户完整信息
	 */
	User getUser(User user);
}
