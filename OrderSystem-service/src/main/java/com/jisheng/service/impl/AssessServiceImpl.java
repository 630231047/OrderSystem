package com.jisheng.service.impl;


import com.jisheng.dao.AssessDAO;
import com.jisheng.po.Assess;
import com.jisheng.service.AssessService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AssessServiceImpl implements AssessService {
	private AssessDAO assessDAOImpl;
	private SqlSession sqlSession;
	private void openSqlSession(){
		sqlSession = SessionUtil.openSqlSession();
		assessDAOImpl = sqlSession.getMapper(AssessDAO.class);
	}
	private void closeSqlSession(){
		sqlSession.close();
	}
	public AssessServiceImpl() {
	}
	@Override
	public boolean add(Assess assess) {
		openSqlSession();
		assess.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		boolean succeed= assessDAOImpl.add(assess);
		closeSqlSession();
		return succeed;
	}

	@Override
	public boolean remove(Assess assess) {
		openSqlSession();
		Assess assess1= assessDAOImpl.lookPath(assess);
		String uuidname = assess1.getUuidname();
		String savepath = assess1.getSavepath();
		new File("E:/Program Files/ideaWorkplace/OrderSystem/OrderSystem-web/src/web/uploadAccess" + savepath + "/" + uuidname).delete();
		closeSqlSession();
		return assessDAOImpl.remove(assess);
	}

	@Override
	public List<Assess> lookSomeOne(Assess assess) {
		try {
			openSqlSession();
			return assessDAOImpl.lookSomeOne(assess);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public float getStoreMark(Assess assess) {
		try {
			openSqlSession();
			return assessDAOImpl.getStoreMark(assess);
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public List<Assess> lookAll() {
		try {
			openSqlSession();
			return assessDAOImpl.lookAll();
		} finally {
			closeSqlSession();
		}
	}

	@Override
	public Assess lookPath(Assess assess) {
		try {
			openSqlSession();
			return assessDAOImpl.lookPath(assess);
		} finally {
			closeSqlSession();
		}
	}

}
