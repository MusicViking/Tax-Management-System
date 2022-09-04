import java.util.Scanner;
public class Main {
    public static boolean login(Client client){
        Scanner scan = new Scanner(System.in);
        int logincount=0;
        String username;
        System.out.println("*******WELCOME TO ONLINE TAX MANAGEMENT PORTAL*******");
        do{
            System.out.print("Enter your Username: ");
            username = scan.nextLine();
            logincount += 1;
        }while (!(client.username.equals(username)) && (logincount!=2));
        if (logincount == 2 && !(client.username.equals(username))){
            return false;
        }
        else{
            logincount=0;
            do{
                System.out.print("Enter Password: ");
                username = scan.nextLine();
                logincount += 1;
            }while (!(client.getpass().equals(username)) && (logincount!=2));
            if (logincount == 2 && !(client.getpass().equals(username))){
                return false;
            }
            return true;
        }
    }
    public static void welcome(Client client){
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        int ch;
        System.out.println();
        System.out.println("*****Login Successful*****");
        System.out.println();
        System.out.println("Welcome, "+client.name+"!");
        System.out.println();
        System.out.println("How can we help you?");
        System.out.println("1. Upload Documents");
        System.out.println("2. Schedule Meeting");
        System.out.println("3. Make Payment");
        System.out.println("4. Raise a Ticket");
        System.out.println("5. View Tax Summary");
        System.out.println("6. View Profile");
        System.out.println("7. Exit");
        do{
            System.out.print("Enter your Choice: ");
            ch = scan.nextInt();
            scan.nextLine();
            switch(ch)
            {
                case 1:
                    Administration.manageRequest(client, Clerk.EMPTYPE);
                    break;
                case 2:
                    Administration.manageRequest(client);
                    break;
                case 3:
                    System.out.print("Enter mode of payment: ");
                    client.makePayment("Sunbeams Consultants",20000,scan.nextLine());
                    break;
                case 4:
                    Administration.manageRequest(client, SupportStaff.EMPTYPE);
                    break;
                case 5:
                    Administration.assignAccountant(client);
                    break;
                case 6:
                    client.viewprofile();
                    break;
                case 7:
                    System.out.println("Thank you!");
                    flag = 1;
                    break; 
                default:
                    break;
            }
        }while(flag == 0);
    }
    public static void main(String[] args) {
        // adding clients
        Client foo;
        String temp = "n";
        Scanner scan = new Scanner(System.in);
        Date d = new Date(10,10,2000);
        Client a = new Client("Sujith","abcd@123",d,"ABCTY1234D","9876543210","629471429957719");
        d =new Date(15,9,2002);
        Client b= new Client("Kishore","def@456",d,"DEFGH9876K","6789123453","852542881618661");
        d=new Date(8,7,1999);
        Client c=new Client("Abinav","xyz@9870",d,"XYHUI6547L","9123456730","557730189983534");

        //upcasting
        //adding Employees
        Employee e1 = new SupportStaff("Mark");
        Employee e2 = new SupportStaff("Jimmy");
        Employee e3 = new SupportStaff("Krish");
        Employee n1 = new Accountant("Vikram");
        Employee n2 = new Accountant("abhi");
        Employee n3 = new Accountant("jack");
        Employee n4 = new Clerk("max");
        Employee n5 = new Clerk("miller");
        Employee n6 = new Clerk("john");
        foo = a;
        do {
            if (temp.equals("y")){
                if (foo.equals(a)){
                    foo = b;
                }
                else if (foo.equals(b)){
                    foo = c;
                }
                else{
                    foo = a;
                }
            }
            if (login(foo)){
                welcome(foo);
                System.out.print("Change Client (y/n)? ");
                temp = scan.nextLine();
            }
            else{
                System.out.println("Invalid Credentials");
                System.out.print("Change Client (y/n)? ");
                temp = scan.nextLine();
            }
        } while (temp.equals("y"));
        scan.close();
        
    }
}