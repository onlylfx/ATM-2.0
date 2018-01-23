package com.feicuiedu.atm.bean;

public class Admin {
	
	private String account = "7410";
	private String password = "8520";
	private String adminUser = "翡翠侠";
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}
	public Admin(String account, String password, String adminUser) {
		super();
		this.account = account;
		this.password = password;
		this.adminUser = adminUser;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
}
