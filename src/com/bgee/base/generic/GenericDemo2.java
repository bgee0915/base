package com.bgee.base.generic;

import java.util.HashMap;
import java.util.Map;

import com.bgee.base.util.FunUtil;

public class GenericDemo2 {
	public static void main(String[] args) {
		Favorites favorites = new Favorites();
		favorites.putFavorite(String.class, "哈哈哈哈");
		favorites.putFavorite(Integer.class, 12);
		favorites.putFavorite(Long.class, 12000000000000L);
		favorites.putFavorite(Class.class, Favorites.class);

		String stirngClass = favorites.getFavorite(String.class);
		Integer integerClass = favorites.getFavorite(Integer.class);
		Long longClass = favorites.getFavorite(Long.class);
		Class<?> favorite = favorites.getFavorite(Class.class);
		
		FunUtil.println(stirngClass,integerClass,longClass,favorite,String.class,String.class.cast("abc"));
	}
}

// 类型安全的异构容器
class Favorites{
	private Map<Class<?>,Object> favorites = new HashMap<Class<?>,Object>();
	
	public <T> void putFavorite(Class<T> type, T instance) {
		if(null == type) {
			return ;
		}
		favorites.put(type, type.cast(instance));
	}
	
	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
}