package com.ljt.fanxing;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
	public void drawAll(List<String> shapes){
		for(String s:shapes){
			System.out.println("s=="+s.toString());
		}
	}
	public static void main(String[] args) {
		List<String> shapes = new ArrayList<String>();
		shapes.add("s1");
		shapes.add("s2");
		shapes.add("s3");
		shapes.add("s4");
		Canvas c = new Canvas();
		c.drawAll(shapes);
	}
}
