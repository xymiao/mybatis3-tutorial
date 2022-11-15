package com.xymiao.tutorial.mybatis.clazz.pojo;

import java.io.Serializable;

public class SysRes implements Serializable {
    private int resId;
    private int roleId;
    private String resName;
    private String validFlag;
    private String resUrl;

    @Override
    public String toString() {
        return "SysRes{" +
                "resId=" + resId +
                ", roleId=" + roleId +
                ", resName='" + resName + '\'' +
                ", validFlag='" + validFlag + '\'' +
                ", resUrl='" + resUrl + '\'' +
                '}';
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }
}
