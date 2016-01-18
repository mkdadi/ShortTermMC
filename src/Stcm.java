package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This is the main class for running the program
 * This program is designed to run in terminal/cmd
 * So, running it in IDE console can return some errors
 * 
 * @author Madhu Kumar Dadi
 * 
 * @version 16.1.2016
 */
public class Stcm
{
    public static void main(String[] args) {
    	Scanner input=new Scanner(System.in);
    	int check,error,option,whileBreak;
    	while(true)
    	{
    		System.out.print("Enter the option you want "
    				+ "query about:\n1.Add a Course\t\t2.Display all Courses\n"
    				+ "3.Exit\n");
    		option=input.nextInt();
    		input.nextLine();
    		whileBreak=0;
    		switch (option) {
    		case 1:{
    			String name;
    			check=1;
    			while(check==1)
    			{
	    			System.out.print("Enter the name of the course you want to add: ");
	    			name=input.nextLine();
	    			Path path=Paths.get("./Data/Courses/courses.cdat");
	    			try{
	    				BufferedReader bReader=Files.newBufferedReader(path);
	    				String handle=bReader.readLine();
	    				while(!handle.equals(null))
	    				{
	    					if(handle.equals(name)){
	    						System.out.print("Course with the Name "
	    					+name+" already exists. Give a different name\n");
	    						
	    					}
	    				}
	    			}
	    			catch(IOException ioe){
	    				System.out.print(ioe+"\nData files have been manipulated "
	    						+ "For this to work make a fresh install\nExiting...\n");
	    				return;
	    			}
	    			System.out.print("Enter the start date of the course in "
	    					+ "dd mm yyyy format: ");
	    			int day,month,year;
	    			Course addCourse=null;
	    			try{
	    				day=input.nextInt();
	    				month=input.nextInt();
	    				year=input.nextInt();
	    				input.nextLine();
	    				int fee;
	    				System.out.print("Enter the fee amount(in Rupees): ");
	    				fee=input.nextInt();
	    				input.nextLine();
	    				addCourse=new Course(name, fee, day, month, year);
	    				check=0;
	    			}
	    			catch(DateTimeException dte){
	    				System.out.print(dte+"\nEnter Valid! Details this time\n");
	    				check=1;
	    				continue;
	    			}
	    			catch (InputMismatchException mm) {
						System.out.print(mm+"\nEnter the Date in give format this time!!!\n");
						check=1;
						continue;
					}
	    			addCourse.getDuration();
	    			addCourse.addTeachers();
	    			addCourse.addParticipants();
	    			while(true)
	    			{
		    			System.out.print("Do you want to save these details to the Data"
		    					+ "(You can change mistakes if any later through display "
		    					+ "option)? Y or N: ");
		    			String yn=input.next();
		    			if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
		    			{
		    				File course_file=new File("./Data/Courses/"+addCourse.name+".cdat");
		    				try{
		    					course_file.createNewFile();
		    				}
		    				catch(IOException ioe){
		    					System.out.println(ioe+"\nExiting...");
		    					return;
		    				}
		    			}
		    			else System.out.print("Not a Valid Option!\n");
	    			}
    			}
    			break;
    		}
    		case 2:{
    			
    			break;
    		}
    		case 3:{
    			whileBreak=1;
    			break;
    		}
    		default: {System.out.println("Enter a valid option!");break;}
    		}
    		if(whileBreak==1) break;
    	}
    	if(input!=null)
    	{
    		input.close();
    	}
    }
}
