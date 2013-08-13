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
public class Operation extends BaseEntity {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String persianDescription;
    @JsonProperty
    private String englishDescription;
    @JsonProperty
    private boolean enabled;
    @JsonProperty
    private String deleted;

    @JsonProperty
    private boolean selected;

    public Operation() {
    }


    public Operation(long id) {
        this.id = id;
    }

    public Operation(long id, String name, String persianDescription, String englishDescription, boolean enabled, String deleted, Set<WorkGroup> workGroups, boolean selected) {
        this.id = id;
        this.name = name;
        this.persianDescription = persianDescription;
        this.englishDescription = englishDescription;
        this.enabled = enabled;
        this.deleted = deleted;
        this.selected = selected;
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

    public String getPersianDescription() {
        return persianDescription;
    }

    public void setPersianDescription(String persianDescription) {
        this.persianDescription = persianDescription;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


}