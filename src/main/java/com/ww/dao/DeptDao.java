package com.ww.dao;

import com.ww.mapper.DeptMapper;
import com.ww.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wurp on 17/2/6.
 */
@Repository
public class DeptDao extends BaseDao<Dept> {
    @Resource
    private DeptMapper deptMapper;

    @Autowired
    public void setDeptMapper(){
        super.setMapper (deptMapper);
    }

    public Map<String, Object> selectDeptAndMenu(int id)
    {
        System.out.println("  ----  DeptDao ----  selectDeptAndMenu方法");
        return deptMapper.selectDeptAndMenu(id) ;
    }




}
