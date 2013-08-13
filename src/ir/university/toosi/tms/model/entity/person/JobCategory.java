package ir.university.toosi.tms.model.entity.person;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;
import ir.university.toosi.tms.model.entity.calendar.Calendar;

import java.io.Serializable;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@JsonIgnoreProperties(value = "@id")
public class JobCategory extends BaseEntity {


    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String code;
    @JsonProperty
    private BLookup categoryType;
    @JsonProperty
    private Calendar defaultCalendar;
    @JsonProperty
    private Calendar calendar;

    public JobCategory() {
    }

    public JobCategory(String name, String code, BLookup categoryType) {
        this.name = name;
        this.code = code;
        this.categoryType = categoryType;
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

    public BLookup getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(BLookup categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryTypeCode() {
        return "CategoryType";
    }

    public Calendar getDefaultCalendar() {
        return defaultCalendar;
    }

    public void setDefaultCalendar(Calendar defaultCalendar) {
        this.defaultCalendar = defaultCalendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}