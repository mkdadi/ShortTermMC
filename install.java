import java.io.File;

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
		File course_dir=new File("./src/Data/Courses/");
		try{
			course_dir.mkdirs();
		}
		catch(SecurityException se){
			System.out.println(se+"\nExiting...");
			return;
		}
	}

}
