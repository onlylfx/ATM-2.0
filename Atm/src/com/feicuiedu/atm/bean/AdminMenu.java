package com.feicuiedu.atm.bean;

import java.util.Scanner;

public class AdminMenu {
	
	private Admin admin;
	public AdminMenu(Admin admin) {
		this.admin = admin;
	}
	
	public AdminMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public void signAdmin(Admin admin) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("欢迎来到管理员用户登录窗口");
			System.out.println("请输入账户：");
			String account = scanner.nextLine();
			if (account.length() != 4) {
				System.out.println("账号长度不符合，请重新输入：");
				signAdmin(admin);
				break;
			}else if (!account.equals(admin.getAccount())) {
				System.out.println("账号有误，请重新输入：");
				signAdmin(admin);
				break;
			}
			System.out.println("请输入密码：");
			String password = scanner.nextLine();
			if (password.equals(admin.getPassword())) {
				System.out.println("登录成功！");
				break;
			}else{
				System.out.println("密码错误，请重新输入！");
				signAdmin(admin);
				break;
			}
		}
	}
}
