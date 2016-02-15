package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class STCM
{
	/**
	 * This function is to make printing easier
	 * 
	 * @param s
	 * @return void
	 */
	
	public static
	void print(String s)
	{System.out.print(s);}
	
	/**
	 * Main function for Short Term Course Management
	 * The main idea for the program is given in README.txt
	 * if you haven't read it please read it first
	 * 
	 * @param args
	 * @return void
	 */
	
	public static void main(String[] args) {
		Course[] courses=new Course[10];
		int no_of_courses=0;
		try{
			File file=new File("stcm.txt");
			if(!file.exists())file.createNewFile();
		}
		catch(IOException ioe)
		{
			print("Problem creating file\n");
		}
		no_of_courses=getCourses(courses,no_of_courses);
    	Scanner input=new Scanner(System.in);
    	int error,option,whileBreak;
    	while(true)
    	{
    		print("\n**********************************************\n"
    				+ "  SHORT TERM COURSE MANAGEMENT IIT KHARAGPUR\n"
    				+ "**********************************************\n");
    		print("Enter the option you want "
    				+ "query about:\n1.Add a Course\t\t2.Display all Courses\n"
    				+ "3.Exit\nEnter your option: ");
    		option=getInt(input);
    		whileBreak=0;
    		switch (option) {
    		case 1:{
    			if(no_of_courses==10)
    			{
    				print("Max limit for the number of Courses reached\nTry to remove completed "
    						+ "courses and then try to add\n");
    				break;
    			}
    			String name=null;
    			error=1;
				while(error==1)
				{
					error=0;
					print("Enter the name of the course you want to add: ");
	    			name=input.nextLine();
	    			courses[no_of_courses]=new Course();
	    			for(int i=0;i<no_of_courses;i++)
	    			{
	    				if(name.equals(courses[i].name))
	    				{
	    					print("Course with name "+name+" already exists!\n"
	    							+"Do you want to try a different name? Yes or No");
	    					name=input.nextLine();
	    					if(name.equalsIgnoreCase("y")||name.equalsIgnoreCase("yes"))
	    						{
	    							error=1;break;
	    						}
	    					else {
	    						error=2;
	    						break;
	    					}
	    				}
	    			}
				}
				if(error==2) break;
    			print("Enter the start date of the course in dd mm yyyy format: ");
    			LocalDate date=getDate(input);
    			print("Enter the Course Fee in rupees: ");
    			int fee=getInt(input);
    			courses[no_of_courses]=new Course(name,fee,date);
    			print("Duration of the Course in Days: ");
    			while(true){
    				courses[no_of_courses].duration=getInt(input);
    				if(courses[no_of_courses].duration>14||courses[no_of_courses].duration<1)
    				{
    					print("A course can have a maximum of 2 weeks(14 days) duration\nGive in"
    							+ "put in that range: "); 
    					continue;
    				}
    				break;
    			}
    			courses[no_of_courses].addTeachers(input);
    			courses[no_of_courses].addParticipants(input);
    			no_of_courses++;
    			break;
			}
    		case 2:{
    			int j=0;
    			for(int i=0;i<no_of_courses;i++)
    			{
    				if(checkDate(courses[i].startDate))
    				{
    					print(Integer.toString(j+1)+". "+courses[i].name+"\n");
    					j++;
    				}
    			}
				print("Enter a index of course name to check or modify the details of the course"
						+ "(Enter 0 to go back): ");
				option=getInt(input);
				if(option==0) break;
				if(option>j||option<0){
					print("Wrong Index Enter a valid Index this time..\n");
					break;
					}
				int k=0;
				for(int i=0;i<j&&k<no_of_courses;k++)
				{
					if(!checkDate(courses[k].startDate))option++;
					else i++;
				}
				print("Course Name: "+courses[option-1].name+"\n");
				print("Start Date: "+courses[option-1].startDate.toString()+"\n");
				print("Duration: "+Integer.toString(courses[option-1].duration)+" days\n");
				print("Course Fee: "+Integer.toString(courses[option-1].fee)+" rupees\n");
				if(courses[option-1].teacher_no!=0)
					print("Co-ordinator: "+courses[option-1].teachers[0].name+"\nFaculty: ");
				for(int i=0;i<courses[option-1].teacher_no-1;i++)
				{
					print(courses[option-1].teachers[i+1].name);
					if(i!=courses[option-1].teacher_no-2) print(", ");
					else print("\n");
				}
				print("Participants: ");
				for(int i=0;i<courses[option-1].student_no;i++)
				{
					print(courses[option-1].students[i].name);
					if(i!=courses[option-1].student_no-1) print(", ");
					else print("\n");
				}
				while(true){
					print("\nCourse: "+courses[option-1].name+"\n1.Change Details\t2.Check Faculty "
					+"details\n3.Check Student details\t4.Delete Course\n5.Back\nEnter your option: ");
					int no=getInt(input);
					switch (no) {
					case 1:
					{
						System.out.print("\n1.Change course name\t"
								+ "2.Change Start Date\n3.Change duration\t"
								+ "4.Change Fees\n5.Back\nEnter your option: ");
						no=getInt(input);
						if(no==5) break;
						else if(no<1||no>5) {System.out.println("Wrong option!\n");break;}
						System.out.print("Do you want to change this Course details from the Data"
		    					+ "? Y or N: ");
						String yn=new String();
						yn=input.next();
						input.nextLine();
						if(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("yes"))
						{
							switch(no)
							{
							case 1:
								print("Enter the New name for the Course: ");
								courses[option-1].name=input.nextLine();
								break;
							case 2:
								print("New Start Date in dd mm yyyy format: ");
								courses[option-1].startDate=getDate(input);
								break;
							case 3:
								print("New Fees of course in Rupees: ");
								courses[option-1].fee=getInt(input);
								break;
							}
						}	
						break;
					}
					case 2:
					{
						for(int i=0;i<courses[option-1].teacher_no;i++)
						{
							print(Integer.toString(i+1)+". "+courses[option-1].teachers[i].name+"\n");
						}
						System.out.print("1.View Faculty\t\t2.Add Faculty\n3.Change details\t"
								+ "4.Delete Faculty\n5.Back\nEnter your option: ");
						no=getInt(input);
						switch(no){
						case 1:
							print("Enter the index of faculty: ");
							no=getInt(input);
							if(no<=0||no>courses[option-1].teacher_no) {
								System.out.print("Wrong input\n");break;}
							Faculty temp=new Faculty();
							temp=courses[option-1].teachers[no-1];
							print("Name: "+temp.name+"\nPhone Number: "+temp.phone+"\nEmail ID: "+
						temp.mailId+"\nDepartment: "+temp.department+"\nAddress: "+temp.address+"\n");
							break;
						case 2:
							if(courses[option-1].teacher_no==Course.LIMIT+1) {
								print("Max Faculty limit reached\n");
								break;
							}
							print("New Faculty: \n");
							courses[option-1].teachers[courses[option-1].teacher_no]=new Faculty();
							courses[option-1].teachers[courses[option-1].teacher_no].add(input);
							courses[option-1].teacher_no++;
							break;
						case 3:
						{
						print("Enter the index of Faculty: ");
						int no1=getInt(input);
						if(no1<=0||no1>courses[option-1].teacher_no) {
							print("Wrong input\n");break;}
						print("1.Change Phone No\t2.Change Name\n3.Change EmailID\t4.Change Department"
								+ "\n5.Change Address\t6.Back\nEnter your option: ");
						no=getInt(input);
						if(no==6)break;
						if(no>6||no<=0){print("Invalid Option\n");break;}
						switch (no) {
						case 1:
							print("Enter the new Phone number: ");
							courses[option-1].teachers[no1-1].phone=getPhone(input);
							break;
						case 2:
							print("Enter new Name: ");
							courses[option-1].teachers[no1-1].name=input.nextLine();
							break;
						case 3:
							print("New Email ID: ");
							courses[option-1].teachers[no1-1].mailId=input.nextLine();
							break;
						case 4:
							print("New Organisation? ");
							courses[option-1].teachers[no1-1].department=input.nextLine();
							break;
						case 5:
							print("New Address? ");
							courses[option-1].teachers[no1-1].address=input.nextLine();
							break;
						}
						break;
						}
						case 4:
							print("Enter the index of faculty: ");
							no=getInt(input);
							if(no<=0||no>courses[option-1].teacher_no) {
								print("Wrong input\n");break;}
							print("Do you want to remove this faculty details from the Data"
			    					+ "? Y or N: ");
							String yn=new String();
							yn=input.nextLine();
							if(!yn.equalsIgnoreCase("y")&&!yn.equalsIgnoreCase("yes")) break;
							for(int i=no-1;i<courses[option-1].teacher_no-1;i++)
							{
								courses[option-1].teachers[i]=courses[option-1].teachers[i+1];
							}
							courses[option-1].teachers[courses[option-1].teacher_no-1]=null;
							courses[option-1].teacher_no--;
							break;
						case 5:
							break;
						default:
							print("Invalid option!\n");
							break;
						}
					}
					case 3:
					{
						for(int i=0;i<courses[option-1].student_no;i++)
						{
							print(Integer.toString(i+1)+". "+courses[option-1].students[i].name+"\n");
						}
						print("1.View Participant\t2.Add Participant\n3.Change details\t"
								+ "4.Delete Participant\n5.Back\nEnter your option: ");
						no=getInt(input);
						switch(no){
						case 1:
							print("Enter the index of Participant: ");
							no=getInt(input);
							if(no<=0||no>courses[option-1].student_no) {
								System.out.print("Wrong input\n");break;}
							Participant temp=new Participant();
							temp=courses[option-1].students[no-1];
							print("Name: "+temp.name+"\nPhone Number: "+temp.phone+"\nEmail ID: "+
						temp.email+"\nOrganisation: "+temp.organisation+"\nAddress: "+temp.address+"\n");
							break;
						case 2:
							if(courses[option-1].student_no==Course.LIMIT) {
								print("Max Participant limit reached\n");
								break;
							}
							print("New Participant: \n");
							courses[option-1].students[courses[option-1].student_no]=new Participant();
							courses[option-1].students[courses[option-1].student_no].add(input);
							courses[option-1].student_no++;
							break;
						case 3:
							print("Enter the index of Participant: ");
							int no1=getInt(input);
							if(no1<=0||no1>courses[option-1].student_no) {
								print("Wrong input\n");break;}
							print("1.Change Phone No\t2.Change Name\n3.Change EmailID\t4.Change Organisa"
									+ "tion\n5.Change Address\t6.Back\nEnter your option: ");
							no=getInt(input);
							if(no==6)break;
							if(no>6||no<=0){print("Invalid Option\n");break;}
							switch (no) {
							case 1:
								print("Enter the new Phone number: ");
								courses[option-1].students[no1-1].phone=getPhone(input);
								break;
							case 2:
								print("Enter new Name: ");
								courses[option-1].students[no1-1].name=input.nextLine();
								break;
							case 3:
								print("New Email ID: ");
								courses[option-1].students[no1-1].email=input.nextLine();
								break;
							case 4:
								print("New Organisation? ");
								courses[option-1].students[no1-1].organisation=input.nextLine();
								break;
							case 5:
								print("New Address? ");
								courses[option-1].students[no1-1].address=input.nextLine();
								break;
							}
							break;
						case 4:
							print("Enter the index of participant: ");
							no=getInt(input);
							if(no<=0||no>courses[option-1].student_no) {
								System.out.print("Wrong input\n");break;}
							print("Do you want to remove this Participant details from the Data"
			    					+ "? Y or N: ");
							String yn=new String();
							yn=input.nextLine();
							if(!yn.equalsIgnoreCase("y")&&!yn.equalsIgnoreCase("yes")) break;
							for(int i=no-1;i<courses[option-1].student_no-1;i++)
							{
								courses[option-1].students[i]=courses[option-1].students[i+1];
							}
							courses[option-1].students[courses[option-1].student_no-1]=null;
							courses[option-1].student_no--;
							break;
						case 5:
							break;
						default:
							print("Invalid option!\n");
							break;
						}
						break;
					}
					case 4:
					{
						for(int i=option-1;i<no_of_courses-1;i++)
						{
							courses[i]=courses[i+1];
						}
						courses[no_of_courses-1]=null;
						no_of_courses--;
					}
					case 5:
						break;
					default:
						print("Invalid option!\n");
						break;
					}
					break;
				}
				break;
    		}
			case 3:
    		{
    			whileBreak=1;
    			break;
    		}
    		default:
    			print("Enter a valid option!\n");break;
    		}
    		if(whileBreak==1)break;
    	}
    	if(input!=null)
    		input.close();
    	saveCourses(courses,no_of_courses);
	}
	
	/**
	 * Method to save all the data before exiting the program
	 * 
	 * @param courses Course details to be stored
	 * @param no_of_courses no of courses
	 */
	
	public static
	void saveCourses(Course[] courses,int no_of_courses)
	{
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter("stcm.txt"));
			for(int i=0;i<no_of_courses;i++)
			{
				writer.write(courses[i].name+"\n");
				writer.write(courses[i].startDate.toString()+"\n");
				writer.write(Integer.toString(courses[i].duration)+"\n");
				writer.write(Integer.toString(courses[i].fee)+"\n");
				writer.write(courses[i].teacher_no+"\n");
				for(int j=0;j<courses[i].teacher_no;j++)
				{
					writer.write(courses[i].teachers[j].name+"\n");
					writer.write(courses[i].teachers[j].phone+"\n");
					writer.write(courses[i].teachers[j].mailId+"\n");
					writer.write(courses[i].teachers[j].department+"\n");
					writer.write(courses[i].teachers[j].address+"\n");
				}
				writer.write(courses[i].student_no+"\n");
				for(int j=0;j<courses[i].student_no;j++)
				{
					writer.write(courses[i].students[j].name+"\n");
					writer.write(courses[i].students[j].phone+"\n");
					writer.write(courses[i].students[j].email+"\n");
					writer.write(courses[i].students[j].organisation+"\n");
					writer.write(courses[i].students[j].address+"\n");
				}
			}
			writer.close();
		}
		catch(IOException ioe)
		{
			print("Can't save the file because "+ioe+"\n");
		}
	}
	
	/**
	 * Method to get data from the file at the start of the program
	 * 
	 * @param courses courses array to store all course details into it
	 * @param no_of_courses no of courses
	 * @return no of courses
	 */
	
	public static
	int getCourses(Course[] courses,Integer no_of_courses)
	{
		try{
			BufferedReader bReader=new BufferedReader(new FileReader("stcm.txt"));
			String x=bReader.readLine();
			while(x!=null)
			{
				courses[no_of_courses]=new Course();
				courses[no_of_courses].name=x;
				String [] date=bReader.readLine().split("-");
				courses[no_of_courses].startDate=LocalDate.of(Integer.parseInt(date[0]),
						Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				courses[no_of_courses].duration=Integer.parseInt(bReader.readLine());
				courses[no_of_courses].fee=Integer.parseInt(bReader.readLine());
				courses[no_of_courses].teacher_no=Integer.parseInt(bReader.readLine());
				if(LocalDate.now().getDayOfYear()-courses[no_of_courses].startDate.getDayOfYear()+365*(LocalDate.now().getYear()-courses[no_of_courses]
						.startDate.getYear())>365*5)
					continue;
				for(int i=0;i<courses[no_of_courses].teacher_no;i++)
				{
					courses[no_of_courses].teachers[i]=new Faculty();
					courses[no_of_courses].teachers[i].name=bReader.readLine();
					courses[no_of_courses].teachers[i].phone=bReader.readLine();
					courses[no_of_courses].teachers[i].mailId=bReader.readLine();
					courses[no_of_courses].teachers[i].department=bReader.readLine();
					courses[no_of_courses].teachers[i].address=bReader.readLine();
				}
				courses[no_of_courses].student_no=Integer.parseInt(bReader.readLine());
				for(int i=0;i<courses[no_of_courses].student_no;i++)
				{
					courses[no_of_courses].students[i]=new Participant();
					courses[no_of_courses].students[i].name=bReader.readLine();
					courses[no_of_courses].students[i].phone=bReader.readLine();
					courses[no_of_courses].students[i].email=bReader.readLine();
					courses[no_of_courses].students[i].organisation=bReader.readLine();
					courses[no_of_courses].students[i].address=bReader.readLine();
				}
				no_of_courses++;
				x=bReader.readLine();
			}
			bReader.close();
		}
		catch(IOException ioe)
		{
			print("Can't read the file because "+ioe+"\n");
		}
		return no_of_courses;
	}

	/**
	 * Method to get a valid Phone Number from the user
	 * 
	 * @param input Scanner to take input from user
	 * @return A valid Phone Number input
	 */
	
	public static
	String getPhone(Scanner input)
	{
		String phone=null;
		int error=1;
		while(error==1)
		{
			error=0;							//No's like +919876543210 will be accepted
			phone=input.nextLine();
			if(phone.length()<10||(phone.charAt(0)!='+'&&(phone.charAt(0)<'0'||phone.charAt(0)>'9')))
			{
				System.out.print("Not a Valid Phone Number!\nTry again: ");
				error=1;
				continue;
			}
			for(int i=1;i<phone.length();i++)
	    	{
	    		if(phone.charAt(i)<'0'||phone.charAt(i)>'9'){
	    			System.out.print("Not a Valid Phone Number!\nTry again: ");
	    			error=1;
	    			break;
	    		}
	    	}
		}
		return phone;
	}
	
	/**
	 * Method to get a valid Integer from the user
	 * 
	 * @param input Scanner to take input from user
	 * @return A valid Integer input
	 */
	
	public static
	int getInt(Scanner input)
	{
		int option;
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
	    		System.out.print("Enter Valid Integer:  ");
	    		continue;
	    	}
	    	break;
    	}
		return option;
	}
	
	/**
	 * Method to get a Valid Date input from user
	 * 
	 * @param input Scanner to take input from user
	 * @return A valid Date
	 */
	
	public static
	LocalDate getDate(Scanner input)
	{
		int year,month,day;
		LocalDate date=null;
		while(true)
		{
			try{
				day=input.nextInt();
				month=input.nextInt();
				year=input.nextInt();
				input.nextLine();
				date=LocalDate.of(year, month, day);
				break;
				}
			catch(DateTimeException dte){
				System.out.print("Input Format is wrong\nTry again: ");continue;}
			catch(InputMismatchException mm){
				input.nextLine();
				System.out.print("Enter a valid Date: ");continue;}
		}
		return date;
	}
	
	/**
	 * Method to get a valid Mail ID
	 * 
	 * @param input Scanner to take input from user
	 * @return Valid Mail ID as String
	 */
	
	public static
	String getMail(Scanner input)
	{
		int i,error=1;
		String mailId;
		while(true)
		{
			error=1;
			mailId=input.nextLine();
			for(i=1;i<mailId.length();i++)
			{
				if(mailId.charAt(i)=='@'){   //checks if there is atleast a letter before @
					error=2;				 //and also some other checks
					break;					 //allows mailids like a@b.c
				}
			}
			for(int j=i+2;j<mailId.length()-1;j++)
			{
				if(error==2&&mailId.charAt(i)=='.'){
					error=0;
					break;
				}
			}
			if(error==1)
			{
				System.out.print("Not a Valid Mail ID!\nTry again: ");
			}
			else break;
		}
		return mailId;
	}
	
	/**
	 * Method to check if date is older to one year from ago from now
	 * 
	 * @param date Date that is to be checked
	 * @return boolean value 0 if it is older to one year from now else 1
	 */
	
	public static 
	boolean checkDate(LocalDate date) {
		LocalDate temp=LocalDate.now();
		int sum=(temp.getYear()-date.getYear())*365+(temp.getDayOfYear()-date.getDayOfYear());
		if(sum>365)return false;
		else {
			return true;
		}
	}
}
