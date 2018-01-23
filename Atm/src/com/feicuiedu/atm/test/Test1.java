package com.feicuiedu.atm.test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		String str = "111";
		String str1 = "222";
		map.put(str, str1);
		
		String str3 = "333";
		String str4 = "444";
		map.put(str3, str4);
				
		System.out.println(map.get(str));
		System.out.println(map.get(str3));
		String str5 = "123456";
		String str6 = "456";
		System.out.println(str5.endsWith(str6));
	}

}
