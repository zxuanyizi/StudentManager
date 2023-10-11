package com.zxc.service;

import java.util.Arrays;

import com.zxc.bean.Student;

public class StudentOperation {
	private Student stuList[] = new Student[10];
	private int count = 0;
	public StudentOperation() {
		Student stu1 = new Student(1, "����", "1��");
		Student stu2 = new Student(2, "����", "2��");
		Student stu3 = new Student(3, "����", "2��");
		Student stu4 = new Student(4, "����", "1��");
		Student stu5 = new Student(5, "����", "3��");
		Student stu6 = new Student(6, "���", "1��");
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
		//���ҵ�Ҫ��ɾ����Ԫ���������е�����λ��
		int index = -1;
		for (int i = 0; i < count; i++) {
			if(stuList[i].equals(stu)) {
				index = i;
			}
		}
		//�������ֵ����-1 ����ζ���ҵ����Ǹ�Ҫ��ɾ����Ԫ��
		if(index >= 0) {
			//�����������ǰλ�Ʋ���
			for (int i = index; i <count; i++) {
				stuList[i] = stuList[i+1];
			}
			count--;
			return true;
		}

		return false;
	}

	/**
	 *   	���հ༶����ѧ��
	 * @return
	 */
	public Student[] getStudentByClass(String className) {
		//��Java������������ʱ����������ȷ�ĳ��ȣ���˾ͻᵼ�°��հ༶���ƻ�ȡ�༶ʱʹ������ǳ�������������

		//��һ�������ݰ༶���Ʋ��ҳ���ѧ�������ж��ͬ��ͬѧ
		int stuCount = 0;
		for (int i = 0; i < count; i++) {
			if(stuList[i].getClassName().equals(className)) {
				stuCount++;
			}
		}
		if(stuCount == 0) {
			return null;
		}
		//�ڶ��������Դ���ͬһ�༶��ѧ������
		Student stus[] = new Student[stuCount];
		//����������ԭ��������ͬһ�༶��ѧ��������ӵ���������
		for(int i=0,j=0;i<count;i++) {
			if(stuList[i].getClassName().equals(className)) {
				stus[j] = stuList[i];
				j++;
			}
		}
		return stus;
	}

}
