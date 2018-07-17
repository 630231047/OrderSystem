package www.jisheng.service;

import com.zengjisheng.www.po.User;

import java.util.List;

public interface AdminService {
	/**
	 * 增加角色
	 * @param t
	 * @return
	 */
	public boolean addCusRole(User user);
	/**
	 * 删除角色
	 * @param t
	 * @return
	 */
	public boolean removeCusRole(User user);
	/**
	 * 增加角色
	 * @param t
	 * @return
	 */
	public boolean addStoRole(User user);
	/**
	 * 删除角色
	 * @param t
	 * @return
	 */
	public boolean removeStoRole(User user);
	/**
	 * 查看用户的角色
	 * @param t
	 * @return
	 */
	public List<Object[]> lookRole(User user);
	/**
	 * 查看所有角色
	 */
	public List<Object[]> lookAll1();
	/**
	 * 得到该URL权限对应的角色名
	 */
	public String getPermRole(String url) ;
}
