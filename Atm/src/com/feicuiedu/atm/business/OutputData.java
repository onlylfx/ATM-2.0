package com.feicuiedu.atm.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class OutputData implements Serializable{
	
	
	public void updateInsert(HashMap<String, Object> hashMap, File file) {
		
		FileOutputStream fios = null;
		ObjectOutputStream oos = null;
		
		try {
			fios = new FileOutputStream(file);
			oos = new ObjectOutputStream(fios);
			oos.writeObject(hashMap);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
