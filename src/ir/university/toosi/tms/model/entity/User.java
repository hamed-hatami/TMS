package ir.university.toosi.tms.model.entity;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFailedLoginCount(String failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public String getFirstLoginDate() {
        return firstLoginDate;
    }

    public void setFirstLoginDate(String firstLoginDate) {
        this.firstLoginDate = firstLoginDate;
    }

    public String getFirstLoginIP() {
        return firstLoginIP;
    }

    public void setFirstLoginIP(String firstLoginIP) {
        this.firstLoginIP = firstLoginIP;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordModifiedDate() {
        return passwordModifiedDate;
    }

    public void setPasswordModifiedDate(String passwordModifiedDate) {
        this.passwordModifiedDate = passwordModifiedDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public WorkGroup getWorkgroup() {
        return workgroup;
    }

    public void setWorkgroup(WorkGroup workgroup) {
        this.workgroup = workgroup;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getFirstLogin() {
        return isFirstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        isFirstLogin = firstLogin;
    }


    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
