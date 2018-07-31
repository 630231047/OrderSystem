package com.jisheng.service.impl;


import com.jisheng.dao.StorerDAO;
import com.jisheng.po.Storer;
import com.jisheng.service.StorerService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorerServiceImpl implements StorerService {
    @Autowired
    private StorerDAO storerDAOImpl;

    public StorerServiceImpl() {
    }

    @Override
    public boolean addStorer(Storer storer) {
        return storerDAOImpl.add(storer);
    }

    @Override
    public boolean removeStorer(Storer storer) {
        return storerDAOImpl.remove(storer);
    }

    @Override
    public List<Storer> lookSomeOne(Storer storer) {
        return storerDAOImpl.lookSomeOne(storer);
    }

    @Override
    public List<Storer> lookAll() {
        return storerDAOImpl.lookAll();
    }

    @Override
    public Storer lookSomeOne1(Storer storer) {
        return storerDAOImpl.lookSomeOne1(storer);
    }

    @Override
    public boolean updateStorer(Storer storer) {
        return storerDAOImpl.update(storer);
    }

    @Override
    public boolean updateMark(Storer storer) {
        return storerDAOImpl.updateMark(storer);
    }

    @Override
    public List<Storer> lookAllApply() {
        return storerDAOImpl.lookAllApply();
    }

    @Override
    public boolean updateStatus(Storer storer) {
        return storerDAOImpl.updateStatus(storer);
    }

    @Override
    public List<Storer> lookSomeOne2(Storer storer) {
        return storerDAOImpl.lookSomeOne2(storer);
    }
}
