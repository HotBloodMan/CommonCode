package com.ljt.fanxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiamondTest {
public static void main(String[] args) {
//	List<String> books = new ArrayList<>();
//	books.add("疯狂讲义");
//	books.add("疯狂讲义213");
//	//遍历books集合，集合元素就是String类型
//	books.forEach(ele->System.out.println(ele.length()));
//	Map<String,List<String>> schoolsInfo = new HashMap<>();
//	List<String> list = new ArrayList<>();
//	list.add("斜月三星洞");
//	list.add("西天取经路");
//	schoolsInfo.put("孙悟空",list);
//	System.out.println("schoolsInfo"+schoolsInfo.toString());
//	System.out.println("-----------------------------------");
//	schoolsInfo.forEach((key,value)->System.out.println(key+"-->"+value));
    Map<String, List<String>> map = new HashMap<String,List<String>>();
    List<String> aa = new ArrayList<>();
    aa.add("wewe1");
    aa.add("wewe23");
    map.put("wo",aa);
    System.out.println("map===>>"+map.toString());
}
}
