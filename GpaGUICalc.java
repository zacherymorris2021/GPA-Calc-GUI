/** 
 * Homework 5 - GPA Calculator
 * Zachery Morris - ztm4qv
 * Resources: inclass coding examples, 
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html,
 * https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html,
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class GpaGUICalc {

	/**
	 * Swing components as fields 
	 */
	private JFrame frame;
	private JTextField enterCourseName;
	private JTextField enterGrade;
	private JTextField enterHours;
	private JTextField enterOneCourse;
	private JTextField enterTargetGpa;
	private ArrayList<Course> allCourses = new ArrayList<Course>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GpaGUICalc window = new GpaGUICalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GpaGUICalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Make the input, remove, course list, 
	 * and summary panel and their respective contents.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("GPA Calculator");
		frame.setBounds(600, 600, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// setup up for input section of calculator
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		inputPanel.setBounds(10, 11, 322, 170);
		frame.getContentPane().add(inputPanel);
		inputPanel.setLayout(null);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setFont(new Font("Arial", Font.BOLD, 12));
		lblInput.setBounds(144, 0, 49, 14);
		inputPanel.add(lblInput);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourse.setBounds(140, 19, 100, 14);
		inputPanel.add(lblCourse);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(10, 44, 124, 14);
		inputPanel.add(lblCourseName);
		
		JLabel lblGourseGradeAs = new JLabel("Grade as a Decimal (ie A = 4.0):");
		lblGourseGradeAs.setBounds(10, 71, 183, 14);
		inputPanel.add(lblGourseGradeAs);
		
		JLabel lblCreditHours = new JLabel("Credit Hours:");
		lblCreditHours.setBounds(10, 96, 124, 14);
		inputPanel.add(lblCreditHours);
		
		enterCourseName = new JTextField();
		enterCourseName.setBounds(144, 41, 96, 20);
		inputPanel.add(enterCourseName);
		enterCourseName.setColumns(10);
		
		enterGrade = new JTextField();
		enterGrade.setBounds(203, 68, 96, 20);
		inputPanel.add(enterGrade);
		enterGrade.setColumns(10);
		
		enterHours = new JTextField();
		enterHours.setBounds(160, 96, 96, 20);
		inputPanel.add(enterHours);
		enterHours.setColumns(10);
		
		// setup for displaying courses section of calculator
		JPanel courseListPanel = new JPanel();
		courseListPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		courseListPanel.setBounds(10, 207, 666, 170);
		frame.getContentPane().add(courseListPanel);
		courseListPanel.setLayout(new GridLayout(10,1));
		
		JLabel lblCourseList = new JLabel("Course List");
		lblCourseList.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseList.setFont(new Font("Arial", Font.BOLD, 12));
		courseListPanel.add(lblCourseList);
		
		// setup for removing courses section of calculator
		JPanel removePanel = new JPanel();
		removePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		removePanel.setBounds(342, 11, 334, 171);
		frame.getContentPane().add(removePanel);
		removePanel.setLayout(null);
		
		JLabel lblRemove = new JLabel("Remove");
		lblRemove.setFont(new Font("Arial", Font.BOLD, 12));
		lblRemove.setBounds(140, 0, 56, 14);
		removePanel.add(lblRemove);
		
		JLabel lblCorseNameTo = new JLabel("Course Name to Remove:");
		lblCorseNameTo.setBounds(10, 28, 214, 14);
		removePanel.add(lblCorseNameTo);
		
		enterOneCourse = new JTextField();
		enterOneCourse.setBounds(228, 25, 96, 20);
		removePanel.add(enterOneCourse);
		enterOneCourse.setColumns(10);
		
		JLabel lblRemoveAllCourses = new JLabel("Click Button Below to Remove All Courses:");
		lblRemoveAllCourses.setBounds(10, 101, 314, 14);
		removePanel.add(lblRemoveAllCourses);
		
		// setup for summary section of calculator 
		JPanel summaryPanel = new JPanel();
		summaryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		summaryPanel.setBounds(10, 387, 666, 115);
		frame.getContentPane().add(summaryPanel);
		summaryPanel.setLayout(null);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Arial", Font.BOLD, 12));
		lblSummary.setBounds(302, 0, 57, 14);
		summaryPanel.add(lblSummary);
		
		JLabel lblCurrentGpa = new JLabel("Current GPA:");
		lblCurrentGpa.setBounds(10, 49, 108, 14);
		summaryPanel.add(lblCurrentGpa);
		
		JLabel lblTargetGpa = new JLabel("Target GPA:");
		lblTargetGpa.setBounds(251, 21, 108, 14);
		summaryPanel.add(lblTargetGpa);
		
		JLabel lblRequiredGpa = new JLabel("Required GPA:");
		lblRequiredGpa.setBounds(251, 52, 133, 14);
		summaryPanel.add(lblRequiredGpa);
		
		JLabel lblWarnings = new JLabel("Warnings:");
		lblWarnings.setBounds(251, 81, 133, 14);
		summaryPanel.add(lblWarnings);
		
		enterTargetGpa = new JTextField();
		enterTargetGpa.setColumns(10);
		enterTargetGpa.setBounds(411, 18, 96, 20);
		summaryPanel.add(enterTargetGpa);
		
		JLabel lblCurrgpa = new JLabel("...");
		lblCurrgpa.setBounds(137, 49, 49, 14);
		summaryPanel.add(lblCurrgpa);
		
		JLabel lblReqgpa = new JLabel("...");
		lblReqgpa.setHorizontalAlignment(SwingConstants.CENTER);
		lblReqgpa.setBounds(326, 52, 268, 14);
		summaryPanel.add(lblReqgpa);
		
		JLabel lblWarnings_1 = new JLabel("...");
		lblWarnings_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarnings_1.setBounds(309, 81, 302, 14);
		summaryPanel.add(lblWarnings_1);
	
		// course contents input button
		JButton inputButton = new JButton("Add to List");
		inputButton.setBounds(103, 121, 114, 23);
		inputPanel.add(inputButton);
		inputButton.setActionCommand("click");
		inputButton.addActionListener(new ActionListener()
		{
			/**
			 * Action listener for input button in input panel.
			 * When user enters course information, gets displayed on course list panel.
			 * If user doesn't enter a course's name, default name is N/A.
			 * Calculates and updates current GPA when adding a new course.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getActionCommand().equals("click")) {
					int creditHours = 0;
					double grade = 0.0;
					String courseName = "";
					
					if(enterGrade.getText().equals("")) {
						grade = 0.0;
					}
					else {
						grade = (double) Double.parseDouble(enterGrade.getText());
					}
					
					// sets course name to N/A if user doesn't enter course's name
					if(enterCourseName.getText().equals("")) {
						courseName = "N/A";
					}
					else {
						courseName = enterCourseName.getText();
					}
					
					creditHours = (int) Integer.parseInt(enterHours.getText());
					
					Course course1 = new Course(creditHours, grade, courseName);
					allCourses.add(course1);
					
					courseListPanel.removeAll(); // remove all contents from panel, get rid of duplicates
					courseListPanel.add(lblCourseList); // add heading back after removing all contents
					
					for(Course c : allCourses) {
						JLabel addit = new JLabel("Course: " + c.getCourseName() + "  Grade: " + c.getGrade() + "  Credit Hours: " + c.getCreditHours());
						courseListPanel.add(addit);
					}
					
					// update display of course list panel
					courseListPanel.revalidate();
					courseListPanel.repaint();
					
					// calculate gpa when adding new courses
					double gpa = 0.0;
					int ch = 0;
					double g = 0.0;
					double weight = 0.0;
					for(Course c : allCourses) {
						if (c.getGrade() != 0.0){
							ch += c.getCreditHours();
							weight += c.getGrade() * c.getCreditHours();
						}
					}
					gpa = ((weight) / (ch));
					String gpaStr = Double.toString(gpa);
					lblCurrgpa.setText(gpaStr);
		}
		}
		}
		);

		// remove button for 1 class
		JButton removeOneButton = new JButton("Submit");
		removeOneButton.setBounds(132, 54, 89, 23);
		removePanel.add(removeOneButton);
		removeOneButton.setActionCommand("click");
		removeOneButton.addActionListener(new ActionListener()
		{
			/**
			 * Action listener for remove one class button in remove panel.
			 * Removes course from display when user inputs course name.
			 * Displays updated ArrayList of courses without the course that was entered.
			 * Updates current gpa when removing a course.
			 * Assumptions/Rules: 
			 * Enter N/A if your course doesn't have a name. 
			 * If two courses have same name, when click button will remove the last entered course 
			 * (must click again to remove the course with the same name).
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getActionCommand().equals("click")) {
					
					// removes course from display when user inputs course name
					String courseNameEntered = enterOneCourse.getText();
					for(Course i: allCourses) {
						if((i).getCourseName().equals(courseNameEntered)) {
							allCourses.remove(i);
							break; // break because concurrency error
						}
					}
					courseListPanel.removeAll();
					courseListPanel.add(lblCourseList);
					
					// display updated ArrayList of courses
					for(Course w : allCourses) {
						JLabel addit2 = new JLabel("Course: " + w.getCourseName() + "  Grade: " + w.getGrade() + "  Credit Hours: " + w.getCreditHours());
						courseListPanel.add(addit2);
					}
					
					// update course list panel
					courseListPanel.revalidate();
					courseListPanel.repaint();
					
					// calculate gpa -- to update gpa after removing a course
					double gpa = 0.0;
					int ch = 0;
					double g = 0.0;
					double weight = 0.0;
					for(Course c : allCourses) {
						if (c.getGrade() != 0.0){
							ch += c.getCreditHours();
							weight += c.getGrade() * c.getCreditHours();
						}
					}
					gpa = ((weight) / (ch));
					String gpaStr = Double.toString(gpa);
					lblCurrgpa.setText(gpaStr);
					summaryPanel.revalidate();
					summaryPanel.repaint();	
		}	
		}
		}
		);
		
		// remove all courses button
		JButton removeAllButton = new JButton("Submit");
		removeAllButton.setBounds(132, 126, 89, 23);
		removePanel.add(removeAllButton);
		removeAllButton.setActionCommand("click");
		removeAllButton.addActionListener(new ActionListener()
		{
			/**
			 * Action listener for remove all courses button in remove panel.
			 * Clears all Course objects from the ArrayList.
			 * Updates current gpa to "..."
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getActionCommand().equals("click")) {
					
					allCourses.clear();
					courseListPanel.removeAll();
					courseListPanel.add(lblCourseList);
					
					// update course list panel
					courseListPanel.revalidate();
					courseListPanel.repaint();
					
					// update gpa to nothing since there are no courses
					lblCurrgpa.setText("...");
					summaryPanel.revalidate();
					summaryPanel.repaint();
		}
		}
		}
		);
		
		// target gpa calculation 
		// if you add course must click target gpa button again to update it 
		JButton calcReqGpaButton = new JButton("Submit");
		calcReqGpaButton.setBounds(551, 17, 89, 23);
		summaryPanel.add(calcReqGpaButton);
		calcReqGpaButton.setActionCommand("click");
		calcReqGpaButton.addActionListener(new ActionListener()
		{
			/**
			 * Action listener for target gpa button in summary panel.
			 * Calculates required gpa based on courses entered.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getActionCommand().equals("click")) {
					String wantedGpa = enterTargetGpa.getText();
					double wGpaStr = Double.parseDouble(wantedGpa);
					double mult = 0.0;
					double credHr = 0.0;
					double loadUnknown = 0.0;
					double requiredGpa = 0.0;
					
					// if user enters a grade calculate components of required gpa formula
					for(Course c : allCourses) {
						if(c.getGrade() != 0.0) {
							mult += (c.getGrade() * c.getCreditHours());
							credHr += c.getCreditHours();
						}
						// if user does not enter grade get the credit hours of course
						else {
							loadUnknown += c.getCreditHours();
						}
					}
					
					// required gpa formaula 
					requiredGpa = (((wGpaStr*(loadUnknown + credHr))-mult)/loadUnknown); 
					String tarGpaStr = Double.toString(requiredGpa);
					lblReqgpa.setText(tarGpaStr);	
					
					// warnings for required gpa
					if(requiredGpa > 4.0) {
						lblWarnings_1.setText("GPA is above 4.0, maybe add more courses");
					}
					else if(requiredGpa < 2.0) {
						lblWarnings_1.setText("GPA is below 2.0, maybe reduce your course load");
					}
					else {
						lblWarnings_1.setText("...");
					}
					
					courseListPanel.revalidate();
					courseListPanel.repaint();
		}
		}
		}
		);
	}
}
