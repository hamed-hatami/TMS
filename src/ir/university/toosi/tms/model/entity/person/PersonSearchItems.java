package ir.university.toosi.tms.model.entity.person;

public enum PersonSearchItems {

    NAME, LASTNAME, NATIONALCODE, PERSONNELNO;

    public String getDescription() {

        switch (this) {
            case NAME:
                return "Name";
            case LASTNAME:
                return "LastName";
            case NATIONALCODE:
                return "NationalCode";
            case PERSONNELNO:
                return "PersonnelNo";
        }
        return "";
    }

    public String getValue() {

        switch (this) {
            case NAME:
                return "1";
            case LASTNAME:
                return "2";
            case NATIONALCODE:
                return "3";
            case PERSONNELNO:
                return "4";
        }

        return "0";
    }
}
