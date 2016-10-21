package com.ljt.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest3 {
public static void main(String[] args) {
	String s=chatTo("sfkasDSDRW+SDFSsfsf");
	print(s);
}

private static  String chatTo(String string) {
	char[] cs = string.toCharArray();
	HashMap<Character,Integer> map = new HashMap<>();
	int count=0;
	for(int i=0;i<cs.length;i++){
		if(!(cs[i]>='a'&&cs[i]<='z'||cs[i]>='A'&&cs[i]<'Z')){
			continue;
		}else{
			Integer value = map.get(cs[i]);
			if(value!=null)
				count=value;
			count++;
			map.put(cs[i],count);
			count=0;
		}
	}
	StringBuilder sb = new StringBuilder();
	Set<Map.Entry<Character, Integer>> set = map.entrySet();
	Iterator<Entry<Character, Integer>> iterator = set.iterator();
	while(iterator.hasNext()){
		Entry<Character, Integer> next = iterator.next();
		Character key = next.getKey();
		Integer value = next.getValue();
		sb.append(" "+key+" 对应的次数是:"+value+" ");
	}
	return sb.toString();
}
public static void print(Object obj)
{
	System.out.println(obj);
}
}
