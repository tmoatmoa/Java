package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class zutuan extends JFrame {

	private JPanel contentPane;
	static zutuan frame = new zutuan();
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private JTextField textField_2;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(denglu.class.getResource("/server/软件图标.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7EC4\u56E2\u4FE1\u606F\u7BA1\u7406");
		label.setFont(new Font("楷体", Font.PLAIN, 28));
		label.setBounds(14, 13, 433, 36);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(217, 290, 135, 24);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("\u65C5\u6E38\u5730\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(147, 291, 72, 18);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String place = textField.getText();
				String date = textField_1.getText();
				if(place.equals("")||date.equals("")) {
					JOptionPane.showMessageDialog(null, "景点及时间不得为空", "error", JOptionPane.ERROR_MESSAGE);
				
			}
			else {
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
					ResultSet rs1 = stmt1.executeQuery("select * from zutuan");
						String sql = "INSERT INTO zutuan(place,date) VALUES('"+place+"','"+date+"')";  
						System.out.println(sql);
		                int result = stmt1.executeUpdate(sql);  
		                if(result!=-1) {
		                	JOptionPane.showMessageDialog(null, "登记成功", "", JOptionPane.INFORMATION_MESSAGE);                       //1注册成功
		                }
					

			} catch (Exception e1) {
				e1.printStackTrace();
			}
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 24));
		button.setBounds(54, 325, 59, 36);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5220");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_2.getText();
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
					
					String sql = "delete from zutuan where id = '"+id+"'";  
					
	                int result = stmt1.executeUpdate(sql);  
	                if(result!=-1) {
	                	JOptionPane.showMessageDialog(null, "删除成功", "", JOptionPane.INFORMATION_MESSAGE);                
	                }
	                else
	                	JOptionPane.showMessageDialog(null, "数据库中没有该记录", "", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 24));
		button_1.setBounds(181, 325, 59, 36);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("\u65F6  \u95F4\uFF1A");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(363, 291, 72, 18);
		contentPane.add(label_2);
		
		JButton button_2 = new JButton("\u67E5");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				try{  
					Connection connect = DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
					System.out.println("Success connect Mysql server!");
					Statement stmt = connect.createStatement();  
					ResultSet rs = stmt.executeQuery("select * from zutuan");
					String aa="编  号"+"\t"+"目标景点"+"\t"+" 开始日期"+"\t"+"报名人数"+"\t\n";
					textArea.append(aa);
				    while (rs.next()) {  
					String s=rs.getString("id")+"\t"+rs.getString("place")+"\t"+" "+rs.getString("date")+"\t"+rs.getString("num")+"\t\n";
					textArea.append(s);
			}
				}catch (Exception e1) {
				e1.printStackTrace();
			}
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 24));
		button_2.setBounds(313, 325, 59, 36);
		contentPane.add(button_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(433, 290, 135, 24);
		contentPane.add(textField_1);
		
		JButton button_3 = new JButton("\u6539");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String place = textField.getText();
				String date = textField_1.getText();
				String id = textField_2.getText();
				if(place!=null&&date!=null) {
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
					ResultSet rs1 = stmt1.executeQuery("select * from zutuan");
					
				
							String sql = "update zutuan set place = '"+place+"'where id = '"+id+"'";  
							String sql_1 = "update zutuan set date = '"+date+"'where id = '"+id+"'";  
							
			                int result = stmt1.executeUpdate(sql);  
			                if(result!=-1) {
			                	JOptionPane.showMessageDialog(null, "修改成功", "", JOptionPane.INFORMATION_MESSAGE);                
			                }
						else {
							
							JOptionPane.showMessageDialog(null, "不存在该条记录", "", JOptionPane.INFORMATION_MESSAGE); 
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
		button_3.setFont(new Font("楷体", Font.PLAIN, 24));
		button_3.setBounds(440, 325, 59, 36);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u8FD4\u56DE");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuwu.main(null);
				frame.dispose();
			}
		});
		button_4.setFont(new Font("楷体", Font.PLAIN, 24));
		button_4.setBounds(228, 402, 113, 36);
		contentPane.add(button_4);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 15));
		textArea.setBounds(54, 62, 477, 213);
		contentPane.add(textArea);
		
		try{  
			Connection connect = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from zutuan");
			String aa="编  号 "+"\t"+"目标景点"+"\t"+" 开始日期"+"\t"+"报名人数 "+"\t\n";
			textArea.append(aa);
		    while (rs.next()) {  
		    	String s=rs.getString("id")+"\t"+rs.getString("place")+"\t"+" "+rs.getString("date")+"\t"+rs.getString("num")+"\t\n";
			textArea.append(s);
	}
		}catch (Exception e1) {
		e1.printStackTrace();
	}
		
		JLabel label_3 = new JLabel("\u7F16\u53F7\uFF1A");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(14, 293, 54, 18);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 290, 49, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		JLabel lblNewLabel = new JLabel(new ImageIcon(denglu.class.getResource("/server/背景3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
}
