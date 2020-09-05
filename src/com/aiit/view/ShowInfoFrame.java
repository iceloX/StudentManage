package com.aiit.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ShowInfoFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowInfoFrame frame = new ShowInfoFrame();
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
	public ShowInfoFrame() {
		setClosable(true);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		setBackground(new Color(245, 245, 245));
		setFrameIcon(new ImageIcon(ShowInfoFrame.class.getResource("/img/admin.png")));
		setTitle("系统信息");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screen=tk.getScreenSize();
		int screen_width=screen.width;
		int screen_height=screen.height;
		setBounds((screen_width-421)/2,(screen_height-319)/2, 421, 319);
		
		JLabel lblNewLabel = new JLabel("系统信息");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("系统版本 1.01.0");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("  安徽信息工程学院©版权所有");
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ShowInfoFrame.class.getResource("/img/log.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(139)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(139)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(69)
							.addComponent(lblNewLabel_1_1)))
					.addContainerGap(119, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(50, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(26)
					.addComponent(lblNewLabel_2)
					.addGap(43)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_1)
					.addGap(31))
		);
		getContentPane().setLayout(groupLayout);

	}

}
