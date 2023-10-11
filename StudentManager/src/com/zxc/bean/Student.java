package com.zxc.bean;

public class Student {

	private int id;
	private String stuName;
	private String className;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String stuName, String className) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.className = className;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + id;
		result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof Student) {
			Student stu = (Student)obj;
			if(this.id == stu.getId() && this.stuName.equals(stu.getStuName())&&this.className.equals(stu.className)) {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	@Override
	public String toString() {
		return "学生信息 [学号=" + id + ", 姓名=" + stuName + ", 班级名称=" + className + "]";
	}



}
