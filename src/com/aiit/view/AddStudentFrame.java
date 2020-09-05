package com.aiit.view;

/**
 * 添加学生面板
 */
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.aiit.model.Student;
import com.aiit.service.StudentService;
import com.aiit.service.impl.StudentServiceImpl;
import com.aiit.utils.Helper;
import com.aiit.utils.MsgConstant;
import com.aiit.utils.StringUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentFrame extends JInternalFrame {
	private JTextField NameText;
	private JTextField AgeText;
	private JTextField ClsText;
	private JTextField PhoneText;
	private JTextField AddressText;
	private JComboBox SexBox;

	private Student stu;
	StudentService ss=new StudentServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentFrame frame = new AddStudentFrame();
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
	
	public AddStudentFrame() {
		getContentPane().setBackground(SystemColor.textHighlight);

		JLabel lblNewLabel = new JLabel("添加学生");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 15));

		NameText = new JTextField();
		NameText.setFont(new Font("黑体", Font.BOLD, 15));
		NameText.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("性别：");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("黑体", Font.BOLD, 15));

		JLabel lblNewLabel_1_1_1 = new JLabel("年龄：");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("黑体", Font.BOLD, 15));

		JLabel lblNewLabel_1_1_1_1 = new JLabel("班级：");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("黑体", Font.BOLD, 15));

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("手机：");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("黑体", Font.BOLD, 15));

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("地址：");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("黑体", Font.BOLD, 15));

		AgeText = new JTextField();
		AgeText.setFont(new Font("黑体", Font.BOLD, 15));
		AgeText.setColumns(10);

		ClsText = new JTextField();
		ClsText.setFont(new Font("黑体", Font.BOLD, 15));
		ClsText.setColumns(10);

		PhoneText = new JTextField();
		PhoneText.setFont(new Font("黑体", Font.BOLD, 15));
		PhoneText.setColumns(10);

		AddressText = new JTextField();
		AddressText.setFont(new Font("黑体", Font.BOLD, 15));
		AddressText.setColumns(10);

		SexBox = new JComboBox();
		SexBox.setForeground(Color.BLACK);
		SexBox.setFont(new Font("黑体", Font.BOLD, 15));
		SexBox.setModel(new DefaultComboBoxModel(new String[] { "男", "女" }));

		JButton btnNewButton = new JButton("重置");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				resetStuent(event);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/重置.png")));
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 15));

		JButton btnNewButton_1 = new JButton("添加");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addStudentAction(event);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/add.png")));
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(141).addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup().addGap(59).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(SexBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(NameText,
												GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(AgeText,
												GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(ClsText,
												GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(124, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(60).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
								.addComponent(btnNewButton_1).addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(103, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(45).addComponent(lblNewLabel).addGap(35)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(NameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(SexBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(AgeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(ClsText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(17)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(53)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(58, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
		setBackground(Color.BLUE);
		setClosable(true);
		setFrameIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/admin.png")));
		setTitle("添加学生");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screen=tk.getScreenSize();
		int screen_width=screen.width;
		int screen_height=screen.height;
		setBounds((screen_width-393)/2, (screen_height-501)/2, 393, 501);
	}

	/**
	 * 添加学生
	 * 
	 * @param event
	 */
	protected void addStudentAction(ActionEvent event) {
		String name = NameText.getText();
		if (StringUtils.isEmpty(name)) {
			Helper.hintshowMessage(MsgConstant.NAME_NOT_NULL, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.NAME_NOT_NULL);
			return;
		}
		String sex = "男";
		int selected = SexBox.getSelectedIndex();
		if (selected == 1) {
			sex = "女";
		}
		String ageStr = AgeText.getText();
		if (StringUtils.isEmpty(ageStr)) {
			Helper.hintshowMessage(MsgConstant.AGE_NOT_NULL, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.AGE_NOT_NULL);
			return;
		}
		if(!StringUtils.isAge(ageStr)) {
			Helper.hintshowMessage(MsgConstant.AGE_ERRO, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.AGE_ERRO);
			return;
		}
		String cls = ClsText.getText();
		if (StringUtils.isEmpty(cls)) {
			Helper.hintshowMessage(MsgConstant.CLS_NOT_NULL, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.CLS_NOT_NULL);
			return;
		}
		String phone = PhoneText.getText();
		if (StringUtils.isEmpty(phone)) {
			Helper.hintshowMessage(MsgConstant.PHONE_NOT_NULL, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.PHONE_NOT_NULL);
			return;
		}
		if(!StringUtils.isMobile(phone)) {
			Helper.hintshowMessage(MsgConstant.PHONE_ERRO, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.PHONE_ERRO);
			return;
		}
		String address = AddressText.getText();
		if (StringUtils.isEmpty(address)) {
			Helper.hintshowMessage(MsgConstant.ADDRESS_NOT_NULL, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.ADDRESS_NOT_NULL);
			return;
		}
		int age=Integer.parseInt(ageStr);
		Student stu=new Student(name, sex, age, cls, phone, address);
		
		int result=ss.addStudent(stu);
		if(result!=0) {
			Helper.hintshowMessage(MsgConstant.ADD_OK, null);
			this.dispose();
			//JOptionPane.showMessageDialog(null, MsgConstant.ADD_OK);
			return;
		}
	}

	
	/**
	 * 重置学生
	 * 
	 * @param event
	 */
	protected void resetStuent(ActionEvent event) {
		NameText.setText("");
		AgeText.setText("");
		SexBox.setSelectedIndex(0);
		ClsText.setText("");
		PhoneText.setText("");
		AddressText.setText("");
	}
}
