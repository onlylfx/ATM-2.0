package com.feicuiedu.atm.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class InputDate {

	public HashMap<String, Object> updateQuery(File file) {

		// 判断文件夹是否为空
		if (file.length() == 0) {
			// 如果文件夹为空， 给文件中创建一个HashMap<String, Object>结构的存储方式。并且返回hashMap
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			return hashMap;
		}

		FileInputStream fils = null;
		ObjectInputStream ois = null;
		HashMap<String, Object> hashMap = null;

		try {
			fils = new FileInputStream(file);
			ois = new ObjectInputStream(fils);
			hashMap = (HashMap<String, Object>) ois.readObject();
			ois.close();
			fils.close();
			return hashMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
}
