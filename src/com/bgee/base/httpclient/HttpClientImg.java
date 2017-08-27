package com.bgee.base.httpclient;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 读取网页上的图片 并下载到本地
 * @author bgee0915
 *
 */
public class HttpClientImg {
	public static void main(String[] args) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet get = new HttpGet("http://www.java1234.com//uploads/allimg/170821/1-1FR1141RLL.JPG");
			HttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			if(null != entity) {
				System.out.println(entity.getContentType().getName());
				System.out.println(entity.getContentType().getValue());
				
				InputStream inputStream = entity.getContent();
				Files.copy(inputStream, Paths.get("e://1.jpg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
