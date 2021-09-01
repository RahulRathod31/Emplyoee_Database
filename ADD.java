import java.awt.EventQueue;



import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class ADD {

	private JFrame frame;
	private JTextField txtid;
	private JTextField textsal;
	private JTextField txtmname;
	private JTextField txtemp;
	private JTextField txtdesignation;
	private JButton btnNewButton;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 * 
	 * 
	 */
	
	
	
	
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
	 
	 
	 
	 
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADD window = new ADD();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ADD() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 36, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth*");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfBirth.setBounds(10, 53, 95, 21);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblCurrentSalary = new JLabel("Current Salary*");
		lblCurrentSalary.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentSalary.setBounds(10, 99, 113, 21);
		frame.getContentPane().add(lblCurrentSalary);
		
		JLabel lblExitDate = new JLabel("Exit Date");
		lblExitDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExitDate.setBounds(10, 141, 95, 21);
		frame.getContentPane().add(lblExitDate);
		
		JLabel lblManagerName = new JLabel("Manager Name*");
		lblManagerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblManagerName.setBounds(10, 192, 113, 21);
		frame.getContentPane().add(lblManagerName);
		
		txtid = new JTextField();
		txtid.setBounds(138, 12, 118, 20);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		textsal = new JTextField();
		textsal.setColumns(10);
		textsal.setBounds(138, 100, 118, 20);
		frame.getContentPane().add(textsal);
		
		txtmname = new JTextField();
		txtmname.setColumns(10);
		txtmname.setBounds(138, 193, 118, 20);
		frame.getContentPane().add(txtmname);
		
		JLabel lblEmployeeName = new JLabel("Employee name*");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmployeeName.setBounds(302, 15, 113, 21);
		frame.getContentPane().add(lblEmployeeName);
		
		JLabel lblJoiningDate = new JLabel("Joining Date*");
		lblJoiningDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJoiningDate.setBounds(296, 99, 95, 21);
		frame.getContentPane().add(lblJoiningDate);
		
		JLabel lblManagerDesignation = new JLabel("Manager Designation");
		lblManagerDesignation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblManagerDesignation.setBounds(282, 192, 144, 21);
		frame.getContentPane().add(lblManagerDesignation);
		
		txtemp = new JTextField();
		txtemp.setColumns(10);
		txtemp.setBounds(447, 16, 118, 20);
		frame.getContentPane().add(txtemp);
		
		txtdesignation = new JTextField();
		txtdesignation.setColumns(10);
		txtdesignation.setBounds(447, 193, 118, 20);
		frame.getContentPane().add(txtdesignation);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String ename,man,des;
				
				ename= txtemp.getText();
				
				man=txtmname.getText();
				des=txtdesignation.getText();
				
				

				
				 try {
						pst = con.prepareStatement("insert into employee(EmployeeName,DateofBirth,JoiningDate,Manager,ExitDate,Designation)values(?,?,?,?,?,?)");
						pst.setString(1, ename);
						pst.setString(4, man);
						pst.setString(6, des);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						pst.executeUpdate();
						
							           
						txtemp.setText("");
						txtmname.setText("");
						txtdesignation.setText("");
						txtemp.requestFocus();
					   }
				 
					catch (SQLException e1) 
				        {
										
					e1.printStackTrace();
					}
				
			}
		});
		btnNewButton.setBounds(156, 253, 95, 35);
		frame.getContentPane().add(btnNewButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(369, 253, 95, 35);
		frame.getContentPane().add(btnCancel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(138, 53, 118, 20);
		frame.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(138, 141, 118, 20);
		frame.getContentPane().add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(447, 100, 118, 20);
		frame.getContentPane().add(dateChooser_2);
	}
}
