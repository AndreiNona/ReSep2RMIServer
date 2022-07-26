package sep2.entities;

import java.util.GregorianCalendar;

/**
 * @author Andrei-Sorin Ioanas
 * Date for appointments, each trainer is booked for an entire day
 */
public class Date
{
    private int day;
    private int month;  //Months are counted form 1 to 12
    private int year;

    /**
     * Empty constructor
     */
    public Date() {
    }

    /**
     * Main constructor
     * @param day int value of the day given to the Date object
     * @param month int value of the month given to the Date object
     * @param year int value of the year given to the Date object
     */
    public Date(int day, int month, int year)
    {
        //Catch all negative values
        day=Math.abs(day);month=Math.abs(month);year=Math.abs(year);

        //Check if month is out of limits
        if(month<=12){

            this.month = month;
            this.year= year;

        }else {

            this.month = 1;
            this.year = year+1;

        }
        //Check if day is out of limits
        if(day<=daysInMonth())

            this.day = day;
        else {

            this.day=1;
            this.month+=1;

            //Check month again
            if(month>12){
                this.month = 1;
                this.year = year+1; //Not a mistake, year cannot grow by more tha one
            }
        }

    }

    /**
     * Use to check of a date is before ot after the current date
     * @implNote Same date is considered false
     * @param date2 Date to be checked against the current date
     * @return boolean value ture if the current date is before the argument and false if contrary
     */
    //
    public boolean isBefore(Date date2){

        if(year<date2.year)
            return true;
        else if(year> date2.year)
            return false;
        else if(month< date2.month)
            return true;
        else if(month>date2.month)
            return false;
        else if(day<date2.day)
            return true;
        else
            return false;
    }

    /**
     * Checks if the current year is a leap year
     * @return boolean true if the current year is a leap year
     */
    private boolean isLeapYear(){
        //Leap
        if (year % 4 == 0) {
            //Check century
            if (year % 100 == 0) {
                //For years ending with 00
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            }else
                return true;
        }

        else
            return false;
    }

    /**
     * Checks if the given year in a date is a leap year
     * @param d Date to check for leap year
     * @return boolean true if the given year is a leap year
     */
    private boolean isLeapYear(Date d){
        //Leap
        if (d.year % 4 == 0) {
            //Check century
            if (d.year % 100 == 0) {
                //For years ending with 00
                if (d.year % 400 == 0)
                    return true;
                else
                    return false;
            }else
                return true;
        }

        else
            return false;
    }

    /**
     * Returns the number of days in the given month of the current date
     * @return int number of days in the given month of the current date
     */
    private int daysInMonth(){
        int toReturn=-1;
        switch(month){
            case 1: case 3: case 5: case 7:case 8: case 10: case 12:
                toReturn=31;
                break;
            case 2:
                if(isLeapYear())
                    toReturn=29;
                else
                    toReturn=28;
                break;
            case 4: case 6: case 9: case 11:
                toReturn=30;
        }
        return toReturn;
    }

    /**
     * Ticks over the date by one day
     */
    private void nextDay(){

        this.day+=1;

        if(day>daysInMonth()){

            this.month+=1;
            this.day=1;

            if(month>12){

                this.year+=1;
                this.month=1;

            }


        }
    }

    /**
     * Use to get the number of days until a given date (from the current date)
     * @implNote Returns 0 if given date is before current day
     * @param date2 Target date
     * @return int  number of days until a given date (from the current date)
     */
    public int numberOfDaysUntil(Date date2){
        int count=0;
        Date currentDate = copy();
        while(currentDate.isBefore(date2)){
            currentDate.nextDay();
            count++;
        }
        return count;
    }

    /**
     * Used to convert the current day into a date class
     * @return Date class of current day
     */
    //Dependent on java.util.GregorianCalendar
    public static Date today(){

        GregorianCalendar currentDate = new GregorianCalendar();

        return new Date(currentDate.get(GregorianCalendar.DATE),currentDate.get(GregorianCalendar.MONTH)+1,currentDate.get(GregorianCalendar.YEAR));
    }

    /**
     *  Use to get a copy of the current date
     * @return Date copy of the current date
     */
    public Date copy(){
        return new Date (day,month,year);
    }

    /**
     * Use to check if the given date is the same object as the current date
     * @param obj Object to be checked
     * @return boolean value, tur if the argument is the same as the current object and false if contrary
     */
    @Override public boolean equals(Object obj){
        if(!(obj instanceof Date))
            return false;
        Date other = (Date) obj;
        return day== other.day && month==other.month && year==other.year;
    }

    /**
     * Use to print the current date as a srting
     * @return String of current date
     */
    @Override public String toString(){
        return String.format("%02d/%02d/%d",day,month,year);
    }
/*
  public static void main(String[] args) {
    Date D1= new Date(1,12,1999);
    Date D2= new Date(27,11,1999);
    //Test copy
    //Date D3 =D1.copy();
    //Date D4 = today();

    //Test to string
    System.out.println(D1.toString());
    System.out.println(D2.toString());
    //System.out.println(D3.toString());
    //System.out.println(D4.toString());

    //Test equals

    if(D1.equals(D2)){
      System.out.println("Same date(D1-D2)");
    }else{
      System.out.println("Not the same date(D1-D2)");
    }
    if(D1.equals(D3)){
      System.out.println("Same (D1-D3)");
    }else{
      System.out.println("Not the same date(D1-D3)");
    }

    //Test isBefore

    if (D1.isBefore(D3)){
      System.out.println(D1.toString()+" is before "+D3.toString());
    }else {
      System.out.println(D1.toString()+" is not before "+D3.toString());
    }

    //Test nextDay

    D1.nextDay();
    D2.nextDay();
    System.out.println(D1.toString());
    System.out.println(D2.toString());

  System.out.println("Day difference: "+D1.numberOfDaysUntil(D2));
  }
  */

}