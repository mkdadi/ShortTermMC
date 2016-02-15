package src;

/**
 * This Class defines the Faculty object for courses 
 * 
 * @author Madhu Kumar Dadi 
 * @version 16.1.2016
 */

public class Faculty
{
    public String name;
    public String phone;
    public String mailId;
    public String department;
    public String address;

    /**
     * Default Constructor for objects of class faculty
     */
    public Faculty()
    {
        this.name="";
        this.phone="nophone!";
        this.mailId="default@mail.id";
        this.department="";
        this.address="";
    }
    
    /**
     * Constructor for objects of class Faculty
     * 
     * @param name Faculty Name
     * @param phone Phone number
     * @param mailid email ID
     * @param dept department
     */
    
    public Faculty(String name,String phone,String mailid,String dept)
    {
        this.name=name;
        this.phone=phone;
        this.mailId=mailid;
        this.department=dept;
        this.address="";
    }
}