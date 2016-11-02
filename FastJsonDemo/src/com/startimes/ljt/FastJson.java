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
		System.out.println("--------method1()开始----------");
		Person person = new Person("1","fastjson",1);
		//将javabean转化成json字符串
		String jsonString = JSON.toJSONString(person);
		System.out.println(jsonString);
		System.out.println("----------method1()结束----------");
	}
//将集合转为json字符串
	private static void method2() {
		// TODO Auto-generated method stub
		System.out.println("--------method2()开始----");
		Person person1 = new Person("1","fastjson1",1);
		Person person2 = new Person("2","fastjson2",2);
		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		String jsonString = JSON.toJSONString(persons);
		System.out.println("json字符串："+jsonString);
		System.out.println("----------method2()结束-----------");
		
		//解析json字符串
		List<Person> persons2 = JSON.parseArray(jsonString,Person.class);
		System.out.println("person1对象:"+persons2.get(0).getName());
		System.out.println("person2对象:"+persons2.get(1).toString());
		System.out.println("----------method2()解析结束-------------");
	}
	private static void method3() {
		System.out.println("----------method3()开始---------");
		List<String> list = new ArrayList<String>();
		list.add("Lee1");
		list.add("Lee2");
		list.add("Lee3");
		String jsonString = JSON.toJSONString(list);
		System.out.println("json字符串:======"+jsonString);
		
		//解析json字符串
		List<String> list3M = JSON.parseObject(jsonString,new TypeReference<List<String>>(){});
		System.out.println(list3M.get(0)+"::"+list3M.get(1)+"::"+list3M.get(2));
		System.out.println("---------method3结束-------------");
	}
//将map转为json字符串
	private static void method4() {
		System.out.println("-----------method4()开始-------------");
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
		System.out.println("MM--json字符串:"+jsonString);
		//解析json字符串
		List<Map<String, Object>> list2 = JSON.parseObject(jsonString,new TypeReference<List<Map<String,Object>>>(){});
		System.out.println("map的key1值=="+list2.get(0).get("key1"));
		System.out.println("map的key2值=="+list2.get(0).get("key2"));
		System.out.println("ma2p的key1值=="+list2.get(1).get("key3"));
		System.out.println("ma2p的key2值=="+list2.get(1).get("key4"));
		System.out.println("-----------method4()结束-------------");
		
	}
}
