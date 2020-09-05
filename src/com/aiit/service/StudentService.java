package com.aiit.service;

import java.util.List;
import java.util.Vector;

import com.aiit.model.Student;

public interface StudentService {

	int addStudent(Student stu);

	List<Vector> selectAll(Student stu);

	int updateStudent(Student stu);

	int deleteStudent(Student stu);

	void saveStudent(List<Student> students);

	List<Student> selectAll();

}
