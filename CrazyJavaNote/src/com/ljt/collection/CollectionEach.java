package com.ljt.collection;

import java.util.Collection;
import java.util.HashSet;

public class CollectionEach {
public static void main(String[] args) {
	Collection books = new HashSet();
	books.add("������java");
	books.add("������java����");
	System.out.println("books-->"+books.toString());
	books.forEach(obj->System.out.println("��������Ԫ�أ�"+obj));
}
}
