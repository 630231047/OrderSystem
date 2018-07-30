package com.jisheng.service;

import com.jisheng.dao.AdminDAO;
import com.jisheng.po.Admin;
import com.jisheng.po.User;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.List;

public class AdminServiceImplTest implements AdminService {
    private static AdminDAO<User> proxy;
    private static ServiceProxy serviceProxy;
    private static AdminService adminService = new AdminServiceImplTest();

    private AdminServiceImplTest() {
//        serviceProxy = new ServiceProxy(adminDAOImpl.getClass());
    }
    public static AdminService getAdminService(){
        return adminService;
    }
    static {
        serviceProxy = new ServiceProxy(AdminDAO.class);
        proxy = (AdminDAO) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{AdminDAO.class}, serviceProxy);
/**
 * 为什么第二个参数不能用AdminDAO.class.getInterfaces()
 */
    }
    @Override
    public boolean addCusRole(User user) {
        boolean succeed = proxy.addCusRole(user);
        return succeed;
    }

    @Override
    public boolean removeCusRole(User user) {
        boolean succeed= proxy.removeCusRole(user);
        return succeed;
    }

    @Override
    public boolean addStoRole(User user) {
        boolean succeed= proxy.addStoRole(user);
        return succeed;
    }

    @Override
    public boolean removeStoRole(User user) {
        boolean succeed= proxy.removeStoRole(user);
        return succeed;
    }

    @Override
    public List<String> lookRole(User user) {
            return proxy.lookRole(user);
    }

    @Override
    public String getPermRole(String url) {
        String roleName= proxy.getPermRole(url);
        return roleName;
    }

    @Override
    public List<Object[]> lookAll1() {
//		return adminDAOImpl.lookAll1();
        //暂时用不上
        return null;
    }

}
