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
import java.time.LocalDate;
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
    	int check,error,option,whileBreak,day,month,year;
    	while(true)
    	{
    		dDisplay();
    		System.out.print("Enter the option you want "
    				+ "query about:\n1.Add a Course\t\t2.Display all Courses\n"
    				+ "3.Exit\n");
    		while(true)
        	{
    	    	try
    	    	{
    	        	option=input.nextInt();
    	    		input.nextLine();
    	    	}
    	    	catch(InputMismatchException mm)
    	    	{
    	    		input.nextLine();
    	    		System.out.print(mm+"\nEnter Valid Integer:  ");
    	    		continue;
    	    	}
    	    	break;
        	}
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
	    				System.out.print(dte+"\nEnter Valid! Details next time\n");
	    				check=1;
	    				continue;
	    			}
	    			catch (InputMismatchException mm) {
	    				input.nextLine();
						System.out.print(mm+"\nEnter the Date in give format next time!!!\n");
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
		    					writer.write(Integer.toString(addCourse.teacher_no)+"\n");
		    					for(int i=0;i<addCourse.teachers.length;i++)
		    					{
		    						writer.write(addCourse.teachers[i].phone+" ");
		    					}
		    					writer.write("\n");
		    					writer.write(Integer.toString(addCourse.student_no)+"\n");
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
    				option=1;
    				while(handle!=null)
    				{
    					if(!handle.equals("courses"))
    					{
    						System.out.println(option+". "+handle+"\n");
    						option++;
    					}
    					handle=bReader.readLine();
    				}
    				System.out.print("Enter a index of course name to "
    						+ "check or modify the details of the course"
    						+ "(Enter 0 to go back): \n");
    				int index;
    				while(true)
    	        	{
    	    	    	try
    	    	    	{
    	    	        	index=input.nextInt();
    	    	    		input.nextLine();
    	    	    	}
    	    	    	catch(InputMismatchException mm)
    	    	    	{
    	    	    		input.nextLine();
    	    	    		System.out.print(mm+"\nEnter Valid Integer:  ");
    	    	    		continue;
    	    	    	}
    	    	    	break;
    	        	}
    				bReader.close();
    				if(index==0) break;
    				bReader=new BufferedReader(new FileReader("./Data/"
    						+ "Courses/courses.cdat"));
    				for(int i=0;i<index;i++)
    				{
    					if(bReader.readLine()==null) break;
    				}
    				handle=bReader.readLine();
    				if(handle==null) {
    					System.out.print("Wrong Index Enter a valid Index this time..\n");
    					continue;
    				}
    				bReader.close();
    				bReader=new BufferedReader(new FileReader("./Data/"
    						+ "Courses/"+handle+".cdat"));
    				String course=handle;
					System.out.println("\nName of the Course: "+handle);
    				handle=bReader.readLine();
					System.out.println("Start Date(YYYY-MM-DD): "+handle);
					handle=bReader.readLine();
    				System.out.println("Duration of the course in Days: "+handle);
    				handle=bReader.readLine();
    				System.out.println("Fees in rupees : "+handle);
    				handle=bReader.readLine();
    				int fac_no=Integer.parseInt(handle);
    				String [] faculty=new String[fac_no];
    				handle=bReader.readLine();
    				if(fac_no>0) faculty=handle.split(" ");
    				System.out.print("Co-ordinator: ");
    				if(fac_no>0)
    				{
	    				BufferedReader freader=new BufferedReader(new FileReader("./Data/"
	    						+ "Faculties/"+faculty[0]+".fdat"));
	    				handle=freader.readLine();
						System.out.print(handle+"\nTA(s): ");
						freader.close();
	    				for(int i=1;i<fac_no;i++)
	    				{
		    				freader=new BufferedReader(new FileReader("./Data/"
		    						+ "Faculties/"+faculty[i]+".fdat"));
		    				handle=freader.readLine();
							System.out.print(handle);
							if(i!=fac_no-1) System.out.print(", ");
							freader.close();
	    				}
    				}
    				System.out.println();
    				handle=bReader.readLine();
    				fac_no=Integer.parseInt(handle);
    				String [] student=new String[fac_no];
    				handle=bReader.readLine();
    				if(fac_no>0) student=handle.split(" ");
    				System.out.print("Participant(s): ");
    				for(int i=0;i<fac_no;i++)
    				{
	    				BufferedReader freader=new BufferedReader(new FileReader("./Data/"
	    						+ "Students/"+student[i]+".sdat"));
	    				handle=freader.readLine();
						System.out.print(handle);
						if(i!=fac_no-1) System.out.print(", ");
						freader.close();
    				}
    				Apply(course,input,faculty,student);
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
    
    /**
     * This function allows to Check details and change details of a course
     * 
     * @param course Course name 
     * @param input Scanner for input
     * @param faculty All the faculty phone numbers (name of files containing faculty 
     * are their phone numbers)
     * @param students All the students phone numbers (name of files containing students 
     * are their phone numbers)
     */

	public static
	void Apply(String course,Scanner input,String[] faculty,String[] students)
	{
		int option;
		while(true)
		{
			dDisplay();
			System.out.print("\nCourse: "+course+"\n1.Change Details\t"
					+ "2.Check Faculty details\n3.Check Student details\t"
					+ "4.Delete Course\n5.Back\nEnter your option: ");
			while(true)
        	{
    	    	try
    	    	{
    	        	option=input.nextInt();
    	    		input.nextLine();
    	    	}
    	    	catch(InputMismatchException mm)
    	    	{
    	    		input.nextLine();
    	    		System.out.print(mm+"\nEnter Valid Integer:  ");
    	    		continue;
    	    	}
    	    	break;
        	}
			switch (option) {
			case 1:
			{
				System.out.print("\n1.Change course name\t"
						+ "2.Change Start Date\n3.Change duration\t"
						+ "4.Change Fees\n5.Back\nEnter your option: ");
				while(true)
	        	{
	    	    	try
	    	    	{
	    	        	option=input.nextInt();
	    	    		input.nextLine();
	    	    	}
	    	    	catch(InputMismatchException mm)
	    	    	{
	    	    		input.nextLine();
	    	    		System.out.print(mm+"\nEnter Valid Integer:  ");
	    	    		continue;
	    	    	}
	    	    	break;
	        	}
				if(option==5) break;
				else if(option<1||option>5) {System.out.println("Wrong option!\n");break;}
				System.out.print("Do you want to change this Course details from the Data"
    					+ "? Y or N: ");
				String yn=new String();
				yn=input.next();
				input.nextLine();
				if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
				{
					if(option==1)
					{
						File course_file=new File("./Data/Courses/"+course+".cdat");
						System.out.print("Enter the New name for the Course: ");
						String temp_course=input.nextLine();
						File tmp_file=new File("./Data/Courses/"+temp_course+".cdat");
						rename(course_file, tmp_file);
						try{
							tmp_file=new File("./Data/Courses/courses.cdat.bak");
							course_file=new File("./Data/Courses/courses.cdat");
							rename(course_file, tmp_file);
							course_file=new File("./Data/Courses/courses.cdat");
							course_file.createNewFile();
							BufferedReader bReader=new BufferedReader(
									new FileReader("./Data/Courses/courses.cdat.bak"));
							BufferedWriter writer=new BufferedWriter(
									new FileWriter("./Data/Courses/courses.cdat"));
							String temp_name=bReader.readLine();
							while(temp_name!=null)
							{
								if(temp_name.equals(course))
									writer.write(temp_course+"\n");
								else {
									writer.write(temp_name+"\n");
								}
								temp_name=bReader.readLine();
							}
							bReader.close();
							writer.close();
							tmp_file.delete();
						}
						catch(IOException ioe)
						{
							System.out.println(ioe);
						}
						return;
					}
					File course_file=new File("./Data/Courses/"+course+".cdat");
					File tmp_file=new File("./Data/Courses/"+course+".cdat.bak");
					rename(course_file, tmp_file);
					try{
						BufferedReader bReader=new BufferedReader(
								new FileReader("./Data/Courses/"+course+".cdat.bak"));
						BufferedWriter writer=new BufferedWriter(
								new FileWriter("./Data/Courses/"+course+".cdat"));
						for(int i=0;i<option-2;i++)
						{
							writer.write(bReader.readLine()+"\n");
						}
						switch (option) {
						case 2:
							System.out.print("New Start Date in dd mm yyyy format: ");
							int year,month,day;
							day=input.nextInt();
							month=input.nextInt();
							year=input.nextInt();
							input.nextLine();
							try{
								LocalDate date=LocalDate.of(year, month, day);
								writer.write(date.toString()+"\n");
								bReader.readLine();
							}
							catch(DateTimeException dte)
							{
								System.out.print("Input Format is wrong Try again later\n");
							}
							catch(InputMismatchException mm)
							{
			    	    		input.nextLine();
								System.out.print(mm+"\nEnter a valid Integer: ");
							}
							break;
						case 3:
							System.out.print("New Duration of course in days: ");
							int duration;
							while(true)
				        	{
				    	    	try
				    	    	{
				    	        	duration=input.nextInt();
				    	    		input.nextLine();
				    	    	}
				    	    	catch(InputMismatchException mm)
				    	    	{
				    	    		input.nextLine();
				    	    		System.out.print(mm+"\nEnter Valid Integer:  ");
				    	    		continue;
				    	    	}
				    	    	break;
				        	}
							writer.write(Integer.toString(duration)+"\n");
							bReader.readLine();
							break;
						case 4:
							System.out.print("New Fees of course in Rupees: ");
							int fees;
							while(true)
				        	{
				    	    	try
				    	    	{
				    	        	fees=input.nextInt();
				    	    		input.nextLine();
				    	    	}
				    	    	catch(InputMismatchException mm)
				    	    	{
				    	    		input.nextLine();
				    	    		System.out.print(mm+"\nEnter Valid Integer:  ");
				    	    		continue;
				    	    	}
				    	    	break;
				        	}
							writer.write(Integer.toString(fees)+"\n");
							bReader.readLine();
							break;
						}
						for(int i=0;i<8-option;i++)
							writer.write(bReader.readLine()+"\n");
						writer.close();
						bReader.close();
					}
					catch(FileNotFoundException fnf)
					{
						System.out.println(fnf);
						break;
					}
					catch (IOException ioe) {
						System.out.println(ioe);
						break;
					}
					course_file=new File("./Data/Courses/"
						+course+".cdat.bak");
					course_file.delete();
				}
			}
				break;
			case 2:
			{
				String handle=null;
				BufferedReader freader=null;
				for(int i=0;i<faculty.length;i++)
				{
					try{
						freader=new BufferedReader(new FileReader("./Data/"
	    						+ "Faculties/"+faculty[i]+".fdat"));
	    				handle=freader.readLine();
						System.out.print(Integer.toString(i+1)+"."+handle+"\n");
						freader.close();
					}
					catch(IOException ioe){
						System.out.println(ioe+"Data has been manipulated "
								+ "need a fresh install\n");
						break;
					}
				}
				System.out.print("1.View Faculty\t\t2.Add Faculty\n3.Change details\t"
						+ "4.Delete Faculty\n4.Back\nEnter your option: ");
				while(true)
	        	{
	    	    	try
	    	    	{
	    	        	option=input.nextInt();
	    	    		input.nextLine();
	    	    	}
	    	    	catch(InputMismatchException mm)
	    	    	{
	    	    		input.nextLine();
	    	    		System.out.print(mm+"\nEnter Valid Integer: ");
	    	    		continue;
	    	    	}
	    	    	break;
	        	}
				switch(option){
				case 1:
				{
					System.out.print("Enter the index of faculty: ");
					while(true)
		        	{
		    	    	try
		    	    	{
		    	        	option=input.nextInt();
		    	    		input.nextLine();
		    	    	}
		    	    	catch(InputMismatchException mm)
		    	    	{
		    	    		input.nextLine();
		    	    		System.out.print(mm+"\nEnter Valid Integer: ");
		    	    		continue;
		    	    	}
		    	    	break;
		        	}
					if(option<=0||option>faculty.length) {System.out.print("Wrong input\n");
					break;}
					try{
						BufferedReader bReader=new BufferedReader(new FileReader(
								"./Data/Faculties/"+faculty[option-1]+".fdat"));
						String temp_string=bReader.readLine();
						System.out.println("Name: "+temp_string+"\n"
								+ "Phone Number: "+faculty[option-1]);
						temp_string=bReader.readLine();
						System.out.println("Email ID: "+temp_string);
						temp_string=bReader.readLine();
						System.out.println("Department: "+temp_string);
						temp_string=bReader.readLine();
						System.out.println("Address: "+temp_string);
						bReader.close();
					}
					catch(IOException ioe){
						System.out.println(ioe);
					}
				}
					break;
				case 2:
				{
					Faculty add_fac=new Faculty();
					if(faculty.length==Course.LIMIT+1) {System.out.print("Faculty "
							+ "Limit reached for Course");return;}
					add_fac.add(input);
					System.out.print("Do you want to save these details to the Data"
	    					+ "(You can change mistakes if any later through display "
	    					+ "option)? Y or N: ");
					String yn=new String();
					yn=input.next();
					input.nextLine();
					if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
	    			{
						try{
							File course_file=new File("./Data/Faculties/"
									+add_fac.phone+".fdat");
							course_file.createNewFile();
							BufferedWriter writer=new BufferedWriter(new FileWriter("./Data/"
									+ "Faculties/"+add_fac.phone
									+".fdat"));
							writer.write(add_fac.name+"\n");
							writer.write(add_fac.mailId+"\n");
							writer.write(add_fac.department+"\n");
							writer.write(add_fac.address+"\n");
							writer.close();
							writer=new BufferedWriter(new FileWriter("./Data/"
									+ "Faculties/faculties.fdat",
									true));
							writer.write(add_fac.phone+"\n");
							writer.close();
							course_file=new File("./Data/Courses/"+course+".cdat");
							File tmp_file=new File("./Data/Courses/"+course+".cdat.bak");
							rename(course_file, tmp_file);
							BufferedReader bReader=new BufferedReader(
									new FileReader("./Data/Courses/"+course+".cdat.bak"));
							writer=new BufferedWriter(
									new FileWriter("./Data/Courses/"+course+".cdat"));
							for(int i=0;i<3;i++)
							{
								writer.write(bReader.readLine()+"\n");
							}
							int length=Integer.parseInt(bReader.readLine());
							writer.write(Integer.toString(length+1)+"\n");
							writer.write(bReader.readLine());
							writer.write(add_fac.phone+" ");
							writer.write("\n");
							writer.write(bReader.readLine()+"\n"+bReader.readLine()+"\n");
							writer.close();
							bReader.close();
							course_file=new File("./Data/Courses/"
								+course+".cdat.bak");
							course_file.delete();
						}
						catch (IOException ioe) {
							System.out.print(ioe+"\nData has been Manipulated "
									+ "make a fresh install to work on");
						}
	    			}
					else System.out.print("I will take that as no\n");
					return;
				}
				case 3:
				{
					System.out.print("Enter the index of faculty: ");
					while(true)
		        	{
		    	    	try
		    	    	{
		    	        	option=input.nextInt();
		    	    		input.nextLine();
		    	    	}
		    	    	catch(InputMismatchException mm)
		    	    	{
		    	    		input.nextLine();
		    	    		System.out.print(mm+"\nEnter Valid Integer: ");
		    	    		continue;
		    	    	}
		    	    	break;
		        	}
					Faculty.changeFac(course, faculty[option-1], input);
					return;
				}
				case 4:
				{
					System.out.print("Enter the index of faculty: ");
					while(true)
		        	{
		    	    	try
		    	    	{
		    	        	option=input.nextInt();
		    	    		input.nextLine();
		    	    	}
		    	    	catch(InputMismatchException mm)
		    	    	{
		    	    		input.nextLine();
		    	    		System.out.print(mm+"\nEnter Valid Integer: ");
		    	    		continue;
		    	    	}
		    	    	break;
		        	}
					if(option<=0||option>faculty.length) {System.out.print("Wrong Input!\n");
					break;
					}
					System.out.print("Do you want to remove this faculty details from the Data"
	    					+ "? Y or N: ");
					String yn=new String();
					yn=input.next();
					input.nextLine();
					if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
					{
						Faculty.facDel(faculty[option-1],course,faculty.length,option);
    				}
					else System.out.print("I will take that as no\n");
				}
					return;
				case 5:
					break;
				default:
					System.out.println("Not a valid Option!\n");
					break;
				}
				break;
			}
			case 3:
			{
				String handle=null;
				BufferedReader freader=null;
				for(int i=0;i<students.length;i++)
				{
					try{
						freader=new BufferedReader(new FileReader("./Data/"
	    						+ "Students/"+students[i]+".sdat"));
	    				handle=freader.readLine();
						System.out.print(Integer.toString(i+1)+"."+handle+"\n");
						freader.close();
					}
					catch(IOException ioe){
						System.out.println(ioe+"Data has been manipulated "
								+ "need a fresh install\n");
						break;
					}
				}
				System.out.print("1.View Participant\t2.Add Participant\n"
						+ "3.Change details\t4.Delete Participant\n5.Back\nEnter "
						+ "your option: ");
				while(true)
	        	{
	    	    	try
	    	    	{
	    	        	option=input.nextInt();
	    	    		input.nextLine();
	    	    	}
	    	    	catch(InputMismatchException mm)
	    	    	{
	    	    		input.nextLine();
	    	    		System.out.print(mm+"\nEnter Valid Integer: ");
	    	    		continue;
	    	    	}
	    	    	break;
	        	}
				switch(option){
				case 1:
				{
					System.out.print("Enter the index of Participant: ");
					while(true)
		        	{
		    	    	try
		    	    	{
		    	        	option=input.nextInt();
		    	    		input.nextLine();
		    	    	}
		    	    	catch(InputMismatchException mm)
		    	    	{
		    	    		input.nextLine();
		    	    		System.out.print(mm+"\nEnter Valid Integer: ");
		    	    		continue;
		    	    	}
		    	    	break;
		        	}
					if(option<=0||option>students.length) {System.out.print("Wrong input\n");
					break;}
					try{
						BufferedReader bReader=new BufferedReader(new FileReader(
								"./Data/Students/"+students[option-1]+".sdat"));
						String temp_string=bReader.readLine();
						System.out.println("Name: "+temp_string+"\n"
								+ "Phone Number: "+students[option-1]);
						temp_string=bReader.readLine();
						System.out.println("Email ID: "+temp_string);
						temp_string=bReader.readLine();
						System.out.println("Organisation: "+temp_string);
						temp_string=bReader.readLine();
						System.out.println("Address: "+temp_string);
						bReader.close();
					}
					catch(IOException ioe){
						System.out.println(ioe);
					}
				}
					break;
				case 2:
				{
					Participant add_par=new Participant();
					if(students.length==Course.LIMIT) {System.out.print("Participant "
							+ "Limit reached for Course");return;}
					add_par.add(input);
					System.out.print("Do you want to save these details to the Data"
	    					+ "(You can change mistakes if any later through display "
	    					+ "option)? Y or N: ");
					String yn=new String();
					yn=input.next();
					input.nextLine();
					if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
	    			{
						try{
							File course_file=new File("./Data/Students/"
									+add_par.phone+".sdat");
							course_file.createNewFile();
							BufferedWriter writer=new BufferedWriter(new FileWriter("./Data/"
									+ "Students/"+add_par.phone
									+".sdat"));
							writer.write(add_par.name+"\n");
							writer.write(add_par.email+"\n");
							writer.write(add_par.organisation+"\n");
							writer.write(add_par.address+"\n");
							writer.close();
							writer=new BufferedWriter(new FileWriter("./Data/"
									+ "Students/students.sdat",
									true));
							writer.write(add_par.phone+"\n");
							writer.close();
							course_file=new File("./Data/Courses/"+course+".cdat");
							File tmp_file=new File("./Data/Courses/"+course+".cdat.bak");
							rename(course_file, tmp_file);
							BufferedReader bReader=new BufferedReader(
									new FileReader("./Data/Courses/"+course+".cdat.bak"));
							writer=new BufferedWriter(
									new FileWriter("./Data/Courses/"+course+".cdat"));
							for(int i=0;i<5;i++)
							{
								writer.write(bReader.readLine()+"\n");
							}
							int length=Integer.parseInt(bReader.readLine());
							writer.write(Integer.toString(length+1)+"\n");
							writer.write(bReader.readLine());
							writer.write(add_par.phone+" ");
							writer.write("\n");
							writer.close();
							bReader.close();
							course_file=new File("./Data/Courses/"
								+course+".cdat.bak");
							course_file.delete();	
						}
						catch (IOException ioe) {
							System.out.print(ioe+"\nData has been Manipulated "
									+ "make a fresh install to work on");
						}
	    			}
					else System.out.print("I will take that as no\n");
					return;
				}
				case 3:
				{
					System.out.print("Enter the index of student: ");
					while(true)
		        	{
		    	    	try
		    	    	{
		    	        	option=input.nextInt();
		    	    		input.nextLine();
		    	    	}
		    	    	catch(InputMismatchException mm)
		    	    	{
		    	    		input.nextLine();
		    	    		System.out.print(mm+"\nEnter Valid Integer: ");
		    	    		continue;
		    	    	}
		    	    	break;
		        	}
					Participant.changePar(course, students[option-1], input);
					return;
				}
				case 4:
				{
					System.out.print("Enter the index of Participant: ");
					while(true)
		        	{
		    	    	try
		    	    	{
		    	        	option=input.nextInt();
		    	    		input.nextLine();
		    	    	}
		    	    	catch(InputMismatchException mm)
		    	    	{
		    	    		input.nextLine();
		    	    		System.out.print(mm+"\nEnter Valid Integer: ");
		    	    		continue;
		    	    	}
		    	    	break;
		        	}
					if(option<=0||option>students.length) {System.out.print("Wrong Input!\n");
					break;
					}
					System.out.print("Do you want to remove this "
							+ "Participant details from the Data"
	    					+ "? Y or N: ");
					String yn=new String();
					yn=input.next();
					input.nextLine();
					if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
					{
						Participant.parDel(students[option-1], course, students.length,option);
    				}
					else System.out.print("I will take that as no\n");
				}
					return;
				case 5:
					break;
				default:
					System.out.println("Not a valid Option!\n");
					break;
				}
				break;
			}
			case 4:
			{
				System.out.print("Do you want to remove this Course details from the Data"
    					+ "? Y or N: ");
				String yn=new String();
				yn=input.next();
				input.nextLine();
				if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
				{
					File course_file=new File("./Data/Courses/courses.cdat");
					File tmp_file=new File("./Data/Courses/courses.cdat.bak");
					rename(course_file, tmp_file);
					try{
						BufferedReader bReader=new BufferedReader(
								new FileReader("./Data/Courses/courses.cdat.bak"));
						BufferedWriter writer=new BufferedWriter(
								new FileWriter("./Data/Courses/courses.cdat"));
						String temp_file=bReader.readLine();
						while(temp_file!=null)
						{
							if(!temp_file.equals(course))
								writer.write(temp_file+"\n");
							temp_file=bReader.readLine();
						}
						writer.close();
						bReader.close();
						course_file=new File("./Data/Courses/courses.cdat.bak");
						course_file.delete();
						for(int i=0;i<faculty.length;i++) Faculty.facDel(
								faculty[i],course,faculty.length,option);
						for(int i=0;i<students.length;i++) Participant.parDel(
								students[i], course, students.length,option);
						course_file=new File("./Data/Courses/"+course+".cdat");
						course_file.delete();
					}
					catch(FileNotFoundException fnf)
					{
						System.out.println(fnf);
						break;
					}
					catch (IOException ioe) {
						System.out.println(ioe);
						break;
					}
				}
				else System.out.print("I will take that as no\n");
			}
				return;
			case 5:
				return;
			default:
				System.out.print("Enter a Valid option!\n");
				break;
			}
		}
	}
	
	/**
	 * This method renames a file source to file dest
	 * 
	 * @param source Name of the file to be renamed
	 * @param dest Name of the file to be renamed to
	 */

	public static
	void rename(File source,File dest)
	{
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter(dest));
			BufferedReader reader=new BufferedReader(new FileReader(source));
			String handle=reader.readLine();
			while(handle!=null)
			{
				writer.write(handle+"\n");
				handle=reader.readLine();
			}
			writer.close();
			reader.close();
			source.delete();
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
			return;
		}
	}
	
	/**
	 * function that prints a header style
	 */
	
	public static
	void dDisplay()
	{
		System.out.print("\n**********************************************\n"
    				+ "  SHORT TERM COURSE MANAGEMENT IIT KHARAGPUR\n"
    				+ "**********************************************\n");
	}
}
