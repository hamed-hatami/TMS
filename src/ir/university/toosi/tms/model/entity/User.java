package ir.university.toosi.tms.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.person.Person;

import java.util.Set;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */
@JsonIgnoreProperties(value = "@id")
public class User extends BaseEntity {

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
    private Set<WorkGroup> workGroups;
    @JsonProperty
    private String extraField1;
    @JsonProperty
    private String extraField2;
    @JsonProperty
    private String extraField3;
    @JsonProperty
    private String extraField4;
    @JsonProperty
    private Person person;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }
    public User(Set<WorkGroup> workgroup) {
        this.workGroups = workgroup;
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
        this.workGroups = workGroups;
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

    public Set<WorkGroup> getWorkGroups() {
        return workGroups;
    }

    public void setWorkGroups(Set<WorkGroup> workGroups) {
        this.workGroups = workGroups;
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

    public String getExtraField1() {
        return extraField1;
    }

    public void setExtraField1(String extraField1) {
        this.extraField1 = extraField1;
    }

    public String getExtraField2() {
        return extraField2;
    }

    public void setExtraField2(String extraField2) {
        this.extraField2 = extraField2;
    }

    public String getExtraField3() {
        return extraField3;
    }

    public void setExtraField3(String extraField3) {
        this.extraField3 = extraField3;
    }

    public String getExtraField4() {
        return extraField4;
    }

    public void setExtraField4(String extraField4) {
        this.extraField4 = extraField4;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
