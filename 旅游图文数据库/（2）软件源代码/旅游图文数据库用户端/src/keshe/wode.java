package keshe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class wode extends JFrame {

	private JPanel contentPane;
	static wode frame = new wode();

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
	public wode() {
		setResizable(false);
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6211\u7684\u7EC4\u56E2\u4FE1\u606F");
		label.setFont(new Font("楷体", Font.PLAIN, 28));
		label.setBounds(14, 13, 355, 63);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xinxi.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton.setBounds(256, 365, 113, 35);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 15));
		textArea.setBounds(48, 89, 512, 245);
		contentPane.add(textArea);
		
		try{  
			Connection connect = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/1400330129薛天杭旅游图文数据库","root","123456");  
			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from zutuanxinxi");
			String aa="编  号"+"\t"+"目标景点"+"\t"+"开始时间 "+"\t"+"登记号码 "+"\t"+"短信通知"+"\t\n";
			textArea.append(aa);
			String[] ss= {"是","否"};
		 while (rs.next()) {  
			   if(rs.getString("username").equals(denglu.username)) {
				String s=rs.getString("id")+"\t"+rs.getString("place")+"\t"+rs.getString("date")+"\t"+rs.getString("phonenumber")+"\t"+ss[rs.getInt("mesg")]+"\t\n";
				textArea.append(s);
			   }
		}
			}catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}

}
