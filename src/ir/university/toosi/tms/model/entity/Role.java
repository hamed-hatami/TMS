package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.util.ThreadPoolManager;

import java.util.Set;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */
@JsonIgnoreProperties(value = "@id")
public class Role extends BaseEntity {
    @JsonProperty
    private long id;
    @JsonProperty
    private String description;
    @JsonProperty
    private boolean enabled;
    @JsonProperty
    private boolean selected;
    @JsonProperty
    private String descText;
    @JsonProperty
    private Set<Operation> operations;

    private String descShow;

    public Role() {
    }


    public Role(long id) {
        this.id = id;
    }

    public Role(long id, String description, boolean enabled, String deleted, Set<WorkGroup> workGroups, boolean selected) {
        this.id = id;
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

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText;
    }

    public String getDescShow() {
        return ThreadPoolManager.getLangValue(this.description);
    }

    public void setDescShow(String descShow) {
        this.descShow = descShow;
    }
}