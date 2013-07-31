package ir.university.toosi.tms.model.entity.calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;

import java.io.Serializable;

@JsonIgnoreProperties(value = "@id")
public class WeekDay implements Serializable {

    @JsonProperty
    private long id;

    @JsonProperty
    private BLookup fromDayType;

    @JsonProperty
    private BLookup toDayType;

    @JsonProperty
    private String startTime;

    @JsonProperty
    private String endTime;

    @JsonProperty
    private int orderIndex;

    @JsonProperty
    private boolean holiday;

    @JsonProperty
    private Calendar calendar;

    public WeekDay() {
    }

    public WeekDay(BLookup fromDayType, BLookup toDayType, String startTime, String endTime, int orderIndex, Calendar calendar) {
        this.fromDayType = fromDayType;
        this.toDayType = toDayType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.orderIndex = orderIndex;
        this.calendar = calendar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BLookup getFromDayType() {
        return fromDayType;
    }

    public void setFromDayType(BLookup fromDayType) {
        this.fromDayType = fromDayType;
    }

    public BLookup getToDayType() {
        return toDayType;
    }

    public void setToDayType(BLookup toDayType) {
        this.toDayType = toDayType;
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

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }
}
