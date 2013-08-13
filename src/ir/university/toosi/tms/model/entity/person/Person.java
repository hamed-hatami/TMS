package ir.university.toosi.tms.model.entity.person;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BaseEntity;
import ir.university.toosi.tms.model.entity.calendar.Calendar;

import java.io.Serializable;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@JsonIgnoreProperties(value = "@id")
public class Person extends BaseEntity {

    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String picture;
    @JsonProperty
    private String personnelNo;
    @JsonProperty
    private String nationalCode;
    @JsonProperty
    private String pin;
    @JsonProperty
    private Calendar defaultCalendar;
    @JsonProperty
    private Calendar calendar;

    public Person() {
    }

    public Person(String name, String lastName, String picture, String personnelNo, String nationalCode, String pin) {
        this.name = name;
        this.lastName = lastName;
        this.picture = picture;
        this.personnelNo = personnelNo;
        this.nationalCode = nationalCode;
        this.pin = pin;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPersonnelNo() {
        return personnelNo;
    }

    public void setPersonnelNo(String personnelNo) {
        this.personnelNo = personnelNo;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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