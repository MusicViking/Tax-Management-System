class Clerk extends Employee{
    public static final String EMPTYPE = "Clerk";
    public static int slotcount = 0;
    public int clientcount = 0;
    int[] docVerificationStatus = new int[10];
    String[] clients = new String[10];
    String[] slots = new String[20];
    public Clerk(String name){
      super(name,EMPTYPE);
    }
    @Override
    public void solveIssue(Client client){
        client.docs.uploadDocs(client);
        this.clients[clientcount] = client.username;
        this.docVerificationStatus[clientcount] = 1;
        clientcount += 1;
        System.out.println();
        System.out.println("Your Documents have been verified!");
        System.out.println();
    }
    public void scheduleMeeting(Client c, Accountant a, String slot){
        int flag = 0;
        for (int i=0; i<slotcount; i++){
            if (this.slots[i]!=null){
                if (this.slots[i].equals(slot)){
                    flag = 1;
                    System.out.println();
                    System.out.println("There\'s another meeting scheduled in the requested slot. Please pick another slot.");
                    System.out.println();
                    break;
                }
            }
        }
        if (flag == 0){
            this.slots[slotcount] = slot;
            slotcount += 1;
            for (int i=0; i<this.clientcount; i++){
                if (this.clients[i].equals(c.username)){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                this.clients[clientcount] = c.username;
                this.clientcount += 1;
            }
            c.getMeetingslot().setAccountantID(a.empID);
            System.out.println();
            System.out.println("Your Meeting is scheduled by Clerk#"+this.empID+" with Accountant#"+a.empID+" on "+slot+".");
            System.out.println();
        }
    }
}