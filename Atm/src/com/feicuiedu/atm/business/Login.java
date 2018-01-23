package com.feicuiedu.atm.business;

import java.util.Scanner;

import com.feicuiedu.atm.bean.Admin;
import com.feicuiedu.atm.bean.AdminMenu;

public class Login {
	
	private Admin admin;
	private AdminMenu adminMenu;
	private Navigation navg;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	Menu menu = new Menu();
	public Login(Admin admin) {
		this.admin = admin;
		adminMenu = new AdminMenu(admin);
		navg = new Navigation();
	}

	public  void signs() {
		LoginUser loginUser = new LoginUser();
		Scanner scanner =new Scanner(System.in);
		System.out.println("*********************");
		System.out.println("用户登录");
		System.out.println("请选择用户登录类型：");
		System.out.println("1、管理员用户登录");
		System.out.println("2、普通用户登录");
		System.out.println("*********************");
		String str = scanner.nextLine();
		if (str.equals("1")) {
			adminMenu.signAdmin(admin);
			navg.nation();
		}else if (str.equals("2")) {
			loginUser.login();
			menu.naviga(null);
		}else {
			System.out.println("您输入不合法,请你重新输入");
			signs();
		}
	}

}
