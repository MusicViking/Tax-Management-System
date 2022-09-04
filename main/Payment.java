class Payment{
    private static final String FILL = "--------------------------------------";
    private static int currentID = 100;
    private int paymentID;
    double amount;
    String paymentStatus = "Pending";
    String modeOfPayment;
    public void setAmount(double amt){
        this.amount = amt;
        this.paymentID = currentID;
        this.paymentStatus = "Completed";
        currentID += 1;
    }
    public void setMode(String mode){
        this.modeOfPayment = mode;
    }
    public void bill(){
        System.out.println(FILL);
        System.out.println("Payment ID: "+this.paymentID);
        System.out.println("Mode of Payment: "+this.modeOfPayment);
        System.out.println("Amount: "+this.amount);
        System.out.println("Status: "+this.paymentStatus);
        System.out.println(FILL);
    }
}