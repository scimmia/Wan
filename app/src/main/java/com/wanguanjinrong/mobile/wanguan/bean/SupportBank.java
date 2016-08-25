package com.wanguanjinrong.mobile.wanguan.bean;

import java.util.List;

/**
 * Created by A on 2016/8/24.
 */
public class SupportBank extends BaseBean{
    /**
     * item : [{"id":"36","name":"苏格兰皇家银行","is_rec":"1","day":"1","sort":"26","icon":"./public/bank/36.jpg"},{"id":"1","name":"中国工商银行","is_rec":"1","day":"3","sort":"0","icon":"./public/attachment/201502/15/11/54e0105a58003.png"},{"id":"2","name":"中国农业银行","is_rec":"1","day":"3","sort":"0","icon":"./public/bank/2.jpg"},{"id":"3","name":"中国建设银行","is_rec":"1","day":"3","sort":"0","icon":"./public/bank/3.jpg"},{"id":"4","name":"招商银行","is_rec":"1","day":"3","sort":"0","icon":"./public/bank/4.jpg"},{"id":"5","name":"中国光大银行","is_rec":"1","day":"3","sort":"0","icon":"./public/bank/5.jpg"},{"id":"6","name":"中国邮政储蓄银行","is_rec":"1","day":"3","sort":"0","icon":"./public/bank/6.jpg"},{"id":"7","name":"兴业银行","is_rec":"1","day":"3","sort":"0","icon":"./public/bank/7.jpg"},{"id":"9","name":"交通银行","is_rec":"0","day":"3","sort":"3","icon":"./public/bank/9.jpg"},{"id":"16","name":"深圳发展银行","is_rec":"0","day":"3","sort":"2","icon":"./public/bank/16.jpg"},{"id":"12","name":"上海浦东发展银行","is_rec":"0","day":"3","sort":"1","icon":"./public/bank/12.jpg"},{"id":"8","name":"中国银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/8.jpg"},{"id":"10","name":"中信银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/10.jpg"},{"id":"11","name":"华夏银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/11.jpg"},{"id":"13","name":"城市信用社","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/13.jpg"},{"id":"14","name":"恒丰银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/14.jpg"},{"id":"15","name":"广东发展银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/15.jpg"},{"id":"17","name":"中国民生银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/17.jpg"},{"id":"18","name":"中国农业发展银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/18.jpg"},{"id":"19","name":"农村商业银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/19.jpg"},{"id":"20","name":"农村信用社","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/20.jpg"},{"id":"21","name":"城市商业银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/21.jpg"},{"id":"22","name":"农村合作银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/22.jpg"},{"id":"23","name":"浙商银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/23.jpg"},{"id":"24","name":"上海农商银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/24.jpg"},{"id":"25","name":"中国进出口银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/25.jpg"},{"id":"26","name":"渤海银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/26.jpg"},{"id":"27","name":"国家开发银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/27.jpg"},{"id":"28","name":"村镇银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/28.jpg"},{"id":"29","name":"徽商银行股份有限公司","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/29.jpg"},{"id":"30","name":"南洋商业银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/30.jpg"},{"id":"31","name":"韩亚银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/31.jpg"},{"id":"32","name":"花旗银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/32.jpg"},{"id":"33","name":"渣打银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/33.jpg"},{"id":"34","name":"华一银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/34.jpg"},{"id":"35","name":"东亚银行","is_rec":"0","day":"3","sort":"0","icon":"./public/bank/35.jpg"}]
     * act_2 :
     */

    private String act_2;
    /**
     * id : 36
     * name : 苏格兰皇家银行
     * is_rec : 1
     * day : 1
     * sort : 26
     * icon : ./public/bank/36.jpg
     */

    private List<ItemBean> item;

    public String getAct_2() {
        return act_2;
    }

    public void setAct_2(String act_2) {
        this.act_2 = act_2;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class ItemBean {
        private String id;
        private String name;
        private String is_rec;
        private String day;
        private String sort;
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

        public String getIs_rec() {
            return is_rec;
        }

        public void setIs_rec(String is_rec) {
            this.is_rec = is_rec;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
