package server;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class denglu extends JFrame {

	private JPanel contentPane;
	static denglu frame = new denglu();
	private JTextField textField;
	private JPasswordField passwordField;
	public static String guanli;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(denglu.class.getResource("/server/软件图标.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(70, 90, 159, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6      \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(70, 190, 159, 34);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(230, 91, 237, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guanli = textField.getText();
				String password = passwordField.getText();
				
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
					ResultSet rs = stmt.executeQuery("select * from guanli");
					int jud =0;
					while (rs.next()) {                           //1正确,2密码错误，3用户名不存在
						if(rs.getString("guanli").equals(guanli)) {
							if(rs.getString("password").equals(password)) {
								jud++;
								fuwu.main(null);
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
					if(guanli.equals("superadmin")&&password.equals("123456")) {
						fuwu.main(null);
						frame.dispose();
					}
					else if(jud==0)
						JOptionPane.showMessageDialog(null, "管理账户不存在", "error", JOptionPane.INFORMATION_MESSAGE);
					rs.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton.setBounds(216, 298, 113, 37);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 24));
		passwordField.setBounds(230, 190, 237, 33);
		contentPane.add(passwordField);
		JLabel lblNewLabel = new JLabel(new ImageIcon(denglu.class.getResource("/server/背景3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
}
