package com.wx.example.entity;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class Account implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private Integer accountId;

    private String accountName;

    private String password;

    private String rememberToken;

    private String accountEmail;

    private String accountTel;

    private Integer accountStatus;

    private Integer accountSex;

    private String accountImage;

    private String accountRealName;

    private String accountIntro;

    private String createTime;

    public Account() {
        super();
    }

    public Account(Account account) {
        this.accountName = account.getAccountName();
        this.password = account.getPassword();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountTel() {
        return accountTel;
    }

    public void setAccountTel(String accountTel) {
        this.accountTel = accountTel;
    }

    public Integer getAccountSex() {
        return accountSex;
    }

    public void setAccountSex(Integer accountSex) {
        this.accountSex = accountSex;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountImage() {
        return accountImage;
    }

    public void setAccountImage(String accountImage) {
        this.accountImage = accountImage;
    }

    public String getAccountRealName() {
        return accountRealName;
    }

    public void setAccountRealName(String accountRealName) {
        this.accountRealName = accountRealName;
    }

    public String getAccountIntro() {
        return accountIntro;
    }

    public void setAccountIntro(String accountIntro) {
        this.accountIntro = accountIntro;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
