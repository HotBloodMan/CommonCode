package com.ljt.collection;

import java.util.Collection;
import java.util.HashSet;

public class CollectionEach {
public static void main(String[] args) {
	Collection books = new HashSet();
	books.add("轻量级java");
	books.add("轻量级java讲义");
	System.out.println("books-->"+books.toString());
	books.forEach(obj->System.out.println("迭代集合元素："+obj));
}
}
