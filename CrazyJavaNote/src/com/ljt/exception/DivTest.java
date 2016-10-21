package com.ljt.exception;

public class DivTest {
public static void main(String[] args) {
	try {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c=a/b;
		System.out.println("你输入的两个数相除的结果是："+c);
	} catch (IndexOutOfBoundsException e) {
		// TODO: handle exception
		System.out.println("数组越界：运行程序时输入的参数个数不够");
	}catch(NumberFormatException ne){
		ne.printStackTrace();
	}catch(ArithmeticException ae){
		System.out.println("算术异常");
	}catch(Exception e){
		System.out.println("未知异常");
	}
}
}
