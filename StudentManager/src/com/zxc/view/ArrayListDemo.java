package com.zxc.view;

import java.util.ArrayList;

import com.zxc.bean.Student;

public class ArrayListDemo {

	public ArrayListDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> stuList = new ArrayList<Student>();
		Student stu1 = new Student(1, "����", "1��");
		Student stu2 = new Student(9, "����", "2��");
		Student stu3 = new Student(13, "����", "2��");
		Student stu4 = new Student(34, "����", "1��");
		Student stu5 = new Student(15, "����", "3��");
		Student stu6 = new Student(6, "���", "1��");
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
		stuList.add(stu4);
		stuList.add(stu5);
		stuList.add(stu6);
		System.out.println("stuList������Ŀǰ��"+stuList.size()+"��Ԫ��");
		Student s1 = new Student(26, "���Ӱ�", "���3��");
		stuList.add(2, s1);
		showAll(stuList);
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(31, "������", "���3��"));
		list.add(new Student(6, "����", "���3��"));
		list.add(new Student(21, "��ͨ", "���3��"));
		//��list����׷�ӵ�stuList���ϵ�ĩβ
//		stuList.addAll(list);
		//��ָ����λ�����һ������
		stuList.addAll(4, list);

		showAll(stuList);

		System.out.println("����3��Ԫ���ǣ�"+stuList.get(3));


	}

	public static void showAll(ArrayList<Student> list) {
		System.out.println("------------------------------");
		for (Student student : list) {
			System.out.println(student.toString());
		}
		System.out.println("------------------------------");
	}

}
