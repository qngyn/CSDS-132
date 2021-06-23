// The Date class present the Date//
public class Date { 
  
  // a field to store the day //
  private int day; 
  
  // a field to store the month //
  private int month; 
  
  // a field to store the year //
  private int year; 
  
  /*A constructor for class Date to make a Date with day, month, year, respectively
   * If the date has the month entered less than 1, it will return 1. 
   * If the date has the month entered more than 12, it will return 12. Otherwise, it will return as entered. 
   * If the day of the date entered is less than 1, it will return 1. 
   * If the day of the date entered is more than the maximum days of the month, it will return the largest day. 
   * Otherwise, it will return as entered. */
  public Date(int day, int month, int year) {  
    this.year = year;
    if(month >=1 & month <=12) {
      this.month = month;
    }
    else if (month < 1) {
      this.month = 1;
    }
    else {
      this.month = 12;
    }
    if (day > daysPerMonth(this.month, year)){
      this.day = daysPerMonth(this.month, year);
    }
    else if (day < 1){
      this.day = 1;
    }
    else{
      this.day = day;
    }
  } 
  
  /*Returns the year of the Date*/ 
  public int getYear() { 
    return year;
  }
  
  /* Change the year of the Date*/
  public void setYear(int year) { 
    this.year = year;
  }
  
  /*Returns the month of the Date, which range from 1 to 12*/
  public int getMonth(){
    return month;
  }
  
  //Change the month of the Date//
  public void setMonth(int month){ 
    /* The input month is  range from 1 to 12. 
     * If it is out of this range, it will be set to 1*/
    if (month >= 1 & month <=12){
    } 
    else {
      month = 1;
    }
    this.month = month;
  }
  
  /*Determines the day of the Date, which ranges from 1 to 31*/
  public int getDay() {
    return day;
  }
  
  //Change the day of the Date//
  public void setDay(int day){
    /* The input day is  range from 1 to 31. 
     * If it is out of this range, it will be set to 1*/
    if (day >= 1 & day <= 31){
    }
    else {
      //if it is out of the range//
      day = 1;
    }
    this.day = day;
  }
  
  /* the method determines if the year is  the leap year. It should return true if year is divisible by 4. 
   * If year is divisible by 100, it returns false. If year is divisible by 400, it returns true
   * */
  public static boolean isLeapYear(int year) {
    boolean isLeap = false;
    if (year%4 ==0) {
      if (year%100 == 0) {
        if (year%400 == 0)
          isLeap = true;
        else 
          isLeap = false;
      }
      else isLeap = true;
    }
    else isLeap = false;
    return isLeap;
  }
  
  /* The method returns the maximum number of days in an input month of an input year*/
  public static int daysPerMonth(int month, int year) { 
    //If the month is 1, 3, 5, 7, 8, 10, 12, it should returns 31//
    //If the month is 2 of a leap year, it should return 29//
    //If the month is 2 of non-leap year, it should return 28//
    //Otherwise, it should return 30//
    int i = 0;
    if (month == 1|| month  == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
      i = 31;
    }
    else if (month == 2 && (isLeapYear(year) == true)){
      i = 29; 
    }
    else if (month == 2 && (isLeapYear(year) == false)){
      i = 28;
    }
    else{
      i = 30;
    }
    return i;
  }
  
  /*It determines as if the Date enter is this Date or not.*/
  public boolean sameEffectiveDayAs(Date date) {
   /* If it this Date, then returns true.
   * Or if the Date's day is larger than this Date's day of the last day of the month, it also returns true. 
   * Otherwise, it returns false*/
    if (this.getDay() == date.getDay()){
      return true;
    } 
    else if (date.getDay() > this.getDay() && this.getDay() == this.daysPerMonth(this.getMonth(), this.getYear())){
      return true;
    } 
    else{
      return false;
    }
  }
  
  //this returns the next day of this Date//
  public void incrementDate(){
    /*If the entered Date is the end day of the month, it should return the first day of next month.
     * If the entered Date is the end day of the year, it should return the first day of next year.
     * Otherwise, it returns the next day of the entered date*/
    if (this.getDay() == this.daysPerMonth(this.getMonth(), this.getYear())) {
      this.setDay(1);
      if (this.getMonth() == 12){
        this.setMonth(1);
        this.setYear(this.getYear() +1);
      }
      else{
        this.setMonth(this.getMonth() + 1);
      }
    }
    else{
      this.setDay(this.getDay() +1);
    }
  }
  
  /*This will compared two dates. If these two dates have the same day and same month despite of year, 
   * it will return true. Otherwise, it returns false*/
  @Override
  public boolean equals(Object obj) {    
    if (obj instanceof Date){
      Date other = (Date) obj;
      if (this.getDay() == other.getDay() && this.getMonth() == other.getMonth()) {
        return true;
      }
    }
    return false;
  }
  
  /*This will return the entered Date into the form of (month's name, day, and year) */
  @Override
  public String toString() {
    /*For the month, it will return the int month into the name of the month.
     * If month = 1, it will return to be January. If month = 2, it will return to be February.
     * If month = 3, it will return to be March. If month  = 4, it will return to be April.
     * If month = 5, it will return to be May. If month = 6, it will return to be June. 
     * If month = 7, it will return to be July. If month = 8, it will return to be August. 
     * If month = 9, it will return to be September. If month = 10, it will return to be October. 
     * If month = 11, it will return to be November. If month = 12, it will return to be December.
     */
    String m = "";
    int month = this.getMonth();
    if (month == 1) {
      m = "January";
    }
    else if (month == 2){
      m = "February" ;
    }
    else if (month == 3) {
      m = "March";
    } 
    else if (month == 4) {
      m = "April";
    } 
    else if (month == 5) {
      m = "May";
    }
    else if (month == 6) {
      m = "June";
    }
    else if (month == 7) {
      m = "July";
    }
    else if (month == 8) {
      m = "August";
    }
    else if (month == 9) {
      m = "September";
    }
    else if (month == 10) {
      m = "October";
    }
    else if (month == 11) {
      m = "November";
    }
    else {
      m = "December";
    }
    return m + " " + getDay() + "," + " " + getYear();
  }
}
        
       
