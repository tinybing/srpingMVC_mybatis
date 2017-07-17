package com.ww.dao;

import com.ww.mapper.DeptMapper;
import com.ww.mapper.QuartztaskMapper;
import com.ww.model.Dept;
import com.ww.model.Quartztask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wurp on 17/5/25.
 */
@Repository
public class QuartzTaskDao extends BaseDao<Quartztask> {
    @Resource
    private QuartztaskMapper quartztaskMapper;

    public QuartztaskMapper getQuartztaskMapper() {
        return quartztaskMapper;
    }

    @Autowired
    public void setQuartztaskMapper() {
        super.setMapper(quartztaskMapper);
    }


}
