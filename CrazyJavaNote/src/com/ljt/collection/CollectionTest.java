package com.ljt.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
public static void main(String[] args) {
	Collection c = new ArrayList();
	c.add("�����");
	c.add("�����2");
	c.add("�����3");
	c.add("�����4");
	c.add("�����5");
	c.add(6);
	Iterator it = c.iterator();
	while(it.hasNext()){
		String kk = (String) it.next();
		System.out.println(kk);
	}
	System.out.println("=======================");
	System.out.println("c���ϵ�Ԫ�ظ���Ϊ:"+c.size());
	c.remove(6);
	System.out.println("c���ϵ�Ԫ�ظ���Ϊ:"+c.size());
}
}
