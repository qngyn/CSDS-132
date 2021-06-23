//The Class Utility presents utiliy//
class Utility {
  
  //a private field for utility charges//
  private double utilityRate;
  
  // a private field month usage//
  private int monthUsage; 
  
  // a private field for year usage//
  private int yearUsage; 
  
  //a private field for this month bill//
  private double monthBill; 
  
  // a private fill for account balance//
  private double balance; 
  
  // a private field for the amount paid this month//
  private double amountPaidThisMonth; 
  
  // a private field for deliquent account//
  private double amountDelinquent; 
  
  //a private field for aniversary date of account//
  private Date aniversaryDate; 
  
  //a private field for sales tax rate//
  private static double salesTaxRate; 
  
  //a private for the interest rate//
  private static double interestRate; 
  
  //a private for the monthly charge//
  private double monthlyCharge; 
  
  /* the constructor for setting the fields of utility, 
   * it will make the utility with an utility rate and aniversary date*/
  public Utility(double utilityRate, Date aniversaryDate) {
    this.utilityRate = utilityRate;
    if (aniversaryDate.equals(new Date(29,2,2000))){
      setAniversaryDate(new Date(28,2,aniversaryDate.getYear()));
    }
    else {
      setAniversaryDate(aniversaryDate);
    }
  }
  
  //Give the Utility rate that utility charges//
  public double getUtilityRate() {
    return utilityRate;
  }
  
  //Set the Utility rate that utility charges//
  public void setUtilityRate(double utilityRate) {
    this.utilityRate = utilityRate;
  }
  
  //Give the amount of utility that is used in this month//
  public int getMonthUsage() {
    return monthUsage;
  }
  
  //Set the amount of utility that is used in one specific month//
  public void setMonthUsage(int monthUsage) {
    this.monthUsage = monthUsage;
  }
  
  //Give the amount of utility that is used in one year//
  public int getYearUsage() {
    return yearUsage;
  }
  
  //Increase the amount paid of this month by input amount//
  public void updateYearUsage(int yearUsage){
    this.yearUsage = yearUsage + this.getYearUsage();
  }
  
  //Give the amount billed this month//
  public double getMonthBill() {
    return monthBill;
  }
  
  //Set the amount billed ths month//
  public void setMonthBill(double monthBill) {
    this.monthBill = monthBill;
  }
  
  //Give the balance of the account//
  public double getBalance() {
    return balance;
  }
  
  //This method should update the balance by adding the input to the balance//
  public void updateBalance(double balance) {
    this.balance = balance + this.balance;
  }
  
  //Give the amount paid this month//
  public double getAmountPaidThisMonth() {
    return amountPaidThisMonth;
  }
  
  //Increasing the amount paid this month by the input//
  public void updateAmountPaidThisMonth(double amountPaidThisMonth) {
    this.amountPaidThisMonth = amountPaidThisMonth + this.amountPaidThisMonth;
  }
  
  //Method determines the account is deliquent//
  public double getAmountDelinquent() {
    return amountDelinquent;
  }
  
  //Method that set the amount that the account is deliquent//
  public void setAmountDelinquent(double amountDelinquent) {
    this.amountDelinquent = amountDelinquent;
  }
  
  //Method that will decrease the balance and increase the amountPaidThisMonth with the same input amount//
  public void makePayment(double a) {
    updateBalance(-a);
    updateAmountPaidThisMonth(a);
    
  }
  
  //It returns the Aniversary Date of the account//
  public Date getAniversaryDate() {
    return aniversaryDate;
  }
  
  //change the Aniversary Date as the input date//
  public void setAniversaryDate(Date aniversaryDate) {
    //if the input date is different from 29,2 of any leap year, it will change the aniversary date into this date//
    //if the input date is 29,2 of any leap year, it will not change the aniversary date//
    if (aniversaryDate.equals(new Date(29,2,2000))){
    }
    else{
      this.aniversaryDate = aniversaryDate;
    }
  }
  
  //methods that returns one sale tax rates for every utility instance//
  public static double getSalesTaxRate() {
    return salesTaxRate;
  }
  
  //methods that sets one sale tax rates for every utility instance//
  public void setSalesTaxRate(double salesTaxRate) {
    this.salesTaxRate = salesTaxRate;
  }
  
  //methods that returns one interest rate for every utility instance//
  public static double getInterestRate() {
    return interestRate;
  }
  
  //methods that set one interest rate for every utility instance//
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }
  
  //methods that returns the monthly charge by getting the multiplication from month usage and utility rate//
  public double getMonthlyCharge() {
    monthlyCharge = getMonthUsage()*getUtilityRate();
    return monthlyCharge;
  }
  
  public void endOfMonthProcessing(){
    //This will add monthlyCharge into the balance//
    updateBalance(getMonthlyCharge());
    
    //This will add the salesTaxRate times the monthlyCharge into the balance//
    updateBalance(getMonthlyCharge()*(getSalesTaxRate()/100));
    
    /*If the amount paid this month is smaller than the month bill, then the difference between the 
     * amount paid this month and monthbill will be added to the delinquent amount*/
    if (getAmountPaidThisMonth() < getMonthBill()){
      setAmountDelinquent(getAmountDelinquent() + (getMonthBill() - getAmountPaidThisMonth())); 
    }
    
    /*If the amount paid this month is greater than month bill, then the difference between the 
     * amount paid this month and month bill will be subtracted from the delinquent amount*/
    else if (getAmountPaidThisMonth() > getMonthBill()){
      setAmountDelinquent(getAmountDelinquent() - (getAmountPaidThisMonth() - getMonthBill()));
    }
    
    /*If the delinquent amount is positive, the multiplication of delinquent amount and the interst rate 
     * will be add to both the amount delinquent and balance*/
    if (getAmountDelinquent() > 0){
      setAmountDelinquent(getAmountDelinquent()*(getInterestRate()/100) + getAmountDelinquent());
      updateBalance(getAmountDelinquent()*(getInterestRate()/100));
    }
    
    //The monthBill is set to be the current balance//
    //the amount paid this month is set to be 0//
    setMonthBill(getBalance());
    updateAmountPaidThisMonth(-getAmountPaidThisMonth());
  }
  
  //This method set the year usage into 0//
  public void endOfYearProcessing(){
    updateYearUsage(-getYearUsage());
  }
}
