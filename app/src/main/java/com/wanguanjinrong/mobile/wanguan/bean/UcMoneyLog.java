package com.wanguanjinrong.mobile.wanguan.bean;

import java.util.List;

/**
 * Created by A on 2016/8/31.
 */
public class UcMoneyLog extends BaseBean{
    /**
     * user_login_status : 1
     * item : [{"id":"7810","log_info":"债:Z-1100,转让金","log_time":"1472593409","log_admin_id":"0","log_user_id":"150","money":"80.00","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 13:43:29","money_format":"￥80.00","lock_money_format":"￥0.00"},{"id":"7811","log_info":"债:Z-1100,转让管理费","log_time":"1472593409","log_admin_id":"0","log_user_id":"150","money":"-0.80","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 13:43:29","money_format":"￥-0.80","lock_money_format":"￥0.00"},{"id":"7807","log_info":"债:Z-1098,转让金","log_time":"1472586618","log_admin_id":"0","log_user_id":"150","money":"45.00","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 11:50:18","money_format":"￥45.00","lock_money_format":"￥0.00"},{"id":"7808","log_info":"债:Z-1098,转让管理费","log_time":"1472586618","log_admin_id":"0","log_user_id":"150","money":"-0.45","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 11:50:18","money_format":"￥-0.45","lock_money_format":"￥0.00"},{"id":"7794","log_info":"[借款测试A02],招标成功","log_time":"1472585726","log_admin_id":"1","log_user_id":"0","money":"10000.00","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 11:35:26","money_format":"￥10,000.00","lock_money_format":"￥0.00"},{"id":"7795","log_info":"[借款测试A02],服务费","log_time":"1472585726","log_admin_id":"1","log_user_id":"0","money":"-300.00","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 11:35:26","money_format":"￥-300.00","lock_money_format":"￥0.00"},{"id":"7761","log_info":"[测试借款 A010001],招标成功","log_time":"1472583796","log_admin_id":"1","log_user_id":"0","money":"10000.00","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 11:03:16","money_format":"￥10,000.00","lock_money_format":"￥0.00"},{"id":"7762","log_info":"[测试借款 A010001],服务费","log_time":"1472583796","log_admin_id":"1","log_user_id":"0","money":"-300.00","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 11:03:16","money_format":"￥-300.00","lock_money_format":"￥0.00"},{"id":"7738","log_info":"[结婚贷款],投资返利","log_time":"1472581111","log_admin_id":"1","log_user_id":"0","money":"1.00","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 10:18:31","money_format":"￥1.00","lock_money_format":"￥0.00"},{"id":"7740","log_info":"[结婚贷款],投资返利","log_time":"1472581111","log_admin_id":"1","log_user_id":"0","money":"1.00","score":"0","point":"0","quota":"0.00","lock_money":"0.00","user_id":"150","log_time_format":"2016-08-31 10:18:31","money_format":"￥1.00","lock_money_format":"￥0.00"}]
     * page : {"page":1,"page_total":5,"page_size":"10"}
     * program_title : 操作日志
     * act_2 :
     */

    private String user_login_status;
    /**
     * page : 1
     * page_total : 5
     * page_size : 10
     */

    private PageBean page;
    /**
     * id : 7810
     * log_info : 债:Z-1100,转让金
     * log_time : 1472593409
     * log_admin_id : 0
     * log_user_id : 150
     * money : 80.00
     * score : 0
     * point : 0
     * quota : 0.00
     * lock_money : 0.00
     * user_id : 150
     * log_time_format : 2016-08-31 13:43:29
     * money_format : ￥80.00
     * lock_money_format : ￥0.00
     */

    private List<ItemBean> item;

    public String getUser_login_status() {
        return user_login_status;
    }

    public void setUser_login_status(String user_login_status) {
        this.user_login_status = user_login_status;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class PageBean {
        private int page;
        private int page_total;
        private String page_size;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPage_total() {
            return page_total;
        }

        public void setPage_total(int page_total) {
            this.page_total = page_total;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }
    }

    public static class ItemBean {
        private String id;
        private String log_info;
        private String log_time;
        private String log_admin_id;
        private String log_user_id;
        private String money;
        private String score;
        private String point;
        private String quota;
        private String lock_money;
        private String user_id;
        private String log_time_format;
        private String money_format;
        private String lock_money_format;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLog_info() {
            return log_info;
        }

        public void setLog_info(String log_info) {
            this.log_info = log_info;
        }

        public String getLog_time() {
            return log_time;
        }

        public void setLog_time(String log_time) {
            this.log_time = log_time;
        }

        public String getLog_admin_id() {
            return log_admin_id;
        }

        public void setLog_admin_id(String log_admin_id) {
            this.log_admin_id = log_admin_id;
        }

        public String getLog_user_id() {
            return log_user_id;
        }

        public void setLog_user_id(String log_user_id) {
            this.log_user_id = log_user_id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public String getQuota() {
            return quota;
        }

        public void setQuota(String quota) {
            this.quota = quota;
        }

        public String getLock_money() {
            return lock_money;
        }

        public void setLock_money(String lock_money) {
            this.lock_money = lock_money;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getLog_time_format() {
            return log_time_format;
        }

        public void setLog_time_format(String log_time_format) {
            this.log_time_format = log_time_format;
        }

        public String getMoney_format() {
            return money_format;
        }

        public void setMoney_format(String money_format) {
            this.money_format = money_format;
        }

        public String getLock_money_format() {
            return lock_money_format;
        }

        public void setLock_money_format(String lock_money_format) {
            this.lock_money_format = lock_money_format;
        }
    }
}
