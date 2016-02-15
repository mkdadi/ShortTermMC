package src;

import java.util.Scanner;

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
    
    /**
     * Method to add a new faculty to a course
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
    	this.mailId=STCM.getMail(input);
    	System.out.print("Enter Department: ");
    	this.department=input.nextLine();
    	System.out.print("Enter Address(Press enter only after writing Total Address): ");
    	this.address=input.nextLine();}
}