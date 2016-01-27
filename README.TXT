------------------------------------------------------------------------------------------
                              SHORT TERM COURSE MANAGEMENT
------------------------------------------------------------------------------------------

PROJECT TITLE: Short Term Course Management IIT KGP

VERSION or DATE: 16/1/2016

HOW TO START THIS PROJECT: linux/mac users can install the program by running 'make' 
	provided in current directory and then run 'java src.Stcm' from this folder

For Windows: First install the project directories and files by running 
	'javac install.java' followed by 'java install'
	In cmd run 'javac src.Stcm.java src.Faculty.java src.Participant.java 
	src.Course.java' in current directory and then run the program by the command 
	'java src.Stcm'

AUTHOR: Madhu Kumar Dadi

USER INSTRUCTIONS: Program should be run from this folder, it can't be run directly 
	because a package named src is being used.So, to run the file type 'java src.Stcm'

IDEA: All the Course data saved through this program will be stored in 'Data/Courses/' 
	folder as COURSENAME.cdat files and similarly participants and Faculty are stored 
	in 'Data/Students/' and 'Data/Faculty/' folders respectively. Every time a Course
	is accessed through the program that file will be open, and not all files are 
	retrieved at the start of the program thus making the program use less memory 
	And before starting the program install file must be run, so that it creates all 
	the files and folders required for the program to run.