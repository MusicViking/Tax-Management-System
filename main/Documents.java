class Documents{
    boolean pancard = false;
    boolean aadhaar = false;
    boolean form16 = false;
    boolean driversLicence = false;
    public void uploadDocs(Client client){
        client.docs.pancard = true;
        client.docs.aadhaar = true;
        client.docs.form16 = true;
        client.docs.driversLicence = true;
    }
}