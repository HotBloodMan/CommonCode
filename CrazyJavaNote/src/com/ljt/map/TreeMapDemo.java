package com.ljt.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
public static void main(String[] args) {
		TreeMap<Student, Object> map = new TreeMap<>(new Comp());
		map.put(new Student("aa ",23 ),"北京");
		map.put(new Student("ggb ",26 ),"北京");
		map.put(new Student("cr ",21 ),"北京");
		map.put(new Student("tc ",21 ),"北京");
		Set<Entry<Student, Object>> set = map.entrySet();
		Iterator<Entry<Student, Object>> it = set.iterator();
		while(it.hasNext()){
			Entry<Student, Object> next = it.next();
			Student key = next.getKey();
			String value = (String) next.getValue();
			print(key.getName()+" 对应的是 "+value);
		}
	
}
public static void print(Object object){
	System.out.println(object);
}
}
class Comp implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		int num = (o1.getName()).compareTo(o2.getName());
		if(num==0){
			return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
		}
		return num;
	}
	
}
//class Student{
//	private String name;
//	private int age;
//	Student(String name,int age){
//		this.name=name;
//		this.age=age;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//}

