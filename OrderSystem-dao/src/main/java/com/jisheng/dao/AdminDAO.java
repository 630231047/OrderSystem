package com.jisheng.dao;

import com.jisheng.bo.AdminLookAll1;

import java.util.List;

public interface AdminDAO<T> extends BaseDAO<T>{
    /**
     * 增加顾客角色
     * @param user
     * @return
     */
     boolean addCusRole(T user);
    /**
     * 删除顾客角色
     * @param user
     * @return
     */
     boolean removeCusRole(T user);
    /**
     * 增加商家角色
     * @param user
     * @return
     */
     boolean addStoRole(T user);
    /**
     * 删除商家角色
     * @param user
     * @return
     */
     boolean removeStoRole(T user);
    /**
     * 查看用户的角色
     * @param user
     * @return
     */
     List<String> lookRole(T user);
    /**
     * 查看所有角色信息(暂时没用上)
     */
     List<AdminLookAll1> lookAll1();
    /**
     * 得到该URL权限对应的角色名
     */
     String getPermRole(String url) ;

}
