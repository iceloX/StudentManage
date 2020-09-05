package com.aiit.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aiit.dao.impl.StudentDaoImpl;
import com.aiit.model.Student;
import com.aiit.service.StudentService;
import com.aiit.service.impl.StudentServiceImpl;
import com.aiit.utils.Helper;
import com.aiit.utils.MsgConstant;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class MoreActionFrame extends JInternalFrame {

	StudentService ss = new StudentServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoreActionFrame frame = new MoreActionFrame();
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
	public MoreActionFrame() {
		getContentPane().setBackground(SystemColor.textHighlight);
		getContentPane().setForeground(Color.BLUE);
		setClosable(true);
		setFrameIcon(new ImageIcon(MoreActionFrame.class.getResource("/img/admin.png")));
		setTitle("批量操作");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screen=tk.getScreenSize();
		int screen_width=screen.width;
		int screen_height=screen.height;
		setBounds((screen_width-450)/2, (screen_height-300)/2, 450, 300);

		JButton btnNewButton = new JButton("从资源管理器导入学生");
		btnNewButton.setIcon(new ImageIcon(MoreActionFrame.class.getResource("/img/导入.png")));
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fd = new JFileChooser();
				// fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fd.showOpenDialog(null);
				File f = fd.getSelectedFile();
				Student stu = null;
				if (f != null) {
					String path = f.getAbsolutePath();
					List<Student> students = save(path);
					ss.saveStudent(students);
					if (StudentDaoImpl.result) {
						Helper.hintshowMessage(MsgConstant.IMPORT_OK, null);
						//JOptionPane.showMessageDialog(null, MsgConstant.IMPORT_OK);
					}
				}
			}
		});

		JButton btnNewButton_1 = new JButton("导出学生到资源管理器");
		btnNewButton_1.setIcon(new ImageIcon(MoreActionFrame.class.getResource("/img/导 出.png")));
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				//JOptionPane.showMessageDialog(null, "请选择一个文件夹！");
				JFileChooser jf = new JFileChooser();
				jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
				jf.showDialog(null, null);
				File fi = jf.getSelectedFile();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
				Date date = new Date();
				String dateStr = sdf.format(date);
				String path = fi.getAbsolutePath() + "\\" + dateStr + "_学生导出表.xlsx";// 字符串拼接得到路径
				Student stu = null;
				List<Student> list = ss.selectAll();
				int i=Helper.hintConfirmMessage(MsgConstant.FILE_SAVE+path+MsgConstant.SURE_SAVE, null);
				//int i=JOptionPane.showConfirmDialog(null, MsgConstant.FILE_SAVE+path+MsgConstant.SURE_SAVE);
				if(i==0) {
					export(list, path);
					Helper.hintshowMessage(MsgConstant.OK_SAVE, null);
					//JOptionPane.showMessageDialog(null, MsgConstant.OK_SAVE);
					
				}else {
					return;
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(112, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(115))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(105)
					.addComponent(btnNewButton)
					.addGap(31)
					.addComponent(btnNewButton_1)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 导出学生文件函数
	 * 
	 * @param list 查询到的学生数据库信息集和
	 * @param path 文件保存的路径
	 */
	protected void export(List<Student> list, String path) {
		//创建文件薄
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		//创建文件表
		XSSFSheet sheet = xssfWorkbook.createSheet("学生");
		//第一行的文件头
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("编号");
		row.createCell(1).setCellValue("姓名");
		row.createCell(2).setCellValue("性别");
		row.createCell(3).setCellValue("年龄");
		row.createCell(4).setCellValue("班级");
		row.createCell(5).setCellValue("手机");
		row.createCell(6).setCellValue("地址");
		for (int i=0;i<list.size();i++){
            XSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(list.get(i).getId());
         row1.createCell(1).setCellValue(list.get(i).getName());
         row1.createCell(2).setCellValue(list.get(i).getSex());
         row1.createCell(3).setCellValue(list.get(i).getAge());
         row1.createCell(4).setCellValue(list.get(i).getCls());
         row1.createCell(5).setCellValue(list.get(i).getPhone());
         row1.createCell(6).setCellValue(list.get(i).getAddress());
        }
		
		try {
			 FileOutputStream f = new FileOutputStream(path);
			 xssfWorkbook.write(f);
	         f.flush();
	         xssfWorkbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	/**
	 * 导入数据函数实现
	 * 
	 * @param path 文件路径
	 * @return
	 */
	protected List<Student> save(String path) {
		List<Student> studentList = new ArrayList<Student>();
		try {
			// 获取工作簿
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(path);
			// 获取工作表
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);// 第一个工作表
			int lastRow = xssfSheet.getLastRowNum();
			for (int i = 1; i <= lastRow; i++) {
				XSSFRow row = xssfSheet.getRow(i);
				// 获取每一行，不为空的情况下，遍历每一个单元格
				if (row != null) {
					List<String> list = new ArrayList<String>();
					for (Cell cell : row) {
						if (cell != null) {
							cell.setCellType(CellType.STRING);// 设置格式
							String value = cell.getStringCellValue();
							if (value != null && !"".equals(value)) {
								list.add(value);
							}
						}
					}
					if (list.size() > 0) {
						Student student = new Student(list.get(0), list.get(1), Integer.parseInt(list.get(2)),
								list.get(3), list.get(4), list.get(5));
						studentList.add(student);
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}
}
