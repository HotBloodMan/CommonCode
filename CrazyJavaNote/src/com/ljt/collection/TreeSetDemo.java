package com.ljt.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
public static void main(String[] args) {
	TreeSet set = new TreeSet(new Compator());
	set.add("aa");
	set.add("adc");
	set.add("edf");
	set.add("bct");
	Iterator it = set.iterator();
	while(it.hasNext()){
		Object next = it.next();
		System.out.println(next);
	}
}
}
class Compator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int num=new Integer(o1.length()).compareTo(new Integer(o2.length()));
		if(num==0){
			return o1.compareTo(o2);
		}
		return num;
	}
	
}
