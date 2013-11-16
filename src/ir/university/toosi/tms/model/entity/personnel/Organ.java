package ir.university.toosi.tms.model.entity.personnel;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;
import ir.university.toosi.tms.model.entity.rule.RulePackage;

import java.util.Set;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */


public class Organ extends BaseEntity {

    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String code;
    @JsonProperty
    private String title;
    @JsonProperty
    private BLookup organType;
    @JsonProperty
    private Organ parentOrgan;
    @JsonIgnore
    private Set<Organ> childOrgans;
    @JsonProperty
    private String extraField1;
    @JsonProperty
    private String extraField2;
    @JsonProperty
    private String extraField3;
    @JsonProperty
    private String extraField4;
    @JsonProperty
    private RulePackage rulePackage;

    public Organ() {
    }

    public Organ(String name, String code, String title, BLookup organType) {
        this.name = name;
        this.code = code;
        this.title = title;
        this.organType = organType;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BLookup getOrganType() {
        return organType;
    }

    public void setOrganType(BLookup organType) {
        this.organType = organType;
    }

    public Organ getParentOrgan() {
        return parentOrgan;
    }

    public void setParentOrgan(Organ parentOrgan) {
        this.parentOrgan = parentOrgan;
    }

    public Set<Organ> getChildOrgans() {
        return childOrgans;
    }

    public void setChildOrgans(Set<Organ> childOrgans) {
        this.childOrgans = childOrgans;
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

    public RulePackage getRulePackage() {
        return rulePackage;
    }

    public void setRulePackage(RulePackage rulePackage) {
        this.rulePackage = rulePackage;
    }
}