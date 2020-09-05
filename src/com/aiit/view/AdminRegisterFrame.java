package com.aiit.view;

/**
 * 管理员注册面板
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.aiit.service.AdminService;
import com.aiit.service.impl.AdminServiceImpl;
import com.aiit.utils.MsgConstant;
import com.aiit.utils.StringUtils;
import com.aiit.utils.WebCam;
import com.aiit.model.Admin;
import com.aiit.view.AdminLoginFrame;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminRegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private String res;

	AdminService as = new AdminServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegisterFrame frame = new AdminRegisterFrame();
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
	public AdminRegisterFrame() {
		setResizable(false);
		setBackground(new Color(102, 51, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminRegisterFrame.class.getResource("/img/admin.png")));
		setTitle("学生管理系统-注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("注 册");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));

		JLabel lblNewLabel_1 = new JLabel("姓  名");
		lblNewLabel_1.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/img/昵称.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));

		JLabel lblNewLabel_1_1 = new JLabel("用户名");
		lblNewLabel_1_1.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/img/username.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 18));

		JLabel lblNewLabel_1_1_1 = new JLabel("密  码");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/img/password.png")));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.BOLD, 18));

		nameText = new JTextField();
		nameText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		nameText.setColumns(10);

		JButton btnNewButton = new JButton("注 册");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/img/register.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AdminRegisterAction(event);
			}
		});

		usernameText = new JTextField();
		usernameText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		usernameText.setColumns(10);

		passwordText = new JPasswordField();
		passwordText.setEchoChar('*');
		passwordText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));

		JButton btnNewButton_1 = new JButton("登 录");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLoginFrame adminLogin = new AdminLoginFrame();
				adminLogin.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/img/进入.png")));

		JButton btnNewButton_2 = new JButton("人脸注册");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faceRegister();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/img/人脸识别.png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(213).addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(61).addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_1_1_1)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 83,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 101,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
										.createSequentialGroup().addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(passwordText).addComponent(usernameText).addComponent(
														nameText, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(31)
												.addComponent(btnNewButton_2).addGap(39).addComponent(btnNewButton)))))
				.addGap(54)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(83).addComponent(lblNewLabel).addGap(41)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addGap(51)));
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}

	protected void faceRegister() {
		/**
		 * 调用摄像头获取头像文件
		 */
		WebCam webcam=new WebCam();
		String name = nameText.getText();
		String username = usernameText.getText();
		String password = new String(passwordText.getPassword());

		if (StringUtils.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, MsgConstant.NAME_NOT_NULL);
			return;
		}
		if (StringUtils.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, MsgConstant.USERNAME_NOT_NULL);
			return;
		}
		if (!StringUtils.isUsername(username)) {
			JOptionPane.showMessageDialog(null, MsgConstant.USERNAME_ERRO);
			return;
		}
		if (StringUtils.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, MsgConstant.PWD_NOT_NULL);
			return;
		}
		if (!StringUtils.isPassword(password)) {
			JOptionPane.showMessageDialog(null, MsgConstant.PWD_ERRO);
			return;
		} else {
			// 检验登录用户得重复性,用户名不能重复
			boolean flag = as.vaildUserName(username);// 用户名存在的标志
			if (flag) {

				int result = JOptionPane.showConfirmDialog(null, MsgConstant.USERNAME_IS_HAVE_LGOIN);

				if (result == 0) {
					dispose();
					new AdminLoginFrame().setVisible(true);
				}
				return;
			}
		}
		Admin a = new Admin(name,username,password);
		res = webcam.getFace("./register/",a);
		this.dispose();
		System.out.println(res);
		
		
	}

	/**
	 * 注册功能实现
	 * 
	 * @param event
	 */
	protected void AdminRegisterAction(ActionEvent event) {
		String name = nameText.getText();
		String username = usernameText.getText();
		String password = new String(passwordText.getPassword());

		if (StringUtils.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, MsgConstant.NAME_NOT_NULL);
			return;
		}
		if (StringUtils.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, MsgConstant.USERNAME_NOT_NULL);
			return;
		}
		if (!StringUtils.isUsername(username)) {
			JOptionPane.showMessageDialog(null, MsgConstant.USERNAME_ERRO);
			return;
		}
		if (StringUtils.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, MsgConstant.PWD_NOT_NULL);
			return;
		}
		if (!StringUtils.isPassword(password)) {
			JOptionPane.showMessageDialog(null, MsgConstant.PWD_ERRO);
			return;
		} else {
			// 检验登录用户得重复性,用户名不能重复
			boolean flag = as.vaildUserName(username);// 用户名存在的标志
			if (flag) {

				int result = JOptionPane.showConfirmDialog(null, MsgConstant.USERNAME_IS_HAVE_LGOIN);

				if (result == 0) {
					dispose();
					new AdminLoginFrame().setVisible(true);
				}
				return;
			}
		}

		Admin admin = new Admin(name, username, password);
		int i = as.AdminRegister(admin);
		if (i != 0) {
			int result = JOptionPane.showConfirmDialog(null, MsgConstant.REG_OK_LOGIN);
			if (result == 0) {
				dispose();
				new AdminLoginFrame().setVisible(true);
			}
			return;
		}

	}
}
