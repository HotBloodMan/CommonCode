package com.ljt.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.print.attribute.HashAttributeSet;

public class MapTest1 {
public static void main(String[] args) {
	String s=charCount("ak+abAf1c,dCkaAbc-defa");
	System.out.println(s);
}

public static String charCount(String string) {
	char [] ch=string.toCharArray();
	TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
	int count=0;
	for(int i=0;i<ch.length;i++){
		if(!(ch[i]>='a'&&ch[i]<='z'||ch[i]>='A'&&ch[i]<='Z'))
			continue;
			Integer value = map.get(ch[i]);
			if(value!=null)
				count=value;
				count++;
				map.put(ch[i],count);
				count=0;
		
	}
	StringBuilder sb = new StringBuilder();
	Set<Map.Entry<Character, Integer>> set = map.entrySet();
	Iterator<Entry<Character, Integer>> it = set.iterator();
	while(it.hasNext()){
		Map.Entry<Character, Integer> next = it.next();
		Character key = next.getKey();
		Integer value = next.getValue();
		sb.append(key+":"+value);
	}
	return sb.toString();
}
}
