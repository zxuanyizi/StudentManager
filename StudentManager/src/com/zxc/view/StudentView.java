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
		System.out.println("********* \t ��ӭʹ��ѧ����Ϣ����ϵͳ \t  ************");
		System.out.println("**********************************************");
	}

	public void mainMenu() {
		int choose = 0;
		do {
			System.out.println("1. �鿴����ѧ����Ϣ");
			System.out.println("2. ���հ༶�鿴ѧ����Ϣ");
			System.out.println("3. ���ѧ����Ϣ");
			System.out.println("4. ����ѧ�����ɾ��ѧ����Ϣ");
			System.out.println("5. �˳�ϵͳ ");
			System.out.println("��������ѡ��Ĺ��ܣ�");
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
				System.out.println("ллʹ��");
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
		System.out.println("��������Ҫɾ����ѧ��ѧ�ţ�");
		int id = sc.nextInt();
		Student stu = operation.getStudentById(id);
		if(stu == null) {
			System.out.println("��Ҫɾ����ѧ�Ų�����");
		}else {
			if(operation.deleteStudent(stu)) {
				System.out.println("ɾ���ɹ�");
			}else {
				System.out.println("ɾ��ʧ��");
			}
		}
	}

	private void insertStudent() {
		// TODO Auto-generated method stub
		Student stu = new Student();
		System.out.println("������ѧ����ѧ�ţ�");
		stu.setId(sc.nextInt());
		System.out.println("������ѧ��������");
		stu.setStuName(sc.next());
		System.out.println("������ѧ�����ڰ༶��");
		stu.setClassName(sc.next());
		if(operation.addStudent(stu)) {
			System.out.println(stu.getStuName()+"ע��ɹ�");
		}else {
			System.out.println("ע��ʧ�ܣ�");
		}
	}

	private void selectStudentByClass() {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ�鿴�İ༶���ƣ�");
		String className = sc.next();
		ArrayList<Student> stuList = operation.getStudentByClass(className);
		if(stuList != null) {
			for (Student student : stuList) {
				System.out.println(student.toString());
			}
		}else {
			System.out.println("��Ҫ�鿴�İ༶Ŀǰû��ѧ����Ϣ");
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
			System.out.println("��ǰϵͳĿǰû��ѧ����Ϣ");
		}
	}
}
