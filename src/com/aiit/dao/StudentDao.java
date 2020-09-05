package com.aiit.dao;

import java.util.List;
import java.util.Vector;

import com.aiit.model.Student;

public interface StudentDao {

	int addStudent(Student stu);

	List<Vector> selectAll(Student stu);

	int updateStudent(Student stu);

	int deleteStudent(Student stu);

	void saveStudent(Student student);

	List<Student> selectAll();

}
