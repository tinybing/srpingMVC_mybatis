package com.ww.dao;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/10.
 */
@Repository
public abstract class BaseDao<T> implements Serializable{

    private Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    public void setMapper(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    public T queryData(T model) {
        return mapper.selectOne(model);
    }

    public List<T> queryByExample(Example example) {
        return mapper.selectByExample(example);
    }

    public int queryCount(T model) {
        return mapper.selectCount(model);
    }

    public int queryCountByExample(Example example) {
        return mapper.selectCountByExample(example);
    }

    public int insert(T model) {
        return mapper.insertSelective(model);
    }

    public int updateByPKSelective(T model) {
        return mapper.updateByPrimaryKeySelective(model);
    }

    public int updateByPK(T model) {
        return mapper.updateByPrimaryKey(model);
    }

    public int updateByExample(T model, Example example) {
        return mapper.updateByExampleSelective(model, example);
    }

    public int deleteOne(T model) {
        return mapper.delete(model);
    }

    public int deleteByExample(Example example) {
        return mapper.deleteByExample(example);
    }
}
