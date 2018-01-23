package com.feicuiedu.atm.business;

import java.io.File;
import java.util.HashMap;

import com.feicuiedu.atm.bean.User;

public class UpdateDate {

	public void date(User user) {
		CreateFile creat = new CreateFile();
		File file = creat.userFile();
		InputDate ipd = new InputDate();
		HashMap<String, Object> hashMap = ipd.updateQuery(file);
		String account = user.getAccount();
		String userCard = user.getUserCard();
		String accountCard = account + userCard;
		hashMap.put(accountCard, user);
		OutputData opt = new OutputData();
		opt.updateInsert(hashMap, file);
	}
	
}
