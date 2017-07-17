package com.ww.quartz;

/**
 * Created by wurp on 17/5/25.
 */
public class JobStatusContext {
    /**
     * 初始化
     */
    public static final int INITION = 0;
    /**
     * 开始
     */
    public static final int START = 1;
    /**
     * success
     */
    public static final int SUCCESS = 2;
    /**
     * 邮件发送失败
     */
    public static final int SEND_MAIL_FAIL = 3;
    /**
     * FAIL
     */
    public static final int FAIL = 4;
}
