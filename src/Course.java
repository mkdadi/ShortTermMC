package src;

import java.time.LocalDate;
import java.util.ArrayList;

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
	public ArrayList<Faculty> teachers=new ArrayList<Faculty>();
	public int teacher_no;
	public ArrayList<Participant> students=new ArrayList<Participant>();
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
    
}