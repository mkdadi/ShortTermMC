package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
	 * Method to save all the data before exiting the program
	 * 
	 * @param courses Course details to be stored
	 * @param no_of_courses no of courses
	 */
	
	public static
	void saveCourses(ArrayList<Course> courses)
	{
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter("stcm.txt"));
			for(int i=0;i<courses.size();i++)
			{
				writer.write(courses.get(i).name+"\n");
				writer.write(courses.get(i).startDate.toString()+"\n");
				writer.write(Integer.toString(courses.get(i).duration)+"\n");
				writer.write(Integer.toString(courses.get(i).fee)+"\n");
				writer.write(courses.get(i).teacher_no+"\n");
				for(int j=0;j<courses.get(i).teacher_no;j++)
				{
					writer.write(courses.get(i).teachers.get(j).name+"\n");
					writer.write(courses.get(i).teachers.get(j).phone+"\n");
					writer.write(courses.get(i).teachers.get(j).mailId+"\n");
					writer.write(courses.get(i).teachers.get(j).department+"\n");
					writer.write(courses.get(i).teachers.get(j).address+"\n");
				}
				writer.write(courses.get(i).student_no+"\n");
				for(int j=0;j<courses.get(i).student_no;j++)
				{
					writer.write(courses.get(i).students.get(j).name+"\n");
					writer.write(courses.get(i).students.get(j).phone+"\n");
					writer.write(courses.get(i).students.get(j).email+"\n");
					writer.write(courses.get(i).students.get(j).organisation+"\n");
					writer.write(courses.get(i).students.get(j).address+"\n");
				}
			}
			writer.close();
		}
		catch(IOException ioe)
		{}
	}
	
	/**
	 * Method to get data from the file at the start of the program
	 * 
	 * @param courses courses array to store all course details into it
	 * @param no_of_courses no of courses
	 * @return no of courses
	 */
	
	public static
	void getCourses(ArrayList<Course> courses)
	{
		try{
			BufferedReader bReader=new BufferedReader(new FileReader("stcm.txt"));
			String x=new String(bReader.readLine());
			while(x!=null)
			{
				Course temp=new Course();
				temp.name=x;
				String [] date=bReader.readLine().split("-");
				temp.startDate=LocalDate.of(Integer.parseInt(date[0]),
						Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				temp.duration=Integer.parseInt(bReader.readLine());
				temp.fee=Integer.parseInt(bReader.readLine());
				temp.teacher_no=Integer.parseInt(bReader.readLine());
				if(LocalDate.now().getDayOfYear()-temp.startDate.getDayOfYear()+365*(LocalDate.now().getYear()-temp.startDate.getYear())>365*5)
					continue;
				for(int i=0;i<temp.teacher_no;i++)
				{
					Faculty fac=new Faculty();
					fac.name=bReader.readLine();
					fac.phone=bReader.readLine();
					fac.mailId=bReader.readLine();
					fac.department=bReader.readLine();
					fac.address=bReader.readLine();
					temp.teachers.add(fac);
				}
				temp.student_no=Integer.parseInt(bReader.readLine());
				for(int i=0;i<temp.student_no;i++)
				{
					Participant par=new Participant();
					par.name=bReader.readLine();
					par.phone=bReader.readLine();
					par.email=bReader.readLine();
					par.organisation=bReader.readLine();
					par.address=bReader.readLine();
					temp.students.add(par);
				}
				courses.add(temp);
				x=bReader.readLine();
			}
			bReader.close();
		}
		catch(IOException ioe)
		{
			MainWindow.mainMess.setText("Can't read the file because "+ioe);
		}
	}
}
