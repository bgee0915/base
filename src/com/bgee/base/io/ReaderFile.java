package com.bgee.base.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.bgee.base.constants.IOConstants;

public class ReaderFile {
	public static void main(String[] args) {
		
		try {
			
			File file = new File(IOConstants.COMMON_URL + "writeFile.txt");
			Reader read = new FileReader(file);
			char charArray[] = new char[1024];
			
			int count = 0;
			int temp = 0;
			while((temp = read.read()) != -1) {
				charArray[count++] = (char)temp;
			}
			read.close();
			
			System.out.println(new String(charArray));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
