package src;

import java.util.Scanner;

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
    
    /**
     * Method to add a new Participant to a course
     * 
     * @param input Scanner for taking inputs
     */
    
    public 
    void add(Scanner input)
    {
    	System.out.print("Enter Name: ");
    	this.name=input.nextLine();
    	System.out.print("Enter Phone Number: ");
    	this.phone=STCM.getPhone(input);
    	System.out.print("Enter Mail ID: ");
    	this.email=STCM.getMail(input);
    	System.out.print("Enter Organisation: ");
    	this.organisation=input.nextLine();
    	System.out.print("Enter Address(Press enter only after writing Total Address): ");
    	this.address=input.nextLine();
    }
}
