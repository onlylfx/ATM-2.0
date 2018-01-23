package com.feicuiedu.atm.business;

import java.util.Scanner;

public class InputRule {
	
	public boolean identity(String str) {
		
		return str.matches("[a-z0-9A-Z]{6,18}");
	}
	
	public boolean password(String str) {
		
		return str.matches("[a-z0-9A-Z]{8,18}") && !str.matches("[a-zA-Z]+") && // 不能只包含字母
				!str.matches("[0-9]+") && // 不能只包含数字
				!str.matches("[a-z]+");// 至少有一个大写
	}
	
}
