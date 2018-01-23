package com.feicuiedu.atm.business;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

import com.feicuiedu.atm.bean.User;

public class AccountJudge {
	
	public User judgeUser(String str) {
		
		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		
		Set<String> set = hashMap.keySet();
		for(String temp:set) {
			if (temp.startsWith(str) || temp.endsWith(str)) {
				User user =(User) hashMap.get(temp);
				return user;
			}
		}
		return null;
	}
}
