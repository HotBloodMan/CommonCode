package com.ljt.fanxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiamondTest {
public static void main(String[] args) {
//	List<String> books = new ArrayList<>();
//	books.add("�����");
//	books.add("�����213");
//	//����books���ϣ�����Ԫ�ؾ���String����
//	books.forEach(ele->System.out.println(ele.length()));
//	Map<String,List<String>> schoolsInfo = new HashMap<>();
//	List<String> list = new ArrayList<>();
//	list.add("б�����Ƕ�");
//	list.add("����ȡ��·");
//	schoolsInfo.put("�����",list);
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
