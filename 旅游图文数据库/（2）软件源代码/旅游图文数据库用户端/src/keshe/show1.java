package keshe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class show1 extends JFrame {

	static show1 frame = new show1();
	private JPanel contentPane;
	private static JTextField textField_2;
	private static JTextArea txtrQ;
	private static JLabel label;
	private static String jd;
	private static String url;
	private static String baike;
	private JButton button_2;
	private JButton button_3;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
					
					//数据库
					try {  
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Success loading Mysql Driver!");  
					}
					catch (Exception e) {  
						System.out.print("Error loading Mysql Driver!");  
						e.printStackTrace();  
					}  
					try{  
						Connection connect = DriverManager.getConnection(  
								"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
						System.out.println("Success connect Mysql server!");
						Statement stmt = connect.createStatement();  
						ResultSet rs = stmt.executeQuery("select * from baike");
						
						
						jd=xuanze.jd;
						System.out.println(jd);
						
						while (rs.next()) {
							if(rs.getString("place").equals(jd)) {
								url = rs.getString("url");
								System.out.println(url);
							}
						}
						ResultSet rs1 = stmt.executeQuery("select * from baikewenzi");
						while (rs1.next()) {
							if(rs1.getString("place").equals(jd)) {
								baike = rs1.getString("baike");
							}
						}  

					}catch(Exception ee) {  
						System.out.print("get data error!");  
						ee.printStackTrace();  
					}  
					
					textField_2.setText(url);
					
					txtrQ.setText(baike);
					
					label.setText(jd+"景点介绍:");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public show1() {
		setResizable(false);
		
		
		
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("楷体", Font.PLAIN, 15));
		textField_2.setBounds(114, 53, 469, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		txtrQ = new JTextArea();
		txtrQ.setFont(new Font("楷体", Font.PLAIN, 13));
		txtrQ.setBounds(114, 90, 469, 296);
		contentPane.add(txtrQ);
		
		txtrQ.setLineWrap(true);
		JButton button = new JButton("\u56FE\u7247\u6B23\u8D4F");
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				show2.open();
				frame.dispose();
			}
		});
		button.setBounds(150, 399, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button_1.setFont(new Font("楷体", Font.PLAIN, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuanze.open();
				frame.dispose();
			}
		});
		button_1.setBounds(480, 399, 113, 27);
		contentPane.add(button_1);
		
		label = new JLabel();
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(14, 13, 569, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u767E\u79D1\u94FE\u63A5\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(14, 55, 97, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u666F\u70B9\u7B80\u4ECB\uFF1A");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(14, 92, 97, 18);
		contentPane.add(label_2);
		
		button_2 = new JButton("\u6E38\u8BB0\u6B23\u8D4F");
		button_2.setFont(new Font("楷体", Font.PLAIN, 15));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show3.main(null);
				frame.dispose();
			}
		});
		button_2.setBounds(320, 399, 113, 27);
		contentPane.add(button_2);
		
		button_3 = new JButton("组团报名");
		button_3.setFont(new Font("楷体", Font.PLAIN, 15));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zutuan.main(null);
				frame.dispose();
			}
		});
		button_3.setBounds(0, 399, 113, 27);
		contentPane.add(button_3);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
		
	}
}
