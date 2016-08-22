package com.wanguanjinrong.mobile.wanguan.uitls;

/**
 * Created by A on 2016/6/27.
 */
public interface Global {
    String isFirstRun = "isFirstRun";

    int LoginStateIn = 1;
    int LoginStateOut = 0;

    double LOGIN_AVALIBAL_TIME = 3600000 * 72;
    String LOGIN_TIME = "LOGIN_TIME";
    String LOGIN_INFO = "LOGIN_INFO";
    String LOGIN_USER_INFO = "LOGIN_USER_INFO";

    String INVITE_WEIXIN_API = "wx1f8af9f0ddba4136";
    String INVITE_TITLE = "万贯金融";
    String INVITE_CONTENT = "注册送5000专属本金和0.5%加息，快来加入我们吧 ";
    String INVITE_TARGET_URL = "http://www.wanguanjinrong.com";


    int Toolbar_Color_Normal = 0xFFf71e1a;
    int Toolbar_Color_Red = 0xFFf71e1a;
    //http tag
    String _TAG = "";
    String _MSG = "";
    String LOGIN_TAG = "login";
    String LOGIN_MSG = "登陆中...";
    String UC_CENTER_TAG = "uc_center";
    String UC_CENTER_MSG = "更新用户信息...";
    String INIT_TAG = "init";
    String INIT_MSG = "init";
}
