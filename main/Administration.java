import java.util.Scanner;
import java.util.Random;
class Administration{
    private static int employeecount = 0;
    private static int clientcount = 0;
    private static Employee[] employeelist = new Employee[10];
    private static Client[] clientlist = new Client[10];
    private static int[] paymentAcknowledgementStatus = new int[10];
    private static Random rd = new Random();
    public static void addEmployee(Employee a){
        if (employeecount>9)
        {
            System.out.println("Max employees reached");
        }
        else{
            employeelist[employeecount] = a;
            employeecount += 1;
        }
    }
    public static void addClient(Client a){
        if (clientcount>9)
        {
            System.out.println("Max clients reached");
        }
        else{
            clientlist[clientcount] = a;
            clientcount += 1;
        }
    }
    public static void updatePaymentstatus(){
        for (int i=0; i<clientcount; i++){ 
            if (clientlist[i].slip.paymentStatus.equals("Completed")){
                paymentAcknowledgementStatus[i] = 1;
            }
        }
    }
    public static void displayPaymentStatus(){
        for (int i=0; i<clientcount; i++)
        {
            System.out.println(paymentAcknowledgementStatus[i]);
        }
    }
    public static void manageRequest(Client client,String emptype){
        int a;
        do {
            a = rd.nextInt(employeecount);
        } while (!(employeelist[a].type.equals(emptype)));
        employeelist[a].solveIssue(client);
    }
    // method overloading to schedule meetings
    public static void manageRequest(Client client){
        int a;
        Scanner scan = new Scanner(System.in);
        do {
            a = rd.nextInt(employeecount);
        } while (!(employeelist[a].type.equals(Clerk.EMPTYPE)));
        // downcasting
        if (employeelist[a] instanceof Clerk){
            Clerk clerk = (Clerk)employeelist[a];
            do {
                a = rd.nextInt(employeecount);
            } while (!(employeelist[a].type.equals(Accountant.EMPTYPE)));
            // downcasting
            if (employeelist[a] instanceof Accountant){
                Accountant accountant = (Accountant)employeelist[a];
                System.out.print("Enter a slot: "); // 12 JAN 2022 10:30 AM
                clerk.scheduleMeeting(client, accountant, scan.nextLine());
            }
        }
    }
    public static void assignAccountant(Client client){
        int a;
        int i;
        do {
            a = rd.nextInt(employeecount);
        } while (!(employeelist[a].type.equals(Accountant.EMPTYPE)));
        for (i=0; i<clientcount; i++){
            if (clientlist[i].username.equals(client.username)){
                break;
            }
        }
        if (paymentAcknowledgementStatus[i] == 0){
            System.out.println();
            System.out.println("You have to complete payment to view Tax Summary!");
            System.out.println();
        }
        else{
            employeelist[a].solveIssue(client);
        }
        
    }
}