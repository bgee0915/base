package com.bgee.base.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.bgee.base.constants.IOConstants;

// 字节流写入
public class WriteFileByte {
	public static void main(String[] args) {
		try {
			File file = new File(IOConstants.COMMON_URL + "writeFile.txt");
			OutputStream out = new FileOutputStream(file,true);	// true, 追加内容
			out.write("拉拉".getBytes());
			out.close();
		} catch ( IOException e) {
			e.printStackTrace();
		}  
		
		
		
	}
}
