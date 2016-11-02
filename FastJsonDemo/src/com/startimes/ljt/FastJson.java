package com.startimes.ljt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class FastJson {
	public static void main(String[] args) {
		method1();
		method2();
    	method3();
		method4();
	}

	private static void method1() {
		// TODO Auto-generated method stub
		System.out.println("--------method1()��ʼ----------");
		Person person = new Person("1","fastjson",1);
		//��javabeanת����json�ַ���
		String jsonString = JSON.toJSONString(person);
		System.out.println(jsonString);
		System.out.println("----------method1()����----------");
	}
//������תΪjson�ַ���
	private static void method2() {
		// TODO Auto-generated method stub
		System.out.println("--------method2()��ʼ----");
		Person person1 = new Person("1","fastjson1",1);
		Person person2 = new Person("2","fastjson2",2);
		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		String jsonString = JSON.toJSONString(persons);
		System.out.println("json�ַ�����"+jsonString);
		System.out.println("----------method2()����-----------");
		
		//����json�ַ���
		List<Person> persons2 = JSON.parseArray(jsonString,Person.class);
		System.out.println("person1����:"+persons2.get(0).getName());
		System.out.println("person2����:"+persons2.get(1).toString());
		System.out.println("----------method2()��������-------------");
	}
	private static void method3() {
		System.out.println("----------method3()��ʼ---------");
		List<String> list = new ArrayList<String>();
		list.add("Lee1");
		list.add("Lee2");
		list.add("Lee3");
		String jsonString = JSON.toJSONString(list);
		System.out.println("json�ַ���:======"+jsonString);
		
		//����json�ַ���
		List<String> list3M = JSON.parseObject(jsonString,new TypeReference<List<String>>(){});
		System.out.println(list3M.get(0)+"::"+list3M.get(1)+"::"+list3M.get(2));
		System.out.println("---------method3����-------------");
	}
//��mapתΪjson�ַ���
	private static void method4() {
		System.out.println("-----------method4()��ʼ-------------");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key1","value1");
		map.put("key2","value3");
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("key3",1);
		map2.put("key4",2);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map);
		list.add(map2);
		String jsonString = JSON.toJSONString(list);
		System.out.println("MM--json�ַ���:"+jsonString);
		//����json�ַ���
		List<Map<String, Object>> list2 = JSON.parseObject(jsonString,new TypeReference<List<Map<String,Object>>>(){});
		System.out.println("map��key1ֵ=="+list2.get(0).get("key1"));
		System.out.println("map��key2ֵ=="+list2.get(0).get("key2"));
		System.out.println("ma2p��key1ֵ=="+list2.get(1).get("key3"));
		System.out.println("ma2p��key2ֵ=="+list2.get(1).get("key4"));
		System.out.println("-----------method4()����-------------");
		
	}
}
