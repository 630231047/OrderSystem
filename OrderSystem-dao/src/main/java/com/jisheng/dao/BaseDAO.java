package com.jisheng.dao;

import java.util.List;

public interface BaseDAO <T>{
     boolean add(T t);
     boolean remove(T t);
     List<T> lookSomeOne(T t);
     List<T> lookAll();
     boolean update(T t);
}
