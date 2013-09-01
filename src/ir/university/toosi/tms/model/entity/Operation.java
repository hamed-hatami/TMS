package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private String description;
    @JsonProperty
    private boolean enabled;

    @JsonProperty
    private boolean selected;

    public Operation() {
    }


    public Operation(long id) {
        this.id = id;
    }

    public Operation(long id, String name, String description, boolean enabled, String deleted, Set<WorkGroup> workGroups, boolean selected) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


}