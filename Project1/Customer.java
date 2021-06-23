//The Customer Class preresent customer//
class Customer {
  
  //a private field store the electric utility//
  private Utility electricUtility = null; 
  
  //a private field store the water utility//
  private WaterUtility waterUtility = null; 
  
  //a private field store the gas utility//
  private GasUtility gasUtility = null;
  
  //a private field store the current date//
  private Date currentDate; 
  
  //constructor of Customer class. This constrructor takes a Date that is a customer's current Date//
  public Customer(Date currentDate){
    this.currentDate = currentDate;
  }
  
  /*constructor of the customer class that preresents the customer's current date, electric utility, water utility
   * and gas utility, respectively*/
  public Customer (Date currentDate, Utility electricUtility, WaterUtility waterUtility, GasUtility gasUtility) {
    this.currentDate = currentDate; 
    this.electricUtility = electricUtility; 
    this.waterUtility = waterUtility; 
    this.gasUtility = gasUtility; 
  }
  
  //This method return the electric utility// 
  public Utility getElectricUtility() {
    /*It return the electric utility as the input utility
     * If there is no electric utility, it should return null*/
    return electricUtility;
  }
  
  //This method set the electric utility for the customer//
  public void setElectricUtility(Utility electricUtility){
    this.electricUtility = electricUtility;
  }
 
  //This method return the water utility//
  public WaterUtility getWaterUtility(){ 
    /*It return the water utility as the input utility
     * If there is no water utility, it should return null*/
    return waterUtility;
  }
  
  //This method set the water utility for customer//
  public void setWaterUtility(WaterUtility waterUtility){
    this.waterUtility = waterUtility;
  }
  
  //This method return the gas utility//
  public GasUtility getGasUtility(){
    /*It return the gas utility as the input utility
     * If there is no gas utility, it should return null*/
    return gasUtility;
  }
  
  //This method set the gas utility for the customer//
  public void setGasUtility(GasUtility gasUtility){
    this.gasUtility = gasUtility;
  }
  
  //This method returns the current date for customer//
  public Date getDate(){
    return currentDate;
  }
  
  //This method will set the date for the current date//
  public void setDate(Date currentDate){
    this.currentDate = currentDate;
  }
  
  //This method will increment the current date for the customer//
  public void incrementDate(){
    this.getDate().incrementDate();
    
    /*If the new current date is same as the aniversary date of the electric utility, 
     * it will call the electric utility's endOfMonthProcessing */
    if (this.getDate().sameEffectiveDayAs(getElectricUtility().getAniversaryDate())){
      getElectricUtility().endOfMonthProcessing();
    }
    
    /*If the new current date is same as the aniversary date of the water utility, 
     * it will call the water utility's endOfMonthProcessing */
    if (this.getDate().sameEffectiveDayAs(getWaterUtility().getAniversaryDate())){
      getWaterUtility().endOfMonthProcessing();
    }
    
    /*If the new current date is same as the aniversary date of the gas utility, 
     * it will call the gas utility's endOfMonthProcessing */
    if (this.getDate().sameEffectiveDayAs(getGasUtility().getAniversaryDate())){
      getGasUtility().endOfMonthProcessing();
    }
    
    /*If the new current date is has the same day and same month of the aniversary date of electric utility, 
     * it will call the electric utility's endOfYearProcessing */
    if (this.getDate().equals(getElectricUtility().getAniversaryDate())){
      getElectricUtility().endOfYearProcessing();
    }
    
    /*If the new current date is has the same day and same month of the aniversary date of water utility, 
     * it will call the water utility's endOfYearProcessing */
    if (this.getDate().equals(getWaterUtility().getAniversaryDate())){
      getWaterUtility().endOfYearProcessing();
    }
    
    /*If the new current date is has the same day and same month of the aniversary date of gas utility, 
     * it will call the gas utility's endOfYearProcessing */
    if (this.getDate().equals(getGasUtility().getAniversaryDate())){
      getGasUtility().endOfYearProcessing();
    }
  }
}
