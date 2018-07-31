package com.jisheng.service.impl;


import com.jisheng.dao.AssessDAO;
import com.jisheng.po.Assess;
import com.jisheng.service.AssessService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AssessServiceImpl implements AssessService {
    @Autowired
    private AssessDAO assessDAO;

    public AssessServiceImpl() {
    }

    @Override
    public boolean add(Assess assess) {
        assess.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        boolean succeed = assessDAO.add(assess);
        return succeed;
    }

    @Override
    public boolean remove(Assess assess) {
        ;
        Assess assess1 = assessDAO.lookPath(assess);
        String uuidname = assess1.getUuidname();
        String savepath = assess1.getSavepath();
        new File("E:/Program Files/ideaWorkplace/OrderSystem/OrderSystem-web/src/web/uploadAccess" + savepath + "/" + uuidname).delete();

        return assessDAO.remove(assess);
    }

    @Override
    public List<Assess> lookSomeOne(Assess assess) {
            return assessDAO.lookSomeOne(assess);
    }

    @Override
    public float getStoreMark(Assess assess) {
            return assessDAO.getStoreMark(assess);
    }

    @Override
    public List<Assess> lookAll() {
            return assessDAO.lookAll();
    }

    @Override
    public Assess lookPath(Assess assess) {
            return assessDAO.lookPath(assess);
    }

}
