package keshe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class xuanze extends JFrame {

	private JPanel contentPane;
	private static xuanze frame = new xuanze();
	public static String jd;
	
	String str1[] = {"������","�����","�Ϻ���","������","�ӱ�ʡ","ɽ��ʡ",
			"����ʡ","����ʡ","������ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ",
			"����ʡ","ɽ��ʡ","����ʡ","����ʡ","����ʡ","�㶫ʡ","����ʡ","�Ĵ�ʡ",
			"����ʡ","����ʡ","����ʡ","����ʡ","�ຣʡ","̨��ʡ","���ɹ�������",
			"����׳��������","����������","���Ļ���������","�½�ά���������","����ر�������","�����ر�������"
	};
	JComboBox comboBox = new JComboBox(str1);
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_2 = new JComboBox();
	
	public String jingdian;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public xuanze() {
		
		
		setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(xuanze.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u666F\u70B9");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 40));
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBounds(61, 31, 351, 87);
		contentPane.add(lblNewLabel_1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String sheng;
				sheng=(String) comboBox.getSelectedItem();
				if(sheng == "����׳��������") {
					comboBox_1.addItem("������");
					comboBox_1.addItem("������");
					comboBox_1.addItem("������");
					comboBox_1.addItem("������");
					comboBox_1.addItem("������");
					comboBox_1.addItem("���Ǹ���");
					comboBox_1.addItem("������");
					comboBox_1.addItem("�����");
					comboBox_1.addItem("������");
					comboBox_1.addItem("��ɫ��");
					comboBox_1.addItem("������");
					comboBox_1.addItem("�ӳ���");
					comboBox_1.addItem("������");
					comboBox_1.addItem("������");
				}
			}
		});
		
		
		comboBox.setBounds(61, 207, 127, 24);
		contentPane.add(comboBox);
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String shi;
				shi=(String) comboBox_1.getSelectedItem();
				if(shi == "������") {
					comboBox_2.addItem("��ʤ����");
					comboBox_2.addItem("�콭");
					comboBox_2.addItem("����");
					comboBox_2.addItem("�����ĺ�");
					comboBox_2.addItem("������");
					comboBox_2.addItem("������");
					comboBox_2.addItem("������Դ");
					comboBox_2.addItem("��ƺ���");
					comboBox_2.addItem("«����");
					comboBox_2.addItem("�����ٲ�");
					comboBox_2.addItem("��ʤ��Ȫ");
					comboBox_2.addItem("���Ǿ���");
				}
			}
		});

		
		comboBox_1.setBounds(230, 207, 127, 24);
		contentPane.add(comboBox_1);
		
		
		
		JLabel label = new JLabel("\u7701\u53CA\u76F4\u8F96\u5E02");
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setBounds(61, 159, 116, 35);
		contentPane.add(label);
		 
		JLabel label_1 = new JLabel("\u5E02");
		label_1.setFont(new Font("����", Font.PLAIN, 20));
		label_1.setBounds(230, 162, 72, 28);
		contentPane.add(label_1);
		
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jd=(String) comboBox_2.getSelectedItem();
				if(jd != null) {
				show1.open();
				frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "��δѡ�񾰵�", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(140, 300, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("����");
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xinxi.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(320, 300, 113, 27);
		contentPane.add(btnNewButton_2);
		
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				jingdian=(String) comboBox_2.getSelectedItem();
			}
		});
		comboBox_2.setBounds(404, 207, 116, 24);
		contentPane.add(comboBox_2);
		
		JLabel label_2 = new JLabel("\u666F\u70B9");
		label_2.setFont(new Font("����", Font.PLAIN, 20));
		label_2.setBounds(404, 159, 72, 28);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
}
