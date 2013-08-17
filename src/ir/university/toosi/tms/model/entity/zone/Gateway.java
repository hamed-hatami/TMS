package ir.university.toosi.tms.model.entity.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;
import ir.university.toosi.tms.model.entity.calendar.Calendar;

import java.util.List;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

public class Gateway extends BaseEntity {

    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private boolean passBackControl;
    @JsonProperty
    private BLookup crossingType;
    @JsonProperty
    private String scheduleName;
    @JsonProperty
    private List<Camera> cameras;
    @JsonProperty
    private List<HardwareSpec> hardwareSpecList;
    @JsonProperty
    private Zone zone;
    @JsonProperty
    private String status;
    @JsonProperty
    private Calendar calendar;
    @JsonProperty
    private String deleted;

    public Gateway() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPassBackControl() {
        return passBackControl;
    }

    public void setPassBackControl(boolean passBackControl) {
        this.passBackControl = passBackControl;
    }

    public BLookup getCrossingType() {
        return crossingType;
    }

    public void setCrossingType(BLookup crossingType) {
        this.crossingType = crossingType;
    }

    public String getCrossingTypeCode() {
        return "CrossingType";
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }

    public List<HardwareSpec> getHardwareSpecList() {
        return hardwareSpecList;
    }

    public void setHardwareSpecList(List<HardwareSpec> hardwareSpecList) {
        this.hardwareSpecList = hardwareSpecList;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}