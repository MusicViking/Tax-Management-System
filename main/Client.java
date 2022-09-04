import java.util.Scanner;
class Client{
    private static int usercount = 1;
    public String name;
    public String username;
    private String password;
    private Date dob;
    private String pan;
    private String phone;
    private String accountNo;
    private Meetings slot;
    private static final String FILL = "--------------------------------------";
    Documents docs;
    Acknowledgement slip;
    FilingSite forTax;
    protected Client(String name, String passowrd, Date dob, String pan, String phone, String acc){
        this.name = name;
        this.password = passowrd;
        this.dob = new Date(dob.day, dob.month, dob.year);
        this.username = "user#" + usercount;
        usercount += 1;
        this.pan = pan;
        this.phone = phone;
        this.accountNo = acc;
        this.slip = new Acknowledgement();
        this.docs = new Documents();
        this.slot = new Meetings();
        Administration.addClient(this);
    }
    public void makePayment(String payee, double amt, String mode){
        this.slip.setPayee(payee);
        this.slip.setAmount(amt);
        this.slip.setMode(mode);
        System.out.println("Payment Successful!");
        Administration.updatePaymentstatus();
        this.slip.bill();
    }
    public Ticket generateTicket(String time){
        return new Ticket(time);
    }
    public Meetings getMeetingslot(){
        return this.slot;
    }
    public FilingSite getTaxSummary(){
        Scanner scan = new Scanner(System.in);
        double gross;
        System.out.print("Enter Gross Income: ");
        gross=scan.nextDouble();
        scan.nextLine();
        String type;
        System.out.print("Enter Income Category: ");
        type=scan.nextLine();
        this.forTax = new FilingSite(gross,type);
        return this.forTax;
    }
    public String getpass(){
        return this.password;
    }
    public void viewprofile(){
        System.out.println(FILL);
        System.out.println("Username: "+this.username);
        System.out.println("Name: "+this.name);
        System.out.println("DOB: "+this.dob.getdate());
        System.out.println("Phone: "+this.phone);
        System.out.println("PAN: "+this.pan);
        System.out.println("Bank Account: "+this.accountNo);
        System.out.println(FILL);
    }
}