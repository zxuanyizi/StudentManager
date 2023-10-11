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
		Student stu1 = new Student(1, "张三", "1班");
		Student stu2 = new Student(9, "李四", "2班");
		Student stu3 = new Student(13, "王五", "2班");
		Student stu4 = new Student(34, "赵六", "1班");
		Student stu5 = new Student(15, "田七", "3班");
		Student stu6 = new Student(6, "杨八", "1班");
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
		stuList.add(stu4);
		stuList.add(stu5);
		stuList.add(stu6);
		System.out.println("stuList集合中目前有"+stuList.size()+"个元素");
		Student s1 = new Student(26, "高子昂", "软件3班");
		stuList.add(2, s1);
		showAll(stuList);
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(31, "苏永灿", "软件3班"));
		list.add(new Student(6, "王铎", "软件3班"));
		list.add(new Student(21, "朱通", "软件3班"));
		//将list集合追加到stuList集合的末尾
//		stuList.addAll(list);
		//在指定的位置添加一个集合
		stuList.addAll(4, list);

		showAll(stuList);

		System.out.println("索引3的元素是："+stuList.get(3));


	}

	public static void showAll(ArrayList<Student> list) {
		System.out.println("------------------------------");
		for (Student student : list) {
			System.out.println(student.toString());
		}
		System.out.println("------------------------------");
	}

}
