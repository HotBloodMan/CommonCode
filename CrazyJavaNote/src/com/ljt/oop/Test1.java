package com.ljt.oop;

public class Test1 implements c{
public static void main(String[] args) {
	Test1 t = new Test1();
	t.function();
	t.show();
	t.happy();
}
@Override
public void function() {
	// TODO Auto-generated method stub
}
@Override
public void show() {
	// TODO Auto-generated method stub
}
@Override
public void happy() {
	// TODO Auto-generated method stub
	System.out.println("����������ð�");
}
}
interface A{
 abstract void show();
}
interface B extends A{
	void function();
}
interface c extends B{
	void happy();
}