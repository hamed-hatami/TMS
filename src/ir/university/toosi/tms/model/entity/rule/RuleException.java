package ir.university.toosi.tms.model.entity.rule;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BaseEntity;

import javax.persistence.*;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */
@Entity
@Table(name = "tb_RuleException")
@NamedQueries({
        @NamedQuery(
                name = "RuleException.list",
                query = "select r from RuleException  r where r.deleted='0' "
        ),
        @NamedQuery(
                name = "RuleException.findById",
                query = "select r from RuleException r where r.id=:id"

        ), @NamedQuery(
        name = "RuleException.maximum",
        query = "select max(r.id) from RuleException r"
)
})
public class RuleException extends BaseEntity {

    @Id
    @JsonProperty
    @Column(name = "id")
    private long id;
    @JsonProperty
    @Column(name = "exceptionDate")
    private String date;
    @JsonProperty
    @Column(name = "startTime")
    private String startTime;
    @JsonProperty
    @Column(name = "endTime")
    private String endTime;
    @JsonProperty
    @Column(name = "entranceCount")
    private String entranceCount;
    @JsonProperty
    @Column(name = "exitCount")
    private String exitCount;
    @JsonProperty
    @Column(name = "antiPassBack")
    private boolean aniPassBack;
    @JsonProperty
    @Column(name = "allowExit")
    private boolean allowExit;
    @JsonProperty
    @Column(name = "allowExitGadget")
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