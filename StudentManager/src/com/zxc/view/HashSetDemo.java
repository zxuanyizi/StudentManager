package com.zxc.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.zxc.bean.Student;

public class HashSetDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Student> stuSet = new HashSet<Student>();
		Student stu1 = new Student(1, "张三", "1班");
		Student stu2 = new Student(2, "李四", "2班");
		Student stu3 = new Student(3, "王五", "2班");
		Student stu4 = new Student(4, "赵六", "1班");
		Student stu5 = new Student(5, "田七", "3班");
		Student stu6 = new Student(6, "杨八", "1班");
		stuSet.add(stu1);
		stuSet.add(stu2);
		stuSet.add(stu3);
		stuSet.add(stu4);
		stuSet.add(stu5);
		stuSet.add(stu6);
		showAll(stuSet);
		stuSet.add(stu4);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		showAll(stuSet);
		ArrayList<Student> stuList = new ArrayList<Student>();
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
		stuList.add(stu4);
		stuList.add(stu5);
		stuList.add(stu6);
		stuList.add(stu3);
		System.out.println("-------------------ArrayList对比--------------------------");
		Iterator<Student> it = stuList.iterator();
		for (Student student : stuList) {
			System.out.println(student.toString());
		}

	}

	public static void showAll(HashSet<Student> set) {
		Iterator<Student> it = set.iterator();
		while(it.hasNext()) {
			Student s = it.next();
			System.out.println(s);
		}
	}

}
