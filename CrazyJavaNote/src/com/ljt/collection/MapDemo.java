package com.ljt.collection;

public class MapDemo {
public static void main(String[] args) {
	String s=charTo("addf ABC dfeIIO");
}
public static String charTo(String h){
	char[] cs = h.toCharArray();
	System.out.println("cs="+cs);
	StringBuilder sb = new StringBuilder();
	for(int i=0;i<cs.length;i++){
		System.out.println("cs="+cs[i]);
		sb.append(cs[i]);
	}
	sb.append("����ѽ���");
	System.out.println("sb"+sb.toString());
	return sb.toString();
	
}
}
