class Ticket{
    private static int currentID = 700;
    private int ticketID;
    String status = "Pending";
    String generatedTime;
    public Ticket(String generatedTime)
    {
        this.ticketID = currentID;
        currentID += 1;
        this.generatedTime = generatedTime;
        this.ticketinfo();
    }
    public void ticketinfo(){
        System.out.println();
        System.out.println("Your ticket #"+this.ticketID+" was generated at "+this.generatedTime+". You will be connected to a Support Agent shortly.");
        System.out.println();
    }
    public int getID(){
        return this.ticketID;
    }
}