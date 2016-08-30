package com.wanguanjinrong.mobile.wanguan.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by A on 2016/8/30.
 */
public class Transfer extends BaseBean{
    /**
     * page : 1
     * page_total : 1
     * page_size : 10
     */

    private PageBean page;
    /**
     * id : 138
     * deal_id : 20596
     * load_id : 1097
     * user_id : 150
     * transfer_amount : 1000.00
     * load_money : 1000.00
     * last_repay_time : 0
     * near_repay_time : 1472371200
     * transfer_number : 3
     * t_user_id : 0
     * transfer_time : 0
     * create_time : 1472493507
     * status : 1
     * callback_count : 0
     * lock_user_id : 0
     * lock_time : 0
     * ips_status : 0
     * ips_bill_no : null
     * pMerBillNo : null
     * create_date : 2016-08-30
     * transfer_date : 0000-00-00
     * loantype : 0
     * name : 医疗支出
     * icon :
     * cate_id : 4
     * duser_id : 105
     * rate : 10.00
     * repay_start_time : 1472371200
     * repay_time : 3
     * repay_time_type : 1
     * duser : {"id":"105","user_name":"zhangyalin","hehuo":"0","user_pwd":"5e81d2967d89d04f762fa5a304d0f183","create_time":"1465842401","update_time":"1465842401","login_ip":"111.15.95.15","group_id":"1","is_effect":"1","is_delete":"0","email":"","idno":"","idcardpassed":"0","idcardpassed_time":"0","real_name":"","mobile":"13081627139","mobilepassed":"1","score":"0","money":"0.00","tc_money":"0","huoqi_lock":"0.00","huoqi_money":"0.00","huoqi_cz":"0","huoqi_shouyi":"0.00","quota":"0","lock_money":"0.00","verify":"","code":"","pid":"44","referer_memo":"李廷","login_time":"1465842401","referral_count":"0","passwowg_verify":"","integrate_id":"0","sina_id":"0","renren_id":"0","kaixin_id":"0","sohu_id":"0","bind_verify":"","verify_create_time":"0","tencent_id":"","referer":"","login_pay_time":"0","focus_count":"0","focused_count":"0","n_province_id":"0","n_city_id":"0","province_id":"0","city_id":"0","sex":"-1","step":"0","byear":"0","bmonth":"0","bday":"0","graduation":"","graduatedyear":"0","university":"","edu_validcode":"","has_send_video":"0","marriage":"","haschild":"0","hashouse":"0","houseloan":"0","hascar":"0","carloan":"0","car_brand":"","car_year":"0","car_number":"","address":"","phone":"","postcode":"","locate_time":"0","xpoint":"0.000000","ypoint":"0.000000","topic_count":"0","fav_count":"0","faved_count":"0","insite_count":"","outsite_count":"0","level_id":"2","point":"0","sina_app_key":"","sina_app_secret":"","is_syn_sina":"0","tencent_app_key":"","tencent_app_secret":"","is_syn_tencent":"0","t_access_token":"","t_openkey":"","t_openid":"","sina_token":"","is_borrow_out":"0","is_borrow_int":"0","creditpassed":"0","creditpassed_time":"0","workpassed":"0","workpassed_time":"0","incomepassed":"0","incomepassed_time":"0","housepassed":"0","housepassed_time":"0","carpassed":"0","carpassed_time":"0","marrypassed":"0","marrypassed_time":"0","edupassed":"0","edupassed_time":"0","skillpassed":"0","skillpassed_time":"0","videopassed":"0","videopassed_time":"0","mobiletruepassed":"0","mobiletruepassed_time":"0","residencepassed":"0","residencepassed_time":"0","alipay_id":"","qq_id":"","info_down":"","sealpassed":"0","paypassword":"","apns_code":null,"emailpassed":"0","tmp_email":"","view_info":"","ips_acct_no":null,"referral_rate":"0.00","user_type":"0","create_date":"0000-00-00","register_ip":"111.15.95.15","eacctno":"","import":"0","edit_pass":"0","soleId":"","is_first":"0","wx_username":null,"wxyh_type":null,"yhq_money":null,"yhq_shouyi":null,"yhq_lock":"0.00","cwdz":null,"reg_channel":null,"point_level":"E","url":"/index.php?ctl=space&id=105","workinfo":false}
     * user : {"id":"150","user_name":"alex01","hehuo":"0","user_pwd":"96e79218965eb72c92a549dd5a330112","create_time":"1471320128","update_time":"1472405819","login_ip":"112.237.70.116","group_id":"1","is_effect":"1","is_delete":"0","email":"sfsf@126.com","idno":"370686198910241317","idcardpassed":"0","idcardpassed_time":"0","real_name":"\u2018哈哈","mobile":"13235375178","mobilepassed":"1","score":"321","money":"100000.00","tc_money":"0","huoqi_lock":"0.00","huoqi_money":"0.00","huoqi_cz":"0","huoqi_shouyi":"0.00","quota":"0","lock_money":"61500.00","verify":"","code":"","pid":"113","referer_memo":"","login_time":"1472518473","referral_count":"0","passwowg_verify":"","integrate_id":"0","sina_id":"0","renren_id":"0","kaixin_id":"0","sohu_id":"0","bind_verify":"","verify_create_time":"0","tencent_id":"","referer":"微信客户注册","login_pay_time":"0","focus_count":"0","focused_count":"0","n_province_id":"0","n_city_id":"0","province_id":"0","city_id":"0","sex":"0","step":"0","byear":"0","bmonth":"0","bday":"0","graduation":"","graduatedyear":"2016","university":"","edu_validcode":"","has_send_video":"0","marriage":"","haschild":"0","hashouse":"0","houseloan":"0","hascar":"0","carloan":"0","car_brand":"","car_year":"0","car_number":"","address":"","phone":"","postcode":"","locate_time":"1472515978","xpoint":"0.000000","ypoint":"0.000000","topic_count":"0","fav_count":"0","faved_count":"0","insite_count":"","outsite_count":"0","level_id":"3","point":"100","sina_app_key":"","sina_app_secret":"","is_syn_sina":"0","tencent_app_key":"","tencent_app_secret":"","is_syn_tencent":"0","t_access_token":"","t_openkey":"","t_openid":"","sina_token":"","is_borrow_out":"1","is_borrow_int":"0","creditpassed":"0","creditpassed_time":"0","workpassed":"0","workpassed_time":"0","incomepassed":"0","incomepassed_time":"0","housepassed":"0","housepassed_time":"0","carpassed":"0","carpassed_time":"0","marrypassed":"0","marrypassed_time":"0","edupassed":"0","edupassed_time":"0","skillpassed":"0","skillpassed_time":"0","videopassed":"0","videopassed_time":"0","mobiletruepassed":"0","mobiletruepassed_time":"0","residencepassed":"0","residencepassed_time":"0","alipay_id":"","qq_id":"","info_down":"","sealpassed":"0","paypassword":"96e79218965eb72c92a549dd5a330112","apns_code":null,"emailpassed":"0","tmp_email":"","view_info":"","ips_acct_no":null,"referral_rate":"0.00","user_type":"2","create_date":"0000-00-00","register_ip":"","eacctno":"","import":"0","edit_pass":"0","soleId":"","is_first":"0","wx_username":null,"wxyh_type":null,"yhq_money":null,"yhq_shouyi":null,"yhq_lock":null,"cwdz":null,"reg_channel":null,"point_level":"D","url":"/index.php?ctl=space&id=150","workinfo":false}
     * tuser : null
     * url : /index.php?ctl=transfer&act=detail&id=138
     * app_url : http://192.168.0.167/wap/index.php?ctl=transfer_mobile&is_sj=1&id=20596&transfer_id=138
     * final_repay_time : 1480320000
     * final_repay_time_format : 2016-11-29
     * how_much_month : 3
     * cate_info : {"id":"4","name":"年年万贯","brief":"","uname":"","icon":"./public/attachment/201212/25/10/50d90ba803a9d.jpg"}
     * month_repay_money : 338.90425686585
     * all_must_repay_money : 1016.7127705976
     * left_benjin : 1000.00
     * left_benjin_format : ￥0.10万
     * left_lixi : 16.712770597558
     * left_lixi_format : ￥16.71
     * remain_time : 2616260
     * remain_time_format : 30天6时44分
     * near_repay_time_format : 2016-08-29
     * transfer_amount_format : ￥0.10万
     * transfer_income : 16.712770597558
     * transfer_income_format : ￥16.71
     * transfer_time_format :
     */

    private List<ItemBean> item;

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
        private String deal_id;
        private String load_id;
        private String user_id;
        private String transfer_amount;
        private String load_money;
        private String last_repay_time;
        private String near_repay_time;
        private String transfer_number;
        private String t_user_id;
        private String transfer_time;
        private String create_time;
        private String status;
        private String callback_count;
        private String lock_user_id;
        private String lock_time;
        private String ips_status;
        private Object ips_bill_no;
        private Object pMerBillNo;
        private String create_date;
        private String transfer_date;
        private String loantype;
        private String name;
        private String icon;
        private String cate_id;
        private String duser_id;
        private String rate;
        private String repay_start_time;
        private String repay_time;
        private String repay_time_type;
        /**
         * id : 105
         * user_name : zhangyalin
         * hehuo : 0
         * user_pwd : 5e81d2967d89d04f762fa5a304d0f183
         * create_time : 1465842401
         * update_time : 1465842401
         * login_ip : 111.15.95.15
         * group_id : 1
         * is_effect : 1
         * is_delete : 0
         * email :
         * idno :
         * idcardpassed : 0
         * idcardpassed_time : 0
         * real_name :
         * mobile : 13081627139
         * mobilepassed : 1
         * score : 0
         * money : 0.00
         * tc_money : 0
         * huoqi_lock : 0.00
         * huoqi_money : 0.00
         * huoqi_cz : 0
         * huoqi_shouyi : 0.00
         * quota : 0
         * lock_money : 0.00
         * verify :
         * code :
         * pid : 44
         * referer_memo : 李廷
         * login_time : 1465842401
         * referral_count : 0
         * passwowg_verify :
         * integrate_id : 0
         * sina_id : 0
         * renren_id : 0
         * kaixin_id : 0
         * sohu_id : 0
         * bind_verify :
         * verify_create_time : 0
         * tencent_id :
         * referer :
         * login_pay_time : 0
         * focus_count : 0
         * focused_count : 0
         * n_province_id : 0
         * n_city_id : 0
         * province_id : 0
         * city_id : 0
         * sex : -1
         * step : 0
         * byear : 0
         * bmonth : 0
         * bday : 0
         * graduation :
         * graduatedyear : 0
         * university :
         * edu_validcode :
         * has_send_video : 0
         * marriage :
         * haschild : 0
         * hashouse : 0
         * houseloan : 0
         * hascar : 0
         * carloan : 0
         * car_brand :
         * car_year : 0
         * car_number :
         * address :
         * phone :
         * postcode :
         * locate_time : 0
         * xpoint : 0.000000
         * ypoint : 0.000000
         * topic_count : 0
         * fav_count : 0
         * faved_count : 0
         * insite_count :
         * outsite_count : 0
         * level_id : 2
         * point : 0
         * sina_app_key :
         * sina_app_secret :
         * is_syn_sina : 0
         * tencent_app_key :
         * tencent_app_secret :
         * is_syn_tencent : 0
         * t_access_token :
         * t_openkey :
         * t_openid :
         * sina_token :
         * is_borrow_out : 0
         * is_borrow_int : 0
         * creditpassed : 0
         * creditpassed_time : 0
         * workpassed : 0
         * workpassed_time : 0
         * incomepassed : 0
         * incomepassed_time : 0
         * housepassed : 0
         * housepassed_time : 0
         * carpassed : 0
         * carpassed_time : 0
         * marrypassed : 0
         * marrypassed_time : 0
         * edupassed : 0
         * edupassed_time : 0
         * skillpassed : 0
         * skillpassed_time : 0
         * videopassed : 0
         * videopassed_time : 0
         * mobiletruepassed : 0
         * mobiletruepassed_time : 0
         * residencepassed : 0
         * residencepassed_time : 0
         * alipay_id :
         * qq_id :
         * info_down :
         * sealpassed : 0
         * paypassword :
         * apns_code : null
         * emailpassed : 0
         * tmp_email :
         * view_info :
         * ips_acct_no : null
         * referral_rate : 0.00
         * user_type : 0
         * create_date : 0000-00-00
         * register_ip : 111.15.95.15
         * eacctno :
         * import : 0
         * edit_pass : 0
         * soleId :
         * is_first : 0
         * wx_username : null
         * wxyh_type : null
         * yhq_money : null
         * yhq_shouyi : null
         * yhq_lock : 0.00
         * cwdz : null
         * reg_channel : null
         * point_level : E
         * url : /index.php?ctl=space&id=105
         * workinfo : false
         */

        private DuserBean duser;
        /**
         * id : 150
         * user_name : alex01
         * hehuo : 0
         * user_pwd : 96e79218965eb72c92a549dd5a330112
         * create_time : 1471320128
         * update_time : 1472405819
         * login_ip : 112.237.70.116
         * group_id : 1
         * is_effect : 1
         * is_delete : 0
         * email : sfsf@126.com
         * idno : 370686198910241317
         * idcardpassed : 0
         * idcardpassed_time : 0
         * real_name : ‘哈哈
         * mobile : 13235375178
         * mobilepassed : 1
         * score : 321
         * money : 100000.00
         * tc_money : 0
         * huoqi_lock : 0.00
         * huoqi_money : 0.00
         * huoqi_cz : 0
         * huoqi_shouyi : 0.00
         * quota : 0
         * lock_money : 61500.00
         * verify :
         * code :
         * pid : 113
         * referer_memo :
         * login_time : 1472518473
         * referral_count : 0
         * passwowg_verify :
         * integrate_id : 0
         * sina_id : 0
         * renren_id : 0
         * kaixin_id : 0
         * sohu_id : 0
         * bind_verify :
         * verify_create_time : 0
         * tencent_id :
         * referer : 微信客户注册
         * login_pay_time : 0
         * focus_count : 0
         * focused_count : 0
         * n_province_id : 0
         * n_city_id : 0
         * province_id : 0
         * city_id : 0
         * sex : 0
         * step : 0
         * byear : 0
         * bmonth : 0
         * bday : 0
         * graduation :
         * graduatedyear : 2016
         * university :
         * edu_validcode :
         * has_send_video : 0
         * marriage :
         * haschild : 0
         * hashouse : 0
         * houseloan : 0
         * hascar : 0
         * carloan : 0
         * car_brand :
         * car_year : 0
         * car_number :
         * address :
         * phone :
         * postcode :
         * locate_time : 1472515978
         * xpoint : 0.000000
         * ypoint : 0.000000
         * topic_count : 0
         * fav_count : 0
         * faved_count : 0
         * insite_count :
         * outsite_count : 0
         * level_id : 3
         * point : 100
         * sina_app_key :
         * sina_app_secret :
         * is_syn_sina : 0
         * tencent_app_key :
         * tencent_app_secret :
         * is_syn_tencent : 0
         * t_access_token :
         * t_openkey :
         * t_openid :
         * sina_token :
         * is_borrow_out : 1
         * is_borrow_int : 0
         * creditpassed : 0
         * creditpassed_time : 0
         * workpassed : 0
         * workpassed_time : 0
         * incomepassed : 0
         * incomepassed_time : 0
         * housepassed : 0
         * housepassed_time : 0
         * carpassed : 0
         * carpassed_time : 0
         * marrypassed : 0
         * marrypassed_time : 0
         * edupassed : 0
         * edupassed_time : 0
         * skillpassed : 0
         * skillpassed_time : 0
         * videopassed : 0
         * videopassed_time : 0
         * mobiletruepassed : 0
         * mobiletruepassed_time : 0
         * residencepassed : 0
         * residencepassed_time : 0
         * alipay_id :
         * qq_id :
         * info_down :
         * sealpassed : 0
         * paypassword : 96e79218965eb72c92a549dd5a330112
         * apns_code : null
         * emailpassed : 0
         * tmp_email :
         * view_info :
         * ips_acct_no : null
         * referral_rate : 0.00
         * user_type : 2
         * create_date : 0000-00-00
         * register_ip :
         * eacctno :
         * import : 0
         * edit_pass : 0
         * soleId :
         * is_first : 0
         * wx_username : null
         * wxyh_type : null
         * yhq_money : null
         * yhq_shouyi : null
         * yhq_lock : null
         * cwdz : null
         * reg_channel : null
         * point_level : D
         * url : /index.php?ctl=space&id=150
         * workinfo : false
         */

        private UserBean user;
        private Object tuser;
        private String url;
        private String app_url;
        private int final_repay_time;
        private String final_repay_time_format;
        private int how_much_month;
        /**
         * id : 4
         * name : 年年万贯
         * brief :
         * uname :
         * icon : ./public/attachment/201212/25/10/50d90ba803a9d.jpg
         */

        private CateInfoBean cate_info;
        private double month_repay_money;
        private double all_must_repay_money;
        private String left_benjin;
        private String left_benjin_format;
        private double left_lixi;
        private String left_lixi_format;
        private int remain_time;
        private String remain_time_format;
        private String near_repay_time_format;
        private String transfer_amount_format;
        private double transfer_income;
        private String transfer_income_format;
        private String transfer_time_format;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDeal_id() {
            return deal_id;
        }

        public void setDeal_id(String deal_id) {
            this.deal_id = deal_id;
        }

        public String getLoad_id() {
            return load_id;
        }

        public void setLoad_id(String load_id) {
            this.load_id = load_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getTransfer_amount() {
            return transfer_amount;
        }

        public void setTransfer_amount(String transfer_amount) {
            this.transfer_amount = transfer_amount;
        }

        public String getLoad_money() {
            return load_money;
        }

        public void setLoad_money(String load_money) {
            this.load_money = load_money;
        }

        public String getLast_repay_time() {
            return last_repay_time;
        }

        public void setLast_repay_time(String last_repay_time) {
            this.last_repay_time = last_repay_time;
        }

        public String getNear_repay_time() {
            return near_repay_time;
        }

        public void setNear_repay_time(String near_repay_time) {
            this.near_repay_time = near_repay_time;
        }

        public String getTransfer_number() {
            return transfer_number;
        }

        public void setTransfer_number(String transfer_number) {
            this.transfer_number = transfer_number;
        }

        public String getT_user_id() {
            return t_user_id;
        }

        public void setT_user_id(String t_user_id) {
            this.t_user_id = t_user_id;
        }

        public String getTransfer_time() {
            return transfer_time;
        }

        public void setTransfer_time(String transfer_time) {
            this.transfer_time = transfer_time;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCallback_count() {
            return callback_count;
        }

        public void setCallback_count(String callback_count) {
            this.callback_count = callback_count;
        }

        public String getLock_user_id() {
            return lock_user_id;
        }

        public void setLock_user_id(String lock_user_id) {
            this.lock_user_id = lock_user_id;
        }

        public String getLock_time() {
            return lock_time;
        }

        public void setLock_time(String lock_time) {
            this.lock_time = lock_time;
        }

        public String getIps_status() {
            return ips_status;
        }

        public void setIps_status(String ips_status) {
            this.ips_status = ips_status;
        }

        public Object getIps_bill_no() {
            return ips_bill_no;
        }

        public void setIps_bill_no(Object ips_bill_no) {
            this.ips_bill_no = ips_bill_no;
        }

        public Object getPMerBillNo() {
            return pMerBillNo;
        }

        public void setPMerBillNo(Object pMerBillNo) {
            this.pMerBillNo = pMerBillNo;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        public String getTransfer_date() {
            return transfer_date;
        }

        public void setTransfer_date(String transfer_date) {
            this.transfer_date = transfer_date;
        }

        public String getLoantype() {
            return loantype;
        }

        public void setLoantype(String loantype) {
            this.loantype = loantype;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getDuser_id() {
            return duser_id;
        }

        public void setDuser_id(String duser_id) {
            this.duser_id = duser_id;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getRepay_start_time() {
            return repay_start_time;
        }

        public void setRepay_start_time(String repay_start_time) {
            this.repay_start_time = repay_start_time;
        }

        public String getRepay_time() {
            return repay_time;
        }

        public void setRepay_time(String repay_time) {
            this.repay_time = repay_time;
        }

        public String getRepay_time_type() {
            return repay_time_type;
        }

        public void setRepay_time_type(String repay_time_type) {
            this.repay_time_type = repay_time_type;
        }

        public DuserBean getDuser() {
            return duser;
        }

        public void setDuser(DuserBean duser) {
            this.duser = duser;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public Object getTuser() {
            return tuser;
        }

        public void setTuser(Object tuser) {
            this.tuser = tuser;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public int getFinal_repay_time() {
            return final_repay_time;
        }

        public void setFinal_repay_time(int final_repay_time) {
            this.final_repay_time = final_repay_time;
        }

        public String getFinal_repay_time_format() {
            return final_repay_time_format;
        }

        public void setFinal_repay_time_format(String final_repay_time_format) {
            this.final_repay_time_format = final_repay_time_format;
        }

        public int getHow_much_month() {
            return how_much_month;
        }

        public void setHow_much_month(int how_much_month) {
            this.how_much_month = how_much_month;
        }

        public CateInfoBean getCate_info() {
            return cate_info;
        }

        public void setCate_info(CateInfoBean cate_info) {
            this.cate_info = cate_info;
        }

        public double getMonth_repay_money() {
            return month_repay_money;
        }

        public void setMonth_repay_money(double month_repay_money) {
            this.month_repay_money = month_repay_money;
        }

        public double getAll_must_repay_money() {
            return all_must_repay_money;
        }

        public void setAll_must_repay_money(double all_must_repay_money) {
            this.all_must_repay_money = all_must_repay_money;
        }

        public String getLeft_benjin() {
            return left_benjin;
        }

        public void setLeft_benjin(String left_benjin) {
            this.left_benjin = left_benjin;
        }

        public String getLeft_benjin_format() {
            return left_benjin_format;
        }

        public void setLeft_benjin_format(String left_benjin_format) {
            this.left_benjin_format = left_benjin_format;
        }

        public double getLeft_lixi() {
            return left_lixi;
        }

        public void setLeft_lixi(double left_lixi) {
            this.left_lixi = left_lixi;
        }

        public String getLeft_lixi_format() {
            return left_lixi_format;
        }

        public void setLeft_lixi_format(String left_lixi_format) {
            this.left_lixi_format = left_lixi_format;
        }

        public int getRemain_time() {
            return remain_time;
        }

        public void setRemain_time(int remain_time) {
            this.remain_time = remain_time;
        }

        public String getRemain_time_format() {
            return remain_time_format;
        }

        public void setRemain_time_format(String remain_time_format) {
            this.remain_time_format = remain_time_format;
        }

        public String getNear_repay_time_format() {
            return near_repay_time_format;
        }

        public void setNear_repay_time_format(String near_repay_time_format) {
            this.near_repay_time_format = near_repay_time_format;
        }

        public String getTransfer_amount_format() {
            return transfer_amount_format;
        }

        public void setTransfer_amount_format(String transfer_amount_format) {
            this.transfer_amount_format = transfer_amount_format;
        }

        public double getTransfer_income() {
            return transfer_income;
        }

        public void setTransfer_income(double transfer_income) {
            this.transfer_income = transfer_income;
        }

        public String getTransfer_income_format() {
            return transfer_income_format;
        }

        public void setTransfer_income_format(String transfer_income_format) {
            this.transfer_income_format = transfer_income_format;
        }

        public String getTransfer_time_format() {
            return transfer_time_format;
        }

        public void setTransfer_time_format(String transfer_time_format) {
            this.transfer_time_format = transfer_time_format;
        }

        public static class DuserBean {
            private String id;
            private String user_name;
            private String hehuo;
            private String user_pwd;
            private String create_time;
            private String update_time;
            private String login_ip;
            private String group_id;
            private String is_effect;
            private String is_delete;
            private String email;
            private String idno;
            private String idcardpassed;
            private String idcardpassed_time;
            private String real_name;
            private String mobile;
            private String mobilepassed;
            private String score;
            private String money;
            private String tc_money;
            private String huoqi_lock;
            private String huoqi_money;
            private String huoqi_cz;
            private String huoqi_shouyi;
            private String quota;
            private String lock_money;
            private String verify;
            private String code;
            private String pid;
            private String referer_memo;
            private String login_time;
            private String referral_count;
            private String passwowg_verify;
            private String integrate_id;
            private String sina_id;
            private String renren_id;
            private String kaixin_id;
            private String sohu_id;
            private String bind_verify;
            private String verify_create_time;
            private String tencent_id;
            private String referer;
            private String login_pay_time;
            private String focus_count;
            private String focused_count;
            private String n_province_id;
            private String n_city_id;
            private String province_id;
            private String city_id;
            private String sex;
            private String step;
            private String byear;
            private String bmonth;
            private String bday;
            private String graduation;
            private String graduatedyear;
            private String university;
            private String edu_validcode;
            private String has_send_video;
            private String marriage;
            private String haschild;
            private String hashouse;
            private String houseloan;
            private String hascar;
            private String carloan;
            private String car_brand;
            private String car_year;
            private String car_number;
            private String address;
            private String phone;
            private String postcode;
            private String locate_time;
            private String xpoint;
            private String ypoint;
            private String topic_count;
            private String fav_count;
            private String faved_count;
            private String insite_count;
            private String outsite_count;
            private String level_id;
            private String point;
            private String sina_app_key;
            private String sina_app_secret;
            private String is_syn_sina;
            private String tencent_app_key;
            private String tencent_app_secret;
            private String is_syn_tencent;
            private String t_access_token;
            private String t_openkey;
            private String t_openid;
            private String sina_token;
            private String is_borrow_out;
            private String is_borrow_int;
            private String creditpassed;
            private String creditpassed_time;
            private String workpassed;
            private String workpassed_time;
            private String incomepassed;
            private String incomepassed_time;
            private String housepassed;
            private String housepassed_time;
            private String carpassed;
            private String carpassed_time;
            private String marrypassed;
            private String marrypassed_time;
            private String edupassed;
            private String edupassed_time;
            private String skillpassed;
            private String skillpassed_time;
            private String videopassed;
            private String videopassed_time;
            private String mobiletruepassed;
            private String mobiletruepassed_time;
            private String residencepassed;
            private String residencepassed_time;
            private String alipay_id;
            private String qq_id;
            private String info_down;
            private String sealpassed;
            private String paypassword;
            private Object apns_code;
            private String emailpassed;
            private String tmp_email;
            private String view_info;
            private Object ips_acct_no;
            private String referral_rate;
            private String user_type;
            private String create_date;
            private String register_ip;
            private String eacctno;
            @SerializedName("import")
            private String importX;
            private String edit_pass;
            private String soleId;
            private String is_first;
            private Object wx_username;
            private Object wxyh_type;
            private Object yhq_money;
            private Object yhq_shouyi;
            private String yhq_lock;
            private Object cwdz;
            private Object reg_channel;
            private String point_level;
            private String url;
            private boolean workinfo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getHehuo() {
                return hehuo;
            }

            public void setHehuo(String hehuo) {
                this.hehuo = hehuo;
            }

            public String getUser_pwd() {
                return user_pwd;
            }

            public void setUser_pwd(String user_pwd) {
                this.user_pwd = user_pwd;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getLogin_ip() {
                return login_ip;
            }

            public void setLogin_ip(String login_ip) {
                this.login_ip = login_ip;
            }

            public String getGroup_id() {
                return group_id;
            }

            public void setGroup_id(String group_id) {
                this.group_id = group_id;
            }

            public String getIs_effect() {
                return is_effect;
            }

            public void setIs_effect(String is_effect) {
                this.is_effect = is_effect;
            }

            public String getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(String is_delete) {
                this.is_delete = is_delete;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getIdno() {
                return idno;
            }

            public void setIdno(String idno) {
                this.idno = idno;
            }

            public String getIdcardpassed() {
                return idcardpassed;
            }

            public void setIdcardpassed(String idcardpassed) {
                this.idcardpassed = idcardpassed;
            }

            public String getIdcardpassed_time() {
                return idcardpassed_time;
            }

            public void setIdcardpassed_time(String idcardpassed_time) {
                this.idcardpassed_time = idcardpassed_time;
            }

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMobilepassed() {
                return mobilepassed;
            }

            public void setMobilepassed(String mobilepassed) {
                this.mobilepassed = mobilepassed;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getTc_money() {
                return tc_money;
            }

            public void setTc_money(String tc_money) {
                this.tc_money = tc_money;
            }

            public String getHuoqi_lock() {
                return huoqi_lock;
            }

            public void setHuoqi_lock(String huoqi_lock) {
                this.huoqi_lock = huoqi_lock;
            }

            public String getHuoqi_money() {
                return huoqi_money;
            }

            public void setHuoqi_money(String huoqi_money) {
                this.huoqi_money = huoqi_money;
            }

            public String getHuoqi_cz() {
                return huoqi_cz;
            }

            public void setHuoqi_cz(String huoqi_cz) {
                this.huoqi_cz = huoqi_cz;
            }

            public String getHuoqi_shouyi() {
                return huoqi_shouyi;
            }

            public void setHuoqi_shouyi(String huoqi_shouyi) {
                this.huoqi_shouyi = huoqi_shouyi;
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

            public String getVerify() {
                return verify;
            }

            public void setVerify(String verify) {
                this.verify = verify;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getReferer_memo() {
                return referer_memo;
            }

            public void setReferer_memo(String referer_memo) {
                this.referer_memo = referer_memo;
            }

            public String getLogin_time() {
                return login_time;
            }

            public void setLogin_time(String login_time) {
                this.login_time = login_time;
            }

            public String getReferral_count() {
                return referral_count;
            }

            public void setReferral_count(String referral_count) {
                this.referral_count = referral_count;
            }

            public String getPasswowg_verify() {
                return passwowg_verify;
            }

            public void setPasswowg_verify(String passwowg_verify) {
                this.passwowg_verify = passwowg_verify;
            }

            public String getIntegrate_id() {
                return integrate_id;
            }

            public void setIntegrate_id(String integrate_id) {
                this.integrate_id = integrate_id;
            }

            public String getSina_id() {
                return sina_id;
            }

            public void setSina_id(String sina_id) {
                this.sina_id = sina_id;
            }

            public String getRenren_id() {
                return renren_id;
            }

            public void setRenren_id(String renren_id) {
                this.renren_id = renren_id;
            }

            public String getKaixin_id() {
                return kaixin_id;
            }

            public void setKaixin_id(String kaixin_id) {
                this.kaixin_id = kaixin_id;
            }

            public String getSohu_id() {
                return sohu_id;
            }

            public void setSohu_id(String sohu_id) {
                this.sohu_id = sohu_id;
            }

            public String getBind_verify() {
                return bind_verify;
            }

            public void setBind_verify(String bind_verify) {
                this.bind_verify = bind_verify;
            }

            public String getVerify_create_time() {
                return verify_create_time;
            }

            public void setVerify_create_time(String verify_create_time) {
                this.verify_create_time = verify_create_time;
            }

            public String getTencent_id() {
                return tencent_id;
            }

            public void setTencent_id(String tencent_id) {
                this.tencent_id = tencent_id;
            }

            public String getReferer() {
                return referer;
            }

            public void setReferer(String referer) {
                this.referer = referer;
            }

            public String getLogin_pay_time() {
                return login_pay_time;
            }

            public void setLogin_pay_time(String login_pay_time) {
                this.login_pay_time = login_pay_time;
            }

            public String getFocus_count() {
                return focus_count;
            }

            public void setFocus_count(String focus_count) {
                this.focus_count = focus_count;
            }

            public String getFocused_count() {
                return focused_count;
            }

            public void setFocused_count(String focused_count) {
                this.focused_count = focused_count;
            }

            public String getN_province_id() {
                return n_province_id;
            }

            public void setN_province_id(String n_province_id) {
                this.n_province_id = n_province_id;
            }

            public String getN_city_id() {
                return n_city_id;
            }

            public void setN_city_id(String n_city_id) {
                this.n_city_id = n_city_id;
            }

            public String getProvince_id() {
                return province_id;
            }

            public void setProvince_id(String province_id) {
                this.province_id = province_id;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getStep() {
                return step;
            }

            public void setStep(String step) {
                this.step = step;
            }

            public String getByear() {
                return byear;
            }

            public void setByear(String byear) {
                this.byear = byear;
            }

            public String getBmonth() {
                return bmonth;
            }

            public void setBmonth(String bmonth) {
                this.bmonth = bmonth;
            }

            public String getBday() {
                return bday;
            }

            public void setBday(String bday) {
                this.bday = bday;
            }

            public String getGraduation() {
                return graduation;
            }

            public void setGraduation(String graduation) {
                this.graduation = graduation;
            }

            public String getGraduatedyear() {
                return graduatedyear;
            }

            public void setGraduatedyear(String graduatedyear) {
                this.graduatedyear = graduatedyear;
            }

            public String getUniversity() {
                return university;
            }

            public void setUniversity(String university) {
                this.university = university;
            }

            public String getEdu_validcode() {
                return edu_validcode;
            }

            public void setEdu_validcode(String edu_validcode) {
                this.edu_validcode = edu_validcode;
            }

            public String getHas_send_video() {
                return has_send_video;
            }

            public void setHas_send_video(String has_send_video) {
                this.has_send_video = has_send_video;
            }

            public String getMarriage() {
                return marriage;
            }

            public void setMarriage(String marriage) {
                this.marriage = marriage;
            }

            public String getHaschild() {
                return haschild;
            }

            public void setHaschild(String haschild) {
                this.haschild = haschild;
            }

            public String getHashouse() {
                return hashouse;
            }

            public void setHashouse(String hashouse) {
                this.hashouse = hashouse;
            }

            public String getHouseloan() {
                return houseloan;
            }

            public void setHouseloan(String houseloan) {
                this.houseloan = houseloan;
            }

            public String getHascar() {
                return hascar;
            }

            public void setHascar(String hascar) {
                this.hascar = hascar;
            }

            public String getCarloan() {
                return carloan;
            }

            public void setCarloan(String carloan) {
                this.carloan = carloan;
            }

            public String getCar_brand() {
                return car_brand;
            }

            public void setCar_brand(String car_brand) {
                this.car_brand = car_brand;
            }

            public String getCar_year() {
                return car_year;
            }

            public void setCar_year(String car_year) {
                this.car_year = car_year;
            }

            public String getCar_number() {
                return car_number;
            }

            public void setCar_number(String car_number) {
                this.car_number = car_number;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public String getLocate_time() {
                return locate_time;
            }

            public void setLocate_time(String locate_time) {
                this.locate_time = locate_time;
            }

            public String getXpoint() {
                return xpoint;
            }

            public void setXpoint(String xpoint) {
                this.xpoint = xpoint;
            }

            public String getYpoint() {
                return ypoint;
            }

            public void setYpoint(String ypoint) {
                this.ypoint = ypoint;
            }

            public String getTopic_count() {
                return topic_count;
            }

            public void setTopic_count(String topic_count) {
                this.topic_count = topic_count;
            }

            public String getFav_count() {
                return fav_count;
            }

            public void setFav_count(String fav_count) {
                this.fav_count = fav_count;
            }

            public String getFaved_count() {
                return faved_count;
            }

            public void setFaved_count(String faved_count) {
                this.faved_count = faved_count;
            }

            public String getInsite_count() {
                return insite_count;
            }

            public void setInsite_count(String insite_count) {
                this.insite_count = insite_count;
            }

            public String getOutsite_count() {
                return outsite_count;
            }

            public void setOutsite_count(String outsite_count) {
                this.outsite_count = outsite_count;
            }

            public String getLevel_id() {
                return level_id;
            }

            public void setLevel_id(String level_id) {
                this.level_id = level_id;
            }

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public String getSina_app_key() {
                return sina_app_key;
            }

            public void setSina_app_key(String sina_app_key) {
                this.sina_app_key = sina_app_key;
            }

            public String getSina_app_secret() {
                return sina_app_secret;
            }

            public void setSina_app_secret(String sina_app_secret) {
                this.sina_app_secret = sina_app_secret;
            }

            public String getIs_syn_sina() {
                return is_syn_sina;
            }

            public void setIs_syn_sina(String is_syn_sina) {
                this.is_syn_sina = is_syn_sina;
            }

            public String getTencent_app_key() {
                return tencent_app_key;
            }

            public void setTencent_app_key(String tencent_app_key) {
                this.tencent_app_key = tencent_app_key;
            }

            public String getTencent_app_secret() {
                return tencent_app_secret;
            }

            public void setTencent_app_secret(String tencent_app_secret) {
                this.tencent_app_secret = tencent_app_secret;
            }

            public String getIs_syn_tencent() {
                return is_syn_tencent;
            }

            public void setIs_syn_tencent(String is_syn_tencent) {
                this.is_syn_tencent = is_syn_tencent;
            }

            public String getT_access_token() {
                return t_access_token;
            }

            public void setT_access_token(String t_access_token) {
                this.t_access_token = t_access_token;
            }

            public String getT_openkey() {
                return t_openkey;
            }

            public void setT_openkey(String t_openkey) {
                this.t_openkey = t_openkey;
            }

            public String getT_openid() {
                return t_openid;
            }

            public void setT_openid(String t_openid) {
                this.t_openid = t_openid;
            }

            public String getSina_token() {
                return sina_token;
            }

            public void setSina_token(String sina_token) {
                this.sina_token = sina_token;
            }

            public String getIs_borrow_out() {
                return is_borrow_out;
            }

            public void setIs_borrow_out(String is_borrow_out) {
                this.is_borrow_out = is_borrow_out;
            }

            public String getIs_borrow_int() {
                return is_borrow_int;
            }

            public void setIs_borrow_int(String is_borrow_int) {
                this.is_borrow_int = is_borrow_int;
            }

            public String getCreditpassed() {
                return creditpassed;
            }

            public void setCreditpassed(String creditpassed) {
                this.creditpassed = creditpassed;
            }

            public String getCreditpassed_time() {
                return creditpassed_time;
            }

            public void setCreditpassed_time(String creditpassed_time) {
                this.creditpassed_time = creditpassed_time;
            }

            public String getWorkpassed() {
                return workpassed;
            }

            public void setWorkpassed(String workpassed) {
                this.workpassed = workpassed;
            }

            public String getWorkpassed_time() {
                return workpassed_time;
            }

            public void setWorkpassed_time(String workpassed_time) {
                this.workpassed_time = workpassed_time;
            }

            public String getIncomepassed() {
                return incomepassed;
            }

            public void setIncomepassed(String incomepassed) {
                this.incomepassed = incomepassed;
            }

            public String getIncomepassed_time() {
                return incomepassed_time;
            }

            public void setIncomepassed_time(String incomepassed_time) {
                this.incomepassed_time = incomepassed_time;
            }

            public String getHousepassed() {
                return housepassed;
            }

            public void setHousepassed(String housepassed) {
                this.housepassed = housepassed;
            }

            public String getHousepassed_time() {
                return housepassed_time;
            }

            public void setHousepassed_time(String housepassed_time) {
                this.housepassed_time = housepassed_time;
            }

            public String getCarpassed() {
                return carpassed;
            }

            public void setCarpassed(String carpassed) {
                this.carpassed = carpassed;
            }

            public String getCarpassed_time() {
                return carpassed_time;
            }

            public void setCarpassed_time(String carpassed_time) {
                this.carpassed_time = carpassed_time;
            }

            public String getMarrypassed() {
                return marrypassed;
            }

            public void setMarrypassed(String marrypassed) {
                this.marrypassed = marrypassed;
            }

            public String getMarrypassed_time() {
                return marrypassed_time;
            }

            public void setMarrypassed_time(String marrypassed_time) {
                this.marrypassed_time = marrypassed_time;
            }

            public String getEdupassed() {
                return edupassed;
            }

            public void setEdupassed(String edupassed) {
                this.edupassed = edupassed;
            }

            public String getEdupassed_time() {
                return edupassed_time;
            }

            public void setEdupassed_time(String edupassed_time) {
                this.edupassed_time = edupassed_time;
            }

            public String getSkillpassed() {
                return skillpassed;
            }

            public void setSkillpassed(String skillpassed) {
                this.skillpassed = skillpassed;
            }

            public String getSkillpassed_time() {
                return skillpassed_time;
            }

            public void setSkillpassed_time(String skillpassed_time) {
                this.skillpassed_time = skillpassed_time;
            }

            public String getVideopassed() {
                return videopassed;
            }

            public void setVideopassed(String videopassed) {
                this.videopassed = videopassed;
            }

            public String getVideopassed_time() {
                return videopassed_time;
            }

            public void setVideopassed_time(String videopassed_time) {
                this.videopassed_time = videopassed_time;
            }

            public String getMobiletruepassed() {
                return mobiletruepassed;
            }

            public void setMobiletruepassed(String mobiletruepassed) {
                this.mobiletruepassed = mobiletruepassed;
            }

            public String getMobiletruepassed_time() {
                return mobiletruepassed_time;
            }

            public void setMobiletruepassed_time(String mobiletruepassed_time) {
                this.mobiletruepassed_time = mobiletruepassed_time;
            }

            public String getResidencepassed() {
                return residencepassed;
            }

            public void setResidencepassed(String residencepassed) {
                this.residencepassed = residencepassed;
            }

            public String getResidencepassed_time() {
                return residencepassed_time;
            }

            public void setResidencepassed_time(String residencepassed_time) {
                this.residencepassed_time = residencepassed_time;
            }

            public String getAlipay_id() {
                return alipay_id;
            }

            public void setAlipay_id(String alipay_id) {
                this.alipay_id = alipay_id;
            }

            public String getQq_id() {
                return qq_id;
            }

            public void setQq_id(String qq_id) {
                this.qq_id = qq_id;
            }

            public String getInfo_down() {
                return info_down;
            }

            public void setInfo_down(String info_down) {
                this.info_down = info_down;
            }

            public String getSealpassed() {
                return sealpassed;
            }

            public void setSealpassed(String sealpassed) {
                this.sealpassed = sealpassed;
            }

            public String getPaypassword() {
                return paypassword;
            }

            public void setPaypassword(String paypassword) {
                this.paypassword = paypassword;
            }

            public Object getApns_code() {
                return apns_code;
            }

            public void setApns_code(Object apns_code) {
                this.apns_code = apns_code;
            }

            public String getEmailpassed() {
                return emailpassed;
            }

            public void setEmailpassed(String emailpassed) {
                this.emailpassed = emailpassed;
            }

            public String getTmp_email() {
                return tmp_email;
            }

            public void setTmp_email(String tmp_email) {
                this.tmp_email = tmp_email;
            }

            public String getView_info() {
                return view_info;
            }

            public void setView_info(String view_info) {
                this.view_info = view_info;
            }

            public Object getIps_acct_no() {
                return ips_acct_no;
            }

            public void setIps_acct_no(Object ips_acct_no) {
                this.ips_acct_no = ips_acct_no;
            }

            public String getReferral_rate() {
                return referral_rate;
            }

            public void setReferral_rate(String referral_rate) {
                this.referral_rate = referral_rate;
            }

            public String getUser_type() {
                return user_type;
            }

            public void setUser_type(String user_type) {
                this.user_type = user_type;
            }

            public String getCreate_date() {
                return create_date;
            }

            public void setCreate_date(String create_date) {
                this.create_date = create_date;
            }

            public String getRegister_ip() {
                return register_ip;
            }

            public void setRegister_ip(String register_ip) {
                this.register_ip = register_ip;
            }

            public String getEacctno() {
                return eacctno;
            }

            public void setEacctno(String eacctno) {
                this.eacctno = eacctno;
            }

            public String getImportX() {
                return importX;
            }

            public void setImportX(String importX) {
                this.importX = importX;
            }

            public String getEdit_pass() {
                return edit_pass;
            }

            public void setEdit_pass(String edit_pass) {
                this.edit_pass = edit_pass;
            }

            public String getSoleId() {
                return soleId;
            }

            public void setSoleId(String soleId) {
                this.soleId = soleId;
            }

            public String getIs_first() {
                return is_first;
            }

            public void setIs_first(String is_first) {
                this.is_first = is_first;
            }

            public Object getWx_username() {
                return wx_username;
            }

            public void setWx_username(Object wx_username) {
                this.wx_username = wx_username;
            }

            public Object getWxyh_type() {
                return wxyh_type;
            }

            public void setWxyh_type(Object wxyh_type) {
                this.wxyh_type = wxyh_type;
            }

            public Object getYhq_money() {
                return yhq_money;
            }

            public void setYhq_money(Object yhq_money) {
                this.yhq_money = yhq_money;
            }

            public Object getYhq_shouyi() {
                return yhq_shouyi;
            }

            public void setYhq_shouyi(Object yhq_shouyi) {
                this.yhq_shouyi = yhq_shouyi;
            }

            public String getYhq_lock() {
                return yhq_lock;
            }

            public void setYhq_lock(String yhq_lock) {
                this.yhq_lock = yhq_lock;
            }

            public Object getCwdz() {
                return cwdz;
            }

            public void setCwdz(Object cwdz) {
                this.cwdz = cwdz;
            }

            public Object getReg_channel() {
                return reg_channel;
            }

            public void setReg_channel(Object reg_channel) {
                this.reg_channel = reg_channel;
            }

            public String getPoint_level() {
                return point_level;
            }

            public void setPoint_level(String point_level) {
                this.point_level = point_level;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isWorkinfo() {
                return workinfo;
            }

            public void setWorkinfo(boolean workinfo) {
                this.workinfo = workinfo;
            }
        }

        public static class UserBean {
            private String id;
            private String user_name;
            private String hehuo;
            private String user_pwd;
            private String create_time;
            private String update_time;
            private String login_ip;
            private String group_id;
            private String is_effect;
            private String is_delete;
            private String email;
            private String idno;
            private String idcardpassed;
            private String idcardpassed_time;
            private String real_name;
            private String mobile;
            private String mobilepassed;
            private String score;
            private String money;
            private String tc_money;
            private String huoqi_lock;
            private String huoqi_money;
            private String huoqi_cz;
            private String huoqi_shouyi;
            private String quota;
            private String lock_money;
            private String verify;
            private String code;
            private String pid;
            private String referer_memo;
            private String login_time;
            private String referral_count;
            private String passwowg_verify;
            private String integrate_id;
            private String sina_id;
            private String renren_id;
            private String kaixin_id;
            private String sohu_id;
            private String bind_verify;
            private String verify_create_time;
            private String tencent_id;
            private String referer;
            private String login_pay_time;
            private String focus_count;
            private String focused_count;
            private String n_province_id;
            private String n_city_id;
            private String province_id;
            private String city_id;
            private String sex;
            private String step;
            private String byear;
            private String bmonth;
            private String bday;
            private String graduation;
            private String graduatedyear;
            private String university;
            private String edu_validcode;
            private String has_send_video;
            private String marriage;
            private String haschild;
            private String hashouse;
            private String houseloan;
            private String hascar;
            private String carloan;
            private String car_brand;
            private String car_year;
            private String car_number;
            private String address;
            private String phone;
            private String postcode;
            private String locate_time;
            private String xpoint;
            private String ypoint;
            private String topic_count;
            private String fav_count;
            private String faved_count;
            private String insite_count;
            private String outsite_count;
            private String level_id;
            private String point;
            private String sina_app_key;
            private String sina_app_secret;
            private String is_syn_sina;
            private String tencent_app_key;
            private String tencent_app_secret;
            private String is_syn_tencent;
            private String t_access_token;
            private String t_openkey;
            private String t_openid;
            private String sina_token;
            private String is_borrow_out;
            private String is_borrow_int;
            private String creditpassed;
            private String creditpassed_time;
            private String workpassed;
            private String workpassed_time;
            private String incomepassed;
            private String incomepassed_time;
            private String housepassed;
            private String housepassed_time;
            private String carpassed;
            private String carpassed_time;
            private String marrypassed;
            private String marrypassed_time;
            private String edupassed;
            private String edupassed_time;
            private String skillpassed;
            private String skillpassed_time;
            private String videopassed;
            private String videopassed_time;
            private String mobiletruepassed;
            private String mobiletruepassed_time;
            private String residencepassed;
            private String residencepassed_time;
            private String alipay_id;
            private String qq_id;
            private String info_down;
            private String sealpassed;
            private String paypassword;
            private Object apns_code;
            private String emailpassed;
            private String tmp_email;
            private String view_info;
            private Object ips_acct_no;
            private String referral_rate;
            private String user_type;
            private String create_date;
            private String register_ip;
            private String eacctno;
            @SerializedName("import")
            private String importX;
            private String edit_pass;
            private String soleId;
            private String is_first;
            private Object wx_username;
            private Object wxyh_type;
            private Object yhq_money;
            private Object yhq_shouyi;
            private Object yhq_lock;
            private Object cwdz;
            private Object reg_channel;
            private String point_level;
            private String url;
            private boolean workinfo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getHehuo() {
                return hehuo;
            }

            public void setHehuo(String hehuo) {
                this.hehuo = hehuo;
            }

            public String getUser_pwd() {
                return user_pwd;
            }

            public void setUser_pwd(String user_pwd) {
                this.user_pwd = user_pwd;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getLogin_ip() {
                return login_ip;
            }

            public void setLogin_ip(String login_ip) {
                this.login_ip = login_ip;
            }

            public String getGroup_id() {
                return group_id;
            }

            public void setGroup_id(String group_id) {
                this.group_id = group_id;
            }

            public String getIs_effect() {
                return is_effect;
            }

            public void setIs_effect(String is_effect) {
                this.is_effect = is_effect;
            }

            public String getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(String is_delete) {
                this.is_delete = is_delete;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getIdno() {
                return idno;
            }

            public void setIdno(String idno) {
                this.idno = idno;
            }

            public String getIdcardpassed() {
                return idcardpassed;
            }

            public void setIdcardpassed(String idcardpassed) {
                this.idcardpassed = idcardpassed;
            }

            public String getIdcardpassed_time() {
                return idcardpassed_time;
            }

            public void setIdcardpassed_time(String idcardpassed_time) {
                this.idcardpassed_time = idcardpassed_time;
            }

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMobilepassed() {
                return mobilepassed;
            }

            public void setMobilepassed(String mobilepassed) {
                this.mobilepassed = mobilepassed;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getTc_money() {
                return tc_money;
            }

            public void setTc_money(String tc_money) {
                this.tc_money = tc_money;
            }

            public String getHuoqi_lock() {
                return huoqi_lock;
            }

            public void setHuoqi_lock(String huoqi_lock) {
                this.huoqi_lock = huoqi_lock;
            }

            public String getHuoqi_money() {
                return huoqi_money;
            }

            public void setHuoqi_money(String huoqi_money) {
                this.huoqi_money = huoqi_money;
            }

            public String getHuoqi_cz() {
                return huoqi_cz;
            }

            public void setHuoqi_cz(String huoqi_cz) {
                this.huoqi_cz = huoqi_cz;
            }

            public String getHuoqi_shouyi() {
                return huoqi_shouyi;
            }

            public void setHuoqi_shouyi(String huoqi_shouyi) {
                this.huoqi_shouyi = huoqi_shouyi;
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

            public String getVerify() {
                return verify;
            }

            public void setVerify(String verify) {
                this.verify = verify;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getReferer_memo() {
                return referer_memo;
            }

            public void setReferer_memo(String referer_memo) {
                this.referer_memo = referer_memo;
            }

            public String getLogin_time() {
                return login_time;
            }

            public void setLogin_time(String login_time) {
                this.login_time = login_time;
            }

            public String getReferral_count() {
                return referral_count;
            }

            public void setReferral_count(String referral_count) {
                this.referral_count = referral_count;
            }

            public String getPasswowg_verify() {
                return passwowg_verify;
            }

            public void setPasswowg_verify(String passwowg_verify) {
                this.passwowg_verify = passwowg_verify;
            }

            public String getIntegrate_id() {
                return integrate_id;
            }

            public void setIntegrate_id(String integrate_id) {
                this.integrate_id = integrate_id;
            }

            public String getSina_id() {
                return sina_id;
            }

            public void setSina_id(String sina_id) {
                this.sina_id = sina_id;
            }

            public String getRenren_id() {
                return renren_id;
            }

            public void setRenren_id(String renren_id) {
                this.renren_id = renren_id;
            }

            public String getKaixin_id() {
                return kaixin_id;
            }

            public void setKaixin_id(String kaixin_id) {
                this.kaixin_id = kaixin_id;
            }

            public String getSohu_id() {
                return sohu_id;
            }

            public void setSohu_id(String sohu_id) {
                this.sohu_id = sohu_id;
            }

            public String getBind_verify() {
                return bind_verify;
            }

            public void setBind_verify(String bind_verify) {
                this.bind_verify = bind_verify;
            }

            public String getVerify_create_time() {
                return verify_create_time;
            }

            public void setVerify_create_time(String verify_create_time) {
                this.verify_create_time = verify_create_time;
            }

            public String getTencent_id() {
                return tencent_id;
            }

            public void setTencent_id(String tencent_id) {
                this.tencent_id = tencent_id;
            }

            public String getReferer() {
                return referer;
            }

            public void setReferer(String referer) {
                this.referer = referer;
            }

            public String getLogin_pay_time() {
                return login_pay_time;
            }

            public void setLogin_pay_time(String login_pay_time) {
                this.login_pay_time = login_pay_time;
            }

            public String getFocus_count() {
                return focus_count;
            }

            public void setFocus_count(String focus_count) {
                this.focus_count = focus_count;
            }

            public String getFocused_count() {
                return focused_count;
            }

            public void setFocused_count(String focused_count) {
                this.focused_count = focused_count;
            }

            public String getN_province_id() {
                return n_province_id;
            }

            public void setN_province_id(String n_province_id) {
                this.n_province_id = n_province_id;
            }

            public String getN_city_id() {
                return n_city_id;
            }

            public void setN_city_id(String n_city_id) {
                this.n_city_id = n_city_id;
            }

            public String getProvince_id() {
                return province_id;
            }

            public void setProvince_id(String province_id) {
                this.province_id = province_id;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getStep() {
                return step;
            }

            public void setStep(String step) {
                this.step = step;
            }

            public String getByear() {
                return byear;
            }

            public void setByear(String byear) {
                this.byear = byear;
            }

            public String getBmonth() {
                return bmonth;
            }

            public void setBmonth(String bmonth) {
                this.bmonth = bmonth;
            }

            public String getBday() {
                return bday;
            }

            public void setBday(String bday) {
                this.bday = bday;
            }

            public String getGraduation() {
                return graduation;
            }

            public void setGraduation(String graduation) {
                this.graduation = graduation;
            }

            public String getGraduatedyear() {
                return graduatedyear;
            }

            public void setGraduatedyear(String graduatedyear) {
                this.graduatedyear = graduatedyear;
            }

            public String getUniversity() {
                return university;
            }

            public void setUniversity(String university) {
                this.university = university;
            }

            public String getEdu_validcode() {
                return edu_validcode;
            }

            public void setEdu_validcode(String edu_validcode) {
                this.edu_validcode = edu_validcode;
            }

            public String getHas_send_video() {
                return has_send_video;
            }

            public void setHas_send_video(String has_send_video) {
                this.has_send_video = has_send_video;
            }

            public String getMarriage() {
                return marriage;
            }

            public void setMarriage(String marriage) {
                this.marriage = marriage;
            }

            public String getHaschild() {
                return haschild;
            }

            public void setHaschild(String haschild) {
                this.haschild = haschild;
            }

            public String getHashouse() {
                return hashouse;
            }

            public void setHashouse(String hashouse) {
                this.hashouse = hashouse;
            }

            public String getHouseloan() {
                return houseloan;
            }

            public void setHouseloan(String houseloan) {
                this.houseloan = houseloan;
            }

            public String getHascar() {
                return hascar;
            }

            public void setHascar(String hascar) {
                this.hascar = hascar;
            }

            public String getCarloan() {
                return carloan;
            }

            public void setCarloan(String carloan) {
                this.carloan = carloan;
            }

            public String getCar_brand() {
                return car_brand;
            }

            public void setCar_brand(String car_brand) {
                this.car_brand = car_brand;
            }

            public String getCar_year() {
                return car_year;
            }

            public void setCar_year(String car_year) {
                this.car_year = car_year;
            }

            public String getCar_number() {
                return car_number;
            }

            public void setCar_number(String car_number) {
                this.car_number = car_number;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public String getLocate_time() {
                return locate_time;
            }

            public void setLocate_time(String locate_time) {
                this.locate_time = locate_time;
            }

            public String getXpoint() {
                return xpoint;
            }

            public void setXpoint(String xpoint) {
                this.xpoint = xpoint;
            }

            public String getYpoint() {
                return ypoint;
            }

            public void setYpoint(String ypoint) {
                this.ypoint = ypoint;
            }

            public String getTopic_count() {
                return topic_count;
            }

            public void setTopic_count(String topic_count) {
                this.topic_count = topic_count;
            }

            public String getFav_count() {
                return fav_count;
            }

            public void setFav_count(String fav_count) {
                this.fav_count = fav_count;
            }

            public String getFaved_count() {
                return faved_count;
            }

            public void setFaved_count(String faved_count) {
                this.faved_count = faved_count;
            }

            public String getInsite_count() {
                return insite_count;
            }

            public void setInsite_count(String insite_count) {
                this.insite_count = insite_count;
            }

            public String getOutsite_count() {
                return outsite_count;
            }

            public void setOutsite_count(String outsite_count) {
                this.outsite_count = outsite_count;
            }

            public String getLevel_id() {
                return level_id;
            }

            public void setLevel_id(String level_id) {
                this.level_id = level_id;
            }

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public String getSina_app_key() {
                return sina_app_key;
            }

            public void setSina_app_key(String sina_app_key) {
                this.sina_app_key = sina_app_key;
            }

            public String getSina_app_secret() {
                return sina_app_secret;
            }

            public void setSina_app_secret(String sina_app_secret) {
                this.sina_app_secret = sina_app_secret;
            }

            public String getIs_syn_sina() {
                return is_syn_sina;
            }

            public void setIs_syn_sina(String is_syn_sina) {
                this.is_syn_sina = is_syn_sina;
            }

            public String getTencent_app_key() {
                return tencent_app_key;
            }

            public void setTencent_app_key(String tencent_app_key) {
                this.tencent_app_key = tencent_app_key;
            }

            public String getTencent_app_secret() {
                return tencent_app_secret;
            }

            public void setTencent_app_secret(String tencent_app_secret) {
                this.tencent_app_secret = tencent_app_secret;
            }

            public String getIs_syn_tencent() {
                return is_syn_tencent;
            }

            public void setIs_syn_tencent(String is_syn_tencent) {
                this.is_syn_tencent = is_syn_tencent;
            }

            public String getT_access_token() {
                return t_access_token;
            }

            public void setT_access_token(String t_access_token) {
                this.t_access_token = t_access_token;
            }

            public String getT_openkey() {
                return t_openkey;
            }

            public void setT_openkey(String t_openkey) {
                this.t_openkey = t_openkey;
            }

            public String getT_openid() {
                return t_openid;
            }

            public void setT_openid(String t_openid) {
                this.t_openid = t_openid;
            }

            public String getSina_token() {
                return sina_token;
            }

            public void setSina_token(String sina_token) {
                this.sina_token = sina_token;
            }

            public String getIs_borrow_out() {
                return is_borrow_out;
            }

            public void setIs_borrow_out(String is_borrow_out) {
                this.is_borrow_out = is_borrow_out;
            }

            public String getIs_borrow_int() {
                return is_borrow_int;
            }

            public void setIs_borrow_int(String is_borrow_int) {
                this.is_borrow_int = is_borrow_int;
            }

            public String getCreditpassed() {
                return creditpassed;
            }

            public void setCreditpassed(String creditpassed) {
                this.creditpassed = creditpassed;
            }

            public String getCreditpassed_time() {
                return creditpassed_time;
            }

            public void setCreditpassed_time(String creditpassed_time) {
                this.creditpassed_time = creditpassed_time;
            }

            public String getWorkpassed() {
                return workpassed;
            }

            public void setWorkpassed(String workpassed) {
                this.workpassed = workpassed;
            }

            public String getWorkpassed_time() {
                return workpassed_time;
            }

            public void setWorkpassed_time(String workpassed_time) {
                this.workpassed_time = workpassed_time;
            }

            public String getIncomepassed() {
                return incomepassed;
            }

            public void setIncomepassed(String incomepassed) {
                this.incomepassed = incomepassed;
            }

            public String getIncomepassed_time() {
                return incomepassed_time;
            }

            public void setIncomepassed_time(String incomepassed_time) {
                this.incomepassed_time = incomepassed_time;
            }

            public String getHousepassed() {
                return housepassed;
            }

            public void setHousepassed(String housepassed) {
                this.housepassed = housepassed;
            }

            public String getHousepassed_time() {
                return housepassed_time;
            }

            public void setHousepassed_time(String housepassed_time) {
                this.housepassed_time = housepassed_time;
            }

            public String getCarpassed() {
                return carpassed;
            }

            public void setCarpassed(String carpassed) {
                this.carpassed = carpassed;
            }

            public String getCarpassed_time() {
                return carpassed_time;
            }

            public void setCarpassed_time(String carpassed_time) {
                this.carpassed_time = carpassed_time;
            }

            public String getMarrypassed() {
                return marrypassed;
            }

            public void setMarrypassed(String marrypassed) {
                this.marrypassed = marrypassed;
            }

            public String getMarrypassed_time() {
                return marrypassed_time;
            }

            public void setMarrypassed_time(String marrypassed_time) {
                this.marrypassed_time = marrypassed_time;
            }

            public String getEdupassed() {
                return edupassed;
            }

            public void setEdupassed(String edupassed) {
                this.edupassed = edupassed;
            }

            public String getEdupassed_time() {
                return edupassed_time;
            }

            public void setEdupassed_time(String edupassed_time) {
                this.edupassed_time = edupassed_time;
            }

            public String getSkillpassed() {
                return skillpassed;
            }

            public void setSkillpassed(String skillpassed) {
                this.skillpassed = skillpassed;
            }

            public String getSkillpassed_time() {
                return skillpassed_time;
            }

            public void setSkillpassed_time(String skillpassed_time) {
                this.skillpassed_time = skillpassed_time;
            }

            public String getVideopassed() {
                return videopassed;
            }

            public void setVideopassed(String videopassed) {
                this.videopassed = videopassed;
            }

            public String getVideopassed_time() {
                return videopassed_time;
            }

            public void setVideopassed_time(String videopassed_time) {
                this.videopassed_time = videopassed_time;
            }

            public String getMobiletruepassed() {
                return mobiletruepassed;
            }

            public void setMobiletruepassed(String mobiletruepassed) {
                this.mobiletruepassed = mobiletruepassed;
            }

            public String getMobiletruepassed_time() {
                return mobiletruepassed_time;
            }

            public void setMobiletruepassed_time(String mobiletruepassed_time) {
                this.mobiletruepassed_time = mobiletruepassed_time;
            }

            public String getResidencepassed() {
                return residencepassed;
            }

            public void setResidencepassed(String residencepassed) {
                this.residencepassed = residencepassed;
            }

            public String getResidencepassed_time() {
                return residencepassed_time;
            }

            public void setResidencepassed_time(String residencepassed_time) {
                this.residencepassed_time = residencepassed_time;
            }

            public String getAlipay_id() {
                return alipay_id;
            }

            public void setAlipay_id(String alipay_id) {
                this.alipay_id = alipay_id;
            }

            public String getQq_id() {
                return qq_id;
            }

            public void setQq_id(String qq_id) {
                this.qq_id = qq_id;
            }

            public String getInfo_down() {
                return info_down;
            }

            public void setInfo_down(String info_down) {
                this.info_down = info_down;
            }

            public String getSealpassed() {
                return sealpassed;
            }

            public void setSealpassed(String sealpassed) {
                this.sealpassed = sealpassed;
            }

            public String getPaypassword() {
                return paypassword;
            }

            public void setPaypassword(String paypassword) {
                this.paypassword = paypassword;
            }

            public Object getApns_code() {
                return apns_code;
            }

            public void setApns_code(Object apns_code) {
                this.apns_code = apns_code;
            }

            public String getEmailpassed() {
                return emailpassed;
            }

            public void setEmailpassed(String emailpassed) {
                this.emailpassed = emailpassed;
            }

            public String getTmp_email() {
                return tmp_email;
            }

            public void setTmp_email(String tmp_email) {
                this.tmp_email = tmp_email;
            }

            public String getView_info() {
                return view_info;
            }

            public void setView_info(String view_info) {
                this.view_info = view_info;
            }

            public Object getIps_acct_no() {
                return ips_acct_no;
            }

            public void setIps_acct_no(Object ips_acct_no) {
                this.ips_acct_no = ips_acct_no;
            }

            public String getReferral_rate() {
                return referral_rate;
            }

            public void setReferral_rate(String referral_rate) {
                this.referral_rate = referral_rate;
            }

            public String getUser_type() {
                return user_type;
            }

            public void setUser_type(String user_type) {
                this.user_type = user_type;
            }

            public String getCreate_date() {
                return create_date;
            }

            public void setCreate_date(String create_date) {
                this.create_date = create_date;
            }

            public String getRegister_ip() {
                return register_ip;
            }

            public void setRegister_ip(String register_ip) {
                this.register_ip = register_ip;
            }

            public String getEacctno() {
                return eacctno;
            }

            public void setEacctno(String eacctno) {
                this.eacctno = eacctno;
            }

            public String getImportX() {
                return importX;
            }

            public void setImportX(String importX) {
                this.importX = importX;
            }

            public String getEdit_pass() {
                return edit_pass;
            }

            public void setEdit_pass(String edit_pass) {
                this.edit_pass = edit_pass;
            }

            public String getSoleId() {
                return soleId;
            }

            public void setSoleId(String soleId) {
                this.soleId = soleId;
            }

            public String getIs_first() {
                return is_first;
            }

            public void setIs_first(String is_first) {
                this.is_first = is_first;
            }

            public Object getWx_username() {
                return wx_username;
            }

            public void setWx_username(Object wx_username) {
                this.wx_username = wx_username;
            }

            public Object getWxyh_type() {
                return wxyh_type;
            }

            public void setWxyh_type(Object wxyh_type) {
                this.wxyh_type = wxyh_type;
            }

            public Object getYhq_money() {
                return yhq_money;
            }

            public void setYhq_money(Object yhq_money) {
                this.yhq_money = yhq_money;
            }

            public Object getYhq_shouyi() {
                return yhq_shouyi;
            }

            public void setYhq_shouyi(Object yhq_shouyi) {
                this.yhq_shouyi = yhq_shouyi;
            }

            public Object getYhq_lock() {
                return yhq_lock;
            }

            public void setYhq_lock(Object yhq_lock) {
                this.yhq_lock = yhq_lock;
            }

            public Object getCwdz() {
                return cwdz;
            }

            public void setCwdz(Object cwdz) {
                this.cwdz = cwdz;
            }

            public Object getReg_channel() {
                return reg_channel;
            }

            public void setReg_channel(Object reg_channel) {
                this.reg_channel = reg_channel;
            }

            public String getPoint_level() {
                return point_level;
            }

            public void setPoint_level(String point_level) {
                this.point_level = point_level;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isWorkinfo() {
                return workinfo;
            }

            public void setWorkinfo(boolean workinfo) {
                this.workinfo = workinfo;
            }
        }

        public static class CateInfoBean {
            private String id;
            private String name;
            private String brief;
            private String uname;
            private String icon;

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

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
