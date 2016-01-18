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
    // instance variables - replace the example below with your own
    public String name=new String();
    public String address=new String();
    public String phone=new String();
    public String organisation=new String();
    public String email=new String();

    /**
     * Constructor for objects of class participant
     */
    public Participant(String name,String phone,String orgstn,String mailid)
    {
        // initialise instance variables
        this.name=name;
        this.address="";//Address to be stored in other methods.
        this.phone=phone;
        this.organisation=orgstn;
        this.email=mailid;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public
    void add()
    {
    	int error=1;
    	Scanner input=new Scanner(System.in);
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
	    	this.email=input.nextLine();
	    	for(int i=0;i<this.email.length();i++)
	    	{
	    		if(error==0&&this.email.charAt(i)=='@') error=1;
	    		if(error==1&&this.email.charAt(i)=='.'){ error=2;break;}
	    	}
	    	if(error!=2)
	    	{
	    		System.out.print("Not a Valid Mail ID!\n");
	    	}
	    	else break;
    	}
    	System.out.print("Enter Organisation: ");
    	this.organisation=input.nextLine();
    	System.out.print("Enter Address(Press enter only after writing Total Address): ");
    	this.address=input.nextLine();
    	input.close();
    }
}
