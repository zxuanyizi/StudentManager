package com.zxc.service;

import java.util.ArrayList;

import com.zxc.bean.Student;

public class StudentService {
	private ArrayList<Student> stuList = new ArrayList<Student>();
	public StudentService() {
		Student stu1 = new Student(1, "����", "1��");
		Student stu2 = new Student(2, "����", "2��");
		Student stu3 = new Student(3, "����", "2��");
		Student stu4 = new Student(4, "����", "1��");
		Student stu5 = new Student(5, "����", "3��");
		Student stu6 = new Student(6, "���", "1��");
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
		stuList.add(stu4);
		stuList.add(stu5);
		stuList.add(stu6);
	}

	public boolean addStudent(Student stu) {
		return stuList.add(stu);
	}

	public ArrayList<Student> getAllStudent(){
		return stuList.size()>0?stuList:null;
	}

	public Student getStudentById(int id) {
		for (Student student : stuList) {
			if(student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	public boolean deleteStudent(Student stu) {
		return stuList.remove(stu);
	}
	public ArrayList<Student> getStudentByClass(String className) {
		ArrayList<Student> classList = new ArrayList<Student>();
		for (int i = 0; i < stuList.size(); i++) {
			if(stuList.get(i).getClassName().equals(className)) {
				classList.add(stuList.get(i));
			}
		}
		return classList.size() == 0 ? null : classList;
	}
}
