package com.jisheng.service;

import com.jisheng.po.Storer;

import java.util.List;

public interface StorerService {
	/**
	 * 添加新商铺
	 * 
	 * @param user
	 *            新用户
	 * @return true - 添加成功 false - 添加失败
	 */
	boolean addStorer(Storer storer);

	/**
	 * 删除商家
	 */
	boolean removeStorer(Storer storer);
	/**
	 * 更新商家信息
	 */
	boolean updateStorer(Storer storer);
	/**
	 * 通过店铺名搜索商家
	 */
	List<Storer> lookSomeOne(Storer storer);

	/**
	 * 通过user_id 得到商家信息
	 */
	Storer lookSomeOne1(Storer storer);

	/**
	 * 得到所有商家信息
	 */
	List<Storer> lookAll();
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
	 * @param t
	 * @return
	 */
	public List<Storer> lookSomeOne2(Storer storer);
}
