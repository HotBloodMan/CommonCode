package com.ljt.oop;

public class Student extends Study implements Smoke{

	@Override
	public void smoke() {
		System.out.println("ѧ��ѧ���˳���");
	}

	@Override
	void study() {
		System.out.println("ѧ����ʼѧϰ��");
	}
	public static void main(String[] args) {
		Student st = new Student();
		st.smoke();
		st.study();
	}

}
