class Date{
    int day;
    int month;
    int year;
    protected Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public String getdate(){
        return this.day+"/"+this.month+"/"+this.year;
    }
}