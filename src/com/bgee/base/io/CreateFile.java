package com.bgee.base.io;

import java.io.File;
import java.io.IOException;

import com.bgee.base.constants.IOConstants;

/**
 * 创建文件
 * @author bgee0915
 *
 */
public class CreateFile {
	
	
	public static final String FILE_URL = IOConstants.COMMON_URL +"test.txt";
	
	public static final String DIRECTION_URL = IOConstants.COMMON_URL + "directionOnly";
	
	public static final String DIRECTION_URL_MORE = IOConstants.COMMON_URL + "direction1" + File.separator + "direction2" + File.separator + "direction3";
	
	public static void main(String[] args) {
		try {
			boolean createFileResult = new File(FILE_URL).createNewFile();
			System.out.println("create file result=" + createFileResult);
			
			boolean createDirectionResult = new File(DIRECTION_URL).mkdir();	// 只建立最后位置的 目录  如果中间层目录不存在 return false
			System.out.println("create direction result=" + createDirectionResult);
			
			
			boolean createMoreDirectionResult = new File(DIRECTION_URL_MORE).mkdirs();	// 会顺带创建中间没有的目录
			System.out.println("create more direction result=" + createMoreDirectionResult);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
