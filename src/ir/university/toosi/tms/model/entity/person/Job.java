package ir.university.toosi.tms.model.entity.person;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;

import java.io.Serializable;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@JsonIgnoreProperties(value = "@id")
public class Job extends BaseEntity {

    @JsonProperty
    private long id;
    @JsonProperty
    private String employNo;
    @JsonProperty
    private BLookup employType;
    @JsonProperty
    private String folderNo;
    @JsonProperty
    private String internalTel;
    @JsonProperty
    private BLookup assistType;
    @JsonProperty
    private BLookup postType;
    @JsonProperty
    private String description;
    @JsonProperty
    private Person person;
    @JsonProperty
    private JobCategory jobCategory;
    @JsonProperty
    private Organ organ;

    public Job() {
    }

    public Job(String employNo, BLookup employType, String folderNo, String internalTel, BLookup assistType, BLookup postType, String description, Person person, JobCategory jobCategory, Organ organ) {
        this.employNo = employNo;
        this.employType = employType;
        this.folderNo = folderNo;
        this.internalTel = internalTel;
        this.assistType = assistType;
        this.postType = postType;
        this.description = description;
        this.person = person;
        this.jobCategory = jobCategory;
        this.organ = organ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployNo() {
        return employNo;
    }

    public void setEmployNo(String employNo) {
        this.employNo = employNo;
    }

    public BLookup getEmployType() {
        return employType;
    }

    public void setEmployType(BLookup employType) {
        this.employType = employType;
    }

    public String getEmployTypeCode() {
        return "EmployType";
    }

    public String getFolderNo() {
        return folderNo;
    }

    public void setFolderNo(String folderNo) {
        this.folderNo = folderNo;
    }

    public String getInternalTel() {
        return internalTel;
    }

    public void setInternalTel(String internalTel) {
        this.internalTel = internalTel;
    }

    public BLookup getAssistType() {
        return assistType;
    }

    public void setAssistType(BLookup assistType) {
        this.assistType = assistType;
    }

    public String getAssistTypeCode() {
        return "AssistType";
    }

    public BLookup getPostType() {
        return postType;
    }

    public void setPostType(BLookup postType) {
        this.postType = postType;
    }

    public String getPostTypeCode() {
        return "PostType";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }
}