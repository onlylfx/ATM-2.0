package com.feicuiedu.atm.business;
import java.util.Scanner;

import com.feicuiedu.atm.bean.User;

public class LoginUser {
	
	Scanner scanner = new Scanner(System.in);
	
	public void login() {
		
		boolean flag = true;
		while(flag) {
			System.out.println("欢迎来到普通用户登录页面！");
			System.out.println("请输入身份证号或账号：");
			String account = scanner.nextLine();
			AccountJudge jude = new AccountJudge();
			User user = jude.judgeUser(account);
			if (user == null) {
				System.out.println("账号或身份证号不存在,请重新输入：");
				login();
				break;
			}
			if(!account.equals(user.getUserCard())) {
				System.out.println("身份证号错误，请重新输入：");
				login();
				break;
			}
			System.out.println("请输入密码：");
			String password = scanner.nextLine();
			if (!password.equals(user.getPassword())) {
				System.out.println("密码错误，请重新输入：");
				login();
				break;
			}
			flag = false;
			System.out.println("登录成功！");
			Menu menu = new Menu();
			menu.naviga(user);
			break;
		}
		
	}
}
