//The WaterUtility Class preresent water utility//
class WaterUtility extends Utility{
  
  // a field to store number of baths//
  private int numBaths; 
  
  // a field to set the fee per bath//
  private double bathFee; 
  
  /* A constructor of WaterUtility class that make a WaterUtility with an utility rate, aniversary date, 
   * number of baths, bath fee*/
  public WaterUtility(double utilityRate, Date aniversaryDate, int numBaths, double bathFee){
    super(utilityRate, aniversaryDate); 
    this.numBaths = numBaths;
    this.bathFee = bathFee;
  }
  
  //Get the number of bathroom for this account//
  public int getNumBaths() {
    return numBaths;
  }
  
  //Set the number of bathroom for this account//
  public void setNumBaths(int numBaths) {
    this.numBaths = numBaths; 
  }
  
  //Get the number of bath fee for this account//
  public double getBathFee() {
    return bathFee;
  }
  
  //Set the number of Bath Fee for this account//
  public void setBathFee(double bathFee) {
    this.bathFee = bathFee;
  }
  
  //Change the method of the getMonthlyCharge//
  @Override
  public double getMonthlyCharge() {
    /*This will add the multiplication of number of baths and bath fee to the montly charge*/
    return (super.getMonthlyCharge() + (getNumBaths()*getBathFee()));
  }
}
