package src;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is class for Courses and it dependencies
 * 
 * @author Madhu Kumar Dadi
 * @version 16.1.2016	
 */
public class Course
{
	//LIMIT is for Participants limit in the program
	public static int LIMIT=5;
	public String name;
	public int fee;
	public LocalDate startDate;
	public int duration;//Assuming duration in days
	public Faculty[] teachers=new Faculty[LIMIT+1];
	public int teacher_no;
	public Participant[] students=new Participant[LIMIT];
	public int student_no;
	
    /**
     * Constructor for objects of class Course
     */
    public 
    Course(String name,int fee,LocalDate date)
    {
    	this.name=name;
    	this.fee=fee;
    	this.startDate=date;
    	this.teachers=null;
    	this.teacher_no=0;
    	this.students=null;
    	this.student_no=0;
    }
    
    /**
     * Default Constructor for the class Course
     */
    public
    Course()
    {
    	this.name=null;
    	this.fee=0;
    	this.duration=0;
    	this.startDate=LocalDate.now();
    	this.teacher_no=0;
    	this.student_no=0;
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
		Faculty[] teachers=new Faculty[LIMIT+1];
		if(no!=0)System.out.print("Co-ordinator: \n");
    	for(int i=0;i<no;i++)
    	{
    		teachers[i]=new Faculty();
    		teachers[i].add(input);
    		if(i!=no-1)	System.out.print("\nFaculty .."+Integer.toString(i)+": \n");
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
		Participant[] students=new Participant[LIMIT];
    	for(int i=0;i<no;i++)
    	{
    		students[i]=new Participant();
    		students[i].add(input);
    		if(i!=no-1)	System.out.print("\nNext one..: \n");
    	}
    	this.students=students;
    }
}
