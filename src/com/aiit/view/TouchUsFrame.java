package com.aiit.view;
/**
 * 联系我们面板
 */

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TouchUsFrame extends JInternalFrame {
	private JTextField txtIceloqqcom;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TouchUsFrame frame = new TouchUsFrame();
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
	public TouchUsFrame() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 15));
		setFrameIcon(new ImageIcon(TouchUsFrame.class.getResource("/img/admin.png")));
		getContentPane().setBackground(new Color(255, 248, 220));
		setClosable(true);
		setTitle("联系我们");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screen=tk.getScreenSize();
		int screen_width=screen.width;
		int screen_height=screen.height;
		setBounds((screen_width-511)/2, (screen_height-342)/2,511,342);
		
		JLabel lblNewLabel = new JLabel("联系我们");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Email：");
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 15));
		lblNewLabel_1.setIcon(new ImageIcon(TouchUsFrame.class.getResource("/img/邮箱.png")));
		
		txtIceloqqcom = new JTextField();
		txtIceloqqcom.setEditable(false);
		txtIceloqqcom.setFont(new Font("黑体", Font.BOLD, 15));
		txtIceloqqcom.setText("icelo@qq.com");
		txtIceloqqcom.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel(" QQ ：");
		lblNewLabel_1_1.setIcon(new ImageIcon(TouchUsFrame.class.getResource("/img/QQ.png")));
		lblNewLabel_1_1.setFont(new Font("黑体", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("黑体", Font.PLAIN, 15));
		textField.setText("2568450165");
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(186)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtIceloqqcom, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(185, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblNewLabel)
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtIceloqqcom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
