package com.ljt.oop;

public class Test4 extends MethodStyle{
public static void main(String[] args) {
	Test4 t = new Test4();
	t.study();
	t.show();
	t.live();
}

@Override
void study() {
	print("我要好好学习");
}
@Override
void show() {
	print("我要学习跳舞");
}
@Override
void live() {
	print("我要学习如何生活");
}
public static void print(Object obj)
{
	System.out.println(obj);
}
}
abstract class MethodStyle{
 abstract void study();
 abstract void show();
 abstract void live();
}
