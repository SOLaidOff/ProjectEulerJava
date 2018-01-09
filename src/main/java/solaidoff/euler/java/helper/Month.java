package solaidoff.euler.java.helper;

public enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

    public Month nextMonth() {
        switch (this) {
            case JANUARY:
                return FEBRUARY;
            case FEBRUARY:
                return MARCH;
            case MARCH:
                return APRIL;
            case APRIL:
                return MAY;
            case MAY:
                return JUNE;
            case JUNE:
                return JULY;
            case JULY:
                return AUGUST;
            case AUGUST:
                return SEPTEMBER;
            case SEPTEMBER:
                return OCTOBER;
            case OCTOBER:
                return NOVEMBER;
            case NOVEMBER:
                return DECEMBER;
            case DECEMBER:
                return JANUARY;
            default:
                assert false : this + "   There are no months not checked for.";
                return null;
        }
    }
}
