package ir.university.toosi.tms.model.entity.calendar;

public enum CalendarSearchItems {

    NAME, CODE;

    public String getDescription() {

        switch (this) {
            case NAME:
                return "Name";
            case CODE:
                return "Code";
        }
        return "";
    }

    public String getValue() {

        switch (this) {
            case NAME:
                return "1";
            case CODE:
                return "2";
        }

        return "0";
    }
}
