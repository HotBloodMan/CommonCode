package com.ljt.oop;

public class Student extends Study implements Smoke{

	@Override
	public void smoke() {
		System.out.println("学生学会了抽烟");
	}

	@Override
	void study() {
		System.out.println("学生开始学习了");
	}
	public static void main(String[] args) {
		Student st = new Student();
		st.smoke();
		st.study();
	}

}
