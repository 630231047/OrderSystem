package www.jisheng.service;


import www.jisheng.po.User;

public interface UserService {
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	boolean addUser(User user);

	/**
	 * 判断密码是否正确
	 * 
	 * @param user
	 * @return
	 */
	boolean checkLoginInfo(User user);
	/**
	 * 更改密码
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	boolean updateUserPassword(User user, String password);

	/**
	 * 判断用户名是否已存在
	 * 
	 * @param user
	 * 			一个用户
	 * @return
	 */
	boolean usernameIsExist(User user);

	/**
	 * 使用用户名获取完整用户信息
	 * 
	 * @param user
	 * 			一个用户
	 * @return
	 * 			包含完整信息的用户
	 */
	User getUserInfo(User user);
	/**
	 * 删除用户
	 */
	boolean removeUser(User user);
}
