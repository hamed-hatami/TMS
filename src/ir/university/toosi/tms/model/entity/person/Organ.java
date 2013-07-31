package ir.university.toosi.tms.model.entity.person;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;

import java.io.Serializable;
import java.util.Set;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@JsonIgnoreProperties(value = "@id")
public class Organ implements Serializable {

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
    @JsonProperty
    private Set<Organ> childOrgans;

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

    public String getOrganTypeCode() {
        return "OrganType";
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
}