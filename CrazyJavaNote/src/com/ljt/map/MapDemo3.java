package com.ljt.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo3 {
public static void main(String[] args) {
	HashMap<Student,String> map = new HashMap<>();
	map.put(new Student("a ",23 ),"北京");
	map.put(new Student("b ",26 ),"北京");
	map.put(new Student("c ",21 ),"北京");
	//Set<Entry<Student, String>> set = map.entrySet();
//	Iterator<Entry<Student, String>> it = set.iterator();
//	while(it.hasNext()){
//		Entry<Student, String> next = it.next();
//		String name = next.getKey().getName();
//		int age = next.getKey().getAge();
//		String value = next.getValue();
//		print(name+age+" 对应的地方是 "+value);
//	}
	
	Set<Student> set = map.keySet();
	Collection<String> values = map.values();
	Iterator<Student> it = set.iterator();
	while(it.hasNext()){
		String name = it.next().getName();
		int age = it.next().getAge();
		print(name+" 对应的年龄是 "+age);
	}
		
}
public static void print(Object object){
	System.out.println(object);
}
}
class Student{
	private String name;
	private int age;
	Student(String name,int age){
		this.name=name;
		this.age=age;
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
	
}
