package com.ww.common;


import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by wurp on 16/12/22.
 */


public class ResponseService {

    public static void WriteResponse(HttpServletResponse response, Map resultmap) {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            PrintWriter out = response.getWriter();
            String jsonstr = JSON.toJSONString(resultmap);
            System.out.println(("send json:" + jsonstr));
            out.println(jsonstr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
