import java.util.Random;
import java.util.Scanner;
class FilingSite extends TaxSummary{
    private static final String FILL = "--------------------------------------";
    private static Random rd = new Random();
    private String OTP = "";
    private String taxCategory;
    public FilingSite(double gross, String taxcat){
        super(gross);
        this.taxCategory = taxcat;
    }
    public void generateOTP(){
        for (int i=0; i<4; i++){
            this.OTP += rd.nextInt(9);
        }
        System.out.print("Enter your OTP (Type in "+this.OTP+"): ");
    }
    public void viewSummary(){
        Scanner scan = new Scanner(System.in);
        this.generateOTP();
        String otp = scan.nextLine();
        if (this.OTP.equals(otp)){
            System.out.println(FILL);
            System.out.println("Gross Income: "+this.grossIncome);
            System.out.println("Tax Category: "+this.taxCategory);
            System.out.println("Total Deductions Eligible: "+this.deductions);
            System.out.println("Taxable Income: "+this.taxableIncome);
            System.out.println("Total Payable Tax amount: "+this.total);
            System.out.println(FILL);
        }
        else{
            System.out.println("Invalid OTP. Try again");
            this.OTP = "";
            viewSummary(); 
        }
    }
}