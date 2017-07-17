package com.ww.quartz;

import com.ww.dao.QuartzTaskDao;
import com.ww.model.Quartztask;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wurp on 17/5/24.
 */
@Service("jobService")
public class JobService implements InitializingBean {
    @Resource
    private QuartzTaskDao quartzTaskDao;

    @Resource
    private QuartzJobManager jobManager;

    public QuartzTaskDao getQuartzTaskDao() {
        return quartzTaskDao;
    }

    public void setQuartzTaskDao(QuartzTaskDao quartzTaskDao) {
        this.quartzTaskDao = quartzTaskDao;
    }

    public QuartzJobManager getJobManager() {
        return jobManager;
    }

    public void setJobManager(QuartzJobManager jobManager) {
        this.jobManager = jobManager;
    }

    /**
     * 任务转换  转换为可执行的quartz任务
     * @param config
     * @return
     */

    private QuartzJobConfig convert(Quartztask config){
        QuartzJobConfig job = new QuartzJobConfig();
        job.setId(config.getId());
        job.setName(config.getName());
        job.setExpression(config.getExpression());
        if(Integer.parseInt(config.getStatus())==1)
            job.setStatus(QuartzJobConfig.STATUS.VALID);
        else if(Integer.parseInt(config.getStatus())==0)
            job.setStatus(QuartzJobConfig.STATUS.PAUSE);
        else if(Integer.parseInt(config.getStatus())==-1)
            job.setStatus(QuartzJobConfig.STATUS.DELETED);
        job.setGroup(config.getGroupname());
        Map<String,Object> map = new HashMap<>();
        map.put("JobConfig",config);
        job.setDataMap(map);
        return  job;
    }

    /**
     * 获取指定的定时任务
     * @param id
     * @return
     */
    public Quartztask get(String id){
        return quartzTaskDao.selectByPrimaryKey(id);
    }

    /**
     * 获取全部的定时任务
     * @return
     */
    public List<Quartztask> getAll(){
        Quartztask model = new Quartztask();
        model.setStatus("1");
        Example example = new Example(Quartztask.class);
        example.createCriteria().andEqualTo("status","1");
        return quartzTaskDao.queryByExample(example);
    }

    /**
     * 清除已完成的任务状态
     */
    public void clearTimerJobStatus(){
        Quartztask config = new Quartztask();
        SimpleDateFormat fullStd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = fullStd.format(curDate);
        config.setUpdateat(str);
        config.setUpdateby("system");
        quartzTaskDao.updateByPKSelective(config);
    }


    public void enterTimerTask(Quartztask scheduleJob) {
        Quartztask timer = quartzTaskDao.selectByPrimaryKey(scheduleJob.getId());
        SimpleDateFormat fullStd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = fullStd.format(curDate);
        timer.setUpdateat(str);
        timer.setUpdateby("system");
        quartzTaskDao.updateByPK(timer);
    }

    /**
     * 新增定时任务(可动态添加的方法)
     */
    public void save(){
        List<Quartztask> list = getAll();
        for(Quartztask job:list){
            jobManager.addIfAbsent(convert(job));
        }
    }

    /**
     * 更新定时任务
     * @param config
     */
    public void update(Quartztask config){
        jobManager.updateJob(convert(config));
    }

    /**
     * 删除定时任务
     * @param config
     */
    public void remove(Quartztask config){
        jobManager.removeJob(config.getId() + "", null);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<Quartztask> list = getAll();

        System.out.println( "afterPropertiesSet: list.size: "+list.size());
        for(Quartztask job:list){
            jobManager.addJob(convert(job));
        }
    }



}
