package com.wanguanjinrong.mobile.wanguan.uitls;

import android.os.Environment;
import java.io.File;

/**
 * Created by A on 2016/6/27.
 */
public interface Global {
    String isFirstRun = "isFirstRun";

    int ResultCancel = 10001;
    int LoginStateIn = 1;
    int LoginStateOut = 0;

    int resetPayPassword = 1;
    int forgetPassword = 0;

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


    String baseFolder = Environment.getExternalStorageDirectory().getPath()+ File.separator+"Wanguan"+ File.separator;
    String updateFolder = baseFolder + "update" + File.separator;

    //http tag
    String _TAG = "";
    String _MSG = "";
    String LOGIN_TAG = "login";
    String LOGIN_MSG = "登陆中...";
    String LOGIN_REFRESH_MSG = "更新信息中...";
    String REGISTER_TAG = "register";
    String REGISTER_MSG = "提交中...";
    String UC_ADD_BANK_TAG = "uc_add_bank";
    String UC_ADD_BANK_MSG = "更新银行信息...";
    String UC_DEL_BANK_TAG = "uc_del_bank";
    String UC_DEL_BANK_MSG = "解绑银行卡...";
    String UC_SAVE_BANK_TAG = "uc_save_bank";
    String UC_SAVE_BANK_MSG = "提交中...";
    String SEND_REGISTER_CODE_TAG = "send_register_code";
    String SEND_REGISTER_CODE_MSG = "";
    String SAVE_RESET_PWD_TAG = "save_reset_pwd";
    String SAVE_RESET_PWD_MSG = "提交中...";
    String SEND_RESET_PWD_CODE_TAG = "send_reset_pwd_code";
    String SEND_RESET_PWD_CODE_MSG = "";
    String UC_SAVE_PWD_TAG = "uc_save_pwd";
    String UC_SAVE_PWD_MSG = "提交中...";
    String UC_CENTER_TAG = "uc_center";
    String UC_CENTER_MSG = "更新用户信息...";
    String DownloadNewFile_TAG = "DownloadNewFile";
    String DownloadNewFile_MSG = "下载中...";
    String INIT_TAG = "init";
    String INIT_MSG = "更新中...";
}
