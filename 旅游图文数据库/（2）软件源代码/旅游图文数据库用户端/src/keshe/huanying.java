package keshe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;  
import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  

public class huanying extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application
	 */
	public void open() {
		huanying frame = new huanying();

		frame.setResizable(false);
		frame.setTitle("\u65C5\u6E38\u56FE\u6587\u6570\u636E\u5E93\u7CFB\u7EDF");
		frame.setFont(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(huanying.class.getResource("/keshe/\u8F6F\u4EF6\u56FE\u6807.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(600, 250, 615, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JLabel label = new JLabel(new ImageIcon(huanying.class.getResource("/keshe/\u80CC\u666F (2).jpg")));
		label.setBounds(0, 0,597,439);
		contentPane.add(label,0); 
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				denglu.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(huanying.class.getResource("/keshe/6041c99a5968d2e1909b0430094183c5.png")));
		btnNewButton.setBounds(226, 320, 136, 48);
		contentPane.add(btnNewButton,1);
		frame.setVisible(true);
		
	}
}
