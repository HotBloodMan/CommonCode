package com.ljt.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
public static void main(String[] args) {
	Collection c = new ArrayList();
	c.add("孙悟空");
	c.add("孙悟空2");
	c.add("孙悟空3");
	c.add("孙悟空4");
	c.add("孙悟空5");
	c.add(6);
	Iterator it = c.iterator();
	while(it.hasNext()){
		String kk = (String) it.next();
		System.out.println(kk);
	}
	System.out.println("=======================");
	System.out.println("c集合的元素个数为:"+c.size());
	c.remove(6);
	System.out.println("c集合的元素个数为:"+c.size());
}
}
