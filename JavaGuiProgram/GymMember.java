public abstract class GymMember
{
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    public GymMember(int id, String name, String location, String phone, 
    String email, String gender, String DOB, String membershipStartDate)
    {
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.attendance=0;
        this.loyaltyPoints=0;
        this.activeStatus=false;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getLocation(){
        return this.location;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getEmail(){
        return this.email;
    }
    public String getGender(){
        return this.gender;
    }
    public String getDOB(){
        return this.DOB;
    }
    public String getMembershipStartDate(){
        return this.membershipStartDate;
    }
    public int getAttendance(){
        return this.attendance;
    }
    public double getLoyaltyPoints(){
        return this.loyaltyPoints;
    }
    public boolean getActiveStatus(){
        return this.activeStatus;
    }
    
    public abstract void markAttendance();
    
    public void activateMembership(){
        this.activeStatus=true;
        System.out.println("The Membership has been Activated");

    }
    public void deactivateMembership(){
        if(this.activeStatus==true){
            this.activeStatus=false;
            System.out.println("The Membership has been Deactivated");

        }
        else{
            System.out.println("The Membership is already Deactivated");
        }
    }
    public void resetMember(){
        this.activeStatus=false;
        this.attendance=0;
        this.loyaltyPoints=0;
    }
    public void display(){
        System.out.println("MEMBER DETAILS:\n");
        System.out.println("Member ID :\t"+this.getId());
        System.out.println("Name :\t"+this.getName());
        System.out.println("Address :\t"+this.getLocation());
        System.out.println("Phone no. :\t"+this.getPhone());
        System.out.println("Email :\t"+this.getEmail());
        System.out.println("Gender :\t"+this.getGender());
        System.out.println("DOB :\t"+this.getDOB());
        System.out.println("Start Date :\t"+this.getMembershipStartDate());
        System.out.println("Attendance :\t"+this.getAttendance());
        System.out.println("Loyalty Points :\t"+this.getLoyaltyPoints());
        System.out.println("Active Status :\t"+this.getActiveStatus());
    }
}
