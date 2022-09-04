class Accountant extends Employee{
    public static final String EMPTYPE = "Accountant";
    Meetings slot;
    public Accountant(String name){
        super(name,EMPTYPE);
    }
    @Override
    public void solveIssue(Client client){
        FilingSite clienttax = client.getTaxSummary();
        if (clienttax.grossIncome < 20000){
            clienttax.deductions = clienttax.grossIncome;
            clienttax.total = 0;
        }
        else if (clienttax.grossIncome <100000){
            clienttax.deductions = 0.5*clienttax.grossIncome;
            clienttax.total = 0.2;
        }
        else{
            clienttax.deductions = 0.2*clienttax.grossIncome;
            clienttax.total = 0.3;
        }
        clienttax.taxableIncome = clienttax.grossIncome - clienttax.deductions;
        clienttax.total *= clienttax.taxableIncome;
        clienttax.viewSummary();
    }
}