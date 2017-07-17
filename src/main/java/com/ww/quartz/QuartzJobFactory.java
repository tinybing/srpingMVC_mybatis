package com.ww.quartz;

import com.ww.model.Quartztask;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wurp on 17/5/24.
 */
public class QuartzJobFactory implements Job {


    private List<Map<String,String>> convert(List<Map<String,Object>> params){
        if(params == null||params.size()==0)return new ArrayList<>();
        List<Map<String,String>> res = new ArrayList<>();
        for(Map<String,Object> map:params){
            Map<String,String> m = new HashMap<>();
            for(Map.Entry<String,Object> entry:map.entrySet()){
                m.put(entry.getKey(),entry.getValue().toString());
            }
            res.add(m);
        }
        return res;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Quartztask timer = (Quartztask)context.getMergedJobDataMap().get("JobConfig");
        JobService jobService = (JobService) context.getMergedJobDataMap().get("jobService");
        System.out.println(" ＝＝＝＝＝＝＝＝＝＝＝  定时job启动：执行业务代码 ＝＝＝＝＝＝＝＝");
       // EmailClient.sendEmailByReportId(jobService, timer, true, null);
    }
}
