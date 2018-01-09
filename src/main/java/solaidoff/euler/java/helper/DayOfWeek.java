package solaidoff.euler.java.helper;

public enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    
    public DayOfWeek advanceDays(int numToAdvance) {
        if(numToAdvance == 0) {
            return this;
        }
        
        switch (this) {
            case SUNDAY:
                return MONDAY.advanceDays(numToAdvance - 1);
            case MONDAY:
                return TUESDAY.advanceDays(numToAdvance - 1);
            case TUESDAY:
                return WEDNESDAY.advanceDays(numToAdvance - 1);
            case WEDNESDAY:
                return THURSDAY.advanceDays(numToAdvance - 1);
            case THURSDAY:
                return FRIDAY.advanceDays(numToAdvance - 1);
            case FRIDAY:
                return SATURDAY.advanceDays(numToAdvance - 1);
            case SATURDAY:
                return SUNDAY.advanceDays(numToAdvance - 1);
            default:
                assert false : this + " All days accounted for";
                return null;
        }
    }
}
