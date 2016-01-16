package src;  
import java.time.*;

/**
 * This is class for Courses and it dependencies
 * 
 * @author Madhu Kumar Dadi
 * @version 16.1.2016
 */
public class Course
{
    // instance variables 
	public String name;
	public int fee;
	public LocalDate startDate;
	public Duration duration;
	public Faculty[] teachers=new Faculty[6];
    /**
     * Constructor for objects of class course
     */
    public Course()
    {
     
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
    }
}
