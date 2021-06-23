//The class GasUtility preresent gas utility//
public class GasUtility extends Utility{
  
  //a private field for installment plan//
  private boolean installmentPlan; 
  
  //a private field for installment amount//
  private double amountInstallment; 
  
  //the constructor for GasUtility class//
  public GasUtility(double utilityRate, Date aniversaryDate){
    super(utilityRate, aniversaryDate);
  }
  
  //Return if this utility is using an installment plan//
  public boolean isInstallmentPlan() {
    return installmentPlan;
  }
  
  //Sets whether this utility uses the installment plan//
  public void setInstallmentPlan(boolean installmentPlan){
    this.installmentPlan = installmentPlan;
  }
  
  @Override 
  //This will update the method of endOfYearProcessing//
  public void endOfYearProcessing(){
    //set the installment amount which is equal to the year usage divide by 12// 
    //the year usage will be set to 0//
    this.amountInstallment = this.getYearUsage()/12; 
    updateYearUsage(-getYearUsage());
  }
  
  //This will return the charge depending on the installment plan//
  public double getMonthlyCharge(boolean installmentPlan){
    //If there is the installment plan, it will return the amount installment//
    //If there is no installment plan, it will return the monthly charge//
    if (installmentPlan) {
      return this.amountInstallment;
    }
    else{
      return super.getMonthlyCharge();
    }
  }
  
  @Override
  //this will update the endOfMonthProcessing method//
  public void endOfMonthProcessing(){
    /*if the account has the installment plan, it will add the amount installment. the delinquent amount
     * and the multiplication of installment amount and sales tax rate */
    super.endOfMonthProcessing();
    if (isInstallmentPlan()) {
      this.setMonthBill(this.amountInstallment + (this.amountInstallment*(getSalesTaxRate()/100)) + getAmountDelinquent());
    }
  }
}
  
