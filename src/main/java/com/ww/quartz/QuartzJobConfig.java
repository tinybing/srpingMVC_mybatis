package com.ww.quartz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wurp on 17/5/24.
 */
public class QuartzJobConfig {
    private String id;
    private String name;
    private String group;
    private String expression;
    private Map<String,Object> dataMap = new HashMap<String, Object>();
    public enum STATUS {VALID,PAUSE,DELETED};
    private STATUS status;

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuartzJobConfig{" +
              "id='" + id + '\'' +
              ", name='" + name + '\'' +
              ", group='" + group + '\'' +
              ", expression='" + expression + '\'' +
              ", dataMap=" + dataMap +
              ", status=" + status +
              '}';
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
