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
	print("��Ҫ�ú�ѧϰ");
}
@Override
void show() {
	print("��Ҫѧϰ����");
}
@Override
void live() {
	print("��Ҫѧϰ�������");
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
