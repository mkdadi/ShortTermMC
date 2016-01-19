package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
    	int check,error,option,whileBreak,day,month,year,filecheck;
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
    			String name=null;
    			check=1;
    			error=1;
    			while(check==1)
    			{
    				while(error==1)
    				{
		    			System.out.print("Enter the name of the course you want to add: ");
		    			name=input.nextLine();
		    			File file=new File("./Data/Courses/courses.cdat");
		    			try{
		    				BufferedReader bReader=new BufferedReader(new FileReader(file));
		    				String handle=bReader.readLine();
		    				while(handle!=null)
		    				{
		    					if(handle.equals(name)){
		    						System.out.print("Course with the Name "
		    					+name+" already exists. Give a different name\n");
		    						error=1;
		    						break;
		    					}
		    					error=0;
		    					handle=bReader.readLine();
		    				}
		    				bReader.close();
		    			}
		    			catch(IOException ioe){
		    				System.out.print(ioe+"\nData files have been manipulated "
		    						+ "For this to work make a fresh install\nExiting...\n");
		    				return;
		    			}
    				}
	    			System.out.print("Enter the start date of the course in "
	    					+ "dd mm yyyy format: ");
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
	    				input.nextLine();
						System.out.print(mm+"\nEnter the Date in give format this time!!!\n");
						check=1;
						continue;
					}
	    			addCourse.getDuration(input);
	    			addCourse.addTeachers(input);
	    			addCourse.addParticipants(input);
	    			while(true)
	    			{
		    			System.out.print("Do you want to save these details to the Data"
		    					+ "(You can change mistakes if any later through display "
		    					+ "option)? Y or N: ");
		    			String yn=input.next();
		    			if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
		    			{
		    				File course_file=new File("./Data/Courses/"
		    							+addCourse.name+".cdat");
		    				try{
		    					course_file.createNewFile();
		    					Path path=Paths.get("./Data/Courses/"+addCourse.name+".cdat");
		    					BufferedWriter writer=Files.newBufferedWriter(path);
		    					System.out.print("Writing to the Data...\n");
		    					writer.write(addCourse.startDate.toString()+"\n");
		    					writer.write(Integer.toString(addCourse.duration)+"\n");
		    					writer.write(Integer.toString(addCourse.fee)+"\n");
		    					for(int i=0;i<addCourse.teachers.length;i++)
		    					{
		    						writer.write(addCourse.teachers[i].phone+" ");
		    					}
		    					writer.write("\n");
		    					for(int i=0;i<addCourse.students.length;i++)
		    					{
		    						writer.write(addCourse.students[i].phone+" ");
		    					}
		    					writer.write("\n");
		    					writer.close();
		    					writer=new BufferedWriter(new FileWriter("./Data/"
		    							+ "Courses/courses.cdat",true));
		    					writer.write(addCourse.name+"\n");
		    					writer.close();
		    					for(int i=0;i<addCourse.teacher_no;i++)
		    					{
		    						course_file=new File("./Data/Faculties/"
		    								+addCourse.teachers[i].phone+".fdat");
		    						course_file.createNewFile();
		    						writer=new BufferedWriter(new FileWriter("./Data/"
		    								+ "Faculties/"+addCourse.teachers[i].phone
		    								+".fdat"));
		    						writer.write(addCourse.teachers[i].name+"\n");
			    					writer.write(addCourse.teachers[i].mailId+"\n");
			    					writer.write(addCourse.teachers[i].department+"\n");
			    					writer.write(addCourse.teachers[i].address+"\n");
			    					writer.close();
			    					writer=new BufferedWriter(new FileWriter("./Data/"
			    							+ "Faculties/faculties.fdat",
			    							true));
			    					writer.write(addCourse.teachers[i].phone+"\n");
			    					writer.close();
		    					}
		    					for(int i=0;i<addCourse.student_no;i++)
		    					{
		    						course_file=new File("./Data/Students/"
		    								+addCourse.students[i].phone+".sdat");
		    						course_file.createNewFile();
		    						writer=new BufferedWriter(new FileWriter("./Data/"
		    								+ "Students/"+addCourse.students[i].phone+".sdat",
		    								true));
		    						writer.write(addCourse.students[i].name+"\n");
			    					writer.write(addCourse.students[i].email+"\n");
			    					writer.write(addCourse.students[i].organisation+"\n");
			    					writer.write(addCourse.students[i].address+"\n");
			    					writer.close();
			    					writer=new BufferedWriter(new FileWriter("./Data/"
			    							+ "Students/students.sdat",true));
			    					writer.write(addCourse.students[i].phone+"\n");
			    					writer.close();
		    					}
		    					System.out.print("Saved files...\n");
		    					break;
		    				}
		    				catch(IOException ioe){
		    					System.out.println(ioe+"\nExiting...");
		    					return;
		    				}
		    			}
		    			else if(!yn.equalsIgnoreCase("n")&&!yn.equalsIgnoreCase("no")) 
		    				System.out.print("Not a Valid Option!\n");
	    			}
    			}
    			break;
    		}
    		case 2:{
    			try
    			{
    				BufferedReader bReader=new BufferedReader(new FileReader("./Data/"
    						+ "Courses/courses.cdat"));
    				String handle=bReader.readLine();
    				while(handle!=null)
    				{
    					if(!handle.equals("courses"))
    						System.out.println(handle+"\n");
    					handle=bReader.readLine();
    				}
    				System.out.print("Enter a course name(case sensitive) to "
    						+ "check or modify the details of the course: \n");
    				handle=null;
    				while(handle==null)
    				{
    					handle=input.nextLine();
    					if(handle==null) System.out.print("Enter a course name please!\n");
    				}
    				bReader.close();
    				bReader=new BufferedReader(new FileReader("./Data/"
    						+ "Courses/courses.cdat"));
    				String handle2=bReader.readLine();
    				while(!handle2.equals(handle))
    				{
    					handle2=bReader.readLine();
    				}
    				if(handle2.equals(handle)){
    					
    				}
    				bReader.close();
    			}
    			catch(FileNotFoundException fnf)
    			{
    				System.out.print(fnf+"\nData has been manipulated,"
    						+ " You need a fresh install to work on\nAnd to be clear "
    						+ "you can't check saved details after fresh install.. \n"
    						+ "Exiting..");
    				return;
    			}
    			catch (IOException ioe) {
    				System.out.print(ioe+"\nMay be you changed the permissions to the file,"
    						+ " You need a fresh install to work on"
    						+ " or change permissions of the file \nAnd to be clear "
    						+ "you can't check saved details after fresh install.. \n"
    						+ "Exiting..");
    				return;
				}
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
