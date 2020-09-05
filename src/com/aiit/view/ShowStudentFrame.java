package com.aiit.view;

/**
 * 查看学生面板
 */
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.aiit.model.Student;
import com.aiit.service.StudentService;
import com.aiit.service.impl.StudentServiceImpl;
import com.aiit.utils.Helper;
import com.aiit.utils.MsgConstant;
import com.aiit.utils.StringUtils;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowStudentFrame extends JInternalFrame {
	private JTextField selectNameText;
	private JTable table;
	private JTextField IdText;
	private JTextField NameText;
	private JTextField AgeText;
	private JTextField ClsText;
	private JTextField PhoneText;
	private JTextField AddressText;
	private JComboBox SexBox;

	StudentService ss = new StudentServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowStudentFrame frame = new ShowStudentFrame();
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
	public ShowStudentFrame() {
		setBackground(SystemColor.inactiveCaption);
		setFrameIcon(new ImageIcon(ShowStudentFrame.class.getResource("/img/admin.png")));
		setClosable(true);
		setTitle("学生信息");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screen=tk.getScreenSize();
		int screen_width=screen.width;
		int screen_height=screen.height;
		setBounds((screen_width-719)/2, (screen_height-700)/2, 719, 700);

		JLabel lblNewLabel = new JLabel("查找学生：");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));

		selectNameText = new JTextField();
		selectNameText.setFont(new Font("黑体", Font.BOLD, 15));
		selectNameText.setColumns(10);

		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Helper.hintshowMessage("搜索到已下信息", null);
				String name = selectNameText.getText();
				if (StringUtils.isEmpty(name)) {
					fillTable(new Student());
				} else {
					Student stu = new Student();
					stu.setName(name);
					fillTable(stu);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(ShowStudentFrame.class.getResource("/img/搜索--1 (1).png")));
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("个人信息：");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 25));
		lblNewLabel_1.setIcon(new ImageIcon(ShowStudentFrame.class.getResource("/img/学生 (1).png")));

		JLabel lblNewLabel_2 = new JLabel("学号：");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));

		IdText = new JTextField();
		IdText.setEditable(false);
		IdText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		IdText.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("姓名：");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.BOLD, 15));

		NameText = new JTextField();
		NameText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		NameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("");

		JLabel lblNewLabel_2_2 = new JLabel("性别：");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.BOLD, 15));

		SexBox = new JComboBox();
		SexBox.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		SexBox.setModel(new DefaultComboBoxModel(new String[] { "男", "女" }));

		JLabel lblNewLabel_2_3 = new JLabel("年龄：");
		lblNewLabel_2_3.setFont(new Font("宋体", Font.BOLD, 15));

		JLabel lblNewLabel_2_4 = new JLabel("班级：");
		lblNewLabel_2_4.setFont(new Font("宋体", Font.BOLD, 15));

		AgeText = new JTextField();
		AgeText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		AgeText.setColumns(10);

		ClsText = new JTextField();
		ClsText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		ClsText.setColumns(10);

		JLabel lblNewLabel_2_3_1 = new JLabel("手机：");
		lblNewLabel_2_3_1.setFont(new Font("宋体", Font.BOLD, 15));

		PhoneText = new JTextField();
		PhoneText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		PhoneText.setColumns(10);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("地址：");
		lblNewLabel_2_3_1_1.setFont(new Font("宋体", Font.BOLD, 15));

		AddressText = new JTextField();
		AddressText.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		AddressText.setColumns(10);

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				updateStudentAction(event);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		//btnNewButton_1.setIcon(new ImageIcon(ShowStudentFrame.class.getResource("/img/修 改1.png")));

		JButton btnNewButton_1_1 = new JButton("删除");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				deleteStudentAction(event);
			}
		});
		//btnNewButton_1_1.setIcon(new ImageIcon(ShowStudentFrame.class.getResource("/img/删 除 copy 2.png")));
		btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(51)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2_3_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2))
								.addGroup(groupLayout.createSequentialGroup().addGap(61)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnNewButton_1)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 48,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(SexBox, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(29)))
										.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_3).addComponent(lblNewLabel_2_3_1,
														GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addComponent(IdText, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(NameText, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(AgeText, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblNewLabel_2_4, GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(ClsText, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 96,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(AddressText, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 273,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(152))
				.addGroup(groupLayout.createSequentialGroup().addGap(110).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(selectNameText, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnNewButton).addContainerGap(194, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(20)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(85, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(70)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(selectNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel).addComponent(btnNewButton))
				.addGap(40).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(IdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(NameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(AgeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_4, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(ClsText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(SexBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_3_1, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_3_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
				.addGap(29)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(29, Short.MAX_VALUE)));

		table = new JTable();
		table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = table.getSelectedRow();// 获取选择的行号
				Object id = table.getValueAt(row, 0);// 学号
				Object name = table.getValueAt(row, 1);// 姓名
				Object sex = table.getValueAt(row, 2);// 性别
				Object age = table.getValueAt(row, 3);// 年龄
				Object cls = table.getValueAt(row, 4);// 班级
				Object phone = table.getValueAt(row, 5);// 手机
				Object address = table.getValueAt(row, 6);// 地址

				IdText.setText(id.toString());
				NameText.setText(name.toString());

				if (sex.toString().equals("男")) {
					SexBox.setSelectedIndex(0);
				} else {
					SexBox.setSelectedIndex(1);
				}

				AgeText.setText(age.toString());
				ClsText.setText(cls.toString());
				PhoneText.setText(phone.toString());
				AddressText.setText(address.toString());
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u5B66\u53F7", "\u59D3\u540D",
				"\u6027\u522B", "\u5E74\u9F84", "\u73ED\u7EA7", "\u624B\u673A", "\u5730\u5740" }) {
			/**
					 * 
					 */
					private static final long serialVersionUID = -9102325233296661968L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		// 查询数据并填充表格
		fillTable(new Student());
	}

	/**
	 * 删除学生信息
	 * 
	 * @param event
	 */
	protected void deleteStudentAction(ActionEvent event) {
		if (StringUtils.isEmpty(IdText.getText())) {
			Helper.hintshowMessage(MsgConstant.ONLY_SELECT_ONE, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.ONLY_SELECT_ONE);
			return;
		} else {
			int id = Integer.parseInt(IdText.getText());
			String name = NameText.getText();
			String sex = "男";
			int selected = SexBox.getSelectedIndex();
			if (selected == 1) {
				sex = "女";
			}
			int age = Integer.parseInt(AgeText.getText());
			String cls = ClsText.getText();
			String phone = PhoneText.getText();
			String address = AddressText.getText();
			Student stu = new Student(id, name, sex, age, cls, phone, address);
			int i=Helper.hintConfirmMessage(MsgConstant.SURE_DELETE, null);
			//int i = JOptionPane.showConfirmDialog(null, MsgConstant.SURE_DELETE);
			if (i == 0) {
				int result = ss.deleteStudent(stu);
				if (result != 0) {
					fillTable(new Student());
					Helper.hintshowMessage(MsgConstant.OK_DELETE, null);
					//JOptionPane.showMessageDialog(null, MsgConstant.OK_DELETE);
					return;
				} else {
					Helper.hintshowMessage(MsgConstant.ERRO_DELETE, null);
					//JOptionPane.showMessageDialog(null, MsgConstant.ERRO_DELETE);
					return;
				}
			}
		}
	}

	/**
	 * 修改学生信息
	 * 
	 * @param event
	 */
	protected void updateStudentAction(ActionEvent event) {
		if (StringUtils.isEmpty(IdText.getText())) {
			Helper.hintshowMessage(MsgConstant.ONLY_SELECT_ONE, null);
			//JOptionPane.showMessageDialog(null, MsgConstant.ONLY_SELECT_ONE);
			return;
		} else {
			int id = Integer.parseInt(IdText.getText());
			String name = NameText.getText();
			String sex = "男";
			int selected = SexBox.getSelectedIndex();
			if (selected == 1) {
				sex = "女";
			}
			String ageStr = AgeText.getText();
			String cls = ClsText.getText();
			String phone = PhoneText.getText();
			String address = AddressText.getText();

			if (StringUtils.isEmpty(name)) {
				Helper.hintshowMessage(MsgConstant.NAME_NOT_NULL, null);
				//JOptionPane.showMessageDialog(null, MsgConstant.NAME_NOT_NULL);
				return;
			}
			if (StringUtils.isEmpty(sex)) {
				Helper.hintshowMessage(MsgConstant.SEX_NOT_NULL, null);
				//JOptionPane.showMessageDialog(null, MsgConstant.SEX_NOT_NULL);
				return;
			}
			if (StringUtils.isEmpty(ageStr)) {
				Helper.hintshowMessage(MsgConstant.AGE_NOT_NULL, null);
				//JOptionPane.showMessageDialog(null, MsgConstant.AGE_NOT_NULL);
				return;
			}
			if (!StringUtils.isAge(ageStr)) {
				Helper.hintshowMessage(MsgConstant.AGE_NOT_NULL, null);
				//JOptionPane.showMessageDialog(null, MsgConstant.AGE_ERRO);
				return;
			}
			int age = Integer.parseInt(ageStr);
			if (StringUtils.isEmpty(cls)) {
				Helper.hintshowMessage(MsgConstant.CLS_NOT_NULL, null);
				//JOptionPane.showMessageDialog(null,MsgConstant.CLS_NOT_NULL);
				return;
			}
			if (StringUtils.isEmpty(phone)) {
				Helper.hintshowMessage(MsgConstant.PHONE_NOT_NULL, null);
				//JOptionPane.showMessageDialog(null, MsgConstant.PHONE_NOT_NULL);
				return;
			}
			if (!StringUtils.isMobile(phone)) {
				Helper.hintshowMessage(MsgConstant.PHONE_ERRO, null);
				//JOptionPane.showMessageDialog(null, MsgConstant.PHONE_ERRO);
				return;
			}
			if (StringUtils.isEmpty(address)) {
				Helper.hintshowMessage(MsgConstant.ADDRESS_NOT_NULL, null);
				JOptionPane.showMessageDialog(null, MsgConstant.ADDRESS_NOT_NULL);
				return;
			}
			Student stu = new Student(id, name, sex, age, cls, phone, address);
			int i=Helper.hintConfirmMessage(MsgConstant.SURE_UPDATE, null);
			//int i = JOptionPane.showConfirmDialog(null, MsgConstant.SURE_UPDATE);
			if (i == 0) {
				int result = ss.updateStudent(stu);
				if (result != 0) {
					fillTable(new Student());
					Helper.hintshowMessage(MsgConstant.OK_UPDATE, null);
					//JOptionPane.showMessageDialog(null, MsgConstant.OK_UPDATE);
					return;
				} else {
					Helper.hintshowMessage(MsgConstant.ERRO_UPDATE, null);
					//JOptionPane.showMessageDialog(null, MsgConstant.ERRO_UPDATE);
					return;
				}

			} else {
				return;
			}
		}

	}

	public void fillTable(Student stu) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// 清空表格
		model.setRowCount(0);
		List<Vector> list = ss.selectAll(stu);// 当传入参数时能够搜索到
		for (Vector v : list) {
			model.addRow(v);
		}
	}
}
