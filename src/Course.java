package src;  

import java.time.*;
import java.util.*;


/**
 * This is class for Courses and it dependencies
 * 
 * @author Madhu Kumar Dadi
 * @version 16.1.2016	
 */
public class Course
{
	public static int LIMIT=5;
    // instance variables 
	public String name;
	public int fee;
	public LocalDate startDate;
	public int duration;//Assuming duration in days
	public Faculty[] teachers;
	public int teacher_no;
	public Participant[] students;
	public int student_no;
	
    /**
     * Constructor for objects of class Course
     */
    public 
    Course(String name,int fee,int day,int month,int year)
    {
    	this.name=name;
    	this.fee=fee;
    	this.startDate=LocalDate.of(year, month, day);
    	this.teachers=null;
    	this.teacher_no=0;
    	this.students=null;
    	this.student_no=0;
    }

    /**
     * Adds the Duration detail to the Course Object
     * 
     * @param  Void
     * @return     Void 
     */
    public 
    void getDuration(Scanner input)
    {
    	System.out.print("Duration of the Course in Days: ");
    	while(true)
    	{
	    	try
	    	{
	        	this.duration=input.nextInt();
	    		input.nextLine();
	    	}
	    	catch(InputMismatchException mm)
	    	{
	    		System.out.print(mm+"\nEnter Valid Integer!\n"
	    				+ "Duration of the Course in Days: ");
	    		continue;
	    	}
	    	break;
    	}
    }
    
    /**
     * Adds the Faculty details to the Course Object
     * 
     * @param	Void
     * @return     Void 
     */
    public 
    void addTeachers(Scanner input)
    {
    	System.out.print("No of Faculty Members(Coordinator and TA's included): ");
    	int no;
    	while(true)
    	{
	    	try
	    	{
	    		no=input.nextInt();
	    		input.nextLine();
	    	}
	    	catch(InputMismatchException mm)
	    	{
	    		input.nextLine();
	    		System.out.print(mm+"\nEnter Valid Integer!\n"
	    				+ "No of Faculty Members(Coordinator and TA's included): ");
	    		continue;
	    	}
	    	if(no<=LIMIT+1)	break;
	    	else {
	    		System.out.print("Maximum of "+Integer.toString(LIMIT)
	    				+" TA's and a Course Coordinator can be alloted\n"
	    				+ "No of Faculty Members(Coordinator and TA's included): ");
	    		continue;
	    	}
    	}
    	this.teacher_no=no;
		Faculty[] teachers=new Faculty[no];
    	for(int i=0;i<no;i++)
    	{
    		teachers[i]=new Faculty();
    		teachers[i].add(input);
    		if(i!=no-1)	System.out.print("\nNext one..: \n");
    	}
    	this.teachers=teachers;
    }
    
    /**
     * Adds the Participant details to the Course Object
     * 
     * @param	Void
     * @return     Void 
     */
    public 
    void addParticipants(Scanner input)
    {
    	System.out.print("No of Participants(max of "+Integer.toString(LIMIT)+"): ");
    	int no;
    	while(true)
    	{
	    	try
	    	{
	    		no=input.nextInt();
	    		input.nextLine();
	    	}
	    	catch(InputMismatchException mm)
	    	{
	    		input.nextLine();
	    		System.out.print(mm+"\nEnter Valid Integer!\n"
	    				+ "No of Participants(max of "+Integer.toString(LIMIT)+"): ");
	    		continue;
	    	}
	    	if(no<=LIMIT)	break;
	    	else {
	    		System.out.print("Maximum of "+Integer.toString(LIMIT)
	    				+ " Students can enroll per a Subject\n"
	    				+ "No of Participants(max of "+Integer.toString(LIMIT)+"): ");
	    		continue;
	    	}
    	}
    	this.student_no=no;
		Participant[] students=new Participant[no];
    	for(int i=0;i<no;i++)
    	{
    		students[i]=new Participant();
    		students[i].add(input);
    		if(i!=no-1)	System.out.print("\nNext one..: \n");
    	}
    	this.students=students;
    }
}
