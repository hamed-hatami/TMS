package ir.university.toosi.tms.model.entity.personnel;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;
import ir.university.toosi.tms.model.entity.rule.RulePackage;

import javax.persistence.*;
import java.util.Set;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@Entity
@Table(name = "tb_organ")
@NamedQueries({
        @NamedQuery(
                name = "Organ.exist",
                query = "select count(o) from Organ o where o.name = :name or o.code = :code"
        ),
        @NamedQuery(
                name = "Organ.list",
                query = "select o from Organ o"
        ),
        @NamedQuery(
                name = "Organ.active.list",
                query = "select o from Organ o where o.deleted <> '1' and o.parentOrgan is null"
        ),
        @NamedQuery(
                name = "Organ.active.by.parent.list",
                query = "select o from Organ o where o.deleted <> '1' and o.parentOrgan is not null and o.parentOrgan.id = :parentId"
        ),
        @NamedQuery(
                name = "Organ.findById",
                query = "select o from Organ o where o.id=:id"
        )
})
public class Organ extends BaseEntity {

    @Id
    @GeneratedValue
    @JsonProperty
    @Column(name = "id")
    private long id;
    @JsonProperty
    @Column(name = "name")
    private String name;
    @JsonProperty
    @Column(name = "code")
    private String code;
    @JsonProperty
    @Column(name = "title")
    private String title;
    @JsonProperty
    @ManyToOne
    private BLookup organType;
    @JsonProperty
    @ManyToOne
    private Organ parentOrgan;
    @JsonIgnore
    @OneToMany(mappedBy = "parentOrgan", fetch = FetchType.EAGER)
    private Set<Organ> childOrgans;
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