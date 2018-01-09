package solaidoff.euler.java;

import solaidoff.euler.java.helper.DayOfWeek;
import solaidoff.euler.java.helper.EulerBasicMath;
import solaidoff.euler.java.helper.Month;

/**
 * https://projecteuler.net/problem=19
 * 
 * Counting Sundays
 * 
 * Problem 19
 * 
 * You are given the following information, but you may prefer to do some research for yourself.
 * 
 * @formatter:off
 * <ul>
 *     <li>1 Jan 1900 was a Monday.
 *     <li>Thirty days has September,
 *     April, June and November.
 *     All the rest have thirty-one,
 *     Saving February alone,
 *     Which has twenty-eight, rain or shine.
 *     And on leap years, twenty-nine.
 *     <li>A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * </ul>
 * @formatter:on
 *                                 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem019 extends EulerProblem {
    public static final int ANSWER_PERIOD_BEGIN_YEAR = 1901;
    public static final Month ANSWER_PERIOD_BEGIN_MONTH = Month.JANUARY;
    public static final int ANSWER_PERIOD_END_YEAR = 2000;
    public static final Month ANSWER_PERIOD_END_MONTH = Month.DECEMBER;

    // It is given that 1 Jan 1900 was a Monday
    public static final int START_DATE_YEAR = 1900;
    public static final Month START_DATE_MONTH = Month.JANUARY;
    public static final DayOfWeek START_DATE_DAY = DayOfWeek.MONDAY;

    public static final int SEP_APR_JUN_NOV_DAY_OFFSET = 30 % 7;
    public static final int JAN_MAR_MAY_JUL_AUG_OCT_DEC_DAY_OFFSET = 31 % 7;
    public static final int FEB_REG_DAY_OFFSET = 28 % 7;
    public static final int FEB_LEAP_DAY_OFFSET = 29 % 7;

    private int currentYear = START_DATE_YEAR;
    private Month currentMonth = START_DATE_MONTH;
    private DayOfWeek firstDayOfMonth = START_DATE_DAY;
    
    private int firstSundaysCount = 0;

    @Override
    public long doProblem() {
        // From the given known starting time, advance time to the start of the period we care about
        while(!(currentYear == ANSWER_PERIOD_BEGIN_YEAR && currentMonth == ANSWER_PERIOD_BEGIN_MONTH)) {
            advanceTime();
        }
        
        // At this point, we start caring whether the first of the month is a Sunday or not
        
        do {
            if (firstDayOfMonth == DayOfWeek.SUNDAY) {
                firstSundaysCount++;
            }
            
            advanceTime();
        } while (!(currentYear == ANSWER_PERIOD_END_YEAR && currentMonth == ANSWER_PERIOD_END_MONTH));

        return firstSundaysCount;
    }
    
    private void advanceTime() {
        switch (currentMonth) {
            case SEPTEMBER:
            case APRIL:
            case JUNE:
            case NOVEMBER:
                firstDayOfMonth = firstDayOfMonth.advanceDays(SEP_APR_JUN_NOV_DAY_OFFSET);
                break;
            case DECEMBER:
                currentYear++;
                // Intentional fall-through
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
                firstDayOfMonth = firstDayOfMonth.advanceDays(JAN_MAR_MAY_JUL_AUG_OCT_DEC_DAY_OFFSET);
                break;
            case FEBRUARY:
                if (isLeapYear(currentYear)) {
                    firstDayOfMonth = firstDayOfMonth.advanceDays(FEB_LEAP_DAY_OFFSET);
                } else {
                    firstDayOfMonth = firstDayOfMonth.advanceDays(FEB_REG_DAY_OFFSET);
                }
                break;
            default:
                assert false : currentMonth + " All months should be accounted for.";
                break;
        }
        
        currentMonth = currentMonth.nextMonth();
    }

    private boolean isLeapYear(int year) {
        if (!(EulerBasicMath.divisibleBy(year, 4))) {
            return false;
        }

        if (EulerBasicMath.divisibleBy(year, 100)) {
            return false;
        }

        return true;
    }
    
    // Just to help with debugging
    @Override
    public String toString() {
        return "Current year: " + currentYear + "   Current month: " + currentMonth + "   First day of month day: " + firstDayOfMonth;
    }

    public static void main(String[] args) {
        System.out.println(new Problem019().doProblem());
    }
}
