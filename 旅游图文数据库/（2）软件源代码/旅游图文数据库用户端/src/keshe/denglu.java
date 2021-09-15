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
import javax.swing.JTextField;
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

public class denglu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static denglu frame = new denglu();
	String password;
	public static String username;
	private JPasswordField passwordField;

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
	public denglu() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username=textField.getText();
				password=passwordField.getText();
				if(username.equals("")) {
					JOptionPane.showMessageDialog(null, "用户名为空", "error", JOptionPane.ERROR_MESSAGE);
				}
				else {
				if(password.equals("")) {
					JOptionPane.showMessageDialog(null, "密码为空", "error", JOptionPane.ERROR_MESSAGE);
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
						Statement stmt = connect.createStatement();  
						ResultSet rs = stmt.executeQuery("select * from user");
						int jud =0;
						while (rs.next()) {                           //1正确,2密码错误，3用户名不存在
							if(rs.getString("username").equals(username)) {
								if(rs.getString("password").equals(password)) {
									jud++;
									xinxi.main(null);
									frame.dispose();
									break;
								}
								else {
									jud++;
									JOptionPane.showMessageDialog(null, "密码错误", "error", JOptionPane.ERROR_MESSAGE);
								break;
								}
							}		
						}
						if(jud==0)
							JOptionPane.showMessageDialog(null, "用户名不存在", "error", JOptionPane.INFORMATION_MESSAGE);
						rs.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
			}
			}
		});
		btnNewButton.setBounds(136, 312, 113, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhuce.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(350, 312, 113, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(120, 123, 96, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(120, 203, 96, 29);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 20));
		textField.setBounds(230, 118, 275, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordField.setBounds(230, 203, 275, 30);
		contentPane.add(passwordField);
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);

		
	}
	
	public void tongxin()throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String localIp = InetAddress.getLocalHost().getHostAddress();
        String abc = "a";
        String str=abc+"><"+username+"><"+password;
        byte[] buf = str.getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(localIp), 9669);
        ds.send(dp);

    }

	public static void close() {
		// TODO Auto-generated method stub
		frame.dispose();
	}
}
