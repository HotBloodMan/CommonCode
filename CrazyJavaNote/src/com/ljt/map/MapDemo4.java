package com.ljt.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo4 {
public static void main(String[] args) {
	HashMap<String,String> map = new HashMap<>();
	map.put("a","3");
	map.put("a","4");
	map.put("b","4");
	map.put("f","5");
	map.put("d","6");
//	Map<Student,String> map = new HashMap<>();
//	map.put(new Student("a1",25),"beijing");
//	map.put(new Student("a2",20),"beijing");
//	map.put(new Student("c1",29),"beijing");
	
	Set<String> set = map.keySet();
	Iterator<String> it = set.iterator();
	while(it.hasNext()){
		String k = it.next();
		String v = map.get(k);
		print(k+" 对应的值是  "+v);
	}
	
	
}
public static void print(Object obj){
	System.out.println(obj);
}
}
//class Student{
//	private String name;
//	private int age;
//	
//	public Student(String name, int age) {
//		super();
//		this.name = name;
//		this.age = age;
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
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (age != other.age)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
//}
