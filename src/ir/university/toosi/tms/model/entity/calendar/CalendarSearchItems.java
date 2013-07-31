package ir.university.toosi.tms.model.entity.calendar;

public enum CalendarSearchItems {

    NAME;

    public String getDescription() {

        switch (this) {
            case NAME:
                return "Name";
        }
        return "";
    }

    public String getValue() {

        switch (this) {
            case NAME:
                return "1";
        }

        return "0";
    }
}
