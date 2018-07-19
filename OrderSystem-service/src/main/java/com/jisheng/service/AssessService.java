package com.jisheng.service;

import com.jisheng.po.Assess;

import java.util.List;

public interface AssessService {
/**
 * 增加评价
 * @param assess
 * @return
 */
	public boolean add(Assess assess);
	/**
	 * 删除评价
	 * 便于定时删除过期评价
	 * @param assess
	 * @return
	 */
	public boolean remove(Assess assess);
	/**
	 * 获得某个商家的所有评价
	 * @param assess
	 * @return
	 */
	public List<Assess> lookSomeOne(Assess assess);
	/**
	 * 得到某个商铺的平均评分
	 */
	public float getStoreMark(Assess assess);
	/**
	 * 得到所有评价
	 */
	public List<Assess> lookAll();
	/**
	 * 通过assess的id来查找assess的图片位置
	 */
	public Assess lookPath(Assess assess);
}
