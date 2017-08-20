package com.bgee.base.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.bgee.base.util.FunUtil;

public class Paths_nio {
	public static void main(String[] args) {
		
		try {
			
			Path normal = Paths.get("/a/b/c/../d/./e");
			Path workPath = Paths.get("work");
			Path morePath = Paths.get("moreOne","moreTwo");
			Path resolve = workPath.resolve(morePath);				// 如果 param 是绝对路径，那么就返回 param ; 否则，返回通过连接 this 和 param 获得的路径	
			Path sibling = resolve.resolveSibling("shit");			// 如果 param 是绝对路径，那么就返回 param ; 否则，返回通过连接 this 的父路径和param 获得的路径。
			Path relativize = sibling.relativize(workPath);			// 返回用 this 解析相对于 param 的相对路径
			Path normalize = normal.normalize();					// 去掉 .. . 之类的
			Path absolute = normal.toAbsolutePath();				// 获取绝对路径
			
			
			FunUtil.println(workPath,morePath,resolve,sibling,relativize,normal,normalize,absolute,"\n================================================\n");
			
	//		================================================
			
			Path p = Paths.get("d:/","cay","myprog.bac");
			Path parent = p.getParent();
			Path file = p.getFileName();
			Path root = p.getRoot();
			File pFile = p.toFile();
			
			FunUtil.println(p,parent,file,root,pFile);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();;
		}
	}
}
