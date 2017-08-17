package com.bgee.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.bgee.base.constants.IOConstants;

/**
 * 压缩单个文件
 * @author bgee
 *
 */
public class ZipOutputStreamFile {
	public static void main(String[] args) {
		try {
			File file = new File(IOConstants.COMMON_URL + "1.jpg");
			File zipFile = new File(IOConstants.COMMON_URL + "1jpg.zip");
			InputStream fileIn = new FileInputStream(file);
			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
			zipOut.putNextEntry(new ZipEntry(file.getName()));
			int temp = 0;
			while((temp = fileIn.read()) != -1) {
				zipOut.write(temp);
			}
			
			fileIn.close();
			zipOut.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
