package com.aiit.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.aiit.model.Admin;
import com.aiit.utils.Helper;
import com.aiit.utils.MsgConstant;
import com.iflytek.cloud.a.c;
import com.sun.glass.ui.Pixels.Format;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;

public class ManagerMainFrame extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private static JLabel AdminIdText;
	private static JLabel AdminUserNameText;
	private static JLabel AdminNameText;
	private static JLabel TimeText;
	private static Admin admin = null;
	private static Color ThemColor = Color.blue;
	private JMenuItem mntmNewMenuItem_9_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMainFrame frame = new ManagerMainFrame(admin);
					new Thread(frame).start();
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
	public ManagerMainFrame(Admin admin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerMainFrame.class.getResource("/img/admin.png")));
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("学生信息管理系统-主页面");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int width = screen.width;
		int height = screen.height;
		setBounds(0, 0, width, height);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("系统设置");
		mnNewMenu.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-太阳.png")));
		mnNewMenu.setBackground(new Color(255, 255, 255));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("系统信息");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowInfoFrame showInfo = new ShowInfoFrame();
				showInfo.setVisible(true);
				desktopPane.add(showInfo);
			}
		});

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("主题设置");
		mntmNewMenuItem_9.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-阔叶树.png")));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JColorChooser colorDialog = new JColorChooser();
				JColorChooser colorChooser = new JColorChooser();
				ThemColor = JColorChooser.showDialog(null, "", null);
				if (ThemColor != null) {
					int i = Helper.hintConfirmMessage("你确定修改系统颜色嘛？", null);
					if (i == 0) {
						desktopPane.setBackground(ThemColor);
						Helper.hintshowMessage("系统颜色已更改！", null);
					}
				}
				return;
			}
			// System.out.println(ThemColor.getRGB());
		});
		mntmNewMenuItem_9.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_9);
		mntmNewMenuItem.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-兔子.png")));
		mntmNewMenuItem.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("修改信息");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminInfoFrame adminInfo = new AdminInfoFrame(admin);
				adminInfo.setVisible(true);
				desktopPane.add(adminInfo);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mntmNewMenuItem_1.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-书本.png")));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("退出登录");
		mntmNewMenuItem_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Helper.hintConfirmMessage("你确定退出登录嘛？", null);
				if (i == 0) {
					dispose();
					AdminLoginFrame adminLogin = new AdminLoginFrame();
					adminLogin.setVisible(true);
				}
			}
		});
		
		mntmNewMenuItem_9_1 = new JMenuItem("垃圾清理");
		mntmNewMenuItem_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<File> list=new ArrayList<File>();
				File temp=new File("./temp/");
				File [] files=temp.listFiles();
				if(files!=null||files.length>0) {
					for(File childFile:files) {
						if(childFile.isFile()&&childFile.getName().endsWith(".png")) {
							list.add(childFile);
						}
					}
				}
				int sum=0;
				for(int i=0;i<list.size();i++) {
					long size = list.get(i).length();
					sum+=size;
				}
				double m;
				m=sum/1024.0;
				m=m/1024.0;
				String fs=String.format("%.2f", m);
				if(m==0) {
					Helper.hintshowMessage("您的系统很干净，没有可以清除的垃圾！", null);
					//JOptionPane.showMessageDialog(null, );
					return;
				}
				int i=Helper.hintConfirmMessage("您将清理一共 "+fs+" M的垃圾文件！确定清除吗？", null);
				//int i=JOptionPane.showConfirmDialog(null,"您将清理一共 "+fs+" M的垃圾文件！确定清除吗？");
				if(i==0) {
					for(int j=0;j<list.size();j++) {
						list.get(j).delete();
					}
					Helper.hintshowMessage("清理完成！", null);
					//JOptionPane.showMessageDialog(null, "清理完成！");
				}
			}
		});
		mntmNewMenuItem_9_1.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-铅笔.png")));
		mntmNewMenuItem_9_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_9_1);
		mntmNewMenuItem_2.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-苹果.png")));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("学生管理");
		mnNewMenu_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-雨伞.png")));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("添加学生");
		mntmNewMenuItem_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddStudentFrame addStudent = new AddStudentFrame();
				addStudent.setVisible(true);
				desktopPane.add(addStudent);
				
			}
		});

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("学生信息");
		mntmNewMenuItem_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowStudentFrame ssf = new ShowStudentFrame();
				ssf.setVisible(true);
				desktopPane.add(ssf);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-礼物.png")));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_3.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-菊花.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("批量操作");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoreActionFrame maf = new MoreActionFrame();
				maf.setVisible(true);
				desktopPane.add(maf);

			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-铅笔.png")));
		mntmNewMenuItem_8.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_2 = new JMenu("帮助");
		mnNewMenu_2.setForeground(Color.BLACK);
		mnNewMenu_2.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-蘑菇.png")));
		mnNewMenu_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("官方网站");
		mntmNewMenuItem_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent envet) {
				if (java.awt.Desktop.isDesktopSupported()) {
					try {
						// 创建一个URI实例
						java.net.URI uri = java.net.URI.create("https://www.aiit.edu.cn/");
						// 获取当前系统桌面扩展
						java.awt.Desktop dp = java.awt.Desktop.getDesktop();
						// 判断系统桌面是否支持要执行的功能
						if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
							// 获取系统默认浏览器打开链接
							dp.browse(uri);
						}
					} catch (java.io.IOException e) {
						// 此为无法获取系统默认浏览器
					}
				}
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-汽车.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("联系我们");
		mntmNewMenuItem_6.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TouchUsFrame touchUs = new TouchUsFrame();
				touchUs.setVisible(true);
				desktopPane.add(touchUs);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-星球.png")));
		mnNewMenu_2.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("版本更新");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.hintshowMessage(MsgConstant.NOT_HAVE_UPDATE, null);
				//JOptionPane.showMessageDialog(null, MsgConstant.NOT_HAVE_UPDATE);
				return;
			}
		});
		mntmNewMenuItem_7.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		mntmNewMenuItem_7.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-糖果.png")));
		mnNewMenu_2.add(mntmNewMenuItem_7);

		JCheckBox voiceBox = new JCheckBox("语音提示");
		// voiceBox.setIcon(new
		// ImageIcon(ManagerMainFrame.class.getResource("/img/儿童手绘-兔子.png")));
		voiceBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Helper.setVoiceTip(voiceBox.isSelected());// 当复选框的值变化时
				if (voiceBox.isSelected()) {
					Helper.hintshowMessage(MsgConstant.VOICE, null);
				}
			}
		});
		voiceBox.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		menuBar.add(voiceBox);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);
		desktopPane = new JDesktopPane();
		System.out.println(ThemColor.getRGB());
		desktopPane.setBackground(ThemColor);
		// desktopPane.setBackground(new Color(255, 204, 102));

		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/img_axg.png")));

		JLabel lblNewLabel_1 = new JLabel("编  号：");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 20));

		JLabel lblNewLabel_1_1 = new JLabel("姓  名：");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("黑体", Font.BOLD, 20));

		JLabel lblNewLabel_1_1_1 = new JLabel("用户名：");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("黑体", Font.BOLD, 20));

		JLabel lblNewLabel_2 = new JLabel("当前登录");
		lblNewLabel_2.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/头像.png")));
		lblNewLabel_2.setFont(new Font("黑体", Font.BOLD, 25));
		lblNewLabel_2.setForeground(Color.WHITE);

		AdminIdText = new JLabel(admin.getId() + "");
		AdminIdText.setForeground(Color.WHITE);
		AdminIdText.setFont(new Font("黑体", Font.BOLD, 20));

		AdminUserNameText = new JLabel(admin.getUsername());
		AdminUserNameText.setForeground(Color.WHITE);
		AdminUserNameText.setFont(new Font("黑体", Font.BOLD, 20));

		AdminNameText = new JLabel(admin.getName());
		AdminNameText.setForeground(Color.WHITE);
		AdminNameText.setFont(new Font("黑体", Font.BOLD, 20));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/日期.png")));

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(ManagerMainFrame.class.getResource("/img/时间.png")));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateStr = sdf.format(date);

		JLabel DateText = new JLabel(dateStr);
		DateText.setForeground(Color.WHITE);
		DateText.setFont(new Font("黑体", Font.BOLD, 25));

		TimeText = new JLabel();
		TimeText.setForeground(Color.WHITE);
		TimeText.setFont(new Font("黑体", Font.BOLD, 25));
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING).addGroup(gl_desktopPane
				.createSequentialGroup().addGap(10)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE).addGap(135)
				.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 85,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(AdminNameText,
										GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPane.createSequentialGroup()
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 85,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(AdminUserNameText,
										GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPane.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(AdminIdText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2)
						.addGroup(gl_desktopPane.createSequentialGroup().addComponent(lblNewLabel_3).addGap(18)
								.addComponent(DateText, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPane.createSequentialGroup()
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(TimeText, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(136, Short.MAX_VALUE)));
		gl_desktopPane.setVerticalGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING).addGroup(gl_desktopPane
				.createSequentialGroup().addGap(165)
				.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING).addGroup(gl_desktopPane
						.createSequentialGroup().addGap(32).addComponent(lblNewLabel_2).addGap(47)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(AdminIdText, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(AdminUserNameText, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(AdminNameText, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE))
						.addGap(108)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3)
								.addComponent(DateText))
						.addGap(28)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(TimeText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(12, Short.MAX_VALUE)));
		desktopPane.setLayout(gl_desktopPane);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	@Override
	public void run() {
		while (true) {
			try {
				String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
				Thread.sleep(1000);
				TimeText.setText(time);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}
}
