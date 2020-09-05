package com.aiit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.aiit.dao.StudentDao;
import com.aiit.model.Student;
import com.aiit.utils.DBUtils;
import com.aiit.utils.StringUtils;

public class StudentDaoImpl implements StudentDao {

	public  static boolean result=false;
	//添加学生的数据库操作
	@Override
	public int addStudent(Student stu) {
		Connection con =null;
		PreparedStatement pstat=null;
		String sql="insert into student (id,name,sex,age,cls,phone,address) values(id,?,?,?,?,?,?)";
		int i=0;
		try {
			con=DBUtils.getConnection();
			pstat=con.prepareStatement(sql);
			pstat.setString(1,stu.getName());
			pstat.setString(2,stu.getSex());
			pstat.setInt(3,stu.getAge());
			pstat.setString(4,stu.getCls());
			pstat.setString(5,stu.getPhone());
			pstat.setString(6, stu.getAddress());
			
			i=pstat.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(con, pstat, null);
		}
		
		return i;
	}

	/**
	 * 显示所有学生的数据库操作
	 */
	@Override
	public List<Vector> selectAll(Student stu) {
		Connection con=null;
		PreparedStatement pstat=null;
		ResultSet res=null;
		StringBuffer sql=new StringBuffer("select * from student where 1=1");
		List<Vector> list=new ArrayList<Vector>();
		
		try {
			con=DBUtils.getConnection();
			if(!StringUtils.isEmpty(stu.getName())) {
				sql.append(" and name like '%"+stu.getName()+"%'" );
			}
			pstat=con.prepareStatement(sql.toString());
			res=pstat.executeQuery();
			while(res.next()) {
				Vector v=new Vector();
				v.add(res.getInt(1));//id
				v.add(res.getString(2));//name
				v.add(res.getString(3));//sex
				v.add(res.getInt(4));//age
				v.add(res.getString(5));//cls
				v.add(res.getString(6));//phone
				v.add(res.getString(7));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(con, pstat, res);
		}
		
		return list;
	}

	//修改学生信息的数据库操作
	@Override
	public int updateStudent(Student stu) {
		Connection con=null;
		PreparedStatement pstat=null;
		String sql="update student set name=?,sex=?,age=?,cls=?,phone=?,address=? where id=? ";
		int i=0;
		try {
			con=DBUtils.getConnection();
			pstat=con.prepareStatement(sql);
			pstat.setString(1, stu.getName());
			pstat.setString(2, stu.getSex());
			pstat.setInt(3, stu.getAge());
			pstat.setString(4, stu.getCls());
			pstat.setString(5, stu.getPhone());
			pstat.setString(6, stu.getAddress());
			pstat.setInt(7, stu.getId());
			i=pstat.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(con, pstat, null);
		}
		return i;
	}

	//删除学生信息的数据库操作
	@Override
	public int deleteStudent(Student stu) {
		
		Connection con=null;
		PreparedStatement pstat=null;
		String sql="delete from student where id =?";
		int i=0;
		try {
			con=DBUtils.getConnection();
			pstat=con.prepareStatement(sql);
			pstat.setInt(1, stu.getId());
			i=pstat.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(con, pstat, null);
		}
		return i;
	}

	//从Excl中保存数据到数据库
	@Override
	public void saveStudent(Student student) {
		result=false;
		 Connection connection=null;
	        PreparedStatement preparedStatement=null;
	        String sql="insert into student (name,sex,age,cls,phone,address) values(?,?,?,?,?,?)";
	        try {
	            connection= DBUtils.getConnection();
	            preparedStatement=connection.prepareStatement(sql);
	            preparedStatement.setString(1,student.getName());
	            preparedStatement.setString(2, student.getSex());
	            preparedStatement.setInt(3,student.getAge());
	            preparedStatement.setString(4,student.getCls() );
	            preparedStatement.setString(5,student.getPhone());
	            preparedStatement.setString(6,student.getAddress());
	            int i=preparedStatement.executeUpdate();
	            if(i>0) {
	            	result=true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	//查询数据库中所有学生保存到Excel
	@Override
	public List<Student> selectAll() {
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from student";
        List<Student> list=new ArrayList<Student>();
        Student student=null;
        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
               int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String sex=resultSet.getString("sex");
                int age=resultSet.getInt("age");
                String cls=resultSet.getString("cls");
                String phone=resultSet.getString("phone");
                String address=resultSet.getString("address");
                student=new Student(id,name,sex,age,cls,phone,address);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
	}

}
