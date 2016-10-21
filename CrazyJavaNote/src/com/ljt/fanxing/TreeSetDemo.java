package com.ljt.fanxing;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
public static void main(String[] args) {
	TreeSet<String> set = new TreeSet<String>(new LiComparator());
	set.add("aa");
	set.add("ggd");
	set.add("a");
	set.add("cc");
	
	Iterator<String> it = set.iterator();
	while(it.hasNext()){
		String next = it.next();
		System.out.println("next="+next);
	}
	
}
}
class LiComparator implements Comparator<String>{
	
	@Override
	public int compare(String o1, String o2) {
		int t = (new Integer(o1.length())).compareTo(new Integer(o2.length()));
		if(t==0){
			return o1.compareTo(o2);
		}
		return t;
	}
	
}
