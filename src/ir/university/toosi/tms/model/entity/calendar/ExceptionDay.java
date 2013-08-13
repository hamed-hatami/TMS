package ir.university.toosi.tms.model.entity.calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BaseEntity;

import java.io.Serializable;

@JsonIgnoreProperties(value = "@id")
public class ExceptionDay extends BaseEntity {

    @JsonProperty
    private long id;

    @JsonProperty
    private String fromDate;

    @JsonProperty
    private String toDate;

    @JsonProperty
    private String startTime;

    @JsonProperty
    private String endTime;

    @JsonProperty
    private Boolean holiday;

    @JsonProperty
    private Calendar calendar;

    public ExceptionDay() {
    }

    public ExceptionDay(String fromDate, String toDate, String startTime, String endTime, Boolean holiday, Calendar calendar) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.holiday = holiday;
        this.calendar = calendar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getHoliday() {
        return holiday;
    }

    public void setHoliday(Boolean holiday) {
        this.holiday = holiday;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
