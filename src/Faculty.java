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
    
    public static
    void facDel(String faculty,String course,int length,int option){
    	File course_file=new File("./Data/Faculties/"
				+faculty+".fdat");
		course_file.delete();
		course_file=new File("./Data/Courses/"+course+".cdat");
		File tmp_file=new File("./Data/Courses/"+course+".cdat.bak");
		Stcm.rename(course_file, tmp_file);
		try{
			BufferedReader bReader=new BufferedReader(
					new FileReader("./Data/Courses/"+course+".cdat.bak"));
			BufferedWriter writer=new BufferedWriter(
					new FileWriter("./Data/Courses/"+course+".cdat"));
			for(int i=0;i<3;i++)
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
			writer.write(bReader.readLine()+"\n");
			writer.write(bReader.readLine()+"\n");
			writer.close();
			bReader.close();
			course_file=new File("./Data/Courses/"
				+course+".cdat.bak");
			course_file.delete();
			course_file=new File("./Data/Faculties/faculties.fdat");
			tmp_file=new File("./Data/Faculties/faculties.fdat.bak");
			Stcm.rename(course_file, tmp_file);
			bReader=new BufferedReader(
					new FileReader("./Data/Faculties/faculties.fdat.bak"));
			writer=new BufferedWriter(
					new FileWriter("./Data/Faculties/faculties.fdat"));
			String temp_string=bReader.readLine();
			while(temp_string!=null)
			{
				if(!temp_string.equals(faculty))
					writer.write(temp_string+"\n");
				temp_string=bReader.readLine();
			}
			writer.close();
			bReader.close();
			course_file=new File("./Data/Faculties/faculties.fdat.bak");
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
    void changeFac(String course,String faculty,Scanner input)
    {
    	try{
			BufferedReader bReader=new BufferedReader(
					new FileReader("./Data/Faculties/"+faculty+".fdat"));
			BufferedWriter writer=new BufferedWriter(
					new FileWriter("./Data/Faculties/"+faculty+".fdat.bak"));
			System.out.print("1.Change Phone No\t2.Change Name\n3.Change EmailID\t"
					+ "4.Change Department\n5.Change Address\t6.Back\n"
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
				File source=new File("./Data/Faculties/"+faculty+".fdat");
				File dest=new File("./Data/Faculties/"+handle+".fdat");
				Stcm.rename(source, dest);
				bReader=new BufferedReader(
						new FileReader("./Data/Faculties/faculties.fdat"));
				writer=new BufferedWriter(
						new FileWriter("./Data/Faculties/faculties.fdat.bak"));
				String handle1=bReader.readLine();
				while(handle1!=null)
				{
					if(handle1.equals(faculty)) handle1=handle;
					writer.write(handle1+"\n");
					handle1=bReader.readLine();
				}
				bReader.close();
				writer.close();
				source=new File("./Data/Faculties/faculties.fdat.bak");
				dest=new File("./Data/Faculties/faculties.fdat");
				Stcm.rename(source, dest);
				bReader=new BufferedReader(
						new FileReader("./Data/Courses/"+course+".cdat"));
				writer=new BufferedWriter(
						new FileWriter("./Data/Courses/"+course+".cdat.bak"));
				for(int i=0;i<4;i++)writer.write(bReader.readLine()+"\n");
				String [] handle2=bReader.readLine().split(" ");
				int i=0;
				while(i!=handle2.length)
				{
					if(handle2[i].equals(faculty)) handle2[i]=handle;
					writer.write(handle2[i]+" ");
					i++;
				}
				writer.write("\n");
				for(i=0;i<2;i++) writer.write(bReader.readLine()+"\n");
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
			File source=new File("./Data/Faculties/"+faculty+".fdat.bak");
			File dest=new File("./Data/Faculties/"+faculty+".fdat");
			Stcm.rename(source, dest);
    	}
    	catch(IOException ioe)
    	{
    		System.out.println(ioe);
    	}
    }
}