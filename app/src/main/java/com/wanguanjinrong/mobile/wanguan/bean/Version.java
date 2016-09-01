package com.wanguanjinrong.mobile.wanguan.bean;

/**
 * Created by A on 2016/9/1.
 */
public class Version extends BaseBean{
    /**
     * serverVersion : 2015021001
     * filename : http://ceshi.wanguanjinrong.com/wg_P2P.apk
     * android_upgrade : 修复bug
     * hasfile : 1
     * filesize : 0
     * has_upgrade : 1
     * forced_upgrade : 1
     * act_2 :
     */

    private String serverVersion;
    private String filename;
    private String android_upgrade;
    private String hasfile;
    private double filesize;
    private String has_upgrade;
    private int forced_upgrade;

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAndroid_upgrade() {
        return android_upgrade;
    }

    public void setAndroid_upgrade(String android_upgrade) {
        this.android_upgrade = android_upgrade;
    }

    public String getHasfile() {
        return hasfile;
    }

    public void setHasfile(String hasfile) {
        this.hasfile = hasfile;
    }

    public double getFilesize() {
        return filesize;
    }

    public void setFilesize(double filesize) {
        this.filesize = filesize;
    }

    public String getHas_upgrade() {
        return has_upgrade;
    }

    public void setHas_upgrade(String has_upgrade) {
        this.has_upgrade = has_upgrade;
    }

    public int getForced_upgrade() {
        return forced_upgrade;
    }

    public void setForced_upgrade(int forced_upgrade) {
        this.forced_upgrade = forced_upgrade;
    }
}
