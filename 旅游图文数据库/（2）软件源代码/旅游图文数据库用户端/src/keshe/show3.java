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
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class show3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static JLabel lbl1;
	static JLabel lbl2;
	static JTextArea textArea;
	
	static show3 frame= new show3();;
	static int id;
	static int num = 0;
	static String[] writer=new String[10];
	static String[] title=new String[10];
	static String[] article=new String[10];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
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
						ResultSet rs1 = stmt.executeQuery("select * from yj"+id);
						System.out.println(id);
						int i = 0;
						while (rs1.next()) {
							
							writer[i] = rs1.getString("writer");
							title[i] = rs1.getString("title");
							article[i] = rs1.getString("article");
							i++;
						}  

					}catch(Exception ee) {  
						System.out.print("get data error!");  
						ee.printStackTrace();  
					} 
					textArea.setText(article[0]);		
					lbl1.setText(writer[0]);
					lbl2.setText(title[0]);
				}

					catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public show3() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u6E38\u8BB0\u6B23\u8D4F");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(14, 13, 146, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u4F5C\u8005\uFF1A");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(14, 55, 60, 18);
		contentPane.add(label);
		
		lbl1 = new JLabel("");
		lbl1.setFont(new Font("楷体", Font.PLAIN, 20));
		lbl1.setBounds(67, 57, 191, 18);
		contentPane.add(lbl1);
		
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u7BC7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num>=1) {
					num--;
					textArea.setText( article[num]); 
					lbl1.setText(writer[num]);
					lbl2.setText(title[num]);
					System.out.println(num);
					}
					else {
						JOptionPane.showMessageDialog(null, "已经是第一篇了", "error", JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(14, 411, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u7BC7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num++;
				textArea.setText( article[num]); 
				lbl1.setText(writer[num]);
				lbl2.setText(title[num]);
				System.out.println(num);
				
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(482, 411, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show1.open();
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_2.setBounds(256, 411, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6807\u9898\uFF1A");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(256, 55, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		lbl2 = new JLabel("");
		lbl2.setFont(new Font("楷体", Font.PLAIN, 20));
		lbl2.setBounds(307, 57, 288, 18);
		contentPane.add(lbl2);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setBounds(14, 86, 581, 312);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("\u641C\u7D22\uFF1A");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(317, 24, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 15));
		textField.setBounds(370, 19, 146, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("\u63D0\u4EA4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String find = textField.getText();	
				for(int i=0;i<writer.length;i++) {
					if(find.equals(writer[i])) {
						textArea.setText( article[i]); 
						lbl1.setText(writer[i]);
						lbl2.setText(title[i]);	
						num=i;
					}
				}
			}
		});
		btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_3.setBounds(530, 18, 65, 27);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
}
