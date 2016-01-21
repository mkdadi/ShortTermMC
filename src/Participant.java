 package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public Participant()
    {
        // initialise instance variables
        this.name="";
        this.address="";//Address to be stored in other methods.
        this.phone="nophone!";
        this.organisation="";
        this.email="default@mail.id";
    }
    
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
    }
    
    public static
    void parDel(String students,String course,int length,int option)
    {
    	File course_file=new File("./Data/Students/"
				+students+".sdat");
		course_file.delete();
		course_file=new File("./Data/Courses/"+course+".cdat");
		File tmp_file=new File("./Data/Courses/"+course+".cdat.bak");
		Stcm.rename(course_file, tmp_file);
		try{
			BufferedReader bReader=new BufferedReader(
					new FileReader("./Data/Courses/"+course+".cdat.bak"));
			BufferedWriter writer=new BufferedWriter(
					new FileWriter("./Data/Courses/"+course+".cdat"));
			for(int i=0;i<5;i++)
			{
				writer.write(bReader.readLine()+"\n");
			}
			length=Integer.parseInt(bReader.readLine());
			writer.write(Integer.toString(length-1)+"\n");
			String [] temp=new String[length];
			temp=bReader.readLine().split(" ");
			for(int i=0;i<length;i++)
			{
				if(i==option-1) continue;
				writer.write(temp[i]+" ");
			}
			writer.write("\n");
			writer.close();
			bReader.close();
			course_file=new File("./Data/Courses/"
				+course+".cdat.bak");
			course_file.delete();
			course_file=new File("./Data/Students/students.sdat");
			tmp_file=new File("./Data/Students/students.sdat.bak");
			Stcm.rename(course_file, tmp_file);
			bReader=new BufferedReader(
					new FileReader("./Data/Students/students.sdat.bak"));
			writer=new BufferedWriter(
					new FileWriter("./Data/Students/students.sdat"));
			String temp_string=bReader.readLine();
			while(temp_string!=null)
			{
				if(!temp_string.equals(students))
					writer.write(temp_string+"\n");
				temp_string=bReader.readLine();
			}
			writer.close();
			bReader.close();
			course_file=new File("./Data/Students/students.sdat.bak");
			course_file.delete();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println(fnf);
			return;
		}
		catch (IOException ioe) {
			System.out.println(ioe);
			return;
		}
    }
    
    public static
    void changePar(String course,String student,Scanner input)
    {
    	try{
			BufferedReader bReader=new BufferedReader(
					new FileReader("./Data/Students/"+student+".sdat"));
			BufferedWriter writer=new BufferedWriter(
					new FileWriter("./Data/Students/"+student+".sdat.bak"));
			System.out.print("1.Change Phone No\t2.Change Name\n3.Change EmailID\t"
					+ "4.Change Organisation\n5.Change Address\t6.Back\n"
					+ "Enter your option: ");
			int option=input.nextInt();
			input.nextLine();
			if(option==6){
				writer.close();
				bReader.close();
				return;
			}
			if(option>6) {
				System.out.print("Invalid Option!\n");
				writer.close();
				bReader.close();	
				return;
			}
			if(option==1)
			{
				System.out.print("Enter the new Phone number: ");
				String handle=input.nextLine();
				bReader.close();
				writer.close();
				File source=new File("./Data/Students/"+student+".sdat");
				File dest=new File("./Data/Students/"+handle+".sdat");
				Stcm.rename(source, dest);
				bReader=new BufferedReader(
						new FileReader("./Data/Students/students.sdat"));
				writer=new BufferedWriter(
						new FileWriter("./Data/Students/students.sdat.bak"));
				String handle1=bReader.readLine();
				while(handle1!=null)
				{
					if(handle1.equals(student)) handle1=handle;
					writer.write(handle1+"\n");
					handle1=bReader.readLine();
				}
				bReader.close();
				writer.close();
				source=new File("./Data/Students/students.sdat.bak");
				dest=new File("./Data/Students/students.sdat");
				Stcm.rename(source, dest);
				bReader=new BufferedReader(
						new FileReader("./Data/Courses/"+course+".cdat"));
				writer=new BufferedWriter(
						new FileWriter("./Data/Courses/"+course+".cdat.bak"));
				for(int i=0;i<6;i++)writer.write(bReader.readLine()+"\n");
				String [] handle2=bReader.readLine().split(" ");
				int i=0;
				while(i!=handle2.length)
				{
					if(handle2[i].equals(student)) handle2[i]=handle;
					writer.write(handle2[i]+" ");
					i++;
				}
				writer.write("\n");
				bReader.close();
				writer.close();
				source=new File("./Data/Courses/"+course+".cdat.bak");
				dest=new File("./Data/Courses/"+course+".cdat");
				Stcm.rename(source, dest);
				return;
			}
			for(int i=0;i<option-2;i++)
			{
				writer.write(bReader.readLine()+"\n");
			}
			System.out.print("Enter the new detail: ");
			String handle=input.nextLine();
			writer.write(handle+"\n");
			bReader.readLine();
			for(int i=0;i<5-option;i++)
			{
				writer.write(bReader.readLine()+"\n");
			}
			writer.close();
			bReader.close();
			File source=new File("./Data/Students/"+student+".sdat.bak");
			File dest=new File("./Data/Students/"+student+".sdat");
			Stcm.rename(source, dest);
    	}
    	catch(IOException ioe)
    	{
    		System.out.println(ioe);
    	}
    }
}
