import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class Update {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;


	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
 
	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/employeedata", "root","");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	        	   ex.printStackTrace();
	        }
 
	    }
	
	public static void Updatee() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Update() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 563, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 36, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth*");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfBirth.setBounds(10, 58, 95, 21);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblCurrentSalary = new JLabel("Current Salary*");
		lblCurrentSalary.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentSalary.setBounds(10, 106, 113, 21);
		frame.getContentPane().add(lblCurrentSalary);
		
		JLabel lblExitDate = new JLabel("Exit Date");
		lblExitDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExitDate.setBounds(10, 152, 95, 21);
		frame.getContentPane().add(lblExitDate);
		
		JLabel lblManagerName = new JLabel("Manager Name*");
		lblManagerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblManagerName.setBounds(10, 206, 113, 21);
		frame.getContentPane().add(lblManagerName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(117, 12, 118, 20);
		frame.getContentPane().add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 107, 118, 20);
		frame.getContentPane().add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(117, 207, 118, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblEmployeeName = new JLabel("Employee name*");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmployeeName.setBounds(276, 15, 113, 21);
		frame.getContentPane().add(lblEmployeeName);
		
		JLabel lblJoiningDate = new JLabel("Joining Date*");
		lblJoiningDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJoiningDate.setBounds(278, 84, 95, 21);
		frame.getContentPane().add(lblJoiningDate);
		
		JLabel lblManagerDesignation = new JLabel("Manager Designation");
		lblManagerDesignation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblManagerDesignation.setBounds(260, 152, 144, 21);
		frame.getContentPane().add(lblManagerDesignation);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(158, 267, 95, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(297, 267, 95, 35);
		frame.getContentPane().add(btnCancel);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(403, 16, 118, 20);
		frame.getContentPane().add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(403, 153, 118, 20);
		frame.getContentPane().add(textField_7);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(117, 59, 118, 20);
		frame.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(117, 153, 118, 20);
		frame.getContentPane().add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(403, 85, 118, 20);
		frame.getContentPane().add(dateChooser_2);
	}
}
