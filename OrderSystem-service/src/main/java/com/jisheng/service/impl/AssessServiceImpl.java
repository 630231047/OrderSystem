package com.jisheng.service.impl;

import com.zengjisheng.www.dao.AssessDao;
import com.zengjisheng.www.dao.impl.AssessDaoImpl;
import com.zengjisheng.www.po.Assess;
import com.zengjisheng.www.service.AssessService;

import java.io.File;
import java.util.List;

public class AssessServiceImpl implements AssessService {
	private AssessDao<Assess> assDao = new AssessDaoImpl();

	@Override
	public boolean add(Assess assess) {
		return assDao.add(assess);
	}

	@Override
	public boolean remove(Assess assess) {
		Assess ass = assDao.lookPath(assess);
		String uuidname = ass.getUuidname();
		String savepath = ass.getSavepath();
		new File("E:/Program Files/javaee/FoodSystem/web/uploadAccess" + savepath + "/" + uuidname).delete();
		return assDao.remove(assess);
	}

	@Override
	public List<Assess> lookSomeOne(Assess assess) {
		return assDao.lookSomeOne(assess);
	}

	@Override
	public float getStoreMark(Assess assess) {
		return assDao.getStoreMark(assess);
	}

	@Override
	public List<Assess> lookAll() {
		return assDao.lookAll();
	}

	@Override
	public Assess lookPath(Assess assess) {
		return assDao.lookPath(assess);
	}

}
