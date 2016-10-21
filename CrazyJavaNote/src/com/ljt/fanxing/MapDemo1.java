package com.ljt.fanxing;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
public static void main(String[] args) {
	Map<Object,Object> map = new HashMap<>();
	map.put("a","324");
	map.put("s","df3");
	map.put("h","45gfg");
	System.out.println(map.get("s"));
}
}
