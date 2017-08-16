package com.bgee.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.bgee.base.constants.IOConstants;

// 字节流读取
public class ReadFileByte {
	public static void main(String[] args) {
		try {
			File file = new File(IOConstants.COMMON_URL + "writeFile.txt");
			InputStream ins = new FileInputStream(file);
			byte fileByte[] = new byte[1024];
			int count = 0;
			int temp = 0;
			while((temp = ins.read()) != -1) {
				fileByte[count++] = (byte)temp;
			}
			ins.close();
			System.out.println(new String(fileByte));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
