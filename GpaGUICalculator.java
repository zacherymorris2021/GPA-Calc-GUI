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

public class GpaGUICalculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_12;
	private JTextField textField_9;
	
	private ArrayList<Course> allCourses = new ArrayList<Course>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GpaGUICalculator window = new GpaGUICalculator();
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
	public GpaGUICalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("GPA Calculator");
		frame.setBounds(600, 600, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 322, 170);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setFont(new Font("Arial", Font.BOLD, 12));
		lblInput.setBounds(144, 0, 49, 14);
		panel.add(lblInput);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourse.setBounds(140, 19, 100, 14);
		panel.add(lblCourse);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(10, 44, 124, 14);
		panel.add(lblCourseName);
		
		JLabel lblGourseGradeAs = new JLabel("Gourse Grade as a Decimal:");
		lblGourseGradeAs.setBounds(10, 71, 183, 14);
		panel.add(lblGourseGradeAs);
		
		JLabel lblCreditHours = new JLabel("Credit Hours:");
		lblCreditHours.setBounds(10, 96, 124, 14);
		panel.add(lblCreditHours);
		
		textField = new JTextField();
		textField.setBounds(144, 41, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 68, 96, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 96, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 207, 666, 170);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCourseList = new JLabel("Course List");
		lblCourseList.setFont(new Font("Arial", Font.BOLD, 12));
		lblCourseList.setBounds(297, 0, 78, 14);
		panel_1.add(lblCourseList);
		
		//textField_12 = new JTextField();
		//textField_12.setBounds(44, 34, 565, 108);
		//panel_1.add(textField_12);
		//textField_12.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(342, 11, 334, 171);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblRemove = new JLabel("Remove");
		lblRemove.setFont(new Font("Arial", Font.BOLD, 12));
		lblRemove.setBounds(140, 0, 56, 14);
		panel_2.add(lblRemove);
		
		JLabel lblCorseNameTo = new JLabel("Course Name to Remove:");
		lblCorseNameTo.setBounds(10, 28, 214, 14);
		panel_2.add(lblCorseNameTo);
		
		textField_7 = new JTextField();
		textField_7.setBounds(228, 25, 96, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(132, 54, 89, 23);
		panel_2.add(btnSubmit);
		
		JLabel lblRemoveAllCourses = new JLabel("Click Button Below to Remove All Courses:");
		lblRemoveAllCourses.setBounds(10, 101, 314, 14);
		panel_2.add(lblRemoveAllCourses);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setBounds(132, 126, 89, 23);
		panel_2.add(btnSubmit_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 387, 666, 115);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Arial", Font.BOLD, 12));
		lblSummary.setBounds(226, 0, 57, 14);
		panel_3.add(lblSummary);
		
		JLabel lblCurrentGpa = new JLabel("Current GPA:");
		lblCurrentGpa.setBounds(10, 49, 108, 14);
		panel_3.add(lblCurrentGpa);
		
		JLabel lblTargetGpa = new JLabel("Target GPA:");
		lblTargetGpa.setBounds(251, 21, 108, 14);
		panel_3.add(lblTargetGpa);
		
		JLabel lblRequiredGpa = new JLabel("Required GPA:");
		lblRequiredGpa.setBounds(251, 52, 133, 14);
		panel_3.add(lblRequiredGpa);
		
		JLabel lblWarnings = new JLabel("Warnings:");
		lblWarnings.setBounds(251, 81, 133, 14);
		panel_3.add(lblWarnings);
		
		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.setBounds(551, 17, 89, 23);
		panel_3.add(btnSubmit_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(411, 18, 96, 20);
		panel_3.add(textField_9);
		
		JLabel lblCurrgpa = new JLabel("currgpa");
		lblCurrgpa.setBounds(137, 49, 49, 14);
		panel_3.add(lblCurrgpa);
		
		JLabel lblReqgpa = new JLabel("reqgpa");
		lblReqgpa.setBounds(434, 49, 49, 14);
		panel_3.add(lblReqgpa);
		
		JLabel lblWarnings_1 = new JLabel("warnings");
		lblWarnings_1.setBounds(434, 81, 49, 14);
		panel_3.add(lblWarnings_1);
	
		// course input button
		JButton btnAddToList = new JButton("Add to List");
		btnAddToList.setBounds(103, 121, 114, 23);
		panel.add(btnAddToList);
		btnAddToList.setActionCommand("click");
		btnAddToList.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getActionCommand().equals("click")) {
					int creditHours = 0;
					double grade = 0.0;
					String courseName = "";
					
					if(textField.getText().equals("")) {
						courseName = "";
					}
					
					if(textField_1.getText().equals("")) {
						grade = 0.0;
					}
					
					courseName = textField.getText();
					creditHours = (int) Integer.parseInt(textField_2.getText());
					grade = (double) Double.parseDouble(textField_1.getText());
					
					Course course1 = new Course(creditHours, grade, courseName);
					allCourses.add(course1);
					
					for(Course c : allCourses) {
						JLabel addit = new JLabel("Course:" + c.getCourseName() + "Grade: " + c.getGrade() + "Credit Hours: " + c.getCreditHours());
						panel_1.add(addit);
					}
					panel_1.revalidate();
					panel_1.repaint();
				}
				}
				}
				);

		}
	}
