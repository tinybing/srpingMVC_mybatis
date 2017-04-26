package com.ww.service;

import tk.mybatis.mapper.entity.Example;

import java.util.Map;

/**
 * Created by Administrator on 2016/5/12.
 */
public interface BaseService<T> {

    public Map<String, Object> queryOne(T model);

    public Map<String, Object> queryList(T model, int pageNumber, int pageSize);

    public int queryCount(Example example);

    public Map<String, Object> insertOne(T model);

    public Map<String, Object> updateOne(T model);

    public Map<String, Object> updateByExample(T model, Example example);

    public Map<String, Object> deleteOne(T model);

    public Map<String, Object> deleteByExample(T model);

}
