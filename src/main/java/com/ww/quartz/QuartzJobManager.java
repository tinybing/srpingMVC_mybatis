package com.ww.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

/**
 * Created by wurp on 17/5/24.
 */
@Service
public class QuartzJobManager {
    private Scheduler scheduler;
    private Class<Job> jobClass;
    private Map metaMap = Collections.emptyMap();
    private static Logger logger = LoggerFactory.getLogger(QuartzJobManager.class);

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Class<Job> getJobClass() {
        return jobClass;
    }

    public void setJobClass(Class<Job> jobClass) {
        this.jobClass = jobClass;
    }

    public Map getMetaMap() {
        return metaMap;
    }

    public void setMetaMap(Map metaMap) {
        this.metaMap = metaMap;
    }

    public void addJob(QuartzJobConfig job){
        try {
            init(job);
        } catch (SchedulerException e) {
            logger.error("添加Job异常"+job, e);
        }
    }

    public void addIfAbsent(QuartzJobConfig job) {
        try {
            init(job,false);
        } catch (SchedulerException e) {
            logger.error("添加Job异常"+job, e);
        }
    }

    public void updateJob(QuartzJobConfig job){
        try {
            init(job);
        } catch (SchedulerException e) {
            logger.error("更新Job异常"+job, e);
        }
    }

    public void removeJob(String id,String group){
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(id, group);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                return;
            }else{
                scheduler.deleteJob(JobKey.jobKey(id,group));
            }
        } catch (SchedulerException e) {
            logger.error("删除Job异常", e);
        }
    }

    public void shutdown(){
        try {
            scheduler.shutdown(true);
        } catch (SchedulerException e) {
            logger.error("shutdown error", e);
            try {
                scheduler.shutdown();
            } catch (SchedulerException e1) {
                logger.error("scheduler.shutdown", e1);
            }
        }
    }

    public void pauseJob(String id,String group){
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(id, group);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                return;
            }else{
                scheduler.pauseJob(JobKey.jobKey(id, group));
            }
        } catch (SchedulerException e) {
            logger.error("暂停Job异常", e);
        }
    }

    private void init(QuartzJobConfig job) throws SchedulerException {
        init(job, true);
    }

    private void init(QuartzJobConfig job,boolean updateIfExist) throws SchedulerException {
        assert job!=null;
        assert job.getId()!=null;
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getId(), job.getGroup());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        if(job.getStatus()== QuartzJobConfig.STATUS.VALID) {
            if (null == trigger) {
                JobDetail jobDetail = JobBuilder.newJob(jobClass)
                      .withIdentity(job.getId(), job.getGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", job);
                jobDetail.getJobDataMap().putAll(job.getDataMap());
                jobDetail.getJobDataMap().putAll(metaMap);
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                      .getExpression());
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getId(), job.getGroup()).withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else if(updateIfExist){
                JobDetail jobDetail = JobBuilder.newJob(jobClass)
                      .withIdentity(job.getId(), job.getGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", job);
                jobDetail.getJobDataMap().putAll(job.getDataMap());
                jobDetail.getJobDataMap().putAll(metaMap);
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                      .getExpression());
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getId(),
                      job.getGroup()).withSchedule(scheduleBuilder).build();
                scheduler.deleteJob(JobKey.jobKey(job.getId(), job.getGroup()));
                scheduler.scheduleJob(jobDetail,trigger);
            }
        }else if(job.getStatus()== QuartzJobConfig.STATUS.PAUSE){
            JobKey key = JobKey.jobKey(job.getId(),job.getGroup());
            scheduler.pauseJob(key);
        }else if(job.getStatus()== QuartzJobConfig.STATUS.DELETED){
            scheduler.deleteJob(JobKey.jobKey(job.getId(), job.getGroup()));
        }
    }
}
