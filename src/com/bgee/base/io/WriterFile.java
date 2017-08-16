package com.bgee.base.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.bgee.base.constants.IOConstants;

// 字符流写入
public class WriterFile {
	public static void main(String[] args) {
		try {
			
			File f = new File(IOConstants.COMMON_URL + "writeFile.txt");
			Writer write = new FileWriter(f,true);
			String writeString = " test writer ";
			write.write(writeString);
			write.close();
		}catch(IOException e) {
			
		}
		
	}
}
