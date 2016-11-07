package com.ljt.oop;

public class Test6 {
	private String name;
	private int age;
	
	public Test6() {
		this("haha");
		System.out.println("name="+name+"age="+age);
	 }
	public Test6(String name) {
		super();
		this.name = name;
		System.out.println("name="+name+"age="+age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static void main(String[] args) {
	Test6 test5 = new Test6();
	Test6 test6 = new Test6("12");
	print(test5);
	print(test6);
	
}
public static void print(Object obj){
	System.out.println(obj);
}
}
