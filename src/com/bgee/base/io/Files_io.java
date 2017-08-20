package com.bgee.base.io;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.bgee.base.constants.IOConstants;
import com.bgee.base.util.FunUtil;

public class Files_io {
	public static void main(String[] args) {
		try {
			Path targetPath = Paths.get(IOConstants.COMMON_URL + "love.txt");
			
//			1: 读取数据
			byte filesByte[] = Files.readAllBytes(targetPath);
			for(Byte b : filesByte) {
				FunUtil.print(b);
			}
			FunUtil.println("\n"+new String(filesByte,"utf-8"));
			
			
			FunUtil.println("\n===============================\n");
			
//			2: 写入
			Path writePath = Files.write(Paths.get(IOConstants.COMMON_URL + "hahahaha.txt"), filesByte);
			FunUtil.println(writePath);
			
//			3: copy
//			Files.copy(targetPath, Paths.get(IOConstants.COMMON_URL + "cpp.txt"));
			
//			4: move
//			Files.move(Paths.get(IOConstants.COMMON_URL + "cpp.txt"),Paths.get(IOConstants.COMMON_URL + "a.txt"),StandardCopyOption.ATOMIC_MOVE); // 移动原子性 -
		
//			5: delete
//			Files.deleteIfExists(Paths.get(IOConstants.COMMON_URL + "a.txt"));
			
//			6: createDirector
//			Files.createDirectories(Paths.get(IOConstants.COMMON_URL +"a/b/c/d/e/d.txt"));  //不会考虑后缀, 只会创建文件夹
			
//			7: createFile
//			Files.createFile(Paths.get(IOConstants.COMMON_URL + "a/b/c/d/e/e.txt"));		//与文件夹重名会爆炸的  不存在的文件夹会爆炸的
			
//			8: list
//			* 匹配路径组成部分中 0 个或多个字符 *.java 匹配当前目录中的所有 Java 文件
//			** 匹配跨目录边界的 0 个或多个字符 **.java 匹配在所有子目录中的 Java 文件
//			? 匹配一个字符 ????.java 匹配所有四个字符的 Java 文件 ( 不包括扩展名 )
//			[...] 匹配一个字符集合，可以使用连线符
//			[0-9] 和取反符 [!0-9]
//			Test[0-9A-F].java 匹配 Testx.java，其中 x 是一个
//			十六进制数字
//			{...} 匹配由逗号隔开的多个可选项之一 *.{java,class} 匹配所有的 Java 文件和类 class 文件
//			\ 转义上述任意模式中的字符 *\** 匹配所有文件名中包含 * 的文件
			try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get(IOConstants.COMMON_URL), "*.txt")){	//try 确保目录流被正确关闭, 参数2 为 glob过滤条件  windows下需要4次\转义   "c:\\\\";
				for(Path entry : entries) {
					FunUtil.println(entry);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
