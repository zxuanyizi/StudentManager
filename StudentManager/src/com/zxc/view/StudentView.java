package com.zxc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.zxc.bean.Student;
import com.zxc.service.StudentService;

public class StudentView {

	Scanner sc = new Scanner(System.in);
	StudentService operation = new StudentService();
	public StudentView() {
		System.out.println("**********************************************");
		System.out.println("********* \t 欢迎使用学生信息管理系统 \t  ************");
		System.out.println("**********************************************");
	}

	public void mainMenu() {
		int choose = 0;
		do {
			System.out.println("1. 查看所有学生信息");
			System.out.println("2. 按照班级查看学生信息");
			System.out.println("3. 添加学生信息");
			System.out.println("4. 根据学生编号删除学生信息");
			System.out.println("5. 退出系统 ");
			System.out.println("请输入您选择的功能：");
			choose = sc.nextInt();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			switch (choose) {
			case 1:
				showAllStudent();
				break;
			case 2:
				selectStudentByClass();
				break;
			case 3:
				insertStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				System.out.println("谢谢使用");
				System.exit(0);
				break;
			default:
				break;
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		} while (choose!=5);
	}

	private void deleteStudent() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要删除的学生学号：");
		int id = sc.nextInt();
		Student stu = operation.getStudentById(id);
		if(stu == null) {
			System.out.println("您要删除的学号不存在");
		}else {
			if(operation.deleteStudent(stu)) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		}
	}

	private void insertStudent() {
		// TODO Auto-generated method stub
		Student stu = new Student();
		System.out.println("请输入学生的学号：");
		stu.setId(sc.nextInt());
		System.out.println("请输入学生姓名：");
		stu.setStuName(sc.next());
		System.out.println("请输入学生所在班级：");
		stu.setClassName(sc.next());
		if(operation.addStudent(stu)) {
			System.out.println(stu.getStuName()+"注册成功");
		}else {
			System.out.println("注册失败！");
		}
	}

	private void selectStudentByClass() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要查看的班级名称：");
		String className = sc.next();
		ArrayList<Student> stuList = operation.getStudentByClass(className);
		if(stuList != null) {
			for (Student student : stuList) {
				System.out.println(student.toString());
			}
		}else {
			System.out.println("您要查看的班级目前没有学生信息");
		}
	}

	private void showAllStudent() {
		// TODO Auto-generated method stub
		ArrayList<Student>  stuList = operation.getAllStudent();
		if(stuList != null) {
			for (Student student : stuList) {
				System.out.println(student.toString());
			}
		}else {
			System.out.println("当前系统目前没有学生信息");
		}
	}
}
