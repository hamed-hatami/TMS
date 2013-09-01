package ir.university.toosi.tms.model.entity;

import ir.university.toosi.tms.util.ThreadPoolManager;

public enum WorkGroupSearchItems {

    NAME;

    public String getDescription() {

        switch (this) {
            case NAME:
                return ThreadPoolManager.getLangValue("TMS_NAME");
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
