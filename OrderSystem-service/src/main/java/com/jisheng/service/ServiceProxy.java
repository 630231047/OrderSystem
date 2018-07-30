package com.jisheng.service;

import com.jisheng.dao.BaseDAO;
import com.jisheng.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceProxy implements InvocationHandler {
    private Class<? extends BaseDAO> daoClass;

    ServiceProxy(Class<? extends BaseDAO> daoClass) {
        this.daoClass = daoClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        SqlSession sqlSession = SessionUtil.openSqlSession();
        BaseDAO daoImpl = sqlSession.getMapper(daoClass);
        result = method.invoke(daoImpl, args);
        sqlSession.close();
        return result;
    }

}
