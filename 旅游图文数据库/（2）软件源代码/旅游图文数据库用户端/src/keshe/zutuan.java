package keshe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class zutuan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static zutuan frame = new zutuan();
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public zutuan() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7EC4\u56E2\u4FE1\u606F\u586B\u62A5\u9875\u9762");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(26, 27, 254, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BA1\u5212\u65F6\u95F4\uFF1A");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(91, 105, 126, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(91, 171, 126, 29);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = textField.getText();
				String phonenumber = textField_1.getText();
				int i;
				if(rdbtnNewRadioButton.isSelected()) 
					i=0;
				else
					i=1;
				String username = denglu.username;
				String place = xuanze.jd;
				try {  
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Success loading Mysql Driver!");  
				}
				catch (Exception e1) {  
					System.out.print("Error loading Mysql Driver!");  
					e1.printStackTrace();  
				}  
				try{  
					Connection connect = DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
					System.out.println("Success connect Mysql server!");
					Statement stmt1 = connect.createStatement();  
				
							String sql = "INSERT INTO zutuanxinxi(username,phonenumber,place,date,mesg) VALUES('"+username+"','"+phonenumber+"','"+place+"','"+date+"','"+i+"')";  
			                int result = stmt1.executeUpdate(sql);  
			                if(result!=-1) {
			                	JOptionPane.showMessageDialog(null, "报名成功", "", JOptionPane.INFORMATION_MESSAGE);                       //1注册成功
			                }

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton.setBounds(117, 312, 113, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				show1.open();
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(318, 312, 113, 35);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(205, 105, 261, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 171, 261, 29);
		contentPane.add(textField_1);
		
		rdbtnNewRadioButton = new JRadioButton("\u77ED\u4FE1\u901A\u77E5");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("楷体", Font.PLAIN, 24));
		rdbtnNewRadioButton.setBounds(205, 207, 152, 35);
		contentPane.add(rdbtnNewRadioButton);
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
}
