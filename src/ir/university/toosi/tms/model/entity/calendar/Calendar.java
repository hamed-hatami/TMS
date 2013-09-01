package ir.university.toosi.tms.model.entity.calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BaseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(value = "@id")
public class Calendar extends BaseEntity {

    @JsonProperty
    private long id;

    @JsonProperty
    private String code;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private boolean defaultCalendar;

    @JsonProperty
    private String extraField1;

    @JsonProperty
    private String extraField2;

    @JsonProperty
    private String extraField3;

    @JsonProperty
    private String extraField4;

    public Calendar() {
    }

    public Calendar(long id) {
        this.id = id;
    }

    public Calendar(String code, String name, String description, boolean defaultCalendar) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.defaultCalendar = defaultCalendar;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefaultCalendar() {
        return defaultCalendar;
    }

    public void setDefaultCalendar(boolean defaultCalendar) {
        this.defaultCalendar = defaultCalendar;
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
}
