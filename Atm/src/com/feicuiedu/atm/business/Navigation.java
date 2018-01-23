package com.feicuiedu.atm.business;

import java.util.Scanner;

import com.feicuiedu.atm.bean.Admin;
import com.feicuiedu.atm.bean.AdminMenu;

public class Navigation {
	private Admin admin;
	Scanner scanner = new Scanner(System.in);
	Method method = new Method();
	AdminMenu amnu = new AdminMenu();
	Login login = new Login();
	public void nation() {
		System.out.println("管理员菜单");
		System.out.println("1、开户");
		System.out.println("2、销户");
		System.out.println("3、显示目前所有账户及基本信息");
		System.out.println("4、修改用户修改");
		System.out.println("5、返回上一级");
		String str = scanner.nextLine();
		if (str.equals("1")) {
			method.openUser();
			nation();
		}else if (str.equals("2")) {
			method.userDelete();
			nation();
		}else if (str.equals("3")) {
			method.queryUser();
			nation();
		}else if (str.equals("4")) {
			method.userUpdate();
			nation();
		}else if (str.equals("5")) {
			
			login.signs();
		}else {
			System.out.println("输入不合法，返回菜单!");
			nation();
		}
	}
	
}
