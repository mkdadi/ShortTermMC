package src;

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
    	Scanner scanner=new Scanner(System.in);
    	System.out.println(scanner.next());
    	if(scanner!=null)
    		scanner.close();
    }
}
