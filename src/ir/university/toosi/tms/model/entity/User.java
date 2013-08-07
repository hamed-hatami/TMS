package ir.university.toosi.tms.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Set;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */
@JsonIgnoreProperties(value = "@id")
public class User extends BaseEntity implements Serializable {

    @JsonProperty
    private long id;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private String mobile;
    @JsonProperty
    private String email;
    @JsonProperty
    private String status;
    @JsonProperty
    private String enable;
    @JsonProperty
    private String address;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String nationalCode;
    @JsonProperty
    private String createDate;
    @JsonProperty
    private String createTime;
    @JsonProperty
    private String createBy;
    @JsonProperty
    private String failedLoginCount;
    @JsonProperty
    private String lastLoginDate;
    @JsonProperty
    private String lastLoginIP;
    @JsonProperty
    private boolean online;
    @JsonProperty
    private String deleted;
    @JsonProperty
    private Set<WorkGroup> workgroup;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }
    public User(Set<WorkGroup> workgroup) {
        this.workgroup = workgroup;
    }

    public User(long id, String username, String password, String firstname, String lastname, String mobile, String email, String status, String enable, String address, String phone, String nationalCode, String createDate, String createTime, String createBy, String passwordModifiedDate, String failedLoginCount, String userComment, String firstLoginDate, String firstLoginIP, String lastLoginDate, String lastLoginIP, boolean online, String deleted, Set<WorkGroup> workGroups) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
        this.enable = enable;
        this.address = address;
        this.phone = phone;
        this.nationalCode = nationalCode;
        this.createDate = createDate;
        this.createTime = createTime;
        this.createBy = createBy;
        this.failedLoginCount = failedLoginCount;
        this.lastLoginDate = lastLoginDate;
        this.lastLoginIP = lastLoginIP;
        this.online = online;
        this.deleted = deleted;
        this.workgroup = workGroups;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFailedLoginCount(String failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public String getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<WorkGroup> getWorkgroup() {
        return workgroup;
    }

    public void setWorkgroup(Set<WorkGroup> workgroup) {
        this.workgroup = workgroup;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getEnable() {
        return enable;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isOnline() {
        return online;
    }
}
