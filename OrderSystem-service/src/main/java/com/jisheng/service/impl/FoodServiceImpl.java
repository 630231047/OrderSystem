package com.jisheng.service.impl;


import com.jisheng.dao.FoodDAO;
import com.jisheng.po.Food;
import com.jisheng.po.Storer;
import com.jisheng.service.FoodService;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodDAO foodDAOImpl;

    public FoodServiceImpl() {
    }

    @Override
    public boolean addFood(Food food) {
        return foodDAOImpl.add(food);
    }

    @Override
    public boolean removeFood(Food food) {
        Food food1 = foodDAOImpl.lookPath(food);
        String uuidname = food1.getUuidname();
        String savepath = food1.getSavepath();
        new File("E:/Program Files/javaee/FoodSystem/webContent/upload" + savepath + "/" + uuidname).delete();
        return foodDAOImpl.remove(food);
    }

    @Override
    public List<Food> lookSomeOne(Food food) {
        return foodDAOImpl.lookSomeOne(food);
    }

    @Override
    public List<Storer> lookAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateFood(Food food) {
        return foodDAOImpl.update(food);
    }

    @Override
    public List<Food> lookPriceInOrder(Food food, boolean isAsc) {
        return foodDAOImpl.lookPriceInOrder(food, isAsc);
    }

    @Override
    public Food lookPath(Food food) {
        return foodDAOImpl.lookPath(food);
    }
}
