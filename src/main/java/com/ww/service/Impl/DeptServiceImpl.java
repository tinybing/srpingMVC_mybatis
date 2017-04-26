package com.ww.service.Impl;

import com.ww.dao.DeptDao;
import com.ww.model.Dept;
import com.ww.service.DeptService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wurp on 17/2/6.
 */
@Service("DeptServiceImpl")
public class DeptServiceImpl implements DeptService{

    @Autowired
    DeptDao deptDao;

    @Override
    public Map<String, Object> queryOne(Dept model) {
        return null;
    }

    @Override
    public Map<String, Object> queryList(Dept model, int pageNumber, int pageSize) {
        Map resultMap = new HashMap();
        Example example = new Example(Dept.class);
        Example.Criteria criteria = example.createCriteria();

        if (model.getId() != null) {
            criteria.andLike("id", "%" + model.getId() + "%");
        }
        if (model.getDept()!= null) {
            criteria.andEqualTo("dept", model.getDept());
        }
        List<Dept> list;

        //分页插件
        //PageHelper.startPage(pageNumber, pageSize);
        System.out.println("＝＝＝＝＝＝未开启分页＝＝＝＝＝＝＝");
        list = deptDao.queryByExample(example);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(  ((Dept)list.get(i)).toString());
        }



        //直接配置SQL方式查询
        Map<String,Object> map = deptDao.selectDeptAndMenu(1);

        for (String key : map.keySet()) {
            Object value = map.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }


        resultMap.put("list", list);
        resultMap.put("total", list.size());
        return resultMap;
    }









    @Override
    public int queryCount(Example example) {
        return 0;
    }

    @Override
    public Map<String, Object> insertOne(Dept model) {

        deptDao.insert(model);

        return null;
    }

    @Override
    public Map<String, Object> updateOne(Dept model) {
        return null;
    }

    @Override
    public Map<String, Object> updateByExample(Dept model, Example example) {
        return null;
    }

    @Override
    public Map<String, Object> deleteOne(Dept model) {
        return null;
    }

    @Override
    public Map<String, Object> deleteByExample(Dept model) {
        return null;
    }
}
