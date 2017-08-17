package com.bgee.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class MoreZipOutputStreamFile {
	
	// 压缩的文件 和 被压缩的文件/文件夹 不能再同一个位置 不然会 自己压缩自己 无限循环。
	public static void main(String[] args) {
		try {
			File direction = new File("d:" + File.separator + "practice");
			File zipFile = new File("d:/allZip.zip");
			ZipOutputStream zipOut =  new ZipOutputStream(new FileOutputStream(zipFile));
			recursion(direction,zipOut,direction.getName());
			zipOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void recursion(File f ,ZipOutputStream zipOut, String baseDir) throws IOException {
		System.out.println("f=" + f + ", baseDir=" + baseDir);
		if(f.isDirectory()) {
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getPath());
			File fileArray[] = f.listFiles();
			for(int i=0; i<fileArray.length; i++) {
				recursion(fileArray[i],zipOut,fileArray[i].getName());
			}
		}else {
			zipOut.putNextEntry(new ZipEntry(f.getPath()));
			InputStream in = new FileInputStream(f);
			int temp = 0;
			while((temp = in.read()) != -1) {
				zipOut.write(temp);
			}
			in.close();
		}
	}
}
