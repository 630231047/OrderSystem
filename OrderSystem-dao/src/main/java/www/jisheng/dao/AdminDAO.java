package www.jisheng.dao;

import java.util.List;

public interface AdminDAO<User> extends BaseDAO<User>{
    /**
     * 增加顾客角色
     * @param user
     * @return
     */
    public boolean addCusRole(User user);
    /**
     * 删除顾客角色
     * @param user
     * @return
     */
    public boolean removeCusRole(User user);
    /**
     * 增加商家角色
     * @param user
     * @return
     */
    public boolean addStoRole(User user);
    /**
     * 删除商家角色
     * @param user
     * @return
     */
    public boolean removeStoRole(User user);
    /**
     * 查看用户的角色
     * @param user
     * @return
     */
    public List<Object[]> lookRole(User user);
    /**
     * 查看所有角色信息
     */
    public List<List> lookAll1();
    /**
     * 得到该URL权限对应的角色名
     */
    public String getPermRole(String url) ;

}
