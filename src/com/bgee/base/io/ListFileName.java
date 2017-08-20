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
		
//		nio流 新实现方式, 速度更快
//		try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get(IOConstants.COMMON_URL), "*.txt")){	//try 确保目录流被正确关闭, 参数2 为 glob过滤条件  windows下需要4次\转义   "c:\\\\";
//			for(Path entry : entries) {
//				FunUtil.println(entry);
//			}
//		}
	}
}
