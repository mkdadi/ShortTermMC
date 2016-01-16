 package src;
/**
 * This class defines the Participant object and its methods for the courses 
 * 
 * @author Madhu Kumar Dadi 
 * @version 16.1.2016
 */
public class Participant
{
    // instance variables - replace the example below with your own
    public String name=new String();
    public String address=new String();
    public String phone=new String();
    public String organisation=new String();
    public String email=new String();

    /**
     * Constructor for objects of class participant
     */
    public Participant(String s,String p,String orgstn,String mailid)
    {
        // initialise instance variables
        name=s;
        address="";
        phone=p;
        organisation=orgstn;
        email=mailid;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
}
