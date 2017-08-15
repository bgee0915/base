package com.bgee.base.io;

import java.io.File;

import com.bgee.base.constants.IOConstants;

public class DeleteFile {
	
	public static final String URL = IOConstants.COMMON_URL + File.separator + "test.txt";
	
	public static void main(String[] args) {
		File file = new File(URL);
		file.deleteOnExit();  // file.delete();
	}
}
