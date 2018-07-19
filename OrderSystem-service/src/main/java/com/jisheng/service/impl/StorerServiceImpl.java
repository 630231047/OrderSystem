package com.jisheng.service.impl;


import com.jisheng.dao.StorerDAO;
import com.jisheng.po.Storer;
import com.jisheng.service.StorerService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StorerServiceImpl implements StorerService {
    private StorerDAO storerDAOImpl;
    private SqlSession sqlSession;

    private void openSqlSession() {
        sqlSession = SessionUtil.openSqlSession();
        storerDAOImpl = sqlSession.getMapper(StorerDAO.class);
    }

    private void closeSqlSession() {
        sqlSession.close();
    }

    public StorerServiceImpl() {
    }

    @Override
    public boolean addStorer(Storer storer) {
        try {
            openSqlSession();
            return storerDAOImpl.add(storer);
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public boolean removeStorer(Storer storer) {
        try {
            openSqlSession();
            return storerDAOImpl.remove(storer);
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public List<Storer> lookSomeOne(Storer storer) {
        try {
            openSqlSession();
            return storerDAOImpl.lookSomeOne(storer);
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public List<Storer> lookAll() {
        try {
            openSqlSession();
            return storerDAOImpl.lookAll();
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public Storer lookSomeOne1(Storer storer) {
        try {
            openSqlSession();
            return storerDAOImpl.lookSomeOne1(storer);
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public boolean updateStorer(Storer storer) {
        try {
            openSqlSession();
            return storerDAOImpl.update(storer);
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public boolean updateMark(Storer storer) {
        try {
            openSqlSession();
            return storerDAOImpl.updateMark(storer);
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public List<Storer> lookAllApply() {
        try {
            openSqlSession();
            return storerDAOImpl.lookAllApply();
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public boolean updateStatus(Storer storer) {
        try {
            openSqlSession();
            return storerDAOImpl.updateStatus(storer);
        } finally {
            closeSqlSession();
        }
    }

    @Override
    public List<Storer> lookSomeOne2(Storer storer) {
        try {
            openSqlSession();
            return storerDAOImpl.lookSomeOne2(storer);
        } finally {
            closeSqlSession();
        }
    }
}
