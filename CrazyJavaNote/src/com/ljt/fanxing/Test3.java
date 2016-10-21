package com.ljt.fanxing;

public class Test3 implements Inter{

//	@Override
//	public void show(String t) {
//		// TODO Auto-generated method stub
//		System.out.println("ÄãºÃ£º"+t);
//	}
	public static void main(String[] args) {
//		Test3 t3 = new Test3();
//		t3.show("324242");
		Test3 t3 = new Test3();
		t3.show(new String("24234234"));
		t3.show(new Integer(4));
	}

@Override
public void show(Object t) {
System.out.println("oo"+t);	
}
}
interface Inter<T>{
	void show(T t);
}
