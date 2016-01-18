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
	public Duration duration;
	public Faculty[] teachers;
	public Participant[] students;
	
    /**
     * Constructor for objects of class Course
     */
    public 
    Course(String name,int fee,int day,int month,int year)
    {
    	this.name=name;
    	this.fee=fee;
    	this.startDate=LocalDate.of(year, month, day);
    	teachers=new Faculty[LIMIT+1];
    	students=new Participant[LIMIT];
    }

    /**
     * Adds the Duration detail to the Course Object
     * 
     * @param  Void
     * @return     Void 
     */
    public 
    void getDuration()
    {
    	System.out.print("Duration of the Course in Days: ");
    	int no;
    	Scanner input=new Scanner(System.in);
    	while(true)
    	{
	    	try
	    	{
	    		no=input.nextInt();
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
    	if(input!=null)
    		input.close();
    	this.duration=Duration.ofDays(no);
    }
    
    /**
     * Adds the Faculty details to the Course Object
     * 
     * @param	Void
     * @return     Void 
     */
    public 
    void addTeachers()
    {
    	System.out.println("No of Faculty Members(Coordinator and TA's included): ");
    	Scanner input=new Scanner(System.in);
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
		Faculty[] teachers=new Faculty[no];
    	for(int i=0;i<no;i++)
    	{
    		teachers[i].add();
    	}
    	if(input!=null)
    		input.close();
    	this.teachers=teachers;
    }
    
    /**
     * Adds the Participant details to the Course Object
     * 
     * @param	Void
     * @return     Void 
     */
    public 
    void addParticipants()
    {
    	System.out.println("No of Participants(max of "+Integer.toString(LIMIT)+"): ");
    	Scanner input=new Scanner(System.in);
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
		Participant[] students=new Participant[no];
    	for(int i=0;i<no;i++)
    	{
    		students[i].add();
    	}
    	if(input!=null)
    		input.close();
    	this.students=students;
    }
}
