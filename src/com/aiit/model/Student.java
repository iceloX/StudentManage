package com.aiit.model;

/**
 * 学生实体类
 * @author icelo
 *
 */
public class Student {
	
	private int id;
	private String name;
	private String sex;
	private int age;
	private String cls;
	private String phone;
	private String address;
	
	public Student(int id, String name, String sex, int age, String cls, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.cls = cls;
		this.phone = phone;
		this.address = address;
	}
	
	
	public Student(String name, String sex, int age, String cls, String phone, String address) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.cls = cls;
		this.phone = phone;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student() {
		super();
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", cls=" + cls + ", phone="
				+ phone + ", address=" + address + "]";
	}
	
	

}
