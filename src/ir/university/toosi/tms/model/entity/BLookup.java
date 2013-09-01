package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = "@id")
public class BLookup extends BaseEntity {

    @JsonProperty
    private long id;

    @JsonProperty
    private String code;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private String persianName;

    @JsonProperty
    private Lookup lookup;

    public BLookup() {
    }

    public BLookup(int id) {
        this.id = id;
    }

    public BLookup(String code, String name, String description, Lookup lookup) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.lookup = lookup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lookup getLookup() {
        return lookup;
    }

    public void setLookup(Lookup lookup) {
        this.lookup = lookup;
    }

    @Override
    public String toString() {
        return name;
    }
}
