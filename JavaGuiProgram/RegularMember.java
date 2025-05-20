public class RegularMember extends GymMember
{
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    public RegularMember(int id, String name, String location, String phone, 
    String email, String gender, String DOB, String membershipStartDate, String referalSource)
    {
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.referralSource=referalSource;
        this.isEligibleForUpgrade=false;
        this.attendanceLimit=30;
        this.plan="basic";
        this.price=6500;
        this.removalReason="";
    }
    
    public int getAttendanceLimit(){
        return this.attendanceLimit;
    }
    public boolean  getIsEligibleForUpgrade(){
        if(super.getAttendance()>=this.getAttendanceLimit()){
            this.isEligibleForUpgrade=true;
        }
        return this.isEligibleForUpgrade;
    }
    public String getRemovalReason(){
        return this.removalReason;
    }
    public String getReferralSource(){
        return this.referralSource;
    }
    public String getPlan(){
        return this.plan;
    }
    public double getPrice(){
        return this.price;
    }
    
    public void markAttendance(){
        super.attendance= super.getAttendance() +1;
        super.loyaltyPoints= super.getLoyaltyPoints() +5;
    }
    
    public double getPlanPrice(String plan){
        switch(plan){
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        }
    }
    
    public String upgradePlan(String plan){        
        if(this.getIsEligibleForUpgrade()){
            
            if(this.getPlanPrice(plan) == -1){
                return "Please Enter a Valid Gym Plan.";
            }
            else if(this.plan == plan){
                return "You are Already Subscribed to this Plan.";
            }
            else{
                this.plan=plan;
                this.price=getPlanPrice(plan);
                return "Gym Plan Successfully Upgraded";
            }
        }
        else{
            return "The Member is not Eligible for Upgrade.";
        }
    }
    
    public void revertRegularMember(String removalReason){
        this.removalReason=removalReason;
        super.resetMember();
        this.isEligibleForUpgrade=false;
        this.plan="basic";
        this.price=6500;
    }
    
    public void display(){
        super.display();
        System.out.println("Gym Plan :\t"+ this.plan);
        System.out.println("Price :\t"+ this.price);
        if(this.removalReason != ""){
            System.out.println("Removal Reason :\n"+ this.removalReason);
        }
    }
}