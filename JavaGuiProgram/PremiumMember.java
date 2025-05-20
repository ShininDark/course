public class PremiumMember extends GymMember
{
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    public PremiumMember(int id, String name, String location, String phone, 
    String email, String gender, String DOB, String membershipStartDate, String personalTrainer)
    {
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.personalTrainer=personalTrainer;
        this.premiumCharge=50000;
        this.paidAmount=0;
        this.isFullPayment=false;
        this.discountAmount=0;
    }
    
    public void markAttendance(){
        super.attendance= super.getAttendance() +1;
        super.loyaltyPoints= super.getLoyaltyPoints() +10;
    }    
    public double getPremiumCharge(){
        return this.premiumCharge;
    }
    public String getPersonalTrainer(){
        return this.personalTrainer;
    }
    public boolean getIsFullPayment(){
        return this.isFullPayment;
    }
    public double getPaidAmount(){
        return this.paidAmount;
    }
    public double getDiscountAmount(){
        return this.discountAmount;
    }

    //wrong probably
    public String payDueAmount(double paidAmount){
        this.paidAmount = this.paidAmount+paidAmount;
        if(this.isFullPayment == true){
            System.out.println("The Full Payment has already been Completed.");
            return "The Full Payment has already been Completed.";
        }
        else if(this.paidAmount>this.premiumCharge){
            System.out.println("Excess Amount has been Paid.");
            return "Excess Amount has been Paid.";
        }
        else if(this.paidAmount == this.premiumCharge){
            System.out.println("Full Payment Completed.");
            this.isFullPayment=true;
            return "Full Payment Completed.";
        }
        else{
            System.out.println("Payment Successful.\nRemaining Amount : "+(this.premiumCharge-this.paidAmount));
            return "Payment Successful.";
        }
    }    
    
    public void calculateDiscount(){
        if(this.isFullPayment)
        {
            this.discountAmount = 0.1*this.premiumCharge;
            System.out.println("The discount has been applied.");
        }
    }
    
     public void display(){
        super.display();
        System.out.println("Personal Trainer :\t"+ this.personalTrainer);
        System.out.println("Paid Amount :\t"+ this.paidAmount);
        System.out.println("Payment Clearence :\t"+ this.isFullPayment);
        System.out.println("Remaining Amount :\t"+ (this.premiumCharge-this.paidAmount));

        if(this.isFullPayment){
            System.out.println("Discount Amount :\t"+ this.discountAmount);
        }
    }
}
