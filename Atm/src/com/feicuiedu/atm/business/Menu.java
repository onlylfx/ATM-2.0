package com.feicuiedu.atm.business;

import java.util.Scanner;

import com.feicuiedu.atm.bean.Admin;
import com.feicuiedu.atm.bean.User;

public class Menu {
	private Admin admin;
	Scanner scanner = new Scanner(System.in);
	
	public void naviga(User user){
		Login longin = new Login(admin);
		System.out.println("菜单-选择业务办理");
		System.out.println("1、查询");
		System.out.println("2、转账");
		System.out.println("3、取款");
		System.out.println("4、存款");
		System.out.println("5、交易流水");
		System.out.println("6、退卡");
		UserMenuMethod mmd = new UserMenuMethod();
		
		String number = scanner .nextLine();
		if (number.equals("1")) {
			mmd.queryBusiness(user);
		}else if (number.equals("2")) {
			mmd.updateTransfer(user);
		}
		else if (number.equals("3")) {
			mmd.updateDraw(user);
		}else if (number.equals("4")) {
			mmd.updateAdd(user);
		}else if (number.equals("5")) {
			mmd.runningTab(user);
		}else if (number.equals("6")) {
			longin.signs();
		}else{
			System.out.println("输入不合法。请重新输入！");
			naviga(user);
		}
	}
}
