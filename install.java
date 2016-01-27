import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Installation Class for the STCM Project
 */

/**
 * @author Madhu Kumar Dadi
 *
 * @version 16.1.2016
 */
public class install {

	/**
	 * @param args no arguments required
	 */
	public static void main(String[] args) {
		File course_dir=new File("./Data/Courses/");
		File faculty_dir=new File("./Data/Faculties/");
		File student_dir=new File("./Data/Students/");
		try{
			course_dir.mkdirs();//To create directories and files required for the program
			System.out.print("Created Directories Data/ and Data/Courses/ \n");
			faculty_dir.mkdirs();
			System.out.print("Created Directory Data/Faculties/ \n");
			student_dir.mkdirs();
			System.out.print("Created Directory Data/Students/ \n");
			File course=new File("./Data/Courses/courses.cdat");
			course.createNewFile();
			System.out.print("Created File Data/Courses/courses.cdat \n");
			Path path=Paths.get("./Data/Courses/courses.cdat");
			BufferedWriter writer=Files.newBufferedWriter(path);
			writer.write("courses\n");
			writer.close();
			course=new File("./Data/Faculties/faculties.fdat");
			course.createNewFile();
			path=Paths.get("./Data/Faculties/faculties.fdat");
			System.out.print("Created File Data/Faculties/faculties.fdat \n");
			writer=Files.newBufferedWriter(path);
			writer.write("faculties\n");
			writer.close();
			course=new File("./Data/Students/students.sdat");
			course.createNewFile();
			path=Paths.get("./Data/Students/students.sdat");
			System.out.print("Created File Data/Students/students.sdat \n");
			writer=Files.newBufferedWriter(path);
			writer.write("students\n");
			writer.close();
		}
		catch(SecurityException se){
			System.out.println(se+"\nExiting...");
			return;
		}
		catch (IOException ioe) {
			System.out.println(ioe+"\nExiting...");
		}
	}
}
