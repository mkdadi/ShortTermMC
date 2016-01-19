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
    // instance variables - replace the example below with your own
    public String name;
    public String phone;
    public String mailId;
    public String department;
    public String address;

    /**
     * Constructor for objects of class faculty
     */
    public Faculty()
    {
        // initialize instance variables
        this.name="";
        this.phone="nophone!";
        this.mailId="default@mail.id";
        this.department="";
        this.address="";//Address to be stored in other methods
    }
    
    public Faculty(String name,String phone,String mailid,String dept)
    {
        // initialize instance variables
        this.name=name;
        this.phone=phone;
        this.mailId=mailid;
        this.department=dept;
        this.address="";//Address to be stored in other methods
    }

    /**
     * This method prompts for details of the faculty and
     * Stores the values in the Faculty object
     * 
     * @param	void
     * @return	void 
     */
    public
    void add(Scanner input)
    {
    	int error=1;
		System.out.print("Enter Name: ");
    	this.name=input.nextLine();
    	while(error==1)
    	{
    		System.out.print("Enter Phone Number: ");
	    	this.phone=input.nextLine();
	    	if(this.phone.length()<10)
	    		{
	    			System.out.print("Not a Valid Phone Number!\n");
	    			error=1;
	    			continue;
	    		}
	    	for(int i=0;i<this.phone.length();i++)
	    	{
	    		if(this.phone.charAt(i)>='0'&&this.phone.charAt(i)<='9')
	    			{
	    				error=0;
	    				continue;
	    			}
	    		error=1;
	    		System.out.print("Not a Valid Phone Number!\n");
	    		break;
	    	}
    	}
    	while(true)
    	{
    		System.out.print("Enter Mail ID: ");
	    	this.mailId=input.nextLine();
	    	for(int i=0;i<this.mailId.length();i++)
	    	{
	    		if(error==0&&this.mailId.charAt(i)=='@') error=1;
	    		if(error==1&&this.mailId.charAt(i)=='.'){ error=2;break;}
	    	}
	    	if(error!=2)
	    	{
	    		System.out.print("Not a Valid Mail ID!\n");
	    	}
	    	else break;
    	}
    	System.out.print("Enter Department: ");
    	this.department=input.nextLine();
    	System.out.print("Enter Address(Press enter only after writing Total Address): ");
    	this.address=input.nextLine();
    }
}
