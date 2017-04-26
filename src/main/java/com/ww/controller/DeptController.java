package com.ww.controller;

import com.ww.model.Dept;
import com.ww.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by wurp on 17/2/6.
 */
@Controller
@RequestMapping("/DeptController")
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping(value = "getDeptList")
    public String getAppVersionList(HttpServletRequest request, HttpServletResponse response){
        Map resultmap;

        Dept dept = new Dept();
        resultmap = deptService.queryList(dept, 1, 10);
        /* 通过getParameter取请求中传过来的参数
        String model=request.getParameter("model");
        JSONObject jsonObject= JSON.parseObject(model);
        resultmap 存入要返回的数据
        ResponseService.WriteResponse(response,resultmap);
        */
        List<Dept> list = (List<Dept>)resultmap.get("list");
        request.setAttribute("deptlist", list);
        return "listDept";
    }


    @RequestMapping(value="/addDept")
    public String addUser(String id,String dept ) {
        Dept deptObj = new Dept();
        deptObj.setDept(dept);
        deptObj.setId(Integer.parseInt(id));
        deptService.insertOne(deptObj);
        return "redirect:/DeptController/getDeptList.do";
    }

}
