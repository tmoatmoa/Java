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
	
	String str1[] = {"北京市","天津市","上海市","重庆市","河北省","山西省",
			"辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省",
			"江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省",
			"贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古自治区",
			"广西壮族自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区"
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
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 40));
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBounds(61, 31, 351, 87);
		contentPane.add(lblNewLabel_1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String sheng;
				sheng=(String) comboBox.getSelectedItem();
				if(sheng == "广西壮族自治区") {
					comboBox_1.addItem("南宁市");
					comboBox_1.addItem("柳州市");
					comboBox_1.addItem("桂林市");
					comboBox_1.addItem("梧州市");
					comboBox_1.addItem("北海市");
					comboBox_1.addItem("防城港市");
					comboBox_1.addItem("钦州市");
					comboBox_1.addItem("贵港市");
					comboBox_1.addItem("玉林市");
					comboBox_1.addItem("百色市");
					comboBox_1.addItem("贺州市");
					comboBox_1.addItem("河池市");
					comboBox_1.addItem("来宾市");
					comboBox_1.addItem("崇左市");
				}
			}
		});
		
		
		comboBox.setBounds(61, 207, 127, 24);
		contentPane.add(comboBox);
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String shi;
				shi=(String) comboBox_1.getSelectedItem();
				if(shi == "桂林市") {
					comboBox_2.addItem("龙胜梯田");
					comboBox_2.addItem("漓江");
					comboBox_2.addItem("王城");
					comboBox_2.addItem("两江四湖");
					comboBox_2.addItem("乐满地");
					comboBox_2.addItem("银子岩");
					comboBox_2.addItem("世外桃源");
					comboBox_2.addItem("兴坪渔村");
					comboBox_2.addItem("芦笛岩");
					comboBox_2.addItem("古龙瀑布");
					comboBox_2.addItem("龙胜温泉");
					comboBox_2.addItem("七星景区");
				}
			}
		});

		
		comboBox_1.setBounds(230, 207, 127, 24);
		contentPane.add(comboBox_1);
		
		
		
		JLabel label = new JLabel("\u7701\u53CA\u76F4\u8F96\u5E02");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(61, 159, 116, 35);
		contentPane.add(label);
		 
		JLabel label_1 = new JLabel("\u5E02");
		label_1.setFont(new Font("楷体", Font.PLAIN, 20));
		label_1.setBounds(230, 162, 72, 28);
		contentPane.add(label_1);
		
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jd=(String) comboBox_2.getSelectedItem();
				if(jd != null) {
				show1.open();
				frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "尚未选择景点", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(140, 300, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 15));
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
		label_2.setFont(new Font("楷体", Font.PLAIN, 20));
		label_2.setBounds(404, 159, 72, 28);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(xuanze.class.getResource("/keshe/\u80CC\u666F3.jpg")));
		lblNewLabel.setBounds(0, 0, 597, 439);
		contentPane.add(lblNewLabel,-1);
	}
}
