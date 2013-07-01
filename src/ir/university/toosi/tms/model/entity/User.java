package ir.university.toosi.tms.model.entity;


import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

public class User implements Serializable {

    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String mobile;
    private String email;
    private String status;
    private String enable;
    private String address;
    private String phone;
    private String nationalCode;
    private String createDate;
    private String createTime;
    private String createBy;
    private String passwordModifiedDate;
    private String failedLoginCount;
    private String userComment;
    private String firstLoginDate;
    private String isFirstLogin;
    private String firstLoginIP;
    private String lastLoginDate;
    private String lastLoginIP;
    private boolean online;
    private String deleted;
    private WorkGroup workgroup;

    public User() {
    }

    public User(String address, String userComment, String createDate, String deleted, String email, String failedLoginCount, String firstLoginDate, String firstLoginIP, String firstname, long id, String lastLoginDate, String lastLoginIP, String lastname, String mobile, String nationalCode, String password, String passwordModifiedDate, String phone, String status, String username, boolean online) {
        this.address = address;
        this.userComment = userComment;
        this.createDate = createDate;
        this.deleted = deleted;
        this.email = email;
        this.failedLoginCount = failedLoginCount;
        this.firstLoginDate = firstLoginDate;
        this.firstLoginIP = firstLoginIP;
        this.firstname = firstname;
        this.id = id;
        this.lastLoginDate = lastLoginDate;
        this.lastLoginIP = lastLoginIP;
        this.lastname = lastname;
        this.mobile = mobile;
        this.nationalCode = nationalCode;
        this.password = password;
        this.passwordModifiedDate = passwordModifiedDate;
        this.phone = phone;
        this.status = status;
        this.username = username;
        this.online = online;
    }

    public User(String username, String password, String enable) {
        this.username = username;
        this.password = password;
        this.enable = enable;
    }


    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("userComment")
    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    @JsonProperty("userComment")
    public String getUserComment() {
        return userComment;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("deleted")
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @JsonProperty("deleted")
    public String getDeleted() {
        return deleted;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("failedLoginCount")
    public void setFailedLoginCount(String failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    @JsonProperty("failedLoginCount")
    public String getFailedLoginCount() {
        return failedLoginCount;
    }

    @JsonProperty("firstLoginDate")
    public void setFirstLoginDate(String firstLoginDate) {
        this.firstLoginDate = firstLoginDate;
    }

    @JsonProperty("firstLoginDate")
    public String getFirstLoginDate() {
        return firstLoginDate;
    }

    @JsonProperty("firstLoginIP")
    public void setFirstLoginIP(String firstLoginIP) {
        this.firstLoginIP = firstLoginIP;
    }

    @JsonProperty("firstLoginIP")
    public String getFirstLoginIP() {
        return firstLoginIP;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("lastLoginDate")
    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @JsonProperty("lastLoginDate")
    public String getLastLoginDate() {
        return lastLoginDate;
    }

    @JsonProperty("lastLoginIP")
    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    @JsonProperty("lastLoginIP")
    public String getLastLoginIP() {
        return lastLoginIP;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("nationalCode")
    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @JsonProperty("nationalCode")
    public String getNationalCode() {
        return nationalCode;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("passwordModifiedDate")
    public void setPasswordModifiedDate(String passwordModifiedDate) {
        this.passwordModifiedDate = passwordModifiedDate;
    }

    @JsonProperty("passwordModifiedDate")
    public String getPasswordModifiedDate() {
        return passwordModifiedDate;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("workgroup")
    public void setWorkgroup(WorkGroup workgroup) {
        this.workgroup = workgroup;
    }

    @JsonProperty("workgroup")
    public WorkGroup getWorkgroup() {
        return workgroup;
    }

    @JsonProperty("enable")
    public void setEnable(String enable) {
        this.enable = enable;
    }

    @JsonProperty("enable")
    public String getEnable() {
        return enable;
    }

    @JsonProperty("createTime")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("createTime")
    public String getCreateTime() {
        return createTime;
    }

    @JsonProperty("createBy")
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @JsonProperty("createBy")
    public String getCreateBy() {
        return createBy;
    }

    @JsonProperty("isFirstLogin")
    public void setFirstLogin(String firstLogin) {
        isFirstLogin = firstLogin;
    }

    @JsonProperty("isFirstLogin")
    public String getFirstLogin() {
        return isFirstLogin;
    }

    @JsonProperty("online")
    public void setOnline(boolean online) {
        this.online = online;
    }

    @JsonProperty("online")
    public boolean isOnline() {
        return online;
    }
}
