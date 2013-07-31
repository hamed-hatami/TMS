package ir.university.toosi.tms.model.entity.calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(value = "@id")
public class Calendar implements Serializable {

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

    public Calendar() {
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
}
