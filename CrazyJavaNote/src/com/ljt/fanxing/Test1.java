package com.ljt.fanxing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {
public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
//	Iterator<String> it = list.iterator();
//	while(it.hasNext()){
//		String next = it.next();
//		sop(next);
//	}
	for(Iterator<String> it=list.iterator();it.hasNext();){
		sop(it.next());
	}
}

private static void sop(String next) {
	// TODO Auto-generated method stub
	System.out.println(next);
}
}
