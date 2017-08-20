package com.bgee.base.io;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.bgee.base.constants.IOConstants;

public class Zip_nio {
	public static void main(String[] args) {
		try {
			
//			遍历出 zip 中的所以文件的名字
			FileSystem fs = FileSystems.newFileSystem(Paths.get(IOConstants.COMMON_URL + "practice.zip"), null);
			Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>() {
				public FileVisitResult visitFile(Path file, BasicFileAttributes attr)throws IOException{
					System.out.println(file);
					return FileVisitResult.CONTINUE;
				}
			});
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
