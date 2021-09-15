package keshe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class show2 extends JFrame {
	static show2 frame = new show2();
	private static JLabel lblNewLabel_1;
	static int id;
	static int num = 0;
	static String[] place=new String[10];

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
						
						
						String jd = xuanze.jd;
						System.out.println(jd);
						
						while (rs.next()) {
							if(rs.getString("place").equals(jd)) {
								id = rs.getInt("id");
							}
						}
						ResultSet rs1 = stmt.executeQuery("select * from id"+id);
						System.out.println(id);
						int i = 0;
						while (rs1.next()) {
							
							place[i] = rs1.getString("place");
							
							i++;
						}  

					}catch(Exception ee) {  
						System.out.print("get data error!");  
						ee.printStackTrace();  
					}  
					lblNewLabel_1.setIcon(new ImageIcon(xuanze.class.getResource(place[0])));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public show2() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u4E0A\u4E00\u5F20");
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num>=1) {
				num--;
				lblNewLabel_1.setIcon(new ImageIcon(xuanze.class.getResource(place[num])));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				System.out.println(num);
				}
				else {
					JOptionPane.showMessageDialog(null, "已经是第一张了", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(0, 412, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4E0B\u4E00\u5F20");
		button_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(num<5) {
				num++;
				lblNewLabel_1.setIcon(new ImageIcon(xuanze.class.getResource(place[num])));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				System.out.println(num);
				}
				else {
					JOptionPane.showMessageDialog(null, "已经是最后一张了", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_1.setBounds(484, 412, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button_2.setFont(new Font("楷体", Font.PLAIN, 15));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show1.open();
				frame.dispose();
			}
		});
		button_2.setBounds(245, 412, 113, 27);
		contentPane.add(button_2);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(0, 0, 597, 399);
		contentPane.add(lblNewLabel_1,1);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
}
