package ir.university.toosi.tms.model.entity.person;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;

import java.io.Serializable;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@JsonIgnoreProperties(value = "@id")
public class Card extends BaseEntity {

    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String code;
    @JsonProperty
    private BLookup cardType;
    @JsonProperty
    private BLookup cardStatus;
    @JsonProperty
    private boolean visible;
    @JsonProperty
    private Person person;

    public Card() {
    }

    public Card(String name, String code, BLookup cardType, BLookup cardStatus, boolean visible, Person person) {
        this.name = name;
        this.code = code;
        this.cardType = cardType;
        this.cardStatus = cardStatus;
        this.visible = visible;
        this.person = person;
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

    public BLookup getCardType() {
        return cardType;
    }

    public void setCardType(BLookup cardType) {
        this.cardType = cardType;
    }

    public String getCardTypeCode() {
        return "CardType";
    }

    public BLookup getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(BLookup cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardStatusCode() {
        return "CardStatus";
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}