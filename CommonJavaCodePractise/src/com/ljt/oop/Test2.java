package com.ljt.oop;

public class Test2 extends Template{
private void mian() {
}
@Override
void runCode() {
	System.out.println("继承抽象类的方法");
}
public static void main(String[] args) {
	Test2 test2 = new Test2();
	test2.run();
}
}
abstract class Template {
	public void run(){
		long mils = System.currentTimeMillis();
		System.out.println(mils);
	}
	 abstract void runCode();
}
