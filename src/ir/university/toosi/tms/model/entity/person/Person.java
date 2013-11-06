package ir.university.toosi.tms.model.entity.person;


import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;
import ir.university.toosi.tms.model.entity.rule.RulePackage;
import ir.university.toosi.tms.model.entity.zone.Gateway;

import javax.persistence.*;
import java.util.Set;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@Entity
@Table(name = "tb_person")
@NamedQueries({
        @NamedQuery(
                name = "Person.list",
                query = "select p from Person p where p.deleted = '0'"
        ),
        @NamedQuery(
                name = "Person.findById",
                query = "select p from Person p where p.id=:id"
        ),
        @NamedQuery(
                name = "Person.findByName",
                query = "select p from Person p where p.name like :name"
        ),
        @NamedQuery(
                name = "Person.findByLastName",
                query = "select p from Person p where p.lastName  like :lastName"
        ),
        @NamedQuery(
                name = "Person.findByNationalCode",
                query = "select p from Person p where p.nationalCode like :nationalCode"
        ),
        @NamedQuery(
                name = "Person.findByPersonnelNo",
                query = "select p from Person p where p.personnelNo like :personnelNo"
        ),
        @NamedQuery(
                name = "Person.exist",
                query = "select p from Person p where p.personnelNo=:personnelNo and p.deleted='0'"
        ), @NamedQuery(
        name = "Person.maximum",
        query = "select max(p.id) from Person p"
)
})
public class Person extends BaseEntity {

    @Id
    @GeneratedValue
    @JsonProperty
    @Column(name = "id")
    private long id;
    @JsonProperty
    @Column(name = "name")
    private String name;
    @JsonProperty
    @Column(name = "lastName")
    private String lastName;
    @JsonProperty
    @Column(name = "Tpicture")
    private String picture;
    @JsonProperty
    @Column(name = "personnelNo")
    private String personnelNo;
    @JsonProperty
    @Column(name = "nationalCode")
    private String nationalCode;
    @JsonProperty
    @Column(name = "pin")
    private String pin;
    @JsonProperty
    @ManyToOne
    private RulePackage rulePackage;
    @JsonProperty
    @Column(name = "extraField1")
    private String extraField1;
    @JsonProperty
    @Column(name = "extraField2")
    private String extraField2;
    @JsonProperty
    @Column(name = "extraField3")
    private String extraField3;
    @JsonProperty
    @Column(name = "extraField4")
    private String extraField4;
    @JsonProperty
    @ManyToOne
    private BLookup personStatus;
    @JsonProperty
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Gateway> gateways;
    @JsonProperty
    @Column(name = "mobile")
    private String mobile;
    @JsonProperty
    @Column(name = "email")
    private String email;
    @JsonProperty
    @Column(name = "address")
    private String address;
    @JsonProperty
    @Column(name = "phone")
    private String phone;
    @JsonProperty
    @Column(name = "createDate")
    private String createDate;
    @JsonProperty
    @Column(name = "createTime")
    private String createTime;
    @JsonProperty
    @Column(name = "createBy")
    private String createBy;
    @JsonProperty
    @ManyToOne
    private Organ organRef;

    public Person() {
    }

    public Person(String name, String lastName, String picture, String personnelNo, String nationalCode, String pin, Organ organRef) {
        this.name = name;
        this.lastName = lastName;
        this.picture = picture;
        this.personnelNo = personnelNo;
        this.nationalCode = nationalCode;
        this.pin = pin;
        this.organRef = organRef;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organ getOrganRef() {
        return organRef;
    }

    public void setOrganRef(Organ organRef) {
        this.organRef = organRef;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPersonnelNo() {
        return personnelNo;
    }

    public void setPersonnelNo(String personnelNo) {
        this.personnelNo = personnelNo;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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

    public BLookup getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(BLookup personStatus) {
        this.personStatus = personStatus;
    }

    public Set<Gateway> getGateways() {
        return gateways;
    }

    public void setGateways(Set<Gateway> gateways) {
        this.gateways = gateways;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public RulePackage getRulePackage() {
        return rulePackage;
    }

    public void setRulePackage(RulePackage rulePackage) {
        this.rulePackage = rulePackage;
    }
}