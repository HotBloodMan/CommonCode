package com.ljt.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
public static void main(String[] args) {
	HashSet set = new HashSet();
	set.add("a");
	set.add("d");
	set.add("c");
	print(set);
	Iterator it = set.iterator();
	while(it.hasNext()){
		String s = (String) it.next();
		print(s);
		if(s.contains("d")){
			print("��ѡ����ȷ��");
		}
	}
}
public static void print(Object obj){
	System.out.println(obj);
}
}
