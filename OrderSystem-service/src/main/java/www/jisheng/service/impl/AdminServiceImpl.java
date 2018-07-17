package www.jisheng.service.impl;

import com.zengjisheng.www.dao.AdminDao;
import com.zengjisheng.www.dao.impl.AdminDaoImpl;
import com.zengjisheng.www.po.User;
import com.zengjisheng.www.service.AdminService;
import www.jisheng.po.User;
import www.jisheng.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
	private AdminDao<User> adminDaoImpl = new AdminDaoImpl<User>();

	@Override
	public boolean addCusRole(User user) {
		return adminDaoImpl.addCusRole(user);
	}

	@Override
	public boolean removeCusRole(User user) {
		return adminDaoImpl.removeCusRole(user);
	}

	@Override
	public boolean addStoRole(User user) {
		return adminDaoImpl.addStoRole(user);
	}

	@Override
	public boolean removeStoRole(User user) {
		return adminDaoImpl.removeStoRole(user);
	}

	@Override
	public List<Object[]> lookRole(User user) {
		return adminDaoImpl.lookRole(user);
	}

	@Override
	public String getPermRole(String url) {
		return adminDaoImpl.getPermRole(url);
	}

	@Override
	public List<Object[]> lookAll1() {
		return adminDaoImpl.lookAll1();
	}

}
