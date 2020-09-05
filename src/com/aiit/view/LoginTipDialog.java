package com.aiit.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Font;

public class LoginTipDialog extends JDialog implements Runnable {
	JLabel tipText = null;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginTipDialog dialog = new LoginTipDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginTipDialog() {
		setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		setTitle("请稍后");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginTipDialog.class.getResource("/img/admin.png")));
		setBounds(100, 100, 342, 164);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginTipDialog.class.getResource("/img/loding.gif")));

		tipText = new JLabel("当前正在人脸识别");
		tipText.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(52).addComponent(lblNewLabel_1).addGap(18)
						.addComponent(tipText, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
						.addGap(43)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(42)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tipText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		contentPanel.setLayout(gl_contentPanel);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		while(true) {
			try {
				tipText.setText("当前正在人脸识别");
				Thread.sleep(1000);
				tipText.setText("当前正在人脸识别。");
				Thread.sleep(1000);
				tipText.setText("当前正在人脸识别。。");
				Thread.sleep(1000);
				tipText.setText("当前正在人脸识别。。。");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
