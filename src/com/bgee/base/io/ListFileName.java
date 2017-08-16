package com.bgee.base.io;

import java.io.File;

import com.bgee.base.constants.IOConstants;

public class ListFileName {
	
	
	public static void main(String[] args) {
		File file = new File(IOConstants.COMMON_URL);
		String []fileName = file.list();
		File []allPath = file.listFiles();
		System.out.println(String.join("\n",fileName) + "\n");
		for(File f : allPath) {
			System.out.println(f);
		}
	}
}
