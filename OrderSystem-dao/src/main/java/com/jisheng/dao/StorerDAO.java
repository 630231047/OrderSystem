package com.jisheng.dao;

import java.util.List;

public interface StorerDAO<Storer> extends BaseDAO<Storer> {
	/**
	 * 通过user_id来查找商家
	 * 
	 * @param t
	 * @return
	 */
	public Storer lookSomeOne1(Storer storer);
	/**
	 * 修改某个商家的平均评分
	 */
	public boolean updateMark(Storer storer);
	/**
	 * 查看处于审核中的商家信息
	 */
	public List<Storer> lookAllApply();
	/**
	 * 修改审核中的店家的状态
	 */
	public boolean updateStatus(Storer storer);
	/**
	 * 通过store_name来查找状态为正常的商家
	 * 
	 * @param t
	 * @return
	 */
	public List<Storer> lookSomeOne2(Storer storer);
}
