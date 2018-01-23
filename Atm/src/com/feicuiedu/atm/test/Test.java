package com.feicuiedu.atm.test;

import com.feicuiedu.atm.bean.Admin;
import com.feicuiedu.atm.business.Login;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		Login login = new Login(admin);
		login.signs();
	}
}
