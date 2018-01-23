package com.feicuiedu.atm.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class User implements Serializable{
	private static final long serialVersionUID = -1025872491647616535L;
	private StringBuffer flow = new StringBuffer();
	private String userName;
	private String userCard;
	private String password;
	private String userSex;
	private String education;
	private double userBalance;
	private String userAddress;
	private String account;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCard() {
		return userCard;
	}
	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public double getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	public StringBuffer getFlow() {
		return flow;
	}
	public StringBuffer setFlow(StringBuffer flow) {
		return this.flow = flow;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "姓名：" + userName + ", 性别：" + userSex +
				", 身份证号：" + userCard + ", 密码：" + password + ", 余额：" + userBalance +
				", 学历" + education + ", 账号：" + account + "\n" + ", 家庭住址：" + userAddress + ", 流水：" + flow + "\n";  
	}
	
	/*public void appendFlow(String flow){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
		String time = format.format(Calendar.getInstance().getTime());
		this.flow.append("\n" + time + flow);
	}*/
	
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof User)) {
			return false;
		}
		User user = (User) obj;
		return (account.equals(user.account) || userCard.equals(user.userCard));
		
	}

	public User(String account, String userCard) {
		this.account = account;
		this.userCard = userCard;
	}
	
	public User(String userName, String userCard, String password, String userSex, String education, double userBalance,
			String userAddress, String account, StringBuffer flow) {
		super();
		this.userName = userName;
		this.userCard = userCard;
		this.password = password;
		this.userSex = userSex;
		this.education = education;
		this.userBalance = userBalance;
		this.userAddress = userAddress;
		this.account = account;
		this.flow = flow;
	}	
	public User() {
		// TODO Auto-generated constructor stub
	}
}
