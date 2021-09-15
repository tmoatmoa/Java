package keshe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JTextArea;

public class xinxi extends JFrame {

	private JPanel contentPane;
	static xinxi frame = new xinxi();
	private JTable table;

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
	public xinxi() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u666F\u70B9\u6D4F\u89C8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuanze.open();
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 24));
		button.setBounds(431, 363, 142, 35);
		contentPane.add(button);
		
		JLabel label = new JLabel("\u4F60\u597D\uFF0C");
		label.setFont(new Font("楷体", Font.PLAIN, 28));
		label.setBounds(14, 13, 84, 42);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("楷体", Font.PLAIN, 28));
		label_1.setBounds(90, 13, 505, 42);
		contentPane.add(label_1);
		String name = denglu.username;
		label_1.setText(name);
		
		JButton btnNewButton = new JButton("\u6211\u7684\u7EC4\u56E2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wode.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton.setBounds(28, 363, 142, 35);
		contentPane.add(btnNewButton);
		
		JLabel label_2 = new JLabel("\u6700\u8FD1\u7EC4\u56E2\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label_2.setFont(new Font("楷体", Font.PLAIN, 24));
		label_2.setBounds(14, 68, 260, 51);
		contentPane.add(label_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 15));
		textArea.setBounds(39, 132, 525, 202);
		contentPane.add(textArea);
		
		
		
		try{  
			Connection connect = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from zutuan");
			String aa="编  号"+"\t"+"目标景点"+"\t"+"开始时间 "+"\t"+"报名人数"+"\t\n";
			textArea.append(aa);
		    while (rs.next()) {  
			String s=rs.getString("id")+"\t"+rs.getString("place")+"\t"+rs.getString("date")+"\t"+rs.getString("num")+"\t\n";
			textArea.append(s);
	}
		}catch (Exception e1) {
		e1.printStackTrace();
	}
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
}
