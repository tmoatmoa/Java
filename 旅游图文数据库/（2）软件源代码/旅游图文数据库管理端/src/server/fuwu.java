package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class fuwu extends JFrame {

	private JPanel contentPane;
	static fuwu frame = new fuwu();
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;

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
	public fuwu() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(denglu.class.getResource("/server/软件图标.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u589E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = textField_1.getText();
				if(username!=null&&password!=null) {
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
					ResultSet rs1 = stmt1.executeQuery("select * from user");
					int judge = 0;
					while (rs1.next()) {                          
						if(rs1.getString("username").equals(username)) {
							JOptionPane.showMessageDialog(null, "该用户名已被使用", "error", JOptionPane.ERROR_MESSAGE);
							judge++;
								break;
						}
					}
					if(judge==0) {
						String sql = "INSERT INTO user(username,password) VALUES('"+username+"','"+password+"')";  
					
		                int result = stmt1.executeUpdate(sql);  
		                if(result!=-1) {
		                	JOptionPane.showMessageDialog(null, "注册成功", "", JOptionPane.INFORMATION_MESSAGE);                       //1注册成功
		                }
					}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
				textField.setText(null);
				textField_1.setText(null);
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名密码不得为空", "error", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton.setBounds(54, 325, 59, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
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
					
					String sql = "delete from user where username = '"+username+"'";  
					
	                int result = stmt1.executeUpdate(sql);  
	                if(result!=-1) {
	                	JOptionPane.showMessageDialog(null, "删除成功", "", JOptionPane.INFORMATION_MESSAGE);                
	                }
	                else
	                	JOptionPane.showMessageDialog(null, "数据库中没有该用户", "", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(181, 325, 59, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u67E5");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				try{  
					Connection connect = DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
					System.out.println("Success connect Mysql server!");
					Statement stmt = connect.createStatement();  
					ResultSet rs = stmt.executeQuery("select * from user");
					String aa="编  号 "+"\t"+"用户名 "+"\t"+"密  码 "+"\t\n";
					textArea.append(aa);
				    while (rs.next()) {  
					String s=rs.getString("id")+" \t"+rs.getString("username")+" \t"+rs.getString("password")+" \t\n";
					textArea.append(s);
			}
				}catch (Exception e1) {
				e1.printStackTrace();
			}
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_2.setBounds(313, 325, 59, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u6539");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = textField_1.getText();
				if(username!=null&&password!=null) {
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
					ResultSet rs1 = stmt1.executeQuery("select * from user");
					
				
							String sql = "update user set password = '"+password+"'where username = '"+username+"'";  
							
			                int result = stmt1.executeUpdate(sql);  
			                if(result!=-1) {
			                	JOptionPane.showMessageDialog(null, "修改成功", "", JOptionPane.INFORMATION_MESSAGE);                
			                }
						else {
							
							JOptionPane.showMessageDialog(null, "用户名不存在", "", JOptionPane.INFORMATION_MESSAGE); 
						}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
				}
				
				else
					JOptionPane.showMessageDialog(null, "用户名密码不得为空", "error", JOptionPane.ERROR_MESSAGE);
				
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_3.setBounds(440, 325, 59, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u7EC4\u56E2\u4FE1\u606F\u7BA1\u7406");
		btnNewButton_4.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zutuan.main(null);
				frame.dispose();
			}
		});
		btnNewButton_4.setBounds(0, 402, 188, 36);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u8D85\u7EA7\u7BA1\u7406\u5458");
		btnNewButton_5.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String guanli = denglu.guanli;
				if(guanli.equals("admin")) {
				chaoji.main(null);
				frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "管理员账号由超级管理员管理", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_5.setBounds(422, 402, 173, 36);
		contentPane.add(btnNewButton_5);
		
		textField = new JTextField();
		textField.setBounds(83, 288, 144, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(372, 288, 159, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(14, 291, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(286, 291, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u7528\u6237\u4FE1\u606F\u7BA1\u7406");
		label.setFont(new Font("楷体", Font.PLAIN, 28));
		label.setBounds(14, 13, 433, 36);
		contentPane.add(label);
		
		JButton btnNewButton_6 = new JButton("\u5F00\u542F\u670D\u52A1");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
					MyThread mythread = new MyThread();
					mythread.start();
			}
		});
		btnNewButton_6.setBounds(231, 402, 127, 36);
		contentPane.add(btnNewButton_6);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 15));
		textArea.setBounds(54, 62, 481, 197);
		contentPane.add(textArea);
		JLabel lblNewLabel = new JLabel(new ImageIcon(denglu.class.getResource("/server/背景3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
		try{  
			Connection connect = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from user");
			String aa="编  号 "+"\t"+"用户名 "+"\t"+"密  码 "+"\t\n";
			textArea.append(aa);
		    while (rs.next()) {  
			String s=rs.getString("id")+" \t"+rs.getString("username")+" \t"+rs.getString("password")+" \t\n";
			textArea.append(s);
	}
		}catch (Exception e1) {
		e1.printStackTrace();
	}
	}
}

