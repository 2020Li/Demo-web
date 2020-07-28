package com.demoWeb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;


@Entity
@Table(name = "userloginlog", schema = "", catalog = "bagevent_test")
public class UserloginlogEntity {
    private int loginId;
    private int userId;
    private java.sql.Timestamp loginTime;
    private String loginIp;

    @Id
    @Column(name = "login_id")
    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "login_time")
    public java.sql.Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(java.sql.Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "login_ip")
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserloginlogEntity that = (UserloginlogEntity) o;

        if (loginId != that.loginId) return false;
        if (userId != that.userId) return false;
        if (loginTime != null ? !loginTime.equals(that.loginTime) : that.loginTime != null) return false;
        if (loginIp != null ? !loginIp.equals(that.loginIp) : that.loginIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loginId;
        result = 31 * result + userId;
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (loginIp != null ? loginIp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserloginlogEntity{" +
                "loginId=" + loginId +
                ", userId=" + userId +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }

    public UserloginlogEntity(int loginId, int userId, java.sql.Timestamp loginTime, String loginIp) {
        this.loginId = loginId;
        this.userId = userId;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
    }

    public UserloginlogEntity() {
    }
}
