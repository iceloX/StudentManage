package com.aiit.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import com.aiit.baidu.AuthService;
import com.aiit.baidu.FaceDelete;
import com.aiit.model.Admin;
import com.aiit.service.AdminService;
import com.aiit.service.impl.AdminServiceImpl;
import com.aiit.utils.Helper;
import com.aiit.utils.MsgConstant;
import com.aiit.utils.StringUtils;
import com.baidu.aip.face.AipFace;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class AdminInfoFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	private static Admin admin = null;
	private JTextField UserNameText;
	private JTextField IdText;
	private JTextField PasswordText;
	private JTextField NameText;
	private static String username1;

	AdminService as = new AdminServiceImpl();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInfoFrame frame = new AdminInfoFrame(admin);
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
	public AdminInfoFrame(Admin admin) {
		setClosable(true);
		getContentPane().setFont(new Font("黑体", Font.BOLD, 15));
		setTitle("管理员信息");
		setBackground(Color.BLUE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		int screen_width = screen.width;
		int screen_height = screen.height;
		setBounds((screen_width - 371) / 2, (screen_height - 506) / 2, 371, 506);

		JLabel lblNewLabel = new JLabel("个人信息");
		lblNewLabel.setIcon(new ImageIcon(AdminInfoFrame.class.getResource("/img/头像.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 20));

		username1 = admin.getUsername();
		UserNameText = new JTextField(admin.getUsername());
		UserNameText.setEditable(false);
		UserNameText.setFont(new Font("Calibri", Font.BOLD, 15));
		UserNameText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("编  号");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 15));
		String id = String.valueOf(admin.getId());
		IdText = new JTextField(id);
		IdText.setEditable(false);
		IdText.setFont(new Font("黑体", Font.BOLD, 15));
		IdText.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("用户名");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("黑体", Font.BOLD, 15));

		JLabel lblNewLabel_1_2 = new JLabel("密  码");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("黑体", Font.BOLD, 15));

		PasswordText = new JTextField(admin.getPassword());
		PasswordText.setFont(new Font("Calibri", Font.PLAIN, 15));
		PasswordText.setColumns(10);

		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				updateAdminAction(event);
			}
		});
		// btnNewButton.setIcon(new ImageIcon(AdminInfoFrame.class.getResource("/img/修
		// 改1.png")));

		JButton btnNewButton_1 = new JButton("注销");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AdminDeleteAction(event);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminInfoFrame.class.getResource("/img/删 除 copy 2.png")));

		JLabel lblNewLabel_1_1_1 = new JLabel("姓  名");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("黑体", Font.BOLD, 15));

		NameText = new JTextField(admin.getName());
		NameText.setFont(new Font("黑体", Font.BOLD, 15));
		NameText.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(34)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1).addGap(18)
								.addComponent(IdText, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
								.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_1_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_1))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(PasswordText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135,
												Short.MAX_VALUE)
										.addComponent(UserNameText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135,
												Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(NameText, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))))
				.addGap(118))
				.addGroup(groupLayout.createSequentialGroup().addGap(25).addComponent(lblNewLabel).addContainerGap(178,
						Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(87).addComponent(lblNewLabel).addGap(56)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						IdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(NameText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(15)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(UserNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(PasswordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addGap(37)));
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 管理员注销
	 * 
	 * @param event
	 */
	protected void AdminDeleteAction(ActionEvent event) {
		int sure = JOptionPane.showConfirmDialog(null, MsgConstant.SURE_ZHUXIAO);
		if (sure != 0) {
			return;
		} else {
			int id = Integer.parseInt(IdText.getText());
			String name = NameText.getText();
			String username = UserNameText.getText();
			String password = PasswordText.getText();
			if (StringUtils.isEmpty(IdText.getText()) || StringUtils.isEmpty(name) || StringUtils.isEmpty(username)
					|| StringUtils.isEmpty(password)) {
				Helper.hintshowMessage(MsgConstant.ERRO_ZHUXIAO, null);
				// JOptionPane.showMessageDialog(null, MsgConstant.ERRO_ZHUXIAO);
				return;
			}
			Admin admin = new Admin(id, name, username, password);
			int result = as.deleteAdmin(admin);
			if (result != 0) {
				// FaceDelete faceDelete=
				sample(new FaceDelete().getClient(), admin);
				Helper.hintshowMessage(MsgConstant.OK_ZHUXIAO, null);
				this.getParent().getParent().getParent().getParent().getParent().setVisible(false);
				this.dispose();
				new AdminLoginFrame().setVisible(true);
			}
		}
	}
	protected void updateAdminAction(ActionEvent event) {
		int sure = Helper.hintConfirmMessage(MsgConstant.SURE_UPDATE, null);
		if (sure != 0) {
			return;
		} else {
			int id = Integer.parseInt(IdText.getText());
			String name = NameText.getText();
			String username = UserNameText.getText();
			String password = PasswordText.getText();

			if (StringUtils.isEmpty(name)) {
				Helper.hintshowMessage(MsgConstant.NAME_NOT_NULL, null);
				return;
			}
			if (StringUtils.isEmpty(username)) {
				Helper.hintshowMessage(MsgConstant.USERNAME_NOT_NULL, null);
				// JOptionPane.showMessageDialog(null, MsgConstant.USERNAME_NOT_NULL);
				return;
			}
			if (!StringUtils.isUsername(username)) {
				Helper.hintshowMessage(MsgConstant.USERNAME_ERRO, null);
				// JOptionPane.showMessageDialog(null, MsgConstant.USERNAME_ERRO);
				return;
			}
			if (StringUtils.isEmpty(password)) {
				Helper.hintshowMessage(MsgConstant.PWD_NOT_NULL, null);
				// JOptionPane.showMessageDialog(null, MsgConstant.PWD_NOT_NULL);
				return;
			}
			if (!StringUtils.isPassword(password)) {
				Helper.hintshowMessage(MsgConstant.PWD_ERRO, null);
				// JOptionPane.showMessageDialog(null, MsgConstant.PWD_ERRO);
				return;
			} /*
				 * else { // 检验登录用户得重复性,用户名不能重复 boolean flag = as.vaildUserName(username);//
				 * 用户名存在的标志 if (flag) {
				 * 
				 * int result = JOptionPane.showConfirmDialog(null, "用户名已存在,请更换其他用户名！");
				 * 
				 * if (result == 0) { dispose(); new AdminLoginFrame().setVisible(true); }
				 * return; } }
				 */
			Admin admin = new Admin(id, name, username, password);
			int result = as.updateAdmin(admin);
			if (result != 0) {
				Helper.hintshowMessage(MsgConstant.UPDATE_OK_EXIT, null);
				this.getParent().getParent().getParent().getParent().getParent().setVisible(false);
				this.dispose();
				new AdminLoginFrame().setVisible(true);
			}

		}
	}

	public void sample(AipFace client, Admin a) {
		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		String userId = a.getUsername();
		System.out.println(userId);
		// 删除用户

		JSONObject res = client.deleteUser("admin", userId, options);
		System.out.println(res.toString());
	}
}
