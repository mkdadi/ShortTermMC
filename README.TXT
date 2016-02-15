------------------------------------------------------------------------------------------
                              SHORT TERM COURSE MANAGEMENT
------------------------------------------------------------------------------------------

PROJECT TITLE: Short Term Course Management IIT KGP

VERSION or DATE: 16/1/2016

HOW TO START THIS PROJECT: linux/mac users can install the program by running 'make' 
	provided in current directory and then run 'java src.STCM' from this folder

For Windows:
	In cmd run 'javac src/STCM.java src/Faculty.java src/Participant.java 
	src/Course.java' in current directory and then run the program by the command 
	'java src.STCM'

AUTHOR: Madhu Kumar Dadi

USER INSTRUCTIONS: Program should be run from this folder, it can't be run directly 
	because a package named src is being used.So, to run the file type 'java src.STCM'

IDEA:
	When the program starts it accesses stcm.txt file if it is not available the program creates one
	And then it reads the whole file to the local objects. The pattern in which the data is stored in 
	the stcm.txt is given below. Then all the manipulations are done to the objects and new objects can 
	also be created. At the end of the runtime all the data in the file is erased and Data in the objects 
	is stored in the file.
	
File Saving Pattern:
	Course Name
	Start Date of Course
	Duration of Course
	Fees
	No of faculty including Coordinator(Say n)
		Faculty Name
		Phone Number
		Email ID
		Department
		Address
		..(continue same for n times)
	No of Participants(Say n)
		Participant Name
		Phone Number
		Email ID
		Organisation
		Address
		..(continue same for n times)
	..(continues for all courses)