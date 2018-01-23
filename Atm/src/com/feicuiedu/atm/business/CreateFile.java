package com.feicuiedu.atm.business;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public File userFile() {
		// 创建用户信息存储的文件
		File file = new File(File.separator + "user.date");
		if (file.exists()) {
			return file;
		}else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return file;
	}
	
}
