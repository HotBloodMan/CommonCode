package com.ljt.fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test5 {
	
	public static void print(Collection<?> a1){
		Iterator<?> it = a1.iterator();
		while(it.hasNext()){
			Student next = (Student)it.next();
			System.out.println(next.getName());
		}
	}
	
public static void main(String[] args) {
	ArrayList<Student> st = new ArrayList<Student>();
	st.add(new Student("B1"));
	st.add(new Student("C1"));
	st.add(new Student("AA1"));
	st.add(new Student("BDF1"));
//	print(st);
	Test5 t5 = new Test5();
	t5.print(st);
	
	List<Integer> list = new ArrayList<Integer>();
	list.add(3);
	list.add(2);
	list.add(6);
	print(list);
}
}
class Person{
	
	
	private String name;
	Person(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class Student extends Person{
	Student(String name){
		super(name);
	}
}
