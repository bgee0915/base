package com.bgee.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.bgee.base.constants.IOConstants;

/**
 * 读取一个 图片流 , 存储到另一个地方并重命名
 * @author lx 
 *
 */
public class ReadImage {
	public static void main(String[] args) {
		try {
			
			File imageFile = new File(IOConstants.COMMON_URL + "1.jpg");
			InputStream in = new FileInputStream(imageFile);
			
			System.out.println(imageFile.length());
			byte imageByte[] = new byte[(int) imageFile.length()];
			
			int count = 0;
//			while(count <)
			while(count < (int)imageFile.length()) {
				imageByte[count++] = (byte) in.read();
			}
//			System.out.println(new String(imageByte));
			in.close();

			
			
			
			OutputStream out = new FileOutputStream(new File(IOConstants.COMMON_URL + "2.jpg"));
			out.write(imageByte);
			out.close();
			
			
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} 
	}
}
