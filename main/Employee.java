abstract class Employee{
    private static int currentID = 200;
    int empID;
    public String name;
    public String type;
    protected Employee(String name, String emptype)
    {
        this.empID = currentID;
        currentID += 1;
        this.name = name;
        this.type = emptype;
        Administration.addEmployee(this);
    }
    public abstract void solveIssue(Client client);
}