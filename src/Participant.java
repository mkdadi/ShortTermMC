package src;

/**
 * This class defines the Participant object and its methods for the courses 
 * 
 * @author Madhu Kumar Dadi 
 * @version 16.1.2016
 */

public class Participant
{
    public String name=new String();
    public String address=new String();
    public String phone=new String();
    public String organisation=new String();
    public String email=new String();

    /**
     * Default Constructor for objects of class participant
     */
    public Participant()
    {
        this.name="";
        this.address="";
        this.phone="nophone!";
        this.organisation="";
        this.email="default@mail.id";
    }
    
    /**
     * Constructor for objects of class participant
     */
    
    public Participant(String name,String phone,String orgstn,String mailid)
    {
        this.name=name;
        this.address="";
        this.phone=phone;
        this.organisation=orgstn;
        this.email=mailid;
    }
}
