package com.jisheng.dao;

import com.jisheng.po.Assess;

public interface AssessDAO extends BaseDAO<Assess> {
	/**
	 * 得到某个商铺的平均评分
	 */
	 float getStoreMark(Assess t);

	/**
	 * 通过assess的id来查找assess的图片位置
	 */
	 Assess lookPath(Assess t);
}
