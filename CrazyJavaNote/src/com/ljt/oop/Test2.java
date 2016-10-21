package com.ljt.oop;

public class Test2 extends Person{
public static void main(String[] args) {
	Test2 t2 = new Test2();
	t2.play();
	t2.show();
	t2.study();
	
}

@Override
void show() {
	System.out.println("你给我跳一支舞");
}

@Override
void study() {
	System.out.println("我正在模仿机器人");
}
}

