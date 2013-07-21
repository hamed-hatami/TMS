package ir.university.toosi.tms.model.entity;

public enum EventType {

    NONE;

    public String getDescription() {

        switch (this) {
            case NONE:
                return "";
        }
        return "";
    }

    public String getValue() {

        switch (this) {
            case NONE:
                return "0";
        }

        return "0";
    }
}
