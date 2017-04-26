package com.ww.mapper;

import com.ww.model.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface DeptMapper extends Mapper<Dept> {
    public Map<String, Object> selectDeptAndMenu(int id);
}