package com.aiit.service.impl;

import java.util.List;
import java.util.Vector;

import com.aiit.dao.StudentDao;
import com.aiit.dao.impl.StudentDaoImpl;
import com.aiit.model.Student;
import com.aiit.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDao dao=new StudentDaoImpl();
	
	@Override
	public int addStudent(Student stu) {
		return dao.addStudent(stu);
	}

	//显示所有学生
	@Override
	public List<Vector> selectAll(Student stu) {
		// TODO Auto-generated method stub
		return dao.selectAll(stu);
	}

	//修改学生信息
	@Override
	public int updateStudent(Student stu) {
		
		return dao.updateStudent(stu);
	}

	//删除学生信息
	@Override
	public int deleteStudent(Student stu) {
		
		return dao.deleteStudent(stu);
	}

	@Override
	public void saveStudent(List<Student> students) {
		 for (Student student : students) {
	            dao.saveStudent(student);
	        }
		
	}

	//查询所有信息
	@Override
	public List<Student> selectAll() {
		return dao.selectAll();
	}

}
