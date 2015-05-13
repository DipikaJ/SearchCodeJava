import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class SwingSearchApp extends JFrame implements ActionListener {
 
	//Initializing Components
    JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7 ,lb8;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7 ,tf8;
    JButton btn;
 
		//Creating Constructor for initializing JFrame components
		SwingSearchApp() {
        //Providing Title
        super("Fetching Student Information");
        lb5 = new JLabel("Enter Name:");
        lb5.setBounds(20, 20, 100, 20);
        tf5 = new JTextField(20);
        tf5.setBounds(130, 20, 200, 20);
 
        btn = new JButton("Submit");
        btn.setBounds(50, 50, 100, 20);
        btn.addActionListener(this);
 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
 
        lb1 = new JLabel("User Detail ID :");
        lb1.setBounds(20, 120, 100, 20);
        tf1 = new JTextField(50);
        tf1.setBounds(130, 120, 200, 20);
		
        lb2 = new JLabel("Mobile :");
        lb2.setBounds(20, 150, 100, 20);
        tf2 = new JTextField(100);
        tf2.setBounds(130, 150, 200, 20);
		
        lb3 = new JLabel("Address :");
        lb3.setBounds(20, 180, 100, 20);
        tf3 = new JTextField(50);
        tf3.setBounds(130, 180, 200, 20);
		
        lb4 = new JLabel("City :");
        lb4.setBounds(20, 210, 100, 20);
        tf4 = new JTextField(50);
        tf4.setBounds(130, 210, 200, 20);
		
	lb6 = new JLabel("Zip :");
        lb6.setBounds(20, 240, 100, 20);
        tf6 = new JTextField(50);
        tf6.setBounds(130, 240, 200, 20);
		
	lb7 = new JLabel("User Id :");
        lb7.setBounds(20, 270, 100, 20);
        tf7 = new JTextField(50);
        tf7.setBounds(130, 270, 200, 20);
		
	lb8 = new JLabel("User Name:");
        lb8.setBounds(20, 300, 100, 20);
        tf8 = new JTextField(50);
        tf8.setBounds(130, 300, 200, 20);
		
        setLayout(null);
 
        //Add components to the JFrame
        add(lb5);
        add(tf5);
        add(btn);
 
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);
        add(lb4);
        add(tf4);
	add(lb6);
        add(tf6);
	add(lb7);
        add(tf7);
	add(lb8);
        add(tf8);
 
        //Set TextField Editable False
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
	tf6.setEditable(false);
	tf7.setEditable(false);
	tf8.setEditable(false);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Create DataBase Coonection and Fetching Records
 
        try {
            String str = tf5.getText();
			
            String dbURL = "jdbc:mysql://172.27.59.54:3306/ecomm";
            String username ="ecomm";
            String password = "ecomm@123";
		
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(dbURL,username,password);
            PreparedStatement st = con.prepareStatement("select * from user_details where user_name=?");
            st.setString(1, str);
 
            //Excuting Query
            ResultSet rs = st.executeQuery();
 
            if (rs.next()) {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                String s3 = rs.getString(3);
                String s4 = rs.getString(4);
		String s5 = rs.getString(5);
		String s6 = rs.getString(6);
		String s7 = rs.getString(7);
 
                //Sets Records in TextFields.
                tf1.setText(s1);
                tf2.setText(s2);
                tf3.setText(s3);
		tf4.setText(s4);
		tf6.setText(s5);
		tf7.setText(s6);
		tf8.setText(s7);
            } else {
                JOptionPane.showMessageDialog(null, "Name not Found");
            }
 
            //Create Exception Handler
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
 
            System.out.println(ex);
        }
    }
//Running Constructor
 
    public static void main(String args[]) {
        new SwingSearchApp();
    }
} 