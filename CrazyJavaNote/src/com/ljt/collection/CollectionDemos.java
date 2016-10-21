package com.ljt.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemos {
public static void main(String[] args) {
	ArrayList list = new ArrayList();
	list.add("t1");
	list.add("t2");
	list.add("t3");
	list.add("t4");
//	Iterator it = list.iterator();
//	while(it.hasNext()){
//		String s =(String) it.next();
//		sop(s);
//	}
	for(Iterator it=list.iterator();it.hasNext();){
		sop(it.next());
	}
}
public static void sop(Object obj)
{
	System.out.println(obj);
}
}
