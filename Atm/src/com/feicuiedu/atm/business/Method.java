package com.feicuiedu.atm.business;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.SpringLayout.Constraints;
import javax.tools.FileObject;

import com.feicuiedu.atm.bean.User;

public class Method {

	Scanner scanner = new Scanner(System.in);

	public void openUser() {
		// 开户
		InputRule rul = new InputRule();
		boolean flag = true;
		while(flag) {
			System.out.println("开通用户页面：");
			System.out.println("请输入姓名：");
			String userName = scanner.nextLine();
			System.out.println("请输入身份证号：");
			System.out.println("身份证号格式：由数字和字母组成，长度不能低于6位不能大于18位");
			String userCard = scanner.nextLine();
			if (!rul.identity(userCard)) {
				System.out.println("身份证号输入格式有误，请重新输入！");
				openUser();
				break;
			}
			System.out.println("请输入密码：");
			System.out.println("密码格式： 长度最少8位、最长不能大于18位,数字和字母必须同时存在,至少有一个大写字母");
			String password = scanner.nextLine();
			if (!rul.password(password)) {
				System.out.println("身份证号输入格式有误，请重新输入！");
				openUser();
				break;
			}
			System.out.println("请输入性别：");
			System.out.println("1代表男");
			System.out.println("2代表女");
			String userSex = null;
			String index = null;
			String gender = scanner.nextLine();
			if (gender.equals("1")) {
				userSex = "男";
				index = "01";
			} else if (gender.equals("2")) {
				userSex = "女";
				index = "02";
			} else {
				System.out.println("输入有误，返回菜单首页!");
				openUser();
				break;
			}
			System.out.println("请输入学历：");
			System.out.println("1代表小学");
			System.out.println("2代表中学");
			System.out.println("3代表大学");
			System.out.println("4代表其他");
			String education = null;
			String number = scanner.nextLine();
			if (number.equals("1")) {
				education = "小学";
			} else if (number.equals("2")) {
				education = "中学";
			} else if (number.equals("3")) {
				education = "大学";
			} else if (number.equals("4")) {
				education = "其他";
			} else {
				System.out.println("输入有误，返回菜单首页!");
				openUser();
				break;
			}
			System.out.println("请输入家庭住址，长度不能大于50！");
			String userAddress = scanner.nextLine();
			if (userAddress.length() > 50) {
				System.out.println("长度大于50，请重新输入：");
				openUser();
				break;
			}
			double userBalance = 0.0;

			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String time = format.format(new Date());
			String account = "37" + index + time;
			StringBuffer flow = new StringBuffer(" ");
			User user = new User(userName, userCard, password, userSex, education, userBalance, userAddress, account, flow);
			CreateFile creat = new CreateFile();
			File file = creat.userFile();
			InputDate input = new InputDate();
			// inpt.updateQuery(file);
			String accountCard = account + userCard;

			HashMap<String, Object> obj = input.updateQuery(file);
			obj.put(accountCard, user);

			OutputData opt = new OutputData();
			opt.updateInsert(obj, file);

			/*
			 * String uri = "E:\\Workspace\\javase\\userData.txt"; File file = new
			 * File(uri);
			 * 
			 * FileInputStream fism = null; ObjectInputStream oism = null; ArrayList<User>
			 * arrays = new ArrayList<User>(); try { fism = new FileInputStream(file); oism
			 * = new ObjectInputStream(fism); Object obj = oism.readObject(); if (obj !=
			 * null && obj instanceof ArrayList) { arrays = (ArrayList<User>)obj; } } catch
			 * (IOException e1) { //e1.printStackTrace(); for (StackTraceElement item :
			 * e1.getStackTrace()) { //System.out.println(item); } } catch
			 * (ClassNotFoundException e2) { //e2.printStackTrace(); for (StackTraceElement
			 * item : e2.getStackTrace()) { //System.out.println(item); } }
			 * arrays.add(user); FileOutputStream fis = null; ObjectOutputStream oos = null;
			 * try { fis = new FileOutputStream(file); oos = new ObjectOutputStream(fis);
			 * oos.writeObject(arrays); System.out.println(arrays); } catch (IOException e)
			 * { e.printStackTrace(); } finally { try { oos.flush(); oos.close();
			 * fis.flush(); fis.close(); } catch (IOException ioe) { ioe.printStackTrace();
			 * } }
			 */
			System.out.println("开户成功!");
			flag = false;
		}
		
	}

	// 查询已开户的所有用户信息
	public void queryUser() {
		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipt = new InputDate();
		ipt.updateQuery(file);
		System.out.println(ipt.updateQuery(file));

		/*
		 * String uri = "E:\\Workspace\\javase\\userData.txt"; File file = new
		 * File(uri); FileInputStream fis = null; ObjectInputStream ois = null;
		 * ArrayList<User> arrays = new ArrayList<User>(); try { fis = new
		 * FileInputStream(file); ois = new ObjectInputStream(fis); Object obj =
		 * ois.readObject(); if (obj != null && obj instanceof ArrayList) { arrays =
		 * (ArrayList<User>)obj; System.out.println(arrays); } ois.close(); fis.close();
		 * } catch (IOException e) { //e.printStackTrace(); System.out.println("^^ 异常");
		 * } catch (ClassNotFoundException e) { //e.printStackTrace();
		 * System.out.println("** 异常"); }
		 */
	}

	// 删除用户信息
	public void userDelete() {
		System.out.println("请输入要删除的账户：");
		String account = scanner.nextLine();
		System.out.println("请输入账户对应的身份证号：");
		String userCard = scanner.nextLine();

		String accountCard = account + userCard;

		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		if (!hashMap.containsKey(accountCard)) {
			System.out.println("账号或身份证号有误，返回管理员菜单！");
			Navigation navi = new Navigation();
			navi.nation();
		} else {
			hashMap.remove(accountCard);
			System.out.println("删除成功！");
			OutputData opt = new OutputData();
			opt.updateInsert(hashMap, file);
		}

		// OutputData opt = new OutputData();
		// opt.updateInsert(hashMap, file);

		/*
		 * String uri = "E:\\Workspace\\javase\\userData.txt"; File file = new
		 * File(uri); FileInputStream fis = null; ObjectInputStream ois = null;
		 * ArrayList<User> arrays = new ArrayList<User>(); try { fis = new
		 * FileInputStream(file); ois = new ObjectInputStream(fis); Object obj =
		 * ois.readObject(); if (obj != null && obj instanceof ArrayList) { arrays =
		 * (ArrayList<User>)obj; System.out.println(arrays); } } catch (IOException e) {
		 * //e.printStackTrace(); System.out.println("^^ 异常"); } catch
		 * (ClassNotFoundException e) { //e.printStackTrace();
		 * System.out.println("** 异常"); }
		 * 
		 * User user = new User(account,userCard); if(arrays != null &&
		 * arrays.contains(user)) { User temp = arrays.get(arrays.indexOf(user)); if
		 * (userCard.equals(temp.getUserCard())) { arrays.remove(temp);
		 * System.out.println("账户删除成功!");
		 * 
		 * String uri1 = "E:\\Workspace\\javase\\userData.txt"; File file1 = new
		 * File(uri); FileOutputStream fos = null; ObjectOutputStream oos = null;
		 * 
		 * try { fos = new FileOutputStream(file1); oos = new ObjectOutputStream(fos);
		 * oos.writeObject(arrays); oos.flush(); } catch (Exception e) { // TODO
		 * Auto-generated catch block //e.printStackTrace(); } finally { try {
		 * oos.close(); } catch (IOException e) { //e.printStackTrace(); } try {
		 * fos.close(); } catch (IOException e) { //e.printStackTrace(); } } } }else {
		 * System.out.println("账号或身份证号错误，请重新输入："); userDelete(); }
		 */
	}

	public void userUpdate() {

		System.out.println("请输入要修改的账号：");
		String account = scanner.nextLine();
		AccountJudge judge = new AccountJudge();
		User user = judge.judgeUser(account);
		if (user == null) {
			System.out.println("没有该用户！请重新输入：");
			userUpdate();
		}
		// 密码,姓名,学历,联系地址
		System.out.println("请输入修改的密码：");
		String password = scanner.nextLine();
		user.setPassword(password);
		System.out.println("请输入修改的姓名：");
		String userName = scanner.nextLine();
		user.setUserName(userName);
		System.out.println("请输入修改的学历：");
		String education = scanner.nextLine();
		user.setEducation(education);
		System.out.println("请输入修改的联系地址：");
		String userAddress = scanner.nextLine();
		user.setUserAddress(userAddress);

		String userCard = user.getUserCard();
		String accountCard = account + userCard;

		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		hashMap.put(accountCard, user);
		OutputData opt = new OutputData();
		opt.updateInsert(hashMap, file);
		System.out.println("修改成功!");

	}
}
