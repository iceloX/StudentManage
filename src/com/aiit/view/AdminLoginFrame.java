package com.aiit.view;

/**
 * 管理员登录面板
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import com.aiit.model.Admin;
import com.aiit.service.AdminService;
import com.aiit.service.impl.AdminServiceImpl;
import com.aiit.utils.StringUtils;
import com.aiit.utils.UserFace;
import com.aiit.utils.WebCam;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.prism.paint.Stop;

import jdk.nashorn.internal.scripts.JO;

import com.aiit.utils.MsgConstant;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class AdminLoginFrame extends JFrame {
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JPanel contentPane;
	private JButton btnNewButton;
	LoginTipDialog ltd=null;

	AdminService as = new AdminServiceImpl();
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginFrame frame = new AdminLoginFrame();
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
	public AdminLoginFrame() {
		setFont(new Font("微软雅黑 Light", Font.BOLD, 12));
		setResizable(false);
		setTitle("学生管理系统-登录");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLoginFrame.class.getResource("/img/admin.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("登 录");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));

		JLabel lblNewLabel_1 = new JLabel("账  号");
		lblNewLabel_1.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/img/username.png")));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));

		usernameText = new JTextField();
		usernameText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		usernameText.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("密  码");
		lblNewLabel_1_1.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/img/password.png")));
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));

		passwordText = new JPasswordField();
		passwordText.setEchoChar('*');
		passwordText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));

		btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminRegisterFrame adminRegister = new AdminRegisterFrame();
				adminRegister.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/img/register.png")));
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));

		JButton btnNewButton_1 = new JButton("登录");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AdminLoginAction(event);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/img/进入.png")));
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		

		btnNewButton_2 = new JButton("人脸登录");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				// new Thread(new ActionImp()).start();
				new Thread(new FaceLoging()).start();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/img/人脸识别.png")));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(85, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(usernameText, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
								.addGap(141))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNewButton_2).addGap(49).addComponent(btnNewButton_1).addGap(41))))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(222).addComponent(lblNewLabel)
						.addContainerGap(224, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(68).addComponent(lblNewLabel).addGap(52)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1).addComponent(usernameText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(40)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGap(58)));
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}

	class Loding implements Runnable {
		@Override
		public void run() {
			ltd=new LoginTipDialog();
			new Thread(ltd).start();
			ltd.setVisible(true);
		}
	}

	class FaceLoging implements Runnable {

		@Override
		public void run() {
			try {
				new Thread(new Loding()).start();
				FaceLogin();
				ltd.dispose();

			} catch (IOException | JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	protected void FaceLogin() throws IOException, JSONException {

		WebCam webcam = new WebCam();
		String res = webcam.getFace2("./temp/" + System.currentTimeMillis());
		// System.out.println(res);
		JSONObject jsonObject = JSONObject.parseObject(res);
		System.out.println(jsonObject);
		JSONObject result = (JSONObject) jsonObject.get("result");
		if (result == null) {
			int i = JOptionPane.showConfirmDialog(null, "当前识别身份未注册，是否立即注册？");
			if (i == 0) {
				this.dispose();
				AdminRegisterFrame arf = new AdminRegisterFrame();
				arf.setVisible(true);
			}
		} else {
			System.out.println(result);
			JSONArray user_list = result.getJSONArray("user_list");
			BigDecimal score = null;
			String user_id = null;
			for (int i = 0; i < user_list.size(); i++) {
				JSONObject js = user_list.getJSONObject(i);
				score = js.getBigDecimal("score");
				user_id = js.getString("user_id");
			}
			if (score.compareTo(BigDecimal.valueOf(0.75)) > 0) {
				Admin a = as.seachAdmin(user_id);
				System.out.println(a.getId());
				ManagerMainFrame mmf = new ManagerMainFrame(a);
				new Thread(mmf).start();
				mmf.setVisible(true);
				this.dispose();
			}
		}
	}

	/**
	 * 管理员登录的函数实现
	 * 
	 * @param event
	 */
	protected void AdminLoginAction(ActionEvent event) {
		String username = usernameText.getText();
		String password = new String(passwordText.getPassword());

		if (StringUtils.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, MsgConstant.USERNAME_NOT_NULL);
			return;
		}
		if (StringUtils.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, MsgConstant.PWD_NOT_NULL);
			return;
		}

		Admin admin = as.AdminLogin(username);

		if (admin == null) {
			int i = JOptionPane.showConfirmDialog(null, MsgConstant.USERNAME_NOT_HAVE_REG);
			usernameText.setText("");
			passwordText.setText("");
			if (i == 0) {
				dispose();
				AdminRegisterFrame aminRegister = new AdminRegisterFrame();
				aminRegister.setVisible(true);
			}
			return;
		}
		if (password.equals(admin.getPassword())) {
			JOptionPane.showMessageDialog(null, MsgConstant.LOGIN_OK);

			dispose();
			ManagerMainFrame mmf = new ManagerMainFrame(admin);
			new Thread(mmf).start();
			mmf.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(null, MsgConstant.ERRO_PWD);
			// usernameText.setText("");
			passwordText.setText("");
			return;
		}
	}
}
