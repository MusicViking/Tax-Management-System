class SupportStaff extends Employee{
    private static final String FILL = "--------------------------------------";
    public static final String EMPTYPE = "Support";
    public Ticket ticket;
    public SupportStaff(String name)
    {
        super(name,EMPTYPE);
    }
    public void solveIssue(Client client){
        this.ticket = client.generateTicket("12:00 p.m");
        System.out.println(FILL);
        System.out.println("You're connected to Support#"+this.empID);
        System.out.println("Your ticket#"+this.ticket.getID()+ " is being resolved.");
        System.out.println("Your issue had been solved!");
        System.out.println(FILL);
    }
}