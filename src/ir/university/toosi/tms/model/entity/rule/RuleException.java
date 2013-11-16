package ir.university.toosi.tms.model.entity.rule;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BaseEntity;


/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */
public class RuleException extends BaseEntity {

    @JsonProperty
    private long id;
    @JsonProperty
    private String date;
    @JsonProperty
    private String startTime;
    @JsonProperty
    private String endTime;
    @JsonProperty
    private String entranceCount;
    @JsonProperty
    private String exitCount;
    @JsonProperty
    private boolean aniPassBack;
    @JsonProperty
    private boolean allowExit;
    @JsonProperty
    private boolean allowExitGadget;

    public RuleException() {

    }

    public RuleException(long id, String date, String startTime, String endTime, String entranceCount, String exitCount) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.entranceCount = entranceCount;
        this.exitCount = exitCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getEntranceCount() {
        return entranceCount;
    }

    public void setEntranceCount(String entranceCount) {
        this.entranceCount = entranceCount;
    }

    public String getExitCount() {
        return exitCount;
    }

    public void setExitCount(String exitCount) {
        this.exitCount = exitCount;
    }

    public boolean isAniPassBack() {
        return aniPassBack;
    }

    public void setAniPassBack(boolean aniPassBack) {
        this.aniPassBack = aniPassBack;
    }

    public boolean isAllowExit() {
        return allowExit;
    }

    public void setAllowExit(boolean allowExit) {
        this.allowExit = allowExit;
    }

    public boolean isAllowExitGadget() {
        return allowExitGadget;
    }

    public void setAllowExitGadget(boolean allowExitGadget) {
        this.allowExitGadget = allowExitGadget;
    }
}