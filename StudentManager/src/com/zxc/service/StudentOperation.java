package com.zxc.service;

import java.util.Arrays;

import com.zxc.bean.Student;

public class StudentOperation {
	private Student stuList[] = new Student[10];
	private int count = 0;
	public StudentOperation() {
		Student stu1 = new Student(1, "张三", "1班");
		Student stu2 = new Student(2, "李四", "2班");
		Student stu3 = new Student(3, "王五", "2班");
		Student stu4 = new Student(4, "赵六", "1班");
		Student stu5 = new Student(5, "田七", "3班");
		Student stu6 = new Student(6, "杨八", "1班");
		stuList[0] = stu1;
		stuList[1] = stu2;
		stuList[2] = stu3;
		stuList[3] = stu4;
		stuList[4] = stu5;
		stuList[5] = stu6;
		count = 6;
	}

	public boolean addStudent(Student stu) {
		if(stu == null) {
			return false;
		}
		if(count == stuList.length) {
			stuList = Arrays.copyOf(stuList, stuList.length*2);
		}
		stuList[count] = stu;
		count ++;
		return true;
	}

	public Student[] getAllStudent() {
		if(count>0) {
			Student stus[] = Arrays.copyOf(stuList, count);
			return stus;
		}else {
			return null;
		}
	}

	public Student getStudentById(int id) {
		for (int i = 0; i < count; i++) {
			if(stuList[i].getId() == id) {
				return stuList[i];
			}
		}
		return null;
	}

	public boolean deleteStudent(Student stu) {
		//先找到要被删除的元素在数组中的索引位置
		int index = -1;
		for (int i = 0; i < count; i++) {
			if(stuList[i].equals(stu)) {
				index = i;
			}
		}
		//如果索引值大于-1 则意味着找到了那个要被删除的元素
		if(index >= 0) {
			//进行数组的向前位移操作
			for (int i = index; i <count; i++) {
				stuList[i] = stuList[i+1];
			}
			count--;
			return true;
		}

		return false;
	}

	/**
	 *   	按照班级查找学生
	 * @return
	 */
	public Student[] getStudentByClass(String className) {
		//在Java中数组在声明时，必须有明确的长度，因此就会导致按照班级名称获取班级时使用数组非常繁琐！！！！

		//第一步：根据班级名称查找出在学生数组有多个同班同学
		int stuCount = 0;
		for (int i = 0; i < count; i++) {
			if(stuList[i].getClassName().equals(className)) {
				stuCount++;
			}
		}
		if(stuCount == 0) {
			return null;
		}
		//第二步：可以创建同一班级的学生数组
		Student stus[] = new Student[stuCount];
		//第三步：将原有数组中同一班级的学生依次添加到新数组中
		for(int i=0,j=0;i<count;i++) {
			if(stuList[i].getClassName().equals(className)) {
				stus[j] = stuList[i];
				j++;
			}
		}
		return stus;
	}

}
