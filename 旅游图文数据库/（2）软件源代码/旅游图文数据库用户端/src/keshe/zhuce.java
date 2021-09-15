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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class zhuce extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static zhuce frame = new zhuce();
	String username,password,password_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
	public zhuce() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(89, 110, 127, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6    \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(89, 170, 127, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(89, 225, 127, 27);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 20));
		textField.setBounds(216, 111, 275, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username=textField.getText();
				password=passwordField.getText();
				password_1=passwordField_1.getText();
				if(username.equals("")) {
					JOptionPane.showMessageDialog(null, "用户名为空", "error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(password.equals("")||password_1.equals("")) {
						JOptionPane.showMessageDialog(null, "密码为空", "error", JOptionPane.ERROR_MESSAGE);
					}
					else if(!password.equals(password_1)) {
						JOptionPane.showMessageDialog(null, "两次密码不同", "error", JOptionPane.ERROR_MESSAGE);
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
							ResultSet rs1 = stmt1.executeQuery("select * from user");
							int jud = 0;
							while (rs1.next()) {                           //2用户名已存在
								if(rs1.getString("username").equals(username)) {
									JOptionPane.showMessageDialog(null, "该用户名已被使用", "error", JOptionPane.ERROR_MESSAGE);
									jud++;
										break;
								}
								
								}
							if(jud==0) {
							String sql = "INSERT INTO user(username,password) VALUES('"+username+"','"+password+"')";  
							
			                int result = stmt1.executeUpdate(sql);  
			                if(result!=-1) {
			                	JOptionPane.showMessageDialog(null, "注册成功", "", JOptionPane.INFORMATION_MESSAGE);                       //1注册成功
							}
							}

					} catch (Exception e1) {
						e1.printStackTrace();
					}
						/*try {
							tongxin();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						DatagramSocket socket = null;
						try {
							socket = new DatagramSocket(9339);
						} catch (SocketException e1) {
							e1.printStackTrace();
						}
				        byte[] buf = new byte[1024];
				        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length); 
				        while(true) {
				        try {
							socket.receive(datagramPacket);
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
				        System.out.println("接收端接收到的数据："+ new String(buf,0,datagramPacket.getLength())); 
				        String str= new String (buf);
				        String [] arr = str.split("><");
						if(arr[0].equals("b")) {
							if(arr[1].equals("1")) {
								JOptionPane.showMessageDialog(null, "注册成功", "", JOptionPane.INFORMATION_MESSAGE);
							}
							if(arr[1].equals("2")) {
								JOptionPane.showMessageDialog(null, "该用户名已被使用", "error", JOptionPane.ERROR_MESSAGE);
							}
						}
						}*/
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton.setBounds(161, 327, 113, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				denglu.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(365, 327, 113, 37);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordField.setBounds(216, 165, 275, 32);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordField_1.setBounds(216, 230, 275, 32);
		contentPane.add(passwordField_1);
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
	
	
	public void tongxin()throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String localIp = InetAddress.getLocalHost().getHostAddress();
        String abc = "b";
        String str=abc+"><"+username+"><"+password;
        byte[] buf = str.getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(localIp), 9669);
        ds.send(dp);

    }

}
