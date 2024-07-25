/**
 * Contains the details of a Date
*/
public class Date{
    private int month;
    private int day;
    private int year;
    /**
     * Initializes a Date object with month, day, and year
     * @param month month for the date
     * @param day day for the date
     * @param year year for the date
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    /**
     * Returns the month of this Date
     * @return month 
     */
    public int getMonth() {
        return month;
    }
    /**
     * Sets a new value for month
     * @param month new value for month 
     */
    public void setMonth(int month) {
        this.month = month;
    }
    /**
     * Returns the day of this Date
     * @return day 
     */
    public int getDay() {
        return day;
    }
    /**
     * Sets a new value for day
     * @param day new value for day 
     */
    public void setDay(int day) {
        this.day = day;
    }
    /**
     * Returns the year of this Date
     * @return year 
     */
    public int getYear() {
        return year;
    }
    /**
     * Sets a new value for year
     * @param year new value for year 
     */
    public void setYear(int year) {
        this.year = year;
    }
}