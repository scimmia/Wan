package com.wanguanjinrong.mobile.wanguan.uitls;

import com.google.gson.Gson;
import com.wanguanjinrong.mobile.wanguan.main.home.gonggao.Gonggao;

import java.util.Random;

/**
 * Created by A on 2016/8/5.
 */
public class TestUtils {

    public static Gonggao generRandomGonggao() {
        String[] gonggaos = new String[]{
            "{\"id\":\"191\",\"title\":\"2016-01-30日发标公告\",\"icon\":\"\",\"content\":\"2016-01-30日发标公告：\n汽配城建设借款20万 第四期 ;\n借款期限：12个月 ; ;收益：年化收益13.2% ; \n还款方式：每月还息，到期还本 ;\n借款金额：20万元 ; \n敬请关注 平台最新内容！！谢谢\",\"cate_id\":\"5\",\"create_time\":\"1454172202\",\"update_time\":\"1454172202\",\"add_admin_id\":\"0\",\"is_effect\":\"1\",\"rel_url\":\"\",\"update_admin_id\":\"0\",\"is_delete\":\"0\",\"click_count\":\"361\",\"sort\":\"206\",\"seo_title\":\"2016-01-30日发标公告\",\"seo_keyword\":\"2016-01-30日发标公告\",\"seo_description\":\"2016-01-30日发标公告\",\"uname\":\"\",\"sub_title\":\"\",\"brief\":\"2016-01-30日发标公告\",\"type_id\":\"2\",\"url\":\"\\/appapi\\/index.php?ctl=notice&id=191\"}",
                "{\"id\":\"190\",\"title\":\"2016-01-28发标公告\",\"icon\":\"\",\"content\":\"2016-01-28日发标公告：\n汽配城建设借款20万 第二期 ;\n借款期限：12个月 ; ;收益：年化收益13.2% ; \n还款方式：每月还息，到期还本 ;\n借款金额：20万元 ; \n敬请关注 平台最新内容！！谢谢\",\"cate_id\":\"5\",\"create_time\":\"1453936919\",\"update_time\":\"1453936919\",\"add_admin_id\":\"0\",\"is_effect\":\"1\",\"rel_url\":\"\",\"update_admin_id\":\"0\",\"is_delete\":\"0\",\"click_count\":\"209\",\"sort\":\"205\",\"seo_title\":\"2016-01-28发标公告2016-01-28发标公告2016-01-28发标公告\",\"seo_keyword\":\"2016-01-28发标公告2016-01-28发标公告2016-01-28发标公告\",\"seo_description\":\"2016-01-28发标公告2016-01-28发标公告\",\"uname\":\"\",\"sub_title\":\"2016-01-28发标公告\",\"brief\":\"2016-01-28发标公告\",\"type_id\":\"2\",\"url\":\"\\/appapi\\/index.php?ctl=notice&id=190\"}",
                "{\"id\":\"189\",\"title\":\"2016-01-20发标公告\",\"icon\":\"\",\"content\":\"2016-01-20日发标公告：\n汽车咨询公司借款10万 第三期 ;\n借款期限：12个月 ; ;收益：年化收益13.2% ; \n还款方式：每月还息，到期还本 ;\n借款金额：10万元 ; \n敬请关注 平台最新内容！！谢谢\",\"cate_id\":\"5\",\"create_time\":\"1453249723\",\"update_time\":\"1453249723\",\"add_admin_id\":\"0\",\"is_effect\":\"1\",\"rel_url\":\"\",\"update_admin_id\":\"0\",\"is_delete\":\"0\",\"click_count\":\"175\",\"sort\":\"204\",\"seo_title\":\"2016-01-20发标公告\",\"seo_keyword\":\"2016-01-20发标公告\",\"seo_description\":\"2016-01-20发标公告\",\"uname\":\"\",\"sub_title\":\"\",\"brief\":\"2016-01-20发标公告\",\"type_id\":\"2\",\"url\":\"\\/appapi\\/index.php?ctl=notice&id=189\"}"
        };
        String temp = gonggaos[new Random().nextInt(gonggaos.length)];
        return new Gson().fromJson(temp,Gonggao.class);
    }
}
