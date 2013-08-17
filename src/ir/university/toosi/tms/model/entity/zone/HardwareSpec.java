package ir.university.toosi.tms.model.entity.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BaseEntity;


public class HardwareSpec extends BaseEntity {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private GAC gac;
    @JsonProperty
    private CardReader cardReader;
    @JsonProperty
    private Gateway gateway;
    @JsonProperty
    private String status;
    @JsonProperty
    private String deleted;

    public HardwareSpec() {
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

    public GAC getGac() {
        return gac;
    }

    public void setGac(GAC gac) {
        this.gac = gac;
    }

    public CardReader getCardReader() {
        return cardReader;
    }

    public void setCardReader(CardReader cardReader) {
        this.cardReader = cardReader;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
