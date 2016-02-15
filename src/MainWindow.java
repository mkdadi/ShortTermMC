package src;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class MainWindow {

	private JFrame frmStcmIitKgp;
	private JPanel mainWin;
	private JPanel addCourse;
	private JPanel addFac;
	private JTextField crName;
	private JTextField crFee;
	private JTextPane crDetails;
	private JTextField crDuration;
	private JTextField crDate;
	private JTextField crFacNo;
	private JTextField crParNo;
	private JTextField facName;
	private JTextField facMobile;
	private JTextField facMail;
	private JTextField facDep;
	private JTextField facAddress;
	private JTextField parName;
	private JTextField parMobile;
	private JTextField parMail;
	private JTextField parOrg;
	private JTextField parAddress;
	private JPanel addPar;
	private JPanel display;
	private JPanel displayCr;
	private JPanel displayFac;
	private JPanel displayPar;
	private JPanel facDetails;
	private JPanel parDetails;
	private Course course;
	public static JLabel addFacMess;
	public static JLabel addParMess;
	public static JLabel addCourseMess;
	private int student_no;
	private int teacher_no;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton parEditB;
	private JButton facEditB;
	private JScrollPane facScroll;
	private JScrollPane parScroll;
	private static ArrayList<Course> courses=new ArrayList<Course>();
	public static JLabel mainMess;
	private JScrollPane crScroll;
	private JPanel parPane;
	private JPanel facPane;
	private JPanel crPane;
	private JButton ceFac;
	private JButton cePar;
	private JButton crCh;
	private JButton delCr;
	private JTextPane facDPane;
	private JTextPane parDPane;
	private JButton facDelete;
	private JButton parDelete;
	private JPanel addNPar;
	private JTextField addNPName;
	private JTextField addNPMob;
	private JTextField addNPMai;
	private JTextField addNPOrg;
	private JTextField addNPAddr;
	private JButton addParB;
	private JButton btnBack_5;
	private JPanel crEdit;
	private JPanel parEdit;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel lblEditCourse;
	private JTextField crEName;
	private JTextField crEFee;
	private JTextField crEDur;
	private JTextField crEDOB;
	private JButton button_6;
	private JButton button_7;
	private JLabel lblChangeParticipantDetails;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JTextField parEName;
	private JTextField parEMob;
	private JTextField parEMail;
	private JTextField parEOrg;
	private JTextField parEAddr;
	private JButton button_8;
	private JButton btnBack_6;
	private JPanel facEdit;
	private JLabel lblChangeFacultyDetails;
	private JLabel lblDepartment;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JTextField facEName;
	private JTextField facEMob;
	private JTextField facEMail;
	private JTextField facEDep;
	private JTextField facEAddr;
	private JButton button_9;
	private JButton button_10;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					Stcm.getCourses(courses);
					window.setCourses(courses);
					window.frmStcmIitKgp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setFac(ArrayList<Course> courses,int id)
	{
		for(int i=0;i<courses.get(id).teacher_no;i++)
		{
			JButton button=new JButton(courses.get(id).teachers.get(i).name);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayFac.setVisible(false);
					JButton button1=(JButton)e.getSource();
					int id1=(int)button1.getClientProperty("id");
					Faculty faculty=new Faculty();
					faculty=courses.get(id).teachers.get(id1);
					facDPane.setText("Name: "+faculty.name+"\nMobile: "+faculty.phone+"\nEmail: "+faculty.mailId+
							"\nDepartment: "+faculty.department+"\nAddress: "+faculty.address);
					facEditB.putClientProperty("id", id);
					facEditB.putClientProperty("id1", id1);
					facDelete.putClientProperty("id", id);
					facDelete.putClientProperty("id1", id1);
					facDetails.setVisible(true);
				}
			});
			button.putClientProperty("id", i);
			facPane.add(button);
		}
	}
	
	public void setPar(ArrayList<Course> courses,int id)
	{
		for(int i=0;i<courses.get(id).student_no;i++)
		{
			JButton button=new JButton(courses.get(id).students.get(i).name);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayPar.setVisible(false);
					JButton button1=(JButton)e.getSource();
					int id1=(int)button1.getClientProperty("id");
					Participant student=new Participant();
					student=courses.get(id).students.get(id1);
					parDPane.setText("Name: "+student.name+"\nMobile: "+student.phone+"\nEmail: "+student.email+
							"\nOrganisation: "+student.organisation+"\nAddress: "+student.address);
					parEditB.putClientProperty("id", id);
					parEditB.putClientProperty("id1", id1);
					parDelete.putClientProperty("id", id);
					parDelete.putClientProperty("id1", id1);
					parDetails.setVisible(true);
				}
			});
			button.putClientProperty("id", i);
			parPane.add(button);
		}
	}
	
	public void setCourses(ArrayList<Course> courses)
	{
		for(int i=0;i<courses.size();i++)
		{
			JButton button =new JButton(courses.get(i).name);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					display.setVisible(false);
					JButton button=(JButton)(e.getSource());
					int id=(int)button.getClientProperty("id");
					Course temp=new Course();
					String teac=new String();
					String stu=new String();
					temp=courses.get(id);
					teac="Co-ordinator: ";
					if(temp.teacher_no>0)
					{
						teac+=temp.teachers.get(0).name+"\nFaculty: ";
						for(int j=1;j<temp.teacher_no;j++)
						{
							teac+=temp.teachers.get(j).name;
							if(j!=temp.teacher_no-1) teac+=", ";
						}
					}
					stu="Participants: ";
					for(int j=0;j<temp.student_no;j++)
					{
						stu+=temp.students.get(j).name;
						if(j!=temp.student_no-1) stu+=", ";
					}
					crDetails.setText("Name: "+temp.name+"\nStart Date: "+temp.startDate.toString()+"\nDuration: "+Integer.toString(temp.duration)+
							" days\nFee: "+Integer.toString(temp.fee)+" Rupees\n"+teac+"\n"+stu);
					displayCr.setVisible(true);
					crCh.putClientProperty("id", id);
					addParB.putClientProperty("id", id);
					ceFac.putClientProperty("id", id);
					cePar.putClientProperty("id", id);
					delCr.putClientProperty("id", id);
				}
			});
			button.putClientProperty("id", i);
			crPane.add(button);
		}
	}
	
	public void visible(boolean b)
	{
		frmStcmIitKgp.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStcmIitKgp = new JFrame();
		frmStcmIitKgp.setTitle("STCM IIT KGP");
		frmStcmIitKgp.setResizable(false);
		frmStcmIitKgp.setBounds(100, 100, 451, 300);
		frmStcmIitKgp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStcmIitKgp.getContentPane().setLayout(new CardLayout(0, 0));
		
		mainWin = new JPanel();
		frmStcmIitKgp.getContentPane().add(mainWin, "name_5332569707219");
		mainWin.setLayout(null);
		mainWin.setVisible(true);
		
		button_1 = new JButton("Display all courses");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWin.setVisible(false);
				display.setVisible(true);
			}
		});
		button_1.setBounds(257, 165, 155, 23);
		mainWin.add(button_1);
		
		JLabel label = new JLabel("Short Term Course Management");
		label.setBounds(79, 36, 280, 22);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Monospaced", Font.PLAIN, 16));
		mainWin.add(label);
		
		button = new JButton("Add a Course");
		button.setBounds(33, 165, 150, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWin.setVisible(false);
				addCourse.setVisible(true);
			}
		});
		mainWin.add(button);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(33, 61, 379, 80);
		textPane.setText("Short Term Course Management is the managing base for the Courses offered by IIT Kharagpur "
				+ "for any participant from any Organization");
		textPane.setRequestFocusEnabled(false);
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		mainWin.add(textPane);
		
		button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stcm.saveCourses(courses);
				frmStcmIitKgp.dispose();
			}
		});
		button_2.setBounds(182, 207, 93, 23);
		mainWin.add(button_2);
		
		mainMess = new JLabel("");
		mainMess.setHorizontalAlignment(SwingConstants.CENTER);
		mainMess.setBounds(10, 11, 425, 23);
		mainWin.add(mainMess);
		
		addCourse = new JPanel();
		frmStcmIitKgp.getContentPane().add(addCourse, "name_5671297843224");
		addCourse.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(87, 53, 128, 14);
		addCourse.add(lblName);
		
		JLabel lblFee = new JLabel("Fee:");
		lblFee.setBounds(87, 90, 128, 14);
		addCourse.add(lblFee);
		
		JLabel lblDateddMmYyyy = new JLabel("Date(dd mm yyyy):");
		lblDateddMmYyyy.setBounds(87, 163, 128, 14);
		addCourse.add(lblDateddMmYyyy);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(87, 125, 128, 14);
		addCourse.add(lblDuration);
		
		JLabel lblNoOfFaculty = new JLabel("No of Faculty:");
		lblNoOfFaculty.setBounds(87, 196, 128, 14);
		addCourse.add(lblNoOfFaculty);
		
		JLabel lblNoOfParticipants = new JLabel("No of Participants:");
		lblNoOfParticipants.setBounds(87, 227, 128, 14);
		addCourse.add(lblNoOfParticipants);
		
		addCourseMess = new JLabel("ADD COURSE");
		addCourseMess.setHorizontalAlignment(SwingConstants.CENTER);
		addCourseMess.setBounds(21, 11, 414, 20);
		addCourse.add(addCourseMess);
		
		crName = new JTextField();
		crName.setBounds(225, 50, 128, 20);
		addCourse.add(crName);
		crName.setColumns(10);
		
		crFee = new JTextField();
		crFee.setColumns(10);
		crFee.setBounds(225, 87, 128, 20);
		addCourse.add(crFee);
		
		crDuration = new JTextField();
		crDuration.setColumns(10);
		crDuration.setBounds(225, 122, 128, 20);
		addCourse.add(crDuration);
		
		crDate = new JTextField();
		crDate.setColumns(10);
		crDate.setBounds(225, 160, 128, 20);
		addCourse.add(crDate);
		
		crFacNo = new JTextField();
		crFacNo.setColumns(10);
		crFacNo.setBounds(225, 193, 128, 20);
		addCourse.add(crFacNo);
		
		crParNo = new JTextField();
		crParNo.setColumns(10);
		crParNo.setBounds(225, 224, 128, 20);
		addCourse.add(crParNo);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourse.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnBack.setBounds(0, 248, 79, 23);
		addCourse.add(btnBack);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				course=new Course();
				course.name=crName.getText();
				course.fee=Integer.parseInt(crFee.getText());
				course.duration=Integer.parseInt(crDuration.getText());
				teacher_no=Integer.parseInt(crFacNo.getText());
				if(teacher_no>6) {
					addCourseMess.setText("teachers no < 6");
					return;
				}
				student_no=Integer.parseInt(crParNo.getText());
				if(student_no>5) {
					addCourseMess.setText("students no < 5");
					return;
				}
				String date[]=new String[3];
				date=crDate.getText().split(" ");
				course.startDate=LocalDate.of(Integer.parseInt(date[2]), 
						Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				crName.setText("");
				crDate.setText("");
				crDuration.setText("");
				crFacNo.setText("");
				crFee.setText("");
				crParNo.setText("");
				if(teacher_no!=0){
					addCourse.setVisible(false);
					addFac.setVisible(true);
				}
				else if(student_no!=0)
				{
					addCourse.setVisible(false);
					addPar.setVisible(true);
				}
				else {
					addCourse.setVisible(false);
					courses.add(course);
					crPane.removeAll();
					crPane.updateUI();
					setCourses(courses);
					mainWin.setVisible(true);
				}
			}
		});
		btnDone.setBounds(356, 248, 89, 23);
		addCourse.add(btnDone);
		
		addFac = new JPanel();
		frmStcmIitKgp.getContentPane().add(addFac, "name_5675298119476");
		addFac.setLayout(null);
		addFac.setVisible(false);
		
		addFacMess = new JLabel("ADD FACULTY");
		addFacMess.setHorizontalAlignment(SwingConstants.CENTER);
		addFacMess.setBounds(30, 11, 392, 24);
		addFac.add(addFacMess);
		
		JLabel lblNewLabel = new JLabel("Department:");
		lblNewLabel.setBounds(30, 166, 129, 14);
		addFac.add(lblNewLabel);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(30, 56, 129, 14);
		addFac.add(lblName_1);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setBounds(30, 92, 129, 14);
		addFac.add(lblMobile);
		
		JLabel lblMailId = new JLabel("Mail ID:");
		lblMailId.setBounds(30, 129, 129, 14);
		addFac.add(lblMailId);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 207, 129, 14);
		addFac.add(lblAddress);
		
		facName = new JTextField();
		facName.setBounds(169, 53, 168, 20);
		addFac.add(facName);
		facName.setColumns(10);
		
		facMobile = new JTextField();
		facMobile.setColumns(10);
		facMobile.setBounds(169, 89, 168, 20);
		addFac.add(facMobile);
		
		facMail = new JTextField();
		facMail.setColumns(10);
		facMail.setBounds(169, 126, 168, 20);
		addFac.add(facMail);
		
		facDep = new JTextField();
		facDep.setColumns(10);
		facDep.setBounds(169, 163, 168, 20);
		addFac.add(facDep);
		
		facAddress = new JTextField();
		facAddress.setColumns(10);
		facAddress.setBounds(169, 204, 168, 20);
		addFac.add(facAddress);
		
		JButton btnDone_1 = new JButton("Done");
		btnDone_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Faculty temp=new Faculty();
				temp.name=facName.getText();
				temp.phone=facMobile.getText();
				temp.mailId=facMail.getText();
				temp.department=facDep.getText();
				temp.address=facAddress.getText();
				course.teacher_no++;
				course.teachers.add(temp);
				facName.setText("");
				facAddress.setText("");
				facDep.setText("");
				facMail.setText("");
				facMobile.setText("");
				if(course.teacher_no==teacher_no)
				{
					if(student_no>0)
					{
						addFac.setVisible(false);
						addPar.setVisible(true);
					}
					else{
						addFac.setVisible(false);
						courses.add(course);
						crPane.removeAll();
						crPane.updateUI();
						setCourses(courses);
						mainWin.setVisible(true);
					}
				}
			}
		});
		btnDone_1.setBounds(346, 235, 89, 23);
		addFac.add(btnDone_1);
		
		addPar = new JPanel();
		addPar.setLayout(null);
		frmStcmIitKgp.getContentPane().add(addPar, "name_11612671480406");
		addPar.setVisible(false);
		
		addParMess = new JLabel("ADD PARTICIPANT");
		addParMess.setHorizontalAlignment(SwingConstants.CENTER);
		addParMess.setBounds(30, 11, 392, 24);
		addPar.add(addParMess);
		
		JLabel lblOrganisation = new JLabel("Organisation:");
		lblOrganisation.setBounds(30, 166, 129, 14);
		addPar.add(lblOrganisation);
		
		JLabel label_3 = new JLabel("Name:");
		label_3.setBounds(30, 56, 129, 14);
		addPar.add(label_3);
		
		JLabel label_4 = new JLabel("Mobile:");
		label_4.setBounds(30, 92, 129, 14);
		addPar.add(label_4);
		
		JLabel label_5 = new JLabel("Mail ID:");
		label_5.setBounds(30, 129, 129, 14);
		addPar.add(label_5);
		
		JLabel label_6 = new JLabel("Address:");
		label_6.setBounds(30, 207, 129, 14);
		addPar.add(label_6);
		
		parName = new JTextField();
		parName.setColumns(10);
		parName.setBounds(169, 53, 168, 20);
		addPar.add(parName);
		
		parMobile = new JTextField();
		parMobile.setColumns(10);
		parMobile.setBounds(169, 89, 168, 20);
		addPar.add(parMobile);
		
		parMail = new JTextField();
		parMail.setColumns(10);
		parMail.setBounds(169, 126, 168, 20);
		addPar.add(parMail);
		
		parOrg = new JTextField();
		parOrg.setColumns(10);
		parOrg.setBounds(169, 163, 168, 20);
		addPar.add(parOrg);
		
		parAddress = new JTextField();
		parAddress.setColumns(10);
		parAddress.setBounds(169, 204, 168, 20);
		addPar.add(parAddress);
		
		button_3 = new JButton("Done");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Participant stu=new Participant();
				stu.name=parName.getText();
				stu.phone=parMobile.getText();
				stu.email=parMail.getText();
				stu.organisation=parOrg.getText();
				stu.address=parAddress.getText();
				course.student_no++;
				course.students.add(stu);
				parName.setText("");
				parAddress.setText("");
				parMail.setText("");
				parMobile.setText("");
				parOrg.setText("");
				if(course.student_no==student_no){
					addPar.setVisible(false);
					mainWin.setVisible(true);
					courses.add(course);
					crPane.removeAll();
					crPane.updateUI();
					setCourses(courses);
				}
			}
		});
		button_3.setBounds(346, 235, 89, 23);
		addPar.add(button_3);

		display = new JPanel();
		frmStcmIitKgp.getContentPane().add(display, "name_16010805216286");
		display.setLayout(null);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setVisible(false);
				mainWin.setVisible(true);
			}
		});
		btnBack_1.setBounds(10, 237, 89, 23);
		display.add(btnBack_1);
		
		crPane = new JPanel();
		crPane.setBounds(10, 11, 425, 215);
		crScroll =new JScrollPane(crPane);
		crPane.setLayout(new BoxLayout(crPane, BoxLayout.Y_AXIS));
		crScroll.setBounds(10, 11, 425, 215);
		display.add(crScroll);
		
		displayCr = new JPanel();
		frmStcmIitKgp.getContentPane().add(displayCr, "name_6886023850973");
		displayCr.setLayout(null);
		
		crDetails = new JTextPane();
		crDetails.setEditable(false);
		crDetails.setBounds(10, 11, 425, 148);
		displayCr.add(crDetails);
		
		JButton crBack = new JButton("Back");
		crBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCr.setVisible(false);
				display.setVisible(true);
			}
		});
		crBack.setBounds(10, 237, 182, 23);
		displayCr.add(crBack);
		
		crCh = new JButton("Change Details");
		crCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCr.setVisible(false);
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				crEName.setText(courses.get(id).name);
				crEDOB.setText(courses.get(id).startDate.getDayOfMonth()+" "+courses.get(id).startDate.getMonthValue()+" "+
						courses.get(id).startDate.getYear());
				crEDur.setText(Integer.toString(courses.get(id).duration));
				crEFee.setText(Integer.toString(courses.get(id).fee));
				button_7.putClientProperty("id", id);
				crEdit.setVisible(true);
			}
		});
		crCh.setBounds(10, 203, 182, 23);
		displayCr.add(crCh);
		
		ceFac = new JButton("Check Faculty");
		ceFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCr.setVisible(false);
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				facPane.removeAll();
				facPane.updateUI();
				setFac(courses, id);
				displayFac.setVisible(true);
			}
		});
		ceFac.setBounds(236, 206, 199, 23);
		displayCr.add(ceFac);
		
		cePar = new JButton("Check Participants");
		cePar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCr.setVisible(false);
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				parPane.removeAll();
				parPane.updateUI();
				setPar(courses, id);
				displayPar.setVisible(true);
			}
		});
		cePar.setBounds(236, 237, 199, 23);
		displayCr.add(cePar);
		
		delCr = new JButton("Delete Course");
		delCr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				courses.remove(id);
				displayCr.setVisible(false);
				crPane.removeAll();
				crPane.updateUI();
				setCourses(courses);
				display.setVisible(true);
			}
		});
		delCr.setBounds(10, 169, 182, 23);
		displayCr.add(delCr);
		
		addParB = new JButton("Add Participants");
		addParB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCr.setVisible(false);
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				button_5.putClientProperty("id", id);
				if(courses.get(id).students.size()>4)
				{
					mainWin.setVisible(true);
					return;
				}
				addNPar.setVisible(true);
			}
		});
		addParB.setBounds(236, 169, 199, 23);
		displayCr.add(addParB);
		
		displayFac = new JPanel();
		frmStcmIitKgp.getContentPane().add(displayFac, "name_7369928593329");
		displayFac.setLayout(null);
		
		facPane = new JPanel();
		facPane.setBounds(10, 11, 425, 215);		
		facScroll = new JScrollPane(facPane);
		facPane.setLayout(new BoxLayout(facPane, BoxLayout.Y_AXIS));
		facScroll.setBounds(10, 11, 425, 215);
		displayFac.add(facScroll);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFac.setVisible(false);
				facPane.removeAll();
				facPane.updateUI();
				displayCr.setVisible(true);
			}
		});
		btnBack_2.setBounds(10, 237, 112, 23);
		displayFac.add(btnBack_2);
		
		displayPar = new JPanel();
		frmStcmIitKgp.getContentPane().add(displayPar, "name_7391006948230");
		displayPar.setLayout(null);
		

		parPane = new JPanel();
		parPane.setBounds(10, 11, 425, 214);
		parScroll = new JScrollPane(parPane);
		parPane.setLayout(new BoxLayout(parPane, BoxLayout.Y_AXIS));
		parScroll.setBounds(10, 11, 425, 214);
		displayPar.add(parScroll);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPar.setVisible(false);
				parPane.removeAll();
				parPane.updateUI();
				displayCr.setVisible(true);
			}
		});
		btnBack_3.setBounds(10, 237, 126, 23);
		displayPar.add(btnBack_3);
		
		facDetails = new JPanel();
		frmStcmIitKgp.getContentPane().add(facDetails, "name_7658512919527");
		facDetails.setLayout(null);
		
		facDPane = new JTextPane();
		facDPane.setEditable(false);
		facDPane.setBounds(10, 11, 425, 217);
		facDetails.add(facDPane);
		
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facDetails.setVisible(false);
				displayFac.setVisible(true);
			}
		});
		btnBack_4.setBounds(10, 237, 114, 23);
		facDetails.add(btnBack_4);
		
		facEditB = new JButton("Edit");
		facEditB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facDetails.setVisible(false);
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				int id1=(int)button.getClientProperty("id1");
				facEName.setText(courses.get(id).teachers.get(id1).name);
				facEMob.setText(courses.get(id).teachers.get(id1).phone);
				facEMail.setText(courses.get(id).teachers.get(id1).mailId);
				facEDep.setText(courses.get(id).teachers.get(id1).department);
				facEAddr.setText(courses.get(id).teachers.get(id1).address);
				button_9.putClientProperty("id", id);
				button_9.putClientProperty("id1", id1);
				facEdit.setVisible(true);
			}
		});
		facEditB.setBounds(321, 237, 114, 23);
		facDetails.add(facEditB);
		
		facDelete = new JButton("Delete");
		facDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				int id1=(int)button.getClientProperty("id1");
				courses.get(id).teachers.remove(id1);
				courses.get(id).teacher_no--;
				facDetails.setVisible(false);
				facPane.removeAll();
				facPane.updateUI();
				setFac(courses,id);
				display.setVisible(true);
			}
		});
		facDelete.setBounds(159, 239, 128, 23);
		facDetails.add(facDelete);
		
		parDetails = new JPanel();
		frmStcmIitKgp.getContentPane().add(parDetails, "name_7774449135897");
		parDetails.setLayout(null);
		
		parDPane = new JTextPane();
		parDPane.setEditable(false);
		parDPane.setBounds(10, 11, 425, 217);
		parDetails.add(parDPane);
		
		button_4 = new JButton("Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parDetails.setVisible(false);
				displayPar.setVisible(true);
			}
		});
		button_4.setBounds(10, 237, 117, 23);
		parDetails.add(button_4);
		
		parEditB = new JButton("Edit");
		parEditB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parDetails.setVisible(false);
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				int id1=(int)button.getClientProperty("id1");
				parEName.setText(courses.get(id).students.get(id1).name);
				parEMob.setText(courses.get(id).students.get(id1).phone);
				parEMail.setText(courses.get(id).students.get(id1).email);
				parEOrg.setText(courses.get(id).students.get(id1).organisation);
				parEAddr.setText(courses.get(id).students.get(id1).address);
				button_8.putClientProperty("id", id);
				button_8.putClientProperty("id1", id1);
				parEdit.setVisible(true);
			}
		});
		parEditB.setBounds(318, 237, 117, 23);
		parDetails.add(parEditB);
		
		parDelete = new JButton("Delete");
		parDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				int id1=(int)button.getClientProperty("id1");
				courses.get(id).students.remove(id1);
				courses.get(id).student_no--;
				parDetails.setVisible(false);
				parPane.removeAll();
				parPane.updateUI();
				setPar(courses,id);
				display.setVisible(true);
			}
		});
		parDelete.setBounds(156, 237, 132, 23);
		parDetails.add(parDelete);
		
		addNPar = new JPanel();
		frmStcmIitKgp.getContentPane().add(addNPar, "name_16619356976476");
		addNPar.setLayout(null);
		
		JLabel label_1 = new JLabel("ADD PARTICIPANT");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(27, 11, 392, 24);
		addNPar.add(label_1);
		
		JLabel label_2 = new JLabel("Organisation:");
		label_2.setBounds(27, 156, 129, 14);
		addNPar.add(label_2);
		
		JLabel label_7 = new JLabel("Name:");
		label_7.setBounds(27, 46, 129, 14);
		addNPar.add(label_7);
		
		JLabel label_8 = new JLabel("Mobile:");
		label_8.setBounds(27, 82, 129, 14);
		addNPar.add(label_8);
		
		JLabel label_9 = new JLabel("Mail ID:");
		label_9.setBounds(27, 119, 129, 14);
		addNPar.add(label_9);
		
		JLabel label_10 = new JLabel("Address:");
		label_10.setBounds(27, 197, 129, 14);
		addNPar.add(label_10);
		
		addNPName = new JTextField();
		addNPName.setColumns(10);
		addNPName.setBounds(153, 46, 168, 20);
		addNPar.add(addNPName);
		
		addNPMob = new JTextField();
		addNPMob.setColumns(10);
		addNPMob.setBounds(153, 82, 168, 20);
		addNPar.add(addNPMob);
		
		addNPMai = new JTextField();
		addNPMai.setColumns(10);
		addNPMai.setBounds(153, 119, 168, 20);
		addNPar.add(addNPMai);
		
		addNPOrg = new JTextField();
		addNPOrg.setColumns(10);
		addNPOrg.setBounds(153, 156, 168, 20);
		addNPar.add(addNPOrg);
		
		addNPAddr = new JTextField();
		addNPAddr.setColumns(10);
		addNPAddr.setBounds(153, 197, 168, 20);
		addNPar.add(addNPAddr);
		
		button_5 = new JButton("Done");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Participant stu=new Participant();
				stu.name=addNPName.getText();
				stu.phone=addNPMob.getText();
				stu.email=addNPMai.getText();
				stu.organisation=addNPOrg.getText();
				stu.address=addNPAddr.getText();
				addNPName.setText("");
				addNPMob.setText("");
				addNPMai.setText("");
				addNPAddr.setText("");
				addNPOrg.setText("");
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				courses.get(id).students.add(stu);
				courses.get(id).student_no++;
				addNPar.setVisible(false);
				display.setVisible(true);
			}
		});
		button_5.setBounds(330, 228, 89, 23);
		addNPar.add(button_5);
		
		btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNPar.setVisible(false);
				displayCr.setVisible(true);
			}
		});
		btnBack_5.setBounds(27, 228, 96, 23);
		addNPar.add(btnBack_5);
		
		crEdit = new JPanel();
		frmStcmIitKgp.getContentPane().add(crEdit, "name_20817761398318");
		crEdit.setLayout(null);
		
		label_11 = new JLabel("Name:");
		label_11.setBounds(76, 53, 128, 14);
		crEdit.add(label_11);
		
		label_12 = new JLabel("Fee:");
		label_12.setBounds(76, 90, 128, 14);
		crEdit.add(label_12);
		
		label_13 = new JLabel("Date(dd mm yyyy):");
		label_13.setBounds(76, 163, 128, 14);
		crEdit.add(label_13);
		
		label_14 = new JLabel("Duration:");
		label_14.setBounds(76, 125, 128, 14);
		crEdit.add(label_14);
		
		lblEditCourse = new JLabel("Edit Course");
		lblEditCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditCourse.setBounds(10, 11, 414, 20);
		crEdit.add(lblEditCourse);
		
		crEName = new JTextField();
		crEName.setColumns(10);
		crEName.setBounds(225, 50, 128, 20);
		crEdit.add(crEName);
		
		crEFee = new JTextField();
		crEFee.setColumns(10);
		crEFee.setBounds(225, 87, 128, 20);
		crEdit.add(crEFee);
		
		crEDur = new JTextField();
		crEDur.setColumns(10);
		crEDur.setBounds(225, 122, 128, 20);
		crEdit.add(crEDur);
		
		crEDOB = new JTextField();
		crEDOB.setColumns(10);
		crEDOB.setBounds(225, 160, 128, 20);
		crEdit.add(crEDOB);
		
		button_6 = new JButton("back");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crEdit.setVisible(false);
				displayCr.setVisible(true);
			}
		});
		button_6.setBounds(32, 215, 79, 23);
		crEdit.add(button_6);
		
		button_7 = new JButton("Done");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				courses.get(id).name=crEName.getText();
				String date[]=new String[3];
				date=crEDOB.getText().split(" ");
				courses.get(id).startDate=LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), 
						Integer.parseInt(date[0]));
				courses.get(id).fee=Integer.parseInt(crEFee.getText());
				courses.get(id).duration=Integer.parseInt(crEDur.getText());
				crPane.removeAll();
				crPane.updateUI();
				setCourses(courses);
				crEdit.setVisible(false);
				display.setVisible(true);
			}
		});
		button_7.setBounds(318, 215, 89, 23);
		crEdit.add(button_7);
		
		facEdit = new JPanel();
		facEdit.setLayout(null);
		frmStcmIitKgp.getContentPane().add(facEdit, "name_22642299650578");
		
		lblChangeFacultyDetails = new JLabel("Change Faculty Details");
		lblChangeFacultyDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeFacultyDetails.setBounds(22, 11, 392, 24);
		facEdit.add(lblChangeFacultyDetails);
		
		lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(22, 159, 129, 14);
		facEdit.add(lblDepartment);
		
		label_24 = new JLabel("Name:");
		label_24.setBounds(22, 49, 129, 14);
		facEdit.add(label_24);
		
		label_25 = new JLabel("Mobile:");
		label_25.setBounds(22, 85, 129, 14);
		facEdit.add(label_25);
		
		label_26 = new JLabel("Mail ID:");
		label_26.setBounds(22, 122, 129, 14);
		facEdit.add(label_26);
		
		label_27 = new JLabel("Address:");
		label_27.setBounds(22, 200, 129, 14);
		facEdit.add(label_27);
		
		facEName = new JTextField();
		facEName.setColumns(10);
		facEName.setBounds(169, 46, 168, 20);
		facEdit.add(facEName);
		
		facEMob = new JTextField();
		facEMob.setColumns(10);
		facEMob.setBounds(169, 82, 168, 20);
		facEdit.add(facEMob);
		
		facEMail = new JTextField();
		facEMail.setColumns(10);
		facEMail.setBounds(169, 119, 168, 20);
		facEdit.add(facEMail);
		
		facEDep = new JTextField();
		facEDep.setColumns(10);
		facEDep.setBounds(169, 156, 168, 20);
		facEdit.add(facEDep);
		
		facEAddr = new JTextField();
		facEAddr.setColumns(10);
		facEAddr.setBounds(169, 197, 168, 20);
		facEdit.add(facEAddr);
		
		button_9 = new JButton("Done");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				int id1=(int)button.getClientProperty("id1");
				courses.get(id).teachers.get(id1).name=facEName.getText();
				courses.get(id).teachers.get(id1).phone=facEMob.getText();
				courses.get(id).teachers.get(id1).mailId=facEMail.getText();
				courses.get(id).teachers.get(id1).department=facEDep.getText();
				courses.get(id).teachers.get(id1).address=facEAddr.getText();
				facEdit.setVisible(false);
				display.setVisible(true);
			}
		});
		button_9.setBounds(325, 228, 89, 23);
		facEdit.add(button_9);
		
		button_10 = new JButton("Back");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facEdit.setVisible(false);
				facDetails.setVisible(true);
			}
		});
		button_10.setBounds(22, 228, 104, 23);
		facEdit.add(button_10);
		
		parEdit = new JPanel();
		frmStcmIitKgp.getContentPane().add(parEdit, "name_20889257631486");
		parEdit.setLayout(null);
		
		lblChangeParticipantDetails = new JLabel("Change Participant Details");
		lblChangeParticipantDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeParticipantDetails.setBounds(22, 11, 392, 31);
		parEdit.add(lblChangeParticipantDetails);
		
		label_17 = new JLabel("Organisation:");
		label_17.setBounds(22, 159, 129, 14);
		parEdit.add(label_17);
		
		label_18 = new JLabel("Name:");
		label_18.setBounds(22, 49, 129, 14);
		parEdit.add(label_18);
		
		label_19 = new JLabel("Mobile:");
		label_19.setBounds(22, 85, 129, 14);
		parEdit.add(label_19);
		
		label_20 = new JLabel("Mail ID:");
		label_20.setBounds(22, 122, 129, 14);
		parEdit.add(label_20);
		
		label_21 = new JLabel("Address:");
		label_21.setBounds(22, 200, 129, 14);
		parEdit.add(label_21);
		
		parEName = new JTextField();
		parEName.setColumns(10);
		parEName.setBounds(169, 46, 168, 20);
		parEdit.add(parEName);
		
		parEMob = new JTextField();
		parEMob.setColumns(10);
		parEMob.setBounds(169, 82, 168, 20);
		parEdit.add(parEMob);
		
		parEMail = new JTextField();
		parEMail.setColumns(10);
		parEMail.setBounds(169, 119, 168, 20);
		parEdit.add(parEMail);
		
		parEOrg = new JTextField();
		parEOrg.setColumns(10);
		parEOrg.setBounds(169, 156, 168, 20);
		parEdit.add(parEOrg);
		
		parEAddr = new JTextField();
		parEAddr.setColumns(10);
		parEAddr.setBounds(169, 197, 168, 20);
		parEdit.add(parEAddr);
		
		button_8 = new JButton("Done");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button=(JButton)e.getSource();
				int id=(int)button.getClientProperty("id");
				int id1=(int)button.getClientProperty("id1");
				courses.get(id).students.get(id1).name=parEName.getText();
				courses.get(id).students.get(id1).phone=parEMob.getText();
				courses.get(id).students.get(id1).email=parEMail.getText();
				courses.get(id).students.get(id1).organisation=parEOrg.getText();
				courses.get(id).students.get(id1).address=parEAddr.getText();
				parEdit.setVisible(false);
				display.setVisible(true);
			}
		});
		button_8.setBounds(346, 228, 89, 23);
		parEdit.add(button_8);
		
		btnBack_6 = new JButton("Back");
		btnBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parEdit.setVisible(false);
				parDetails.setVisible(true);
			}
		});
		btnBack_6.setBounds(22, 228, 104, 23);
		parEdit.add(btnBack_6);
	}
}
