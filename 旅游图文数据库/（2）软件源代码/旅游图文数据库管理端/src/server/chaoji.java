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

public class chaoji extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static chaoji frame = new chaoji();
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
	public chaoji() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(denglu.class.getResource("/server/软件图标.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7\u7BA1\u7406");
		label.setFont(new Font("楷体", Font.PLAIN, 28));
		label.setBounds(14, 13, 433, 36);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(83, 288, 144, 24);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("\u8D26  \u53F7\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(14, 291, 72, 18);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String guanli = textField.getText();
				String password = textField_1.getText();
				if(guanli!=null&&password!=null) {
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
					ResultSet rs1 = stmt1.executeQuery("select * from guanli");
					int judge = 0;
					while (rs1.next()) {                          
						if(rs1.getString("guanli").equals(guanli)) {
							JOptionPane.showMessageDialog(null, "该管理账号已被使用", "error", JOptionPane.ERROR_MESSAGE);
							judge++;
								break;
						}
					}
					if(judge==0) {
						String sql = "INSERT INTO user(username,password) VALUES('"+guanli+"','"+password+"')";  
					
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
				JOptionPane.showMessageDialog(null, "账户及密码不得为空", "error", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 24));
		button.setBounds(54, 325, 59, 36);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5220");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String guanli = textField.getText();
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
					
					String sql = "delete from guanli where guanli = '"+guanli+"'";  
					
	                int result = stmt1.executeUpdate(sql);  
	                if(result!=-1) {
	                	JOptionPane.showMessageDialog(null, "删除成功", "", JOptionPane.INFORMATION_MESSAGE);                
	                }
	                else
	                	JOptionPane.showMessageDialog(null, "数据库中没有该管理账户", "", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 24));
		button_1.setBounds(181, 325, 59, 36);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(286, 291, 72, 18);
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
					ResultSet rs = stmt.executeQuery("select * from guanli");
					String aa="编  号 "+"\t"+"账户 "+"\t"+"密  码 "+"\t\n";
					textArea.append(aa);
				    while (rs.next()) {  
				    	String s=rs.getString("id")+" \t"+rs.getString("guanli")+" \t"+rs.getString("password")+" \t\n";
					textArea.append(s);
			}
				}catch (Exception e1) {
				e1.printStackTrace();
			}
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 24));
		button_2.setBounds(313, 325, 59, 36);
		contentPane.add(button_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(372, 288, 159, 24);
		contentPane.add(textField_1);
		
		JButton button_3 = new JButton("\u6539");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String guanli = textField.getText();
				String password = textField_1.getText();
				if(guanli!=null&&password!=null) {
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
					ResultSet rs1 = stmt1.executeQuery("select * from guanli");
					
				
							String sql = "update guanli set password = '"+password+"'where guanli = '"+guanli+"'";  
							
			                int result = stmt1.executeUpdate(sql);  
			                if(result!=-1) {
			                	JOptionPane.showMessageDialog(null, "修改成功", "", JOptionPane.INFORMATION_MESSAGE);                
			                }
						else {
							
							JOptionPane.showMessageDialog(null, "管理账户不存在", "", JOptionPane.INFORMATION_MESSAGE); 
						}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
				}
				
				else
					JOptionPane.showMessageDialog(null, "账户及密码不得为空", "error", JOptionPane.ERROR_MESSAGE);
				
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
		button_4.setBounds(231, 402, 113, 36);
		contentPane.add(button_4);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 15));
		textArea.setBounds(54, 73, 488, 188);
		
		try{  
			Connection connect = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from guanli");
			String aa="编  号 "+"\t"+"账户 "+"\t"+"密  码 "+"\t\n";
			textArea.append(aa);
		    while (rs.next()) {  
			String s=rs.getString("id")+" \t"+rs.getString("guanli")+" \t"+rs.getString("password")+" \t\n";
			textArea.append(s);
	}
		}catch (Exception e1) {
		e1.printStackTrace();
	}
		contentPane.add(textArea);
		JLabel lblNewLabel = new JLabel(new ImageIcon(denglu.class.getResource("/server/背景3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}

}
