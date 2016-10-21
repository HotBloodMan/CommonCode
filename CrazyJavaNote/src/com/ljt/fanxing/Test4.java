package com.ljt.fanxing;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Test4 {
public static void main(String[] args) {
	TreeSet<String> set = new TreeSet<>(new Compare());
	set.add("bcdfd");
	set.add("aa");
	set.add("avdffd");
	set.add("ac");
	Iterator<String> it = set.iterator();
	while(it.hasNext()){
		String is = it.next();
		System.out.println("is---"+is.toString());
	}
}
}
class Compare implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		int num=(new Integer(o2.length())).compareTo(new Integer(o1.length()));
		if(num==0){
			return o2.compareTo(o1);
		}
		return num;
	}
	
}