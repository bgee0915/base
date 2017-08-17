package com.bgee.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.bgee.base.constants.IOConstants;

/**
 * 序列号
 * @author bgee
 *
 */
public class SerializableFlow {
	public static void main(String[] args) {
		Love java = new Love("java");
		try {
//			写入 
			File objectFile = new File(IOConstants.COMMON_URL + "love.txt");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(objectFile));
			out.writeObject(java);
			out.close();
			
//			读取
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(objectFile)) ;
			Object object = in.readObject();
			System.out.println(object);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


// ================  bean  ==================
class Love implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Love() {}
	public Love(String name) {
		this.name = name;
	}
	 
	private String name;
	
	public Love setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return "Love [name=" + name + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}



