package com.ljt.collection;

public class Test1 {
public static void main(String[] args) {
	String arr[]={"12","13","34","56"};
//	System.out.println(toString(arr));
	System.out.println(toString2(arr));
}
public static String toString(String[] obj){
	String str="[";
	for(int i=0;i<obj.length;i++){
		str+=obj[i];
	}
	str+="]";
	return str;
	
}
public static String toString2(String[] obj){
	StringBuffer sb = new StringBuffer();
	for(int i=0;i<obj.length;i++){
		sb.append(obj[i]);
		if(i!=obj.length-1){
			sb.append(obj[i]+"]");
		}else{
			sb.append(obj.length-1+"}");
		}
	}
	return sb.toString();
}

}
