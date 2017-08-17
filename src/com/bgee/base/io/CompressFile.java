package com.bgee.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.bgee.base.constants.IOConstants;

public class CompressFile {
	public static void main(String[] args) {
		try {
			
			File file = new File(IOConstants.COMMON_URL + "practice.zip");
			File outFile = null;
			ZipFile zipFile = new ZipFile(file);
			ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
			ZipEntry entry = null;
			InputStream input = null;
			OutputStream out = null;
			
			while((entry = zipInput.getNextEntry()) != null) {
				outFile = new File("D:\\x\\" + entry.getName());
				
				if(!outFile.exists()) {
					
					if(entry.isDirectory()) {
						outFile.mkdir();
						continue;
					} 
					
					outFile.createNewFile();
				}
				
				
				System.out.println(outFile);
				input = zipFile.getInputStream(entry);
				out = new FileOutputStream(outFile);
				int temp = 0;
				while((temp = input.read()) != -1) {
					out.write(temp);
				}
				
				input.close();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
